
import chisel3._
import chisel3.util._
import primitives._
import primitives.primitives_wrapper._

//data out/in main module

class GrSrBankSubbank_DataIO(val bkNum: Int=2, val sbkNum: Int=8,val hwNum: Int=4,val elemNum: Int=32,val elemWidth: Int=16) extends Module {
  val io = IO(new Bundle{
    // scatter sb out
    val finalDramWrDataSubbank   = Output(Vec(bkNum, Vec(sbkNum, UInt((hwNum*elemWidth).W))))
    // gather data in 
    val gr_data                  = Output(UInt((sbkNum*hwNum*elemWidth).W))
    val dramRespBankData         = Input(Vec(bkNum, UInt((sbkNum*hwNum*elemWidth).W)))
    val scatterBankData          = Input(Vec(bkNum, UInt((sbkNum*hwNum*elemWidth).W)))
    val inc16_req_bank_stage5    = Input(Vec(bkNum, Bool()))
    val scatterIncAmountSbHw     = Input(Vec(sbkNum*bkNum, Vec(hwNum, UInt(6.W))))
    val scatter_valid_stage2     = Input(Vec(elemNum,Bool()))
    val ar_byte_num_stage5_ele   = Input(Vec(elemNum,Bool()))
    val ele_bank_select          = Input(Vec(elemNum,UInt(log2Ceil(bkNum).W)))
    val xbarDataSel              = Input(Vec(bkNum,Vec(sbkNum,Vec(hwNum,UInt(log2Ceil(elemNum).W)))))

    val waitClkGate              = Input(Bool())
    val MyReset                  = Input(Bool())
    val G2dramReadPwrCLK         = Input(Vec(bkNum*sbkNum,Clock()))
    val G2dramReadPwrDCLK        = Input(Vec(bkNum*sbkNum,Clock()))
    //val dramReadPwrDCLK0         = Input(Clock())
    val G2dramReadPwrCLKEn       = Input(Vec(bkNum*sbkNum,Bool()))
    val G2dramReadPwrDCLKEn      = Input(Vec(bkNum*sbkNum,Bool()))

    val Subbank_pipe_stall_bank_stage6     = Input(Vec(bkNum, Vec(sbkNum, Bool())))
    val Subbank_pipe_stall_bank_stage5     = Input(Vec(bkNum, Vec(sbkNum, Bool())))
  })


  val sbkWidth = hwNum*elemWidth
  var hwWidth = elemWidth
 
//SCatter/Resp Mux In
//line 100608-100838
  val regWidth = elemNum*elemWidth
  val scatter_data = Wire(UInt(regWidth.W))
  scatter_data.suggestName("scatter_data")
  scatter_data := io.scatterBankData//Cat(io.sr_data_stage4.reverse)
  
 // io.scatter_data := scatter_data

 val data_pre_bank_sb_hw = Wire(Vec(bkNum,Vec(sbkNum,UInt(sbkWidth.W))))
 val dramRespBankSb_pre_step5 =Wire(Vec(bkNum,Vec(sbkNum,UInt(sbkWidth.W))))
 val localReset =io.MyReset.asAsyncReset
 // resp data reg
 for( bkIdx <- 0 until bkNum)
   for( sbkIdx <- 0 until sbkNum)
   {
     val dramRspGateEnable =  !io.waitClkGate && io.G2dramReadPwrCLKEn(bkIdx*sbkNum+sbkIdx)
     dramRespBankSb_pre_step5(bkIdx)(sbkIdx) := xcff(sbkWidth,io.G2dramReadPwrCLK(bkIdx*sbkNum+sbkIdx),localReset,dramRspGateEnable,io.dramRespBankData(bkIdx)(sbkIdx*sbkWidth+sbkWidth-1,sbkIdx*sbkWidth) )
   }

 for( bkId <- 0 until bkNum)
  for ( i <- 0 until elemNum) {
    val scatter_val_sel = Wire(Bool())
    scatter_val_sel.suggestName(s"scatter_val_sel_ele$i")
    scatter_val_sel := io.scatter_valid_stage2(i)
    val mux = Wire(UInt(16.W))
    mux.suggestName(s"data_pre_bank_sb${i/4}_hw${i%4}")
    val hwId=i%hwNum
    val sc_val_mux2_sel =Seq(scatter_val_sel,!scatter_val_sel)
    mux := Xtmux2(elemWidth,Seq(scatter_data((i+1)*elemWidth-1, i*elemWidth), dramRespBankSb_pre_step5(bkId)(i/hwNum)((hwId+1)*elemWidth-1,hwId*elemWidth)),sc_val_mux2_sel)

   //data_pre_bank_sb_hw(bkId)(i/hwNum)(i%hwNum) := mux
   data_pre_bank_sb_hw(bkId)(i) := mux
  }

//data arbitration
//out xbar_data_bank0_sbXX_hwX,xbar_data_bank1_sbXX_hwX
val xbar_data_bank_sb= Wire(Vec(bkNum,Vec(sbkNum,Vec(hwNum,UInt(hwWidth.W)))))
val scatter_data_bank_ele = Wire(Vec(bkNum,Vec(sbkNum*hwNum,UInt(hwWidth.W))))
for( bkId <- 0 until bkNum)
  for ( i <- 0 until sbkNum) 
    for( hwId <- 0 until hwNum)
    {
      xbar_data_bank_sb(bkId)(i)(hwId):= Xtmux32e(hwWidth,data_pre_bank_sb_hw(bkId),io.xbarDataSel(bkId)(i)(hwId))
      scatter_data_bank_ele(bkId)(hwId+i*hwNum) :=Cat(xbar_data_bank_sb(bkId)(i)(hwId)(elemWidth-1,8),xbar_data_bank_sb(bkId)(i)(hwId)(7,0))
    }

//gather In data collection
 val gr_data_sb_hw = Wire(Vec(sbkNum,Vec(hwNum,UInt(hwWidth.W))))

 for( sbkId <- 0 until sbkNum) 
    for( hwId <- 0 until hwNum)
    {
      val dataSet=Seq.tabulate(bkNum){i=>xbar_data_bank_sb(i)(sbkId)(hwId)}
      val sel_seq=1.U(bkNum.W) << io.ele_bank_select(sbkId*hwNum+hwId)
      gr_data_sb_hw(sbkId)(hwId):=Xtmux(elemWidth,dataSet,sel_seq.asBools)  //Xtmux abstract which allowfor mux2,4,8
    }

    val gr_data_elements=gr_data_sb_hw.flatten
    val gr_data_ele= gr_data_elements.zipWithIndex.map{case (gr,i) => Mux(io.ar_byte_num_stage5_ele(i), gr(i), (gr(i)>>8))}  //Wire(Vec(elemNum,UInt(elemWidth.W)))
    //gather collection out
    io.gr_data:=Cat(gr_data_ele.reverse)
//scatter_data_bank0,scatter_data_bank1/inc_data0，inc_data1, Mux: Mux_DataOut


//Get dram write data
//  -- 100590
 
 for (bankIdx <- 0 until bkNum) {
    val scatterSbkData  =  scatter_data_bank_ele(bankIdx).grouped(hwNum).toSeq
    val incScatter = io.inc16_req_bank_stage5(bankIdx)
    for (subbankIdx <- 0 until sbkNum) {
      //rmw   incdata
      val gSbkIdx=bankIdx*sbkNum+subbankIdx
      val PwrDgate = (!io.waitClkGate) && (io.G2dramReadPwrDCLKEn(gSbkIdx))
      val scattGateEnable =  !io.waitClkGate && io.G2dramReadPwrCLKEn(gSbkIdx)
      val DRAM_resp_data_bank_sb_stage5 = VecInit((0 until hwNum).map{i => dramRespBankSb_pre_step5(bankIdx)(subbankIdx)(elemWidth*(i+1)-1, elemWidth*i) + Cat(0.U(10.W), io.scatterIncAmountSbHw(bankIdx*sbkNum+subbankIdx)(i))}).reduce(Cat(_,_))

      val scatter_data_bank_sb_stage5_nxt = Wire(UInt(sbkWidth.W)) 
      val scatter_data_bank_sb_stage5     = Wire(UInt(sbkWidth.W))
     
      //val scatterSbkData  =   io.scatterBankData(bankIdx)(subbankIdx*sbkWidth+sbkWidth-1,subbankIdx*sbkWidth)
         val scatterSbkDataVec = Cat(scatterSbkData(subbankIdx)) //.toIndexedSeq
         val stallSel = Seq(!io.Subbank_pipe_stall_bank_stage6(bankIdx)(subbankIdx),io.Subbank_pipe_stall_bank_stage6(bankIdx)(subbankIdx))
          scatter_data_bank_sb_stage5_nxt := Xtmux2(sbkWidth,Seq(scatterSbkDataVec, scatter_data_bank_sb_stage5), stallSel)
          scatter_data_bank_sb_stage5     := xcff(sbkWidth,io.G2dramReadPwrCLK(gSbkIdx), io.MyReset.asAsyncReset, scattGateEnable,scatter_data_bank_sb_stage5_nxt)

      /* scatterDataReg := Mux(io.myReset, 0.U, Mux(!io.waitClkGate && io.g2dramReadPwrCLKEn0, io.scatterData(bankIdx)(subbankIdx), scatterDataReg))
         dramRespDataPreReg := Mux(io.myReset, 0.U, Mux(!io.waitClkGate && io.g2dramReadPwrCLKEn0, io.dramRespBank_step5(bankIdx)(subbankIdx), dramRespDataPreReg))
 */

     val DRAM_resp_data_d_bank_sb = Wire(UInt(sbkWidth.W))
    
      /* val resp_data_scatter_data_bank_sb_stage5 =  MuxCase(scatter_data_bank_sb_stage5, Seq(
        (!io.subbankPipeStall(bankIdx)(subbankIdx) && incScatter) -> dramRespBankSb_step5,
        (io.subbankPipeStall(bankIdx)(subbankIdx)) -> DRAM_resp_data_d_bank_sb)) */
      val scinc_d_sel = VecInit(!(incScatter || io.Subbank_pipe_stall_bank_stage6(bankIdx)(subbankIdx)), (!io.Subbank_pipe_stall_bank_stage6(bankIdx)(subbankIdx) && incScatter), io.Subbank_pipe_stall_bank_stage6(bankIdx)(subbankIdx));

      val resp_data_scatter_data_bank_sb_stage5 = Xtmux3(sbkWidth,
                                                         Seq(scatter_data_bank_sb_stage5,
                                                         DRAM_resp_data_bank_sb_stage5,
                                                         DRAM_resp_data_d_bank_sb),
                                                         scinc_d_sel)
      
      DRAM_resp_data_d_bank_sb := xcff(sbkWidth,io.G2dramReadPwrDCLK(gSbkIdx),localReset,PwrDgate,resp_data_scatter_data_bank_sb_stage5)

      /* dramRespDataDReg := Mux(io.myReset, 0.U, Mux(!io.waitClkGate && io.g2dramReadPwrDCLKEn0, MuxCase(scatterDataReg, Seq(
        (!io.subbankPipeStall(bankIdx)(subbankIdx) && incScatter) -> dramRespData,
        (io.subbankPipeStall(bankIdx)(subbankIdx)) -> dramRespDataDReg
      )), dramRespDataDReg))
 */
      io.finalDramWrDataSubbank(bankIdx)(subbankIdx) := DRAM_resp_data_d_bank_sb
    }
  }
}
