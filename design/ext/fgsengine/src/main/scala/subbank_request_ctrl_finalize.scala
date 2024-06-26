
import chisel3._
import chisel3.util._
import primitives._
import primitives.primitives_wrapper._


// Finalize the access ctrl signal to sram  per subbank
//line 37560-37977
// output
// final_dram_id_wrreq_sb
// final_dram_id_rdreq_sb
// final_sc8_req_sb
// final_sc16_req_sb
// final_inc16_req_sb


class SbReqCtrlFinalize(val addrWidth:Int=18,val byteEnWidth:Int=8,val numElem:Int=32,val bkNum: Int=2, val sbkNum: Int=8,val hwNum: Int=4) extends Module {

    val io=IO(new Bundle{
        val final_dram_id_wrreq_sb= Output(Vec(sbkNum*bkNum,Bool()))
        val final_dram_id_rdreq_sb= Output(Vec(sbkNum*bkNum,Bool()))
        val final_sc8_req_sb      = Output(Vec(sbkNum*bkNum,Bool()))      
        val final_sc16_req_sb     = Output(Vec(sbkNum*bkNum,Bool()))                  
        val final_inc16_req_sb    = Output(Vec(sbkNum*bkNum,Bool()))  
                
        val final_addr_req_sb     =Output(Vec(sbkNum*bkNum,UInt(addrWidth.W)))
        val final_byte_en_req_sb  =Output(Vec(sbkNum*bkNum,UInt(byteEnWidth.W)))
        val final_val_dram_req_sb =Output(Vec(sbkNum*bkNum,Bool())) 
        val final_wr_req_sb       =Output(Vec(sbkNum*bkNum,Bool()))
        val final_wr_req_notrmw_sb=Output(Vec(sbkNum*bkNum,Bool()))
        
        val scatter_rmw_wr_req_sb_stage4=Output(Vec(sbkNum*bkNum,Bool()))

        val ar_addr               = Input(Vec(numElem,UInt(addrWidth.W)))
        val ar_addr_sc8           = Input(UInt(numElem.W))
        val ar_addr_sc16          = Input(UInt(numElem.W))
        val ar_addr_inc16         = Input(UInt(numElem.W))
        val ar_dram_id            = Input(UInt(numElem.W))      
        val ar_addr_grant_sb      = Input(Vec(sbkNum*bkNum,UInt(numElem.W)))
        val ar_data_grant_scatter_valid_bank_sb_hw_stage2=Input(Vec(sbkNum,Vec(hwNum,Bool())))
        val ar_data_grant_byte_num_bank_sb_hw_stage2     =Input(Vec(sbkNum,Vec(hwNum,Bool())))
        val Subbank_wrbusy_sb     = Input(Vec(sbkNum*bkNum,Bool()))
        val Subbank_rdbusy_sb     = Input(Vec(sbkNum*bkNum,Bool()))
        val Subbank_wrbusy_bank   = Input(Vec(bkNum,Bool()))
        val Subbank_busy_bank     = Input(Vec(bkNum,Bool()))
        val Subbank_pipe_stall_bank_stage1 = Input(Vec(bkNum,Bool()))
        val Subbank_pipe_stall_bank_stage2 = Input(Vec(bkNum,Bool()))
        val Subbank_pipe_stall_bank_stage5 = Input(Vec(bkNum,Bool()))
    // val wr_req_sb_stage5      = Input(Vec(sbkNum*bkNum,Bool()))
        val G2generalCLK           = Input(Clock())
        val G2generalCLKEn         = Input(Bool())
        val MyReset                = Input(Bool())
        val WaitClkGate            = Input(Bool())
        val G3bankStallStage1CLK  = Input(Vec(bkNum,Clock()))
        val G3bankStallStage2CLK  = Input(Vec(bkNum,Clock()))
        val G3bankStallStage3CLK  = Input(Vec(bkNum,Clock()))
        val G3bankStallStage5CLK  = Input(Vec(bkNum,Clock()))
        val G3bankStallStage6CLK  = Input(Vec(bkNum,Clock()))
     
        val G3bankStallStage1CLKEn=Input(Vec(bkNum,Bool()))
        val G3bankStallStage2CLKEn=Input(Vec(bkNum,Bool()))
        val G3bankStallStage3CLKEn=Input(Vec(bkNum,Bool()))
        val G3bankStallStage5CLKEn=Input(Vec(bkNum,Bool()))
        val G3bankStallStage6CLKEn=Input(Vec(bkNum,Bool()))
    })

  val final_dram_id_wrreq_sb= Wire(Vec(sbkNum*bkNum,Bool()))
  val final_dram_id_rdreq_sb= Wire(Vec(sbkNum*bkNum,Bool()))
  val final_sc8_req_sb      = Wire(Vec(sbkNum*bkNum,Bool()))   
  val final_sc16_req_sb     = Wire(Vec(sbkNum*bkNum,Bool()))   
  val final_inc16_req_sb    = Wire(Vec(sbkNum*bkNum,Bool()))   
  val final_addr_req_sb     = Wire(Vec(sbkNum*bkNum,UInt(addrWidth.W)))
  val final_byte_en_req_sb  = Wire(Vec(sbkNum*bkNum,UInt(byteEnWidth.W)))
  val final_val_dram_req_sb = Wire(Vec(sbkNum*bkNum,Bool())) 
  val final_wr_req_sb       = Wire(Vec(sbkNum*bkNum,Bool()))
  val final_wr_req_notrmw_sb= Wire(Vec(sbkNum*bkNum,Bool()))
  
  io.final_dram_id_wrreq_sb <> final_dram_id_wrreq_sb
  io.final_dram_id_rdreq_sb <> final_dram_id_rdreq_sb
  io.final_sc8_req_sb       <> final_sc8_req_sb      
  io.final_sc16_req_sb      <> final_sc16_req_sb     
  io.final_inc16_req_sb     <> final_inc16_req_sb    
  io.final_addr_req_sb      <> final_addr_req_sb     
  io.final_byte_en_req_sb   <> final_byte_en_req_sb  
  io.final_val_dram_req_sb  <> final_val_dram_req_sb 
  io.final_wr_req_sb        <> final_wr_req_sb       
  io.final_wr_req_notrmw_sb <> final_wr_req_notrmw_sb


  val sc8_req_bank_stage1            = Wire(Vec(bkNum,Bool()))
  val sc16_req_bank_stage1           = Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage1          = Wire(Vec(bkNum,Bool()))

  val dram_id_req_bank_stage1        = Wire(Vec(bkNum,Bool()))


       
  val sc8_req_nxt_sb_stage1           = Wire(Vec(bkNum*sbkNum,Bool()))
  val sc16_req_nxt_sb_stage1          = Wire(Vec(bkNum*sbkNum,Bool()))
  val inc16_req_nxt_sb_stage1         = Wire(Vec(bkNum*sbkNum,Bool()))
  val dram_id_req_nxt_sb_stage1       = Wire(Vec(bkNum*sbkNum,Bool()))

  for( bkId <-0 until bkNum){
    for( i <- 0 until sbkNum)
    {
      val vec_sc8=io.ar_addr_sc8.asBools.map{b => b.asUInt}
      val vec_sc16=io.ar_addr_sc16.asBools.map{b => b.asUInt}
      val vec_inc16=io.ar_addr_inc16.asBools.map{b => b.asUInt}
      val vec_bid=io.ar_dram_id.asBools.map{b => b.asUInt}

      sc8_req_nxt_sb_stage1(bkId*sbkNum+i)        := Xtmux32e(1,vec_sc8  ,io.ar_addr_grant_sb(bkId*sbkNum+i))
      sc16_req_nxt_sb_stage1(bkId*sbkNum+i)       := Xtmux32e(1,vec_sc16 ,io.ar_addr_grant_sb(bkId*sbkNum+i))
      inc16_req_nxt_sb_stage1(bkId*sbkNum+i)      := Xtmux32e(1,vec_inc16,io.ar_addr_grant_sb(bkId*sbkNum+i))
      dram_id_req_nxt_sb_stage1(bkId*sbkNum+i)    := Xtmux32e(1,vec_bid  ,io.ar_addr_grant_sb(bkId*sbkNum+i))
    }
    sc8_req_bank_stage1(bkId)     := sc8_req_nxt_sb_stage1(bkId).asUInt.orR 
    sc16_req_bank_stage1(bkId)    := sc16_req_nxt_sb_stage1(bkId).asUInt.orR
    inc16_req_bank_stage1(bkId)   := inc16_req_nxt_sb_stage1(bkId).asUInt.orR 
    dram_id_req_bank_stage1(bkId) := dram_id_req_nxt_sb_stage1(bkId).asUInt.orR
}

  
  val g2CLK    =io.G2generalCLK
  val g2CLKEn  =io.G2generalCLKEn
  val localReset    =io.MyReset.asAsyncReset


  val g2ClkEnable =(!io.WaitClkGate) && (g2CLKEn)
  
 

  val sc8_req_bank_stage2      =Wire(Vec(bkNum,Bool()))  
  val sc16_req_bank_stage2     =Wire(Vec(bkNum,Bool()))  

  val dram_id_req_bank_stage2  =Wire(Vec(bkNum,Bool()))  
  val dram_id_req_bank_stage5  =Wire(Vec(bkNum,Bool()))
  val dram_id_req_bank_stage6  =Wire(Vec(bkNum,Bool()))
 
  val inc16_req_bank_stage2    =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage3    =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage4_p1 =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage4_p2 =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage4_p3 =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage4_p4 =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage4    =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage5    =Wire(Vec(bkNum,Bool()))
  val inc16_req_bank_stage6    =Wire(Vec(bkNum,Bool()))
  val rmw_conflict_kill_stage3_t_bank =WireInit(false.B)
  val numSubbankBytes = byteEnWidth*sbkNum
val subbankByteBits = log2Ceil(numSubbankBytes)
val entryAddrBits   = addrWidth-subbankByteBits
//addr


val wr_req_sb_stage5   = Wire(Vec(sbkNum*bkNum,Bool()))
val addr_req_sb_stage2_          = Wire(Vec(sbkNum*bkNum,UInt(addrWidth.W)))
for(bkId <- 0 until bkNum){
    val stage5CLK=io.G3bankStallStage5CLK(bkId)
    val stage6CLK=io.G3bankStallStage6CLK(bkId)
    val stage1CLK=io.G3bankStallStage1CLK(bkId)
    val stage1CLKEn =io.G3bankStallStage1CLKEn(bkId)
    val stage2CLK   =io.G3bankStallStage2CLK(bkId)
    val stage2CLKEn =io.G3bankStallStage2CLKEn(bkId)
    val stage3CLK   =io.G3bankStallStage3CLK(bkId)
    val stage3CLKEn =io.G3bankStallStage3CLKEn(bkId)
    val g3ClkS1Enable = (!io.WaitClkGate) && (g2CLKEn) && (stage1CLKEn)
    val g3ClkS2Enable = (!io.WaitClkGate) && g2CLKEn && stage2CLKEn
    val g3ClkS3Enable = (!io.WaitClkGate) && g2CLKEn && stage3CLKEn
    val g3ClkS5Enable = (!io.WaitClkGate) && (g2CLKEn&&(io.G3bankStallStage5CLKEn(bkId))) 
    val g3ClkS6Enable = (!io.WaitClkGate) && (g2CLKEn&&(io.G3bankStallStage6CLKEn(bkId))) 
    
      sc8_req_bank_stage2(bkId)        := xcff(1, stage2CLK,localReset, g3ClkS2Enable, sc8_req_bank_stage1(bkId)     ) 
      sc16_req_bank_stage2(bkId)       := xcff(1, stage2CLK,localReset, g3ClkS2Enable, sc16_req_bank_stage1(bkId)    ) 
      inc16_req_bank_stage2(bkId)      := xcff(1, stage2CLK,localReset, g3ClkS2Enable, inc16_req_bank_stage1(bkId)   )
      dram_id_req_bank_stage2(bkId)    := xcff(1, stage2CLK,localReset, g3ClkS2Enable, dram_id_req_bank_stage1(bkId) ) 

      val sc8_req_bank_stage3_pre    = xcff(1, stage3CLK,localReset, g3ClkS3Enable, sc8_req_bank_stage2(bkId)     ) 
      val sc16_req_bank_stage3_pre   = xcff(1, stage3CLK,localReset, g3ClkS3Enable, sc16_req_bank_stage2(bkId)    ) 
      val inc16_req_bank_stage3_pre  = xcff(1, stage3CLK,localReset, g3ClkS3Enable, inc16_req_bank_stage2(bkId)   )
      
      val dram_id_req_bank_stage3    = xcff(1, stage3CLK,localReset, g3ClkS3Enable, dram_id_req_bank_stage2(bkId) ) 
      val sc8_req_bank_stage3        = sc8_req_bank_stage3_pre.asBool    && !rmw_conflict_kill_stage3_t_bank    
      val sc16_req_bank_stage3       = sc16_req_bank_stage3_pre.asBool   && !rmw_conflict_kill_stage3_t_bank   
          inc16_req_bank_stage3(bkId)      := inc16_req_bank_stage3_pre.asBool  && !rmw_conflict_kill_stage3_t_bank 
      //val dram_id_req_bank_stage3    = dram_id_req_bank_stage3_pre&& dram_id_req_bank_stage3_pre

      val sc8_req_bank_stage4_p1    = xcff(1, g2CLK,localReset, g2ClkEnable, sc8_req_bank_stage3     ) 
      val sc16_req_bank_stage4_p1   = xcff(1, g2CLK,localReset, g2ClkEnable, sc16_req_bank_stage3    ) 
          inc16_req_bank_stage4_p1(bkId)  := xcff(1, g2CLK,localReset, g2ClkEnable, inc16_req_bank_stage3(bkId)   )
      val dram_id_req_bank_stage4_p1= xcff(1, g2CLK,localReset, g2ClkEnable, dram_id_req_bank_stage3 ) 

      val sc8_req_bank_stage4_p2    = xcff(1, g2CLK,localReset, g2ClkEnable, sc8_req_bank_stage4_p1     ) 
      val sc16_req_bank_stage4_p2   = xcff(1, g2CLK,localReset, g2ClkEnable, sc16_req_bank_stage4_p1    ) 
          inc16_req_bank_stage4_p2(bkId)  := xcff(1, g2CLK,localReset, g2ClkEnable, inc16_req_bank_stage4_p1(bkId)   )
      val dram_id_req_bank_stage4_p2= xcff(1, g2CLK,localReset, g2ClkEnable, dram_id_req_bank_stage4_p1 )

      val sc8_req_bank_stage4_p3    = xcff(1, g2CLK,localReset, g2ClkEnable, sc8_req_bank_stage4_p2     ) 
      val sc16_req_bank_stage4_p3   = xcff(1, g2CLK,localReset, g2ClkEnable, sc16_req_bank_stage4_p2    ) 
          inc16_req_bank_stage4_p3(bkId)  := xcff(1, g2CLK,localReset, g2ClkEnable, inc16_req_bank_stage4_p2(bkId)   )
      val dram_id_req_bank_stage4_p3= xcff(1, g2CLK,localReset, g2ClkEnable, dram_id_req_bank_stage4_p2 )

      val sc8_req_bank_stage4_p4    = xcff(1, g2CLK,localReset, g2ClkEnable, sc8_req_bank_stage4_p3     ) 
      val sc16_req_bank_stage4_p4   = xcff(1, g2CLK,localReset, g2ClkEnable, sc16_req_bank_stage4_p3    ) 
          inc16_req_bank_stage4_p4(bkId)  := xcff(1, g2CLK,localReset, g2ClkEnable, inc16_req_bank_stage4_p3(bkId)   )
      val dram_id_req_bank_stage4_p4= xcff(1, g2CLK,localReset, g2ClkEnable, dram_id_req_bank_stage4_p3 )

      val sc8_req_bank_stage4       = xcff(1, g2CLK,localReset, g2ClkEnable, sc8_req_bank_stage4_p4     ) 
      val sc16_req_bank_stage4      = xcff(1, g2CLK,localReset, g2ClkEnable, sc16_req_bank_stage4_p4    ) 
          inc16_req_bank_stage4(bkId)     := xcff(1, g2CLK,localReset, g2ClkEnable, inc16_req_bank_stage4_p4(bkId)   )
      val dram_id_req_bank_stage4   = xcff(1, g2CLK,localReset, g2ClkEnable, dram_id_req_bank_stage4_p4 )

      
          inc16_req_bank_stage5(bkId)     := xcff(1, g2CLK,localReset, g2ClkEnable, inc16_req_bank_stage4(bkId)   )
          dram_id_req_bank_stage5(bkId)   := xcff(1, stage5CLK,localReset, g3ClkS5Enable, dram_id_req_bank_stage4 )
      
      
          inc16_req_bank_stage6(bkId)     := xcff(1, g2CLK,localReset, g2ClkEnable, inc16_req_bank_stage5(bkId)   )
          dram_id_req_bank_stage6(bkId)   := xcff(1, stage6CLK,localReset, g3ClkS6Enable, dram_id_req_bank_stage5(bkId) )   
//}

//for(  sbkId <- 0 until sbkNum*bkNum){

 for(  sbkId_ <- 0 until sbkNum/* *bkNum */){
  val sbkId = bkId*sbkNum+sbkId_
  val addr_req_nxt_sb_stage1      = Xtmux32(addrWidth,io.ar_addr,io.ar_addr_grant_sb(sbkId).asBools.toSeq)
  val addr_req_sb_stage1          = xcff(addrWidth,stage1CLK,localReset,g3ClkS1Enable,addr_req_nxt_sb_stage1)
  val addr_req_sb_stage2          = xcff(addrWidth,stage2CLK,localReset,g3ClkS2Enable,addr_req_sb_stage1)
      addr_req_sb_stage2_(sbkId) := addr_req_sb_stage2
  val addr_req_sb_stage3          = xcff(entryAddrBits,stage3CLK,localReset,g3ClkS3Enable,addr_req_sb_stage2(addrWidth-1,subbankByteBits))
         
  val addr_req_sb_stage4_p1       = xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage3)
  val addr_req_sb_stage4_p2       = xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p1)
  val addr_req_sb_stage4_p3       = xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p2)
  val addr_req_sb_stage4_p4       = xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p3)
  val addr_req_sb_stage4          = xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p4)
 // Mux inc16
  val addr_req_nxt_sb_stage5      = Mux(inc16_req_bank_stage4(bkId) ,  addr_req_sb_stage4 , addr_req_sb_stage2(addrWidth-1,subbankByteBits))

  val addr_req_sb_stage5          = xcff(entryAddrBits,stage5CLK,localReset,g3ClkS5Enable,addr_req_nxt_sb_stage5)
  val addr_req_sb_stage6          = xcff(entryAddrBits,stage5CLK,localReset,g3ClkS6Enable,addr_req_sb_stage5)
  //for_final_addr_req_sb0_stage1 = val_dram_req_sb0_stage1 ?						addr_req_sb0_stage1 :		addr_req_sb0_stage1;
  val for_final_addr_req_sb_stage2=addr_req_sb_stage2
  val for_final_addr_req_sb_stage1=addr_req_sb_stage1
  
 
  val	addr_req_sb_for_final = Mux(io.Subbank_wrbusy_sb(sbkId), final_addr_req_sb(sbkId), 
					              Mux((wr_req_sb_stage5(sbkId)) , Cat(addr_req_sb_stage5, Fill(subbankByteBits,0.U(1.W))) , 
                                    Mux(io.Subbank_rdbusy_sb(sbkId),for_final_addr_req_sb_stage2,for_final_addr_req_sb_stage1)))
   
 
   final_addr_req_sb(sbkId) := xcff(addrWidth,g2CLK,localReset,g2ClkEnable,addr_req_sb_for_final)

  } 
 }

  for(bkId <- 0 until bkNum)
     for(i <- 0 until sbkNum){
       final_sc8_req_sb(bkId*sbkNum+i)      :=  Xtmux2e(1,sc8_req_bank_stage1(bkId),sc8_req_bank_stage2(bkId),io.Subbank_busy_bank(bkId))
       final_sc16_req_sb(bkId*sbkNum+i)     :=  Xtmux2e(1,sc16_req_bank_stage1(bkId),sc16_req_bank_stage2(bkId),io.Subbank_busy_bank(bkId))
       final_inc16_req_sb(bkId*sbkNum+i)    :=  Xtmux2e(1,inc16_req_bank_stage1(bkId),inc16_req_bank_stage2(bkId),io.Subbank_busy_bank(bkId))
       final_dram_id_wrreq_sb(bkId*sbkNum+i):=  Xtmux2e(1,dram_id_req_bank_stage5(bkId),dram_id_req_bank_stage6(bkId),io.Subbank_wrbusy_bank(bkId))
       final_dram_id_rdreq_sb(bkId*sbkNum+i):=  Xtmux2e(1,dram_id_req_bank_stage1(bkId),dram_id_req_bank_stage2(bkId),io.Subbank_busy_bank(bkId))
    }
//   xtmux2e #(1) final_val_dram_req_mux_sb0(final_val_dram_req_sb0, val_dram_req_sb0_for_final_stage1, val_dram_req_sb0_for_final_stage2, io.Subbank_busy_bank(bkId));
//   xtmux2e #(1) final_wr_req_mux_sb0(final_wr_req_sb0, wr_req_sb0_stage5, wr_req_sb0_stage6, Subbank_wrbusy_bank0);
//   xtmux2e #(1) final_wr_req_notrmw_mux_sb0(final_wr_req_notrmw_sb0, wr_req_notrmw_sb0_stage5, wr_req_notrmw_sb0_stage6, Subbank_wrbusy_bank0);
//val final_byte_en_req_sb = Wire(Vec(sbkNum*bkNum,UInt(byteEnWidth)))
val rmw_conflict_kill_stage3_t_bank0		= WireInit(false.B) //1'b0;

for( sbkId <- 0 until sbkNum*bkNum){
  val bankId = sbkId/sbkNum

    val stage5CLK=io.G3bankStallStage5CLK(bankId)
    val stage6CLK=io.G3bankStallStage6CLK(bankId) 
    val stage1CLK   =io.G3bankStallStage1CLK(bankId)
    val stage1CLKEn =io.G3bankStallStage1CLKEn(bankId)
    val stage2CLK   =io.G3bankStallStage2CLK(bankId)
    val stage2CLKEn =io.G3bankStallStage2CLKEn(bankId)
    val stage3CLK   =io.G3bankStallStage3CLK(bankId)
    val stage3CLKEn =io.G3bankStallStage3CLKEn(bankId)
    val g3ClkS1Enable = (!io.WaitClkGate) && (g2CLKEn) && (stage1CLKEn)
    val g3ClkS2Enable = (!io.WaitClkGate) && g2CLKEn && stage2CLKEn
    val g3ClkS3Enable = (!io.WaitClkGate) && g2CLKEn && stage3CLKEn
    val g3ClkS5Enable = (!io.WaitClkGate) && (g2CLKEn&&(io.G3bankStallStage5CLKEn(bankId))) 
    val g3ClkS6Enable = (!io.WaitClkGate) && (g2CLKEn&&(io.G3bankStallStage6CLKEn(bankId))) 

  val val_dram_req_nxt_sb_stage1      = io.ar_addr_grant_sb(sbkId).orR   //reduce(_|_)
  val val_dram_req_sb_stage1          = Wire(Bool())
  val val_dram_req_sb_stage2          = Wire(Bool())
  val val_dram_req_sb_stage3_pre      = Wire(Bool())
  val val_dram_req_sb_stage3          = Wire(Bool())
  val val_dram_req_sb_stage4_p1       = Wire(Bool())
  val val_dram_req_sb_stage4_p2       = Wire(Bool())
  val val_dram_req_sb_stage4_p3       = Wire(Bool())
  val val_dram_req_sb_stage4_p4       = Wire(Bool())
  val val_dram_req_sb_stage4          = Wire(Bool())
  val val_dram_req_sb_stage5          = Wire(Bool())
  val val_dram_req_sb_stage6          = Wire(Bool())
  val val_dram_req_sb_stage4_copy0    = Wire(Bool())
  val val_dram_req_sb_stage4_copy1    = Wire(Bool())

  val scatter_rmw_wr_req_sb_stage2    = val_dram_req_sb_stage2    && inc16_req_bank_stage2(bankId);
  val scatter_rmw_wr_req_sb_stage3    = val_dram_req_sb_stage3    && inc16_req_bank_stage3(bankId);
  val scatter_rmw_wr_req_sb_stage4_p1 = val_dram_req_sb_stage4_p1 && inc16_req_bank_stage4_p1(bankId);
  val scatter_rmw_wr_req_sb_stage4_p2 = val_dram_req_sb_stage4_p2 && inc16_req_bank_stage4_p2(bankId);
  val scatter_rmw_wr_req_sb_stage4_p3 = val_dram_req_sb_stage4_p3 && inc16_req_bank_stage4_p3(bankId);
  val scatter_rmw_wr_req_sb_stage4_p4 = val_dram_req_sb_stage4_p4 && inc16_req_bank_stage4_p4(bankId);
  //the aboves useless?
  val scatter_rmw_wr_req_sb_stage4    = val_dram_req_sb_stage4    && inc16_req_bank_stage4(bankId);
   io.scatter_rmw_wr_req_sb_stage4(sbkId)    := scatter_rmw_wr_req_sb_stage4
  //useless?
  val scatter_rmw_wr_req_sb_stage5    = val_dram_req_sb_stage5    && inc16_req_bank_stage5(bankId);
  val scatter_rmw_wr_req_sb_stage6    = val_dram_req_sb_stage6    && inc16_req_bank_stage6(bankId);
      val_dram_req_sb_stage1 :=xcff(1,stage1CLK,localReset,g3ClkS1Enable, val_dram_req_nxt_sb_stage1)
      val_dram_req_sb_stage2 :=xcff(1,stage2CLK,localReset,g3ClkS2Enable, val_dram_req_sb_stage1.asBool && (!io.Subbank_pipe_stall_bank_stage1(bankId)))
  val val_dram_req_nxt_sb_stage3 = val_dram_req_sb_stage2 && !io.Subbank_pipe_stall_bank_stage2(bankId) && 
                                           !(sc8_req_bank_stage2(bankId) || sc16_req_bank_stage2(bankId))

      val_dram_req_sb_stage3_pre :=xcff(1,stage3CLK,localReset,g3ClkS3Enable,val_dram_req_nxt_sb_stage3)
      val_dram_req_sb_stage3 := val_dram_req_sb_stage3_pre.asBool && !rmw_conflict_kill_stage3_t_bank0;
 

      val_dram_req_sb_stage4_p1      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage3  )
      val_dram_req_sb_stage4_p2      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p1 ) 
      val_dram_req_sb_stage4_p3      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p2)
      val_dram_req_sb_stage4_p4      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p3)
      val_dram_req_sb_stage4         :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p4)
      val_dram_req_sb_stage4_copy0   :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4)
      val_dram_req_sb_stage4_copy1   :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4)
      val_dram_req_sb_stage5         :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4    )
      val_dram_req_sb_stage6         :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage5    )   

  // Byte Enable 
  	val val_dram_req_sb_for_final_stage1 = val_dram_req_sb_stage1 //&& !rmw_conflict_kill_read_t_bank1;
    val val_dram_req_sb_for_final_stage2 = val_dram_req_sb_stage2 //&& !rmw_conflict_kill_read_t_bank1;
  val RdByteEn_req_sb_stage1  = Mux(val_dram_req_sb_stage1, Fill(byteEnWidth, 1.U), 0.U(byteEnWidth.W))

  
  
  val ByteEn_sc_req_sb_hw   =  Wire(Vec(hwNum,UInt(2.W)))
  val ByteEn_scinc_req_sb_hw=  Wire(Vec(hwNum,UInt(2.W)))
  
  for (i <- 0 until hwNum){
    val sc_valid = io.ar_data_grant_scatter_valid_bank_sb_hw_stage2(sbkId)(i)
    val byte_num = io.ar_data_grant_byte_num_bank_sb_hw_stage2(sbkId)(i)
    ByteEn_sc_req_sb_hw(i) := Mux(sc_valid, 
                                     Mux(sc16_req_bank_stage2(bankId) || (sc8_req_bank_stage2(bankId) && byte_num), "b11".U, "b10".U),
                                     "b00".U)
    ByteEn_scinc_req_sb_hw(i) := Mux(sc_valid && inc16_req_bank_stage2(bankId), "b11".U, "b00".U)
 }

    val ByteEn_req_sb_stage2        = Wire(UInt(byteEnWidth.W))
    val ByteEn_req_sb_stage5_nxt    = Wire(UInt(byteEnWidth.W))
    val ByteEn_req_sb_stage5_nxt_pre= Wire(UInt(byteEnWidth.W))

    ByteEn_req_sb_stage5_nxt_pre   := Cat(ByteEn_sc_req_sb_hw.reverse)  //?
    ByteEn_req_sb_stage2           := Cat(ByteEn_scinc_req_sb_hw.reverse)
//stage 2
    val RdByteEn_req_sb_stage2  = xcff(byteEnWidth,stage2CLK,localReset,g3ClkS2Enable,RdByteEn_req_sb_stage1)
//stage 3
//val g3ClkS3GateEnale =!io.WaitClkGate && g2CLKEn && stage3CLKEn
    val ByteEn_req_sb_stage3 = xcff(byteEnWidth,stage3CLK,localReset,g3ClkS3Enable,ByteEn_req_sb_stage2)


/* val ByteEn_req_sb_stage5        =Wire(UInt(byteEnWidth.W))
val ByteEn_req_sb_stage6        =Wire(UInt(byteEnWidth.W)) */

//stage 4:p1-p4
   val ByteEn_req_sb_stage4_p1 = xcff(byteEnWidth,g2CLK, localReset,g2ClkEnable,ByteEn_req_sb_stage3)
   val ByteEn_req_sb_stage4_p2 = xcff(byteEnWidth,g2CLK, localReset,g2ClkEnable,ByteEn_req_sb_stage4_p1)
   val ByteEn_req_sb_stage4_p3 = xcff(byteEnWidth,g2CLK, localReset,g2ClkEnable,ByteEn_req_sb_stage4_p2)
   val ByteEn_req_sb_stage4_p4 = xcff(byteEnWidth,g2CLK, localReset,g2ClkEnable,ByteEn_req_sb_stage4_p3)
   val ByteEn_req_sb_stage4    = xcff(byteEnWidth,g2CLK, localReset,g2ClkEnable,ByteEn_req_sb_stage4_p4)
   
   val sel_stage5_ByteEn_nxt_sb    = inc16_req_bank_stage4(bankId)
//ByteEn_req_sb_stage5_nxt_pre: sc req, ByteEn_req_sb_stage4 pipe delayed inc
      ByteEn_req_sb_stage5_nxt :=Xtmux2e(byteEnWidth,ByteEn_req_sb_stage5_nxt_pre, ByteEn_req_sb_stage4,sel_stage5_ByteEn_nxt_sb)
//stage 5
   val ByteEn_req_sb_stage5 = xcff(byteEnWidth,stage5CLK, localReset, g3ClkS5Enable, ByteEn_req_sb_stage5_nxt)
//stage subbankByteBits
   val ByteEn_req_sb_stage6 = xcff(byteEnWidth,stage6CLK, localReset, g3ClkS6Enable, ByteEn_req_sb_stage5)


   val for_final_RdByteEn_req_sb_stage2 = Mux(val_dram_req_sb_stage2,RdByteEn_req_sb_stage2, addr_req_sb_stage2_(sbkId))

    val byte_en_req_sb_for_final = Wire(UInt(byteEnWidth.W))  // val = yield Chisel.Data TYPE?
    byte_en_req_sb_for_final := Mux(io.Subbank_wrbusy_sb(sbkId),final_byte_en_req_sb,
                                       Mux(wr_req_sb_stage5(sbkId), ByteEn_req_sb_stage5,
                                            Mux(io.Subbank_rdbusy_sb(sbkId), for_final_RdByteEn_req_sb_stage2,RdByteEn_req_sb_stage1)))
    final_byte_en_req_sb(sbkId)   := xcff(byteEnWidth,g2CLK,localReset,g2ClkEnable,byte_en_req_sb_for_final)

    //io.final_byte_en_req_sb(sbkId) := final_byte_en_req_sb(sbkId)
    val wr_req_nxt_sb_stage5 =  scatter_rmw_wr_req_sb_stage4|| !io.Subbank_pipe_stall_bank_stage2(bankId) &&
                            val_dram_req_sb_stage2 &&	(sc8_req_bank_stage2(bankId) || sc16_req_bank_stage2(bankId))
                            
    //wr_req_notrmw_nxt_sb_stage5 = WireInit(false.B)
    val wr_req_notrmw_nxt_sb_stage5=	!io.Subbank_pipe_stall_bank_stage2(bankId) && val_dram_req_sb_stage2 && (sc8_req_bank_stage2(sbkId) || sc16_req_bank_stage2(sbkId))|| false.B
   
    wr_req_sb_stage5(sbkId)             := xcff(1,stage5CLK, localReset, g3ClkS5Enable, wr_req_nxt_sb_stage5       )
    val wr_req_notrmw_sb_stage5      = xcff(1,stage5CLK, localReset, g3ClkS5Enable, wr_req_notrmw_nxt_sb_stage5)
     
    val wr_req_sb_stage6             = xcff(1,stage6CLK, localReset, g3ClkS6Enable,(wr_req_sb_stage5(sbkId) && !io.Subbank_pipe_stall_bank_stage5(bankId))) 
    val wr_req_notrmw_sb_stage6      = xcff(1,stage6CLK, localReset, g3ClkS6Enable,(wr_req_notrmw_sb_stage5.asBool && !io.Subbank_pipe_stall_bank_stage5(bankId)))
    final_val_dram_req_sb(sbkId) := Xtmux2e (1, val_dram_req_sb_for_final_stage1,  val_dram_req_sb_for_final_stage2,  io.Subbank_busy_bank(bankId));
    final_wr_req_sb(sbkId)       := Xtmux2e (1, wr_req_sb_stage5(sbkId),            wr_req_sb_stage6,                 io.Subbank_wrbusy_bank(bankId));
    final_wr_req_notrmw_sb(sbkId):= Xtmux2e (1, wr_req_notrmw_sb_stage5,           wr_req_notrmw_sb_stage6,           io.Subbank_wrbusy_bank(bankId));
  }

}



/* class SbReqAddrNByteEnFinalize(val addrWidth:Int=18,val byteEnWidth:Int=8,val numElem:Int=32) extends Module {

  val io=IO(new Bundle{
   val final_val_dram_req_sb = Output(Bool()) 
   val final_wr_req_sb       = Output(Bool()) 
   val final_wr_req_notrmw_sb= Output(Bool()) 
   val final_addr_req_sb     = Output(UInt(addrWidth))   //[17:0]        
   val final_byte_en_req_sb  = Output(UInt(byteEnWidth.W))
   val scatter_rmw_wr_req_sb_stage4 = Output(Bool())
   val ar_addr_grant_raw     = Input(UInt(elemNum.W))
   val ar_req_addr_for_arb_sb= Input(UInt(numElem.W))
  

   val Subbank_rdbusy_bank    = Input(Bool())
   val Subbank_wrbusy_bank    = Input(Bool())
   val Subbank_pipe_stall_bank_stage1 = Input(Bool())
   val Subbank_pipe_stall_bank_stage2 = Input(Bool())
   val rmw_conflict_kill_stage3_t_bank= Input(Bool())

   val G2generalCLK           = Input(Bool())
   val G2generalCLKEn         = Input(Bool())
   val MyReset                = Input(Bool())
   val G3bankStallStage1CLK(i)  = Input(Bool())
   val G3bankStallStage2CLK(i)  = Input(Bool())
   val G3bankStallStage3CLK(i)  = Input(Bool())
   val G3bankStallStage5CLK(i)  = Input(Bool())
   val G3bankStallStage6CLK(i)  = Input(Bool())

   val G3bankStallStage1CLKEn(i)=Input(Bool())
   val G3bankStallStage2CLKEn(i)=Input(Bool())
   val G3bankStallStage3CLKEn(i)=Input(Bool())
   val G3bankStallStage5CLKEn(i)=Input(Bool())
   val G3bankStallStage6CLKEn(i)=Input(Bool())
  })

  val stage3CLK=io.G3bankStallStage3CLK(i)
  val stage5CLK=io.G3bankStallStage5CLK(i)
  val stage6CLK=io.G3bankStallStage6CLK(i)

  val stage1CLK=io.G3bankStallStage1CLK(i)
  val stage1CLKEn =io.G3bankStallStage1CLKEn(i)
  val stage2CLK=io.G3bankStallStage2CLK(i)
  val stage2CLKEn =io.G3bankStallStage2CLKEn(i)
  val stage3CLK=io.G3bankStallStage3CLK(i)
  val stage3CLKEn =io.G3bankStallStage3CLKEn(i)
  
  //val g3ClkS2Enable =!io.WaitClkGate && g2CLKEn && stage2CLKEn

  val g2CLK    =io.G2generalCLK
  val g2CLKEn  =io.G2generalCLKEn
  val localReset    =io.MyReset.asAsyncReset

  val g3ClkS1Enable = (!io.WaitClkGate) && (g2CLKEn) && (stage1CLKEn)
  val g3ClkS2Enable=(!io.WaitClkGate) && (g2CLKEn) && stage2CLKEn
  val g3ClkS3Enable = (!io.WaitClkGate) && (g2CLKEn) && stage3CLKEn
  val g2ClkEnable =(!io.WaitClkGate) && (g2CLKEn)

  val addr_req_nxt_sb_stage1 := Xtmux32(18,ar_addr,io.ar_addr_grant_raw)
  val addr_req_sb_stage1   = xcff(18,stage1CLK,localReset,g3ClkS1Enable,addr_req_nxt_sb_stage1)
  val addr_req_sb_stage2    =xcff(18,stage2CLK,localReset,g3ClkS2Enable,addr_req_sb_stage1)
  val addr_req_sb_stage3    =xcff(entryAddrBits,stage3CLK,localReset,g3ClkS3Enable,addr_req_sb_stage2(17,subbankByteBits))
  
  val addr_req_sb_stage4_p1 =xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage3)
  val addr_req_sb_stage4_p2 =xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p1)
  val addr_req_sb_stage4_p3 =xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p2)
  val addr_req_sb_stage4_p4 =xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p3)
  val addr_req_sb_stage4    =xcff(entryAddrBits,g2CLK,localReset,g2ClkEnable,addr_req_sb_stage4_p4)
 // Mux inc16
  val addr_req_nxt_sb_stage5 =io.inc16_req_bank0_stage4 ?addr_req_sb_stage4:addr_req_sb0_stage2(17,subbankByteBits)

  val addr_req_sb_stage5    =xcff(entryAddrBits,stage5CLK,localReset,g3ClkS5Enable,addr_req_nxt_sb_stage5)
  val addr_req_sb_stage6    =xcff(entryAddrBits,stage56LK,localReset,g3ClkS6Enable,addr_req_sb_stage5)
  //for_final_addr_req_sb0_stage1 = val_dram_req_sb0_stage1 ?						addr_req_sb0_stage1 :		addr_req_sb0_stage1;
  val for_final_addr_req_sb_stage2=addr_req_sb_stage2
  val for_final_addr_req_sb_stage1=addr_req_sb_stage1
  
  val final_addr_req_sb  = Wire(UInt(18.W))
  val	addr_req_sb_for_final  =Subbank_wrbusy_sb ? final_addr_req_sb:
					 wr_req_sb0_stage5 ? addr_req_sb_stage5:
					 Subbank_rdbusy_sb ?  for_final_addr_req_sb_stage2:for_final_addr_req_sb_stage1
   io.final_addr_req_sb = xcff(18,g2CLK,localReset,g2ClkEnable,addr_req_sb_for_final)
// reg [17:0] final_addr_req_sb0_reg;
// assign final_addr_req_sb0 = final_addr_req_sb0_reg;
// always @(posedge G2generalCLK or posedge MyReset) final_addr_req_sb0_reg <= `XT_SEQ_DELAY MyReset ? 18'b0 :
//     ((~WaitClkGate) & (G2generalCLKEn)) ? addr_req_sb0_for_final : final_addr_req_sb0_reg;

  val val_dram_req_sb_for_final_stage1= Wire(Bool())
  val wr_req_sb_stage5                = Wire(Bool())
  val wr_req_notrmw_sb_stage5         = Wire(Bool())
  
  //val                   = io.ar_req_addr_for_arb_sb
 
  val val_dram_req_nxt_sb_stage1      = ar_addr_grant_sb.reduce(_|_)
  val val_dram_req_sb_stage1          = Wire(Bool())
  val val_dram_req_sb_stage2          = Wire(Bool())
  val val_dram_req_sb_stage3_pre      = Wire(Bool())
  val val_dram_req_sb_stage3          = Wire(Bool())
  val val_dram_req_sb_stage4_p1       = Wire(Bool())
  val val_dram_req_sb_stage4_p2       = Wire(Bool())
  val val_dram_req_sb_stage4_p3       = Wire(Bool())
  val val_dram_req_sb_stage4_p4       = Wire(Bool())
  val val_dram_req_sb_stage4          = Wire(Bool())
  val val_dram_req_sb_stage5          = Wire(Bool())
  val val_dram_req_sb_stage6          = Wire(Bool())

  val scatter_rmw_wr_req_sb_stage2    = val_dram_req_sb_stage2    && inc16_req_bank0_stage2;
  val scatter_rmw_wr_req_sb_stage3    = val_dram_req_sb_stage3    && inc16_req_bank0_stage3;
  val scatter_rmw_wr_req_sb_stage4_p1 = val_dram_req_sb_stage4_p1 && inc16_req_bank0_stage4_p1;
  val scatter_rmw_wr_req_sb_stage4_p2 = val_dram_req_sb_stage4_p2 && inc16_req_bank0_stage4_p2;
  val scatter_rmw_wr_req_sb_stage4_p3 = val_dram_req_sb_stage4_p3 && inc16_req_bank0_stage4_p3;
  val scatter_rmw_wr_req_sb_stage4_p4 = val_dram_req_sb_stage4_p4 && inc16_req_bank0_stage4_p4;
  //the aboves useless?
  val scatter_rmw_wr_req_sb_stage4    = val_dram_req_sb_stage4    && inc16_req_bank0_stage4;
   io.scatter_rmw_wr_req_sb_stage4    := scatter_rmw_wr_req_sb_stage4
  //useless?
  val scatter_rmw_wr_req_sb_stage5    = val_dram_req_sb_stage5    && inc16_req_bank0_stage5;
  val scatter_rmw_wr_req_sb_stage6    = val_dram_req_sb_stage6    && inc16_req_bank0_stage6;
  
 
      val_dram_req_sb_stage1 :=xcff(1,stage1CLK,localReset,g3ClkS1Enable, val_dram_req_nxt_sb_stage1)
      val_dram_req_sb_stage2 :=xcff(1,stage2CLK,localReset,g3ClkS2Enable, val_dram_req_sb_stage&&!io.Subbank_pipe_stall_bank_stage1)
  val val_dram_req_nxt_sb_stage3 = val_dram_req_sb_stage2 && !io.Subbank_pipe_stall_bank_stage2
				                        	&& !(sc8_req_bank0_stage2 || sc16_req_bank0_stage2)

      val_dram_req_sb_stage3_pre :=xcff(1,stage3CLK,localReset,val_dram_req_nxt_sb_stage3)
  val val_dram_req_sb_stage3 = val_dram_req_sb_stage3_pre && !io.rmw_conflict_kill_stage3_t_bank0;
 

      val_dram_req_sb_stage4_p1      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage3  )
      val_dram_req_sb_stage4_p2      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p1 ) 
      val_dram_req_sb_stage4_p3      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p2)
      val_dram_req_sb_stage4_p4      :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p3)
      val_dram_req_sb_stage4         :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4_p4)
      val_dram_req_sb_stage4_copy0   :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4)
      val_dram_req_sb_stage4_copy1   :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4)
      val_dram_req_sb_stage5         :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage4    )
      val_dram_req_sb_stage6         :=xcff(1,g2CLK,localReset,g2ClkEnable , val_dram_req_sb_stage5    )   

  // Byte Enable 
  val RdByteEn_req_sb_stage1  = Mux(val_dram_req_sb_stage1, Fill(byteEnWidth, 1.U), 0.U(byteEnWidth.W))

  
  
  val ByteEn_sc_req_sb_hw   =  Wire(UInt(2.W))
  val ByteEn_scinc_req_sb_hw=  Wire(UInt(2.W))
  
  for (i <- 0 until hwNum){
    val sc_valid = io.ar_data_grant_scatter_valid_bank_sb_hw_stage2(i)
    val byte_num = io.ar_data_grant_byte_num_bank_sb_hw_stage2(i)
    ByteEn_sc_req_sb_hw(i) := Mux(sc_valid, 
                                     Mux(io.sc16_req_bank0_stage2 || (io.sc8_req_bank0_stage2 && byte_num), "b11".U, "b10".U),
                                     "b00".U)
    ByteEn_scinc_req_sb_hw(i) := Mux(sc_valid && io.inc16_req_bank0_stage2, "b11".U, "b00".U)
 }

val ByteEn_req_sb_stage2        = Wire(UInt(byteEnWidth.W))
val ByteEn_req_sb_stage5_nxt    = Wire(UInt(byteEnWidth.W))
val ByteEn_req_sb_stage5_nxt_pre= Wire(UInt(byteEnWidth.W))

    ByteEn_req_sb_stage5_nxt_pre   := Cat(ByteEn_sc_req_sb_hw.reverse)  //?
    ByteEn_req_sb_stage2           := Cat(ByteEn_scinc_req_sb_hw.reverse)
//stage 2
val RdByteEn_req_sb_stage2  = xcff(byteEnWidth,io.G3bankStallStage2CLK(i),localReset,g3ClkGateEnable,RdByteEn_req_sb_stage1)
//stage 3
val g3ClkS3GateEnale =!io.WaitClkGate && g2CLKEn && stage3CLKEn
val ByteEn_req_sb_stage3 = xcff(byteEnWidth,stage3CLK,localReset,g3ClkS3GateEnable,ByteEn_req_sb_stage2)


val ByteEn_req_sb_stage5        =Wire(UInt(byteEnWidth.W))
val ByteEn_req_sb_stage6        =Wire(UInt(byteEnWidth.W))

//stage 4:p1-p4
val ByteEn_req_sb4_stage4_p1 := xcff(byteEnWidth,g2CLK, localReset.asAsyncReset,g2ClkEnable,ByteEn_req_sb_stage3)
val ByteEn_req_sb4_stage4_p2 := xcff(byteEnWidth,g2CLK, localReset.asAsyncReset,g2ClkEnable,ByteEn_req_sb4_stage4_p1)
val ByteEn_req_sb4_stage4_p3 := xcff(byteEnWidth,g2CLK, localReset.asAsyncReset,g2ClkEnable,ByteEn_req_sb4_stage4_p2)
val ByteEn_req_sb4_stage4_p4 := xcff(byteEnWidth,g2CLK, localReset.asAsyncReset,g2ClkEnable,ByteEn_req_sb4_stage4_p3)
val ByteEn_req_sb4_stage4    := xcff(byteEnWidth,g2CLK, localReset.asAsyncReset,g2ClkEnable,ByteEn_req_sb4_stage4_p4)

val sel_stage5_ByteEn_nxt_sb    = io.inc16_req_bank_stage4
//ByteEn_req_sb_stage5_nxt_pre: sc req, ByteEn_req_sb_stage4 pipe delayed inc
Xtmux2e(byteEnWidth,ByteEn_req_sb_stage5_nxt, ByteEn_req_sb_stage5_nxt_pre, ByteEn_req_sb_stage4,sel_stage5_ByteEn_nxt_sb)
//stage 5
ByteEn_req_sb_stage5:= xcff(byteEnWidth,stage5CLK, localReset,  ByteEn_req_sb_stage5_nxt)
//stage subbankByteBits
ByteEn_req_sb_stage6:= xcff(byteEnWidth,stage6CLK, localReset,  ByteEn_req_sb_stage5)
val final_byte_en_req_sb = Wire(UInt(byteEnWidth))

// assign	for_final_RdByteEn_req_sb0_stage2 = val_dram_req_sb0_stage2 ?
// 						RdByteEn_req_sb0_stage2 :
// 						addr_req_sb0_stage2;

val byte_en_req_sb_for_final = Subbank_wrbusy_sb ? final_byte_en_req_sb: 
                                wr_req_sb_stage5 ? ByteEn_req_sb_stage5: 
                                Subbank_rdbusy_sb ? for_final_RdByteEn_req_sb_stage2: RdByteEn_req_sb_stage1
    final_byte_en_req_sb   := xcff(byteEnWidth,g2CLK,localReset,g2ClkEnable,byte_en_req_sb_for_final)

    io.final_byte_en_req_sb := final_byte_en_req_sb
val wr_req_nxt_sb_stage5 =  scatter_rmw_wr_req_sb_stage4|| !io.Subbank_pipe_stall_bank_stage2(bankId) &&
                            val_dram_req_sb_stage2 &&	(sc8_req_bank_stage2(bankId) || sc16_req_bank_stage2(bankId))
                            
    wr_req_notrmw_nxt_sb_stage5 = WireInit(false.B)
val wr_req_notrmw_nxt_sb_stage5=	!io.Subbank_pipe_stall_bank_stage2(bankId) && val_dram_req_sb_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2)


    wr_req_sb_stage5(sbkId)        := xcff(1,stage5CLK, localReset, g3ClkS5Enable, wr_req_nxt_sb_stage5       )
    wr_req_notrmw_sb_stage5 := xcff(1,stage5CLK, localReset, g3ClkS5Enable, wr_req_notrmw_nxt_sb_stage5)

    wr_req_sb_stage6        := xcff(1,stage6CLK, localReset, g3ClkS6Enable,(wr_req_sb_stage5(sbkId) && !io.Subbank_pipe_stall_bank0_stage5)) 
    wr_req_notrmw_sb_stage6 := xcff(1,stage6CLK, localReset, g3ClkS6Enable,(wr_req_notrmw_sb_stage5 && !io.Subbank_pipe_stall_bank0_stage5))

 io.final_val_dram_req_sb :=Xtmux2e (1,val_dram_req_sb_for_final_stage1,  val_dram_req_sb_for_final_stage2, io.Subbank_busy_bank)
 io.final_wr_req_sb       :=Xtmux2e (1,wr_req_sb_stage5,                  wr_req_sb_stage6,                 io.Subbank_wrbusy_bank)
 io.final_wr_req_notrmw_sb:=Xtmux2e (1,wr_req_notrmw_sb_stage5,           wr_req_notrmw_sb_stage6,          io.Subbank_wrbusy_bank)
//  Xtmux2e (1,io.final_sc8_req_sb,       sc8_req_bank0_stage1,              sc8_req_bank0_stage2,             io.Subbank_busy_bank(bkId));
//  Xtmux2e (1,io.final_sc16_req_sb,      sc16_req_bank0_stage1,             sc16_req_bank0_stage2,            io.Subbank_busy_bank(bkId));
//  Xtmux2e (1,io.final_inc16_req_sb,     inc16_req_bank0_stage1,            inc16_req_bank0_stage2,           io.Subbank_busy_bank(bkId));
//  Xtmux2e (1,io.final_dram_id_wrreq_sb, dram_id_req_bank0_stage5,          dram_id_req_bank0_stage6,         io.Subbank_wrbusy_bank0);
//  Xtmux2e (1,io.final_dram_id_rdreq_sb, dram_id_req_bank0_stage1,          dram_id_req_bank0_stage2,         io.Subbank_busy_bank(bkId));

}
 */