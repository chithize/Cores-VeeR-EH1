 // Gather/Scatter  Registers Staging Pipeline
import chisel3._
import chisel3.util._

class GatherRegisterCtrl(eleNum:Int=32,eleWidth:Int=16,regNo:Int=0) extends Module {
 val io = IO(new Bundle {

   val waitClkGate = Input(Bool())
   val G2generalCLK = Input(Clock())
   val MyReset = Input(Bool())


   // Inputs
   val gatherD_L1 = Input(Bool())
   val gatherA_L1 = Input(Bool())
   val movgatherD_L1= Input(Bool())
   val gvrRd0AddrL1 = Input(UInt(3.W))
   val gvrWr0AddrL1 = Input(UInt(3.W))
   val valid_L2     = Input(Bool())
   val killPipeW    = Input(Bool())
   val valid_M      = Input(Bool())
   val stall_R1toM  = Input(Bool())
   val gatherA_M    = Input(Bool())
   val movgatherD_M = Input(Bool())
   val gvrWr0AddrM  = Input(UInt(3.W))
   val gatherA_C    = Input(Bool())
   val movgatherD_C = Input(Bool())
   val gvrWr0AddrC  = Input(UInt(3.W))
   val gatherA_W    = Input(Bool())
   val movgatherD_W = Input(Bool())
   val gvrWr0AddrW  = Input(UInt(3.W))
   val gatherA_D2   = Input(Bool())
   val movgatherD_D2 = Input(Bool())
   val gvrWr0AddrD2 = Input(UInt(3.W))
   val gsPredicate_D2 = Input(UInt(eleNum.W))
   val g2Ele_Size1B_D2 = Input(Bool())

   val nextAge = Input(UInt(4.W))
   val arFinishAge1 = Input(Bool())
   val arFinishAge0 = Input(Bool())
   val gatherAValidStage2_Ele = Input(Vec(eleNum,Bool()))
   val arGrsrNumStage2_Ele = Input(Vec(eleNum,UInt(3.W)))
  
   val gatherAValidStage2_Ele = Input(Vec(eleNum,Bool()))
   val arGrsrNumStage2_Ele    = Input(Vec(eleNum,UInt(3.W)))
   val gr_sgeDataWrStage5     = Input(Vec(eleNum, Bool()))
   val gsDramID_D2 = Input(UInt(32.W))
   val grAddr_D2   = Input(UInt(regWidth.W))
   val grData      = Input(UInt(regWidth.W))
   val gsAddrExtendedW = Input(UInt(2*eleNum.W))

   val nextArAge = Input(UInt(4.W))
   val arAddrSel = Input(Vec(eleNum,UInt(3.W)))
   val arAddrSet = Input(Vec(eleNum,Bool()))
   val arAddrEn  = Input(Bool())
   val arAddrIssuedToDramForReady = Input(Vec(eleNum,Bool()))
   val arAddrAge = Input(Vec(eleNum,Bool()))
   val finishArOp = Input(Bool())
   
   val grReady             = Output(Vec(eleNum,Bool()))
   val gr_sgStallInclStall = Output(Bool())
   val gr_sgStall          = Output(Bool())
   val gr_Ad               = Output(UInt(regWidth.W))
   val gr_ExtendedAd       = Output(UInt((eleNum*2).U))
 
 })
 val regWidth    = eleNum*eleWidth 
 val gr_wrSelect = Wire(UInt(3.W))

 
 val gr_AdSet_Ele = VecInit(seq.fill(eleNum)(Wire(Bool())))
 // ... (repeat for elements 1 to 31)
 //val gr_Ele31AdSet = Wire(Bool())
 //val gr_Ele31AdSet = Wire(Bool())

 val gr_ActiveNxt = Wire(Bool())
 val gr_ActiveSet = Wire(Bool())
 val gr_ActiveReg = RegInit(false.B)
 val gr_Active = Wire(Bool())

 val gr_Ga8u = Wire(Bool())

 val gr_AdNxt = Wire(UInt(regWidth.W))


 val gr_DramNxt = Wire(UInt(eleNum.W))
 val gr_DramReg = RegInit(0.U(eleNum.W))
 val gr_Dram = Wire(UInt(eleNum.W))

 val gr_MgdSet = Wire(Bool())
 val gr_GrSet  = Wire(Bool())
 val gr_ReadyNxt = Wire(UInt(eleNum.W))
 val gr_Ready0 = Wire(UInt(eleNum.W))

 val gr_InProgNxt = Wire(UInt(eleNum.W))
 val gr_InProgReg = RegInit(0.U(eleNum.W))
 val gr_InProg = Wire(UInt(eleNum.W))

 val gr_GatherDBusyVecReg = RegInit(0.U(eleNum.W))
 val gr_GatherDBusyVecNxt = Wire(UInt(eleNum.W))
 val gr_GatherDBusyVec = Wire(UInt(eleNum.W))
 
 val gr_NextAgeDecAmt = Wire(UInt(4.W))
 val gr_AgeNxtPre = Wire(UInt(4.W))
 val gr_AgeNxt = Wire(UInt(4.W))
 val gr_Age = RegInit(0.U(4.W))


 val gr_GAbusyInst_L1 = Wire(Bool())
 val gr_GAbusyInst_L2Pre = RegInit(false.B)
 val gr_GAbusyInst_L2 = Wire(Bool())
 val gr_GAbusyInst_MPre = RegInit(false.B)
 val gr_GAbusyInst_M = Wire(Bool())
 val gr_BsyStateReg = RegInit(0.U(3.W))
 val gr_BsyState_nxt = Wire(UInt(3.W))

 val gr_PipeBusyReg = RegInit(false.B)
 val gr_PipeBusy = Wire(Bool())
 

 val gr_DataMaskGr = Wire(UInt(regWidth.W))

/*  val gr_Ad150Reg = RegInit(0.U(16.W))
 
 val gr_ExtendedAd10Reg = RegInit(0.U(2.W))
 val gr_ExtendedAd = Wire(UInt(64.W))
 // ... (repeat for elements 1 to 31)
 val gr_Ad511496Reg = RegInit(0.U(16.W))
 val gr_ExtendedAd6362Reg = RegInit(0.U(2.W)) */

 
 // Assignments
 gr_WrSelect := Cat(gr_MgdSet, gr_GaSet, !gr_MgdSet && !gr_GaSet)
 gr_GaSet := io.gatherA_D2 && io.gvrWr0AddrD2 === regNo.U
 gr_MgdSet := io.movgatherD_D2 && io.gvrWr0AddrD2 === regNo.U
/* 
 gr_Ele0AdSet := gr_MgdSet || gr_GaSet || io.gsPredicate_D2(0)
 // ... (repeat for elements 1 to 31)
 gr_Ele31AdSet := gr_MgdSet || gr_GaSet || io.gsPredicate_D2(31)

val gr0_ele_ad_set = Wire(Vec(32, Bool())) */
//6147-6213
for (i <- 0 until eleNum) {
  gr_AdSet_Ele(i) := gr_MgdSet || gr_GaSet || gr_sgeDataWrStage5(i)
}

  gr_NextAgeDecAmt := Mux(!gr_GaSet && gr_Age === 0.U, 0.U, Cat(0.U(2.W), io.arFinishAge1 && io.arFinishAge0, io.arFinishAge1 ^ io.arFinishAge0))
  gr_AgeNxtPre := Mux(gr_GaSet, io.nextAge, gr_Age)
  gr_AgeNxt := gr_AgeNxtPre - gr_NextAgeDecAmt

  gr_GAbusyInst_L2 := gr_GAbusyInst_L2Pre && io.valid_L2 && !io.killPipeW
  gr_GAbusyInst_M := gr_GAbusyInst_MPre && io.valid_M && !io.killPipeW
  gr_GAbusyInst_L1 := (io.gatherD_L1 && io.gvrRd0AddrL1 === 0.U) || ((io.gatherA_L1 || io.movgatherD_L1) && io.gvrWr0AddrL1 === 0.U)

withClockAndReset(io.G2generalCLK, io.myReset.asAsyncReset) {
      gr_Ga8u := RegNext(Mux(io.myReset.asBool, false.B, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, gr_Ga8u, Mux(gr_GaSet && !io.waitClkGate.asBool && io.G2generalCLKEn, io.g2EleSize1BD2, gr_Ga8u))), false.B)
      gr_Age := RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, gr_Age, gr_AgeNxt)), 0.U)
          
 }

 withClockAndReset(io.G2SCLK, io.myReset.asAsyncReset) {
     gr_GAbusyInst_L2Pre := RegNext(Mux(io.myReset.asBool, false.B, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn(1), gr_GAbusyInst_L2Pre, GAbusyInst_gr_L1)), false.B)
     gr_GAbusyInst_MPre := RegNext(Mux(io.myReset.asBool, false.B, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn(1), gr_GAbusyInst_MPre, GAbusyInst_gr_L2)), false.B)
 }

gr_BsyState_nxt := MuxCase(0.U, Array(
   (gr_BsyStateReg === "b000".U && (io.gatherA_M || io.movgatherD_M) && io.gvrWr0AddrM === 0.U && !io.stall_R1toM) -> "b001".U,
   (gr_BsyStateReg === "b001".U && (io.gatherA_C || io.movgatherD_C) && io.gvrWr0AddrC === 0.U) -> "b010".U,
   (gr_BsyStateReg === "b010".U && (io.gatherA_W || io.movgatherD_W) && io.gvrWr0AddrW === 0.U) -> "b011".U,
   (gr_BsyStateReg === "b011".U && (io.gatherA_D2 || io.movgatherD_D2) && io.gvrWr0AddrD2 === 0.U && !gr_GatherDBusyVecNxt.orR) -> "b000".U,
   (gr_BsyStateReg === "b011".U && (io.gatherA_D2 || io.movgatherD_D2) && io.gvrWr0AddrD2 === 0.U && gr_GatherDBusyVecNxt.orR) -> "b100".U,
   (gr_BsyStateReg === "b100".U && gr_GatherDBusyVecNxt.orR) -> "b100".U
 ))
 
 withClockAndReset(io.G2W1CLK, io.myReset.asAsyncReset) {
    gr_BsyStateReg := RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2W1CLKEn, gr_BsyStateReg, gr_BsyState_nxt)), 0.U)
 }

 gr_InProgNxt := Mux(gr_GaSet, io.gsPredicate_D2, Mux(gr_MgdSet, 0.U, gr_InProgReg & ~io.gsPredicate_D2))
 val updateMask = Cat(io.gatherA_valid_stage2.zip(io.ar_grsr_num_stage2).map { case (valid, num) =>
    valid && (num === regNo.U)
  }.reverse) // 注意：Cat在Chisel中是MSB到LSB，而Vec的遍历是从头到尾，可能需要反转

 gr_GatherDBusyVecNxt := Mux(gr_GaSet, io.gsPredicate_D2, Mux(gr_MgdSet, 0.U, gr_GatherDBusyVecReg & ~updateMask))
 
 withClockAndReset(io.G2generalCLK, io.myReset.asAsyncReset) {
  gr_InProgReg   := RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, gr_InProgReg, gr_InProgNxt)), 0.U)
  gr_PipeBusyReg := RegNext(Mux(io.myReset.asBool, false.B, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, gr_PipeBusyReg, gr_InProgNxt.orR)), false.B)
  gr_GatherDBusyVecReg := RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, gr_GatherDBusyVecReg, gr_GatherDBusyVecNxt)), 0.U)
  gr_DramReg := RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, gr_DramReg, Mux(gr_GaSet, gr_DramNxt, gr_DramReg))), 0.U)
 }
 
 gr_InProg := gr_InProgReg
 gr_PipeBusy := gr_PipeBusyReg
 gr_GatherDBusyVec := gr_GatherDBusyVecReg

 gr_sgStallInclStall := gr_GAbusyInst_L2Pre && gr_GAbusyInst_MPre || gr_GAbusyInst_L2Pre && gr_BsyStateReg(2)
 gr_sgStall := gr_GAbusyInst_MPre && gr_BsyStateReg(2)

 gr_DramNxt := Fill(eleNum, io.gsDramID_D2)
 gr_Dram := gr_DramReg

//gr0_data_mask_gr = {32{{{8{!gr0_ga8u}}, 8'hff}}};
 gr_DataMaskGr :=  Cat(Seq.fill(32)(Cat(Fill(8, !io.gr0_ga8u), "hff".U(8.W))).reverse:_*)// Fill(regWidth, Fill(8, Mux(!gr_Ga8u, 0.U, 0xff.U.asUInt)))
 gr_AdNxt := Mux1H(Cat(gr_WrSelect), Seq(io.grData & gr_DataMaskGr, io.grAddr_D2, io.gvrWr0DataD1))

  // 为了能够在生成的RTL中保持与Verilog代码一致的net名称，我们在这里使用注解
/*   (gr_Ad zip gr_ExtendedAd zip gr_AdSet_Ele zip gr_AdNxt zip io.gsAddrExtendedW).zipWithIndex.foreach {
    case (((((adReg, extendedReg), adSet), adNxt), extendedNxt), idx) =>
      withClockAndReset(io.G2generalCLK, io.MyReset.asAsyncReset()) {
        when(!io.WaitClkGate && io.G2generalCLKEn && adSet) {
          adReg := adNxt
          extendedReg := extendedNxt
        }
      }
 */
  withClockAndReset(io.G2generalCLK, io.myReset.asAsyncReset()) {
    // 创建和更新寄存器
    val gr_ad        = WireInit(VecInit(Seq.fill(eleNum)(0.U(eleWidth.W))))
    val gr_extended_ad        = WireInit(VecInit(Seq.fill(eleNum)(0.U(2.W))))
    val gr_active_nxt := gr_GaSet && io.GSPredicate_D2.orR
    val gr_active        = WireInit(0.U(1.W))
    val gr_active_set = Wire(Bool())
    gr_active_set: = gr_GaSet || ((gr_Age===1.U)&&arFinishAge1 ||(gr_age===0.U)&&arFinishAge0)
    // 更新逻辑
    for (i <- 0 until eleNum) {
      // 更新gr0_ad寄存器数组
      when((!io.WaitClkGate) && io.G2generalCLKEn && gr_AdSet_Ele(i)) {
        gr_ad(i) := gr_AdNxt(16 * i + 15, 16 * i)
      }

      // 更新gr0_extended_ad寄存器数组
      when((!io.WaitClkGate) && io.G2generalCLKEn && gr_AdSet_Ele(i)) {
        gr_extended_ad(i) := io.gsAddrExtendedW(2 * i + 1, 2 * i)
      }

      when((!io.WaitClkGate) && io.G2generalCLKEn && gr_active_set){
        gr_active:= gr_active_nxt
      }

    }

    // 将寄存器数组连接为单个宽位宽信号
    gr_Ad := gr_ad.asTypeOf(UInt(eleWidth*eleNum.W))
    gr_ExtendedAd := gr_extended_ad.asTypeOf(UInt(eleNum*2.W))
  }

 val gr_ReadyPre      = RegInit(VecInit(Seq.fill(eleNum)(false.B)))
 val gr_ReadyNxt   = Wire(Vec(eleNum,Bool()))
 val gr_ReadySet   = Wire(Vec(eleNum,Bool()))
 val gr_Ready      = Wire(Vec(eleNum,Bool()))

for(i <- 0 until eleNum ){
    gr_ReadyNxt(i):=gr_GaSet && io.GSPredicate_D2(i) && (!((nextArAge===0.U || nextArAge===1.U) && arAddrSel(i)(0)&&arAddrSet(i)))
    gr_ReadySet(i):=gr_GaSet || gr_MgdSet || gr_ReadyPre(i)&&(((gr_Age===1.U)&&((!arAddrEn(i)||arAddrIssuedToDramForReady(i)&&!arAddrAge(i))) || (gr_Age===2.U)&&finishArOp &&(!arAddrEn(i)||arAddrIssuedToDramForReady(i)))
    withClockAndReset(io.G2generalCLK,io.myReset)    {
      gr_ReadyPre(i):=Mux(io.myReset,false.B,Mux((!io.WaitClkGate) & (io.G2generalCLKEn) & (gr_ReadySet(i)),gr_ReadyNxt,gr_ReadyPre))
    }
    gr_Ready(i):=gr_ReadyPre(i)
 }
 io.grReady:=gr_Ready
  

 val gr_Age0Active = Wire(Bool())
 val gr_Age0DramId = Wire(Bool())
 val gr_Age1Active = Wire(Bool())
 val gr_Age1Ready  = Wire(Bool())
 val gr_Age1DramId = Wire(Bool())

 gr_Age0Active:= (gr_Age===0.U) && gr_Active
 gr_Age0DramId:= gr_Dram(0)&&gr_Age0Active
 gr_Age1Active:= (gr_Age===1.U) && gr_Active
 gr_Age1Ready := (gr_Age===1.U) && grReady.orR
 gr_Age1DramId:= gr_Dram(0)&&gr_Age1Active

}


class ScatterRegisterCtrl(eleNum:Int=32,eleWidth:Int:16,regNo:Int=0) extends Module {
 val io = IO(new Bundle {

   val waitClkGate = Input(Bool())
   val G2generalCLK = Input(Clock())
   val MyReset = Input(Bool())
   val valid_L2 = Input(Bool())
   val killPipeW = Input(Bool())

   val gsPredicate_D2 = Input(UInt(eleNum.W))
   val g2EleSize1B_D2 = Input(Bool())
   val nextAge = Input(UInt(4.W))
   val arFinishAge1 = Input(Bool())
   val arFinishAge0 = Input(Bool())

   val valid_M = Input(Bool())


   val gsDramID_D2 = Input(UInt(32.W))

   val nextArAge = Input(UInt(4.W))
   val arAddrSel = Input(Vec(eleNum,UInt(3.W)))
   val arAddrSet = Input(Vec(eleNum,Bool()))
   val arAddrEn = Input(Bool())
   val arAddrIssuedToDramForReady = Input(Vec(eleNum,Bool()))
   val arAddrAge = Input(Vec(eleNum,Bool()))
   val finishArOp = Input(Bool())
   //source D2:A->L1->L2->M->C-W->X->Y->D0->D1->D2 
   val Scatter_D2 = Input(Bool())
   val Scatter_D1 = Input(Bool())
   val sr_Addr_D2 = Input(UInt((eleNum*(eleWidth+2).W)))

   val vectorScatterData0_D1=Input(UInt((eleNum*(eleWidth).W)

//from ScEleSignal
   val scatter_valid_stage5 = Input(Bool())
   val ar_sr_num_stage5     = Input(UInt(4.W))


   val srReady       = Output(Vec(eleNum,Bool()))
   val sr_Age0Active = Output(Bool())
   val sr_Age0DramId = Output(Bool())
   val sr_age0_sc8   = Output(Bool())
   val sr_age0_sc16  = Output(Bool())
   val sr_age0_inc16 = Output(Bool())
   val sr_Age1Active = Output(Bool())
   val sr_Age1Ready  = Output(Bool())
   val sr_Age1DramId = Output(Bool())
   val sr_age1_sc8   = Output(Bool())
   val sr_age1_sc16  = Output(Bool())
   val sr_age1_inc16 = Output(Bool())
   val sr_Age        = Output(UInt(4.W))
/*   val sr_sgStallInclStall = Output(Bool())
   val sr_sgStall = Output(Bool())
   val sr_Ad = Output(UInt(regWidth.W))
   val sr_ExtendedAd = Output(UInt((eleNum*2).U))*/
 
 })
 //val regWidth    = eleNum*eleWidth 
 //val sr_wrSelect = Wire(UInt(3.W))
 //val sr_sgeDataWrStage5= Wire(Vec(eleNum, Bool()))
 
 //val sr_AdSet_Ele = VecInit(seq.fill(eleNum)(Wire(Bool())))
 val sr_DataSet = Wire(Bool())
 val sr_AddrSet = Wire(Bool())

 val sr_ActiveNxt = Wire(Bool())
 val sr_ActiveSet = Wire(Bool())
 val sr_ActiveReg = RegInit(false.B)
 val sr_Active = Wire(Bool())

 val sr_Sc8 = Wire(Bool())
 val sr_Sc16 = Wire(Bool())
 val sr_Inc16 = Wire(Bool())
 val sr_Addr = Wire(UInt((eleNum*(eleWidth+2).W)))  //18*32
 val sr_Data = Wire(UInt((eleNum*(eleWidth).W)))  //16*32
 val sr_DataNxt = Wire(UInt((eleNum*(eleWidth).W)))  //16*32

 //val sr_AdNxt = Wire(UInt(regWidth.W))


 val sr_DramNxt = Wire(UInt(eleNum.W))
 val sr_DramReg = RegInit(0.U(eleNum.W))
 val sr_Dram = Wire(UInt(eleNum.W))

 // val sr_MgdSet = Wire(Bool())
 // val sr_GrSet  = Wire(Bool())
 val sr_ReadyNxt = Wire(UInt(eleNum.W))
 val sr_Ready0 = Wire(UInt(eleNum.W))

 val sr_InProgNxt = Wire(UInt(eleNum.W))
 val sr_InProgReg = RegInit(0.U(eleNum.W))
 val sr_InProg = Wire(UInt(eleNum.W))
 
 val sr_NextAgeDecAmt = Wire(UInt(4.W))
 val sr_AgeNxtPre = Wire(UInt(4.W))
 val sr_AgeNxt = Wire(UInt(4.W))

 val sr_PipeBusyReg = RegInit(false.B)
 val sr_PipeBusy = Wire(Bool())
 
 // Assignments
// sr_WrSelect := Cat(sr_MgdSet, sr_GaSet, !sr_MgdSet && !sr_GaSet)
 sr_AddrSet := io.Scatter_D2 && (sr_NextAddr_D2 === regNo.U)
 sr_DataSet := io.Scatter_D1 && (sr_NextAddr_D1 === regNo.U)

  sr_NextAgeDecAmt := Mux(!sr_AddrSet && sr_Age === 0.U, 0.U, Cat(0.U(2.W), io.arFinishAge1 && io.arFinishAge0, io.arFinishAge1 ^ io.arFinishAge0))
  sr_AgeNxtPre := Mux(sr_AddrSet, io.nextAge, sr_Age)
  sr_AgeNxt  := sr_AgeNxtPre - sr_NextAgeDecAmt
  sr_DramNxt := Fill(eleNum,io.GSDramID_D2)
  val sr_AddrNxt := Mux(sr_AddrSet,sr_Addr,sr_Addr_D2)
  /*sr_GAbusyInst_L2 := sr_GAbusyInst_L2Pre && io.valid_L2 && !io.killPipeW
  sr_GAbusyInst_M := sr_GAbusyInst_MPre && io.valid_M && !io.killPipeW
  sr_GAbusyInst_L1 := (io.gatherD_L1 && io.gvrRd0AddrL1 === 0.U) || ((io.gatherA_L1 || io.movgatherD_L1) && io.gvrWr0AddrL1 === 0.U)
*/
 sr_DataNxt := sr_DataSet ? io.vectorScatterData0_D1:sr_Data

 val srMask = Cat(io.scatter_valid_stage5.zip(io.ar_sr_num_stage5).map { case (valid, num) =>
    valid && (num === regNo.U)
  }.reverse) // 注意：Cat在Chisel中是MSB到LSB，而Vec的遍历是从头到尾，可能需要反转

 sr_InProgNxt := Mux(sr_AddrSet, io.gsPredicate_D2,sr_InProg & (!srMask) )



 withClockAndReset(io.G2generalCLK, io.myReset.asAsyncReset) {
    val sr_AgeReg     = RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_AgeReg, sr_AgeNxt)), 0.U)
    val sr_AddrReg    = RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_AddrReg, sr_AddrNxt)), 0.U)
   
    val sr_DramReg    = RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn || (!sr_AddrSet), sr_Dram, sr_DramNxt)), 0.U)
   
    val sr_Sc8Reg     = RegNext(Mux(io.myReset.asBool, false.B, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_Sc8Reg,  Mux(sr_GaSet && !io.waitClkGate.asBool && io.G2generalCLKEn, io.g2EleSize1B_D2&&(!io.ScatterInc_D2), sr_Sc8))), false.B)
    val sr_Sc16Reg    = RegNext(Mux(io.myReset.asBool, false.B, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_Sc16Reg, Mux(sr_GaSet && !io.waitClkGate.asBool && io.G2generalCLKEn, (io.g2EleSize1B_D2||io.G2eleSize_4B_D2)&&(!io.ScatterInc_D2), sr_Sc16))), false.B)
    val sr_Inc16Reg   = RegNext(Mux(io.myReset.asBool, false.B, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_Inc16Reg,Mux(sr_GaSet && !io.waitClkGate.asBool && io.G2generalCLKEn, (io.g2EleSize1B_D2||io.G2eleSize_4B_D2)&&io.ScatterInc_D2,    sr_Inc16))), false.B)
    val sr_DataReg    = RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_DataReg, sr_DataNxt)), 0.U)
    val sr_InProgReg  = RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_InProgReg, sr_InProgNxt)), 0.U)
    val sr_PipeBusyReg= RegNext(Mux(io.myReset.asBool, 0.U, Mux(io.waitClkGate.asBool || !io.G2generalCLKEn, sr_PipeBusyReg,sr_InProgNxt.orR)), 0.U)
    
    sr_Age     :=sr_AgeReg     
    sr_Addr    :=sr_AddrReg    
    sr_Dram    :=sr_DramReg    
    sr_Sc8     :=sr_Sc8Reg     
    sr_Sc16    :=sr_Sc16Reg    
    sr_Inc16   :=sr_Inc16Reg      
    sr_Data    :=sr_DataReg       
    sr_InProg  :=sr_InProgReg  
    sr_PipeBusy:=sr_PipeBusyReg

 }

val sr_active_set = Wire(Bool())
    sr_active_set: = sr_AddrSet || ((sr_Age===1.U)&&arFinishAge1 ||(sr_age===0.U)&&arFinishAge0)
val sr_active_nxt  = sr_AddrSet && io.GSPredicate_D2.orR
val sr_active  = RegInit(0.U(1.W))
    sr_Active := sr_active
withClockAndReset(io.G2generalCLK, io.myReset.asAsyncReset()) {
      when((!io.WaitClkGate) && io.G2generalCLKEn && sr_active_set){
        sr_active:= sr_active_nxt
      }

    }

  
 val sr_ReadyReg   = RegInit(VecInit(Seq.fill(eleNum)(false.B)))
 val sr_ReadyNxt   = Wire(Vec(eleNum,Bool()))
 val sr_ReadySet   = Wire(Vec(eleNum,Bool()))
 val sr_Ready      = Wire(Vec(eleNum,Bool()))

for(i <- 0 until eleNum ){
    sr_ReadyNxt(i):=sr_AddrSet && io.GSPredicate_D2(i) && (!((nextArAge===0.U || nextArAge===1.U) && arAddrSel(i)(0)&&arAddrSet(i)))
    sr_ReadySet(i):=sr_AddrSet || sr_Ready(i)&&(
      (sr_Age===1.U) && ((!arAddrEn(i)||arAddrIssuedToDramForReady(i)&&!arAddrAge(i))) || 
      (sr_Age===2.U) && finishArOp && (!arAddrEn(i)||arAddrIssuedToDramForReady(i))
    )
    withClockAndReset(io.G2generalCLK,io.myReset.asAsyncReset)    {
      sr_ReadyReg(i):=Mux(io.myReset,false.B,Mux((!io.WaitClkGate) & (io.G2generalCLKEn) & (sr_ReadySet(i)),sr_ReadyNxt,sr_ReadyReg(i)))
    }
    sr_Ready(i):=sr_ReadyReg(i)
 }

  io.srReady  :=sr_Ready.reverse.reduce(Cat(_,_))
  io.srFinish :=sr_pipeBusy &&(!(srMask.orR))

  sr_Age0Active:= (sr_Age===0.U) && sr_Active
  sr_Age0DramId:= sr_Dram(0)&&sr_Age0Active
  sr_Age1Active:= (sr_Age===1.U) && sr_Active
  sr_Age1Ready := (sr_Age===1.U) && io.srReady.orR
  sr_Age1DramId:= sr_Dram(0)&&sr_Age1Active
  
  sr_age0_sc8   :=sc8   & sr_Age0Active
  sr_age0_sc16  :=sc16  & sr_Age0Active
  sr_age0_inc16 :=inc16 & sr_Age0Active
  sr_age1_sc8   :=sc8   & sr_Age1Active
  sr_age1_sc16  :=sc16  & sr_Age1Active
  sr_age1_inc16 :=inc16 & sr_Age1Active

 }


//backup from claude  for one gather register

class GatherRegister(val numGrRegs: Int = 8,val numElems:Int=32, val elemWidth:Int=16, val elemNo) extends Module {
  val io = IO(new Bundle {
    // Input signals
    val MyReset = Input(Bool())
    val WaitClkGate = Input(Bool())
    val G2generalCLKEn = Input(Bool())
    val G2generalCLK = Input(Clock())
    val GatherA_D2 = Input(Bool())
    val gvr_wr0_addr_D2 = Input(UInt(3.W))
    val MovgatherD_D1 = Input(Bool())
    val gvr_wr0_addr_D1 = Input(UInt(3.W))
    val gr_sge_data_wr_stage5 = Input(UInt(32.W))
    val gs_addr_extended_W = Input(UInt(2*numElems.W))
    val G2eleSize_1B_D2 = Input(Bool())
    val next_age = Input(UInt(4.W))
    val ar_Finish_age1 = Input(Bool())
    val ar_Finish_age0 = Input(Bool())
    val gvr_wr0_data_D1 = Input(UInt(numElems*eleWidth.W))
    val gr_addr_D2 = Input(UInt(numElems*eleWidth.W))
    val gr_data = Input(UInt(numElems*eleWidth.W))
    val GSPredicate_D2 = Input(UInt(numElems.W))
    val GSDramID_D2 = Input(UInt(numElems.W))
    val Valid_L2 = Input(Bool())
    val killPipe_W = Input(Bool())
    val Valid_M = Input(Bool())
    val Stall_R1toM = Input(Bool())
    val finish_ar_op = Input(Bool())
    val ar_addr_set0 = Input(Bool())
    val ar_addr_en0 = Input(Bool())
    val ar_ele0_addr_issued_to_dram_for_ready = Input(Bool())
    val ar_addr_age0 = Input(Bool())
    // Add similar input signals for ar_addr_set1 to ar_addr_set31 and other signals

    // Output signals
    val GAbusyInst_gr0_L1 = Output(Bool())
    val GAbusyInst_gr0_L2 = Output(Bool())
    val GAbusyInst_gr0_M = Output(Bool())
    val SGstallGr = Output(Bool())
    val SGstallGr_inclStall = Output(Bool())
    val gr_ad = Output(UInt(numElems*eleWidth.W))
    val gr_extended_ad = Output(UInt(numElems*2.W))
    val gr_active = Output(Bool())
    val gr_ga8u = Output(Bool())
    val gr_dram = Output(UInt(numElems.W))
    val gr_ready = Output(UInt(numElems.W))
    val gr_inprog = Output(UInt(numElems.W))
    val gr_gatherD_busy_vec = Output(UInt(numElems.W))
    val gr_pipe_busy = Output(Bool())
    val gr_age = Output(UInt(4.W))
    val gr_age0_active = Output(Bool())
    val gr_age0_dram_id = Output(Bool())
    val gr_age1_active = Output(Bool())
    val gr_age1_ready = Output(Bool())
    val gr_age1_dram_id = Output(Bool())
  })

  // Instantiate xcff registers
  val gr_age           = WireInit(0.U(4.W))
  val gr_ga8u          = WireInit(false.B)
  val gr_inprog        = WireInit(0.U(numElems.W))
  val gr_gatherD_busy_vec = WireInit(0.U(numElems.W))
  val gr_pipe_busy        = WireInit(false.B)
  val gr_active        = WireInit(false.B)
  val gr_ads           = Wire(Vec(numElems,UInt(elemWidth.W)))
  val gr_extended_ads  = Wire(Vec(numElems,UInt(2.W)))
  val gr_dram          = WireInit(0.U(numElems.W))
  val gr_ready_pres    = WireInit(VecInit(seq(numElems)(false.B)))
  val gr_bsy_state        = WireInit(0.U(3.W))
  // Wire definitions
  val gr_wr_select = Wire(Vec(log2Ceil(numGrRegs), Bool()))
  val gr_ad_set = Wire(Vec(numElems, Bool()))
  val gr_ad_nxt = Wire(UInt(numElems*eleWidth.W))
  val gr_active_nxt = Wire(Bool())
  val gr_active_set = Wire(Bool())
  val gr_next_age_dec_amt = Wire(UInt(4.W))
  val gr_age_nxt_pre = Wire(UInt(4.W))
  val gr_age_nxt = Wire(UInt(4.W))
  val gr_inprog_nxt = Wire(UInt(numElems.W))
  val gr_gatherD_busy_vec_nxt = Wire(UInt(numElems.W))
  val gr_dram_nxt = Wire(UInt(numElems.W))
  val gr_ready_nxt = Wire(Vec(numElems, Bool()))
  val gr_ready_set = Wire(Vec(numElems, Bool()))
  val gr_ready = Wire(UInt(numElems.W))
  val nxt_gr_bsy_state = Wire(UInt(3.W))

  // Logic implementation
  gr_wr_select := VecInit(Seq(io.gr_mgd_set, io.gr_ga_set, !(io.gr_mgd_set || io.gr_ga_set)))
  gr_ad_set := VecInit(Seq.tabulate(32)(i => io.gr_mgd_set || io.gr_ga_set || io.gr_sge_data_wr_stage5(i)))

  val gr_data_mask_gr = VecInit(Seq.fill(32)(Cat(Seq.fill(8)(!io.gr_ga8u), "hff".U(8.W))))
  gr_ad_nxt := Mux1H(gr_wr_select, Seq(io.gvr_wr0_data_D1, io.gr_addr_D2, (io.gr_data & gr_data_mask_gr.asUInt)))

  gr_age  := xcff(io.G2generalCLK, io.MyReset, io.G2generalCLKEn&&!io.WaitClkGate, gr_age_nxt,0.U(4.W))
  gr_ga8u := xcff(io.G2generalCLK, io.MyReset, io.G2generalCLKEn&&!io.WaitClkGate&&io.gr_ga_set, io.G2eleSize_1B_D2,false.B)

  gr_next_age_dec_amt := Mux(!io.gr_ga_set && (gr_age === 0.U), 0.U, Cat(0.U(2.W), io.ar_Finish_age1 && io.ar_Finish_age0, io.ar_Finish_age1 ^ io.ar_Finish_age0))
  gr_age_nxt_pre := Mux(io.gr_ga_set, io.next_age, gr_age)
  gr_age_nxt := gr_age_nxt_pre - gr_next_age_dec_amt

  gr_inprog_nxt := Mux(io.gr_ga_set, io.GSPredicate_D2, Mux(io.gr_mgd_set, 0.U, gr_inprog & ~io.gr_sge_data_wr_stage5))
  gr_gatherD_busy_vec_nxt := Mux(io.gr_ga_set, io.GSPredicate_D2, Mux(io.gr_mgd_set, 0.U, gr_gatherD_busy_vec & ~Cat(Seq.tabulate(numElems)(i => io.gatherA_valid_stage2_ele(i) && (io.ar_grsr_num_stage2_ele(i) === 0.U)))))

  gr_inprog           := xcff(io.G2generalCLK,io.MyReset, io.G2generalCLKEn,  true.B, gr_inprog_nxt,          0.U(numElems.W))
  gr_pipe_busy        := xcff(io.G2generalCLK,io.MyReset, io.G2generalCLKEn,  true.B, gr_inprog_nxt.orR,      false.B)
  gr_gatherD_busy_vec := xcff(io.G2generalCLK,io.MyReset, io.G2generalCLKEn,  true.B, gr_gatherD_busy_vec_nxt,0.U(numElems.W))

  io.GAbusyInst_gr_L1 := io.GatherD_L1 && (io.gvr_rd0_addr_L1 === elemNo.U) || (io.GatherA_L1 || io.MovgatherD_L1) && (io.gvr_wr0_addr_L1 === elemNo.U)
  val GAbusyInst_gr0_L2_pre        = WireNext(io.GAbusyInst_gr0_L1, init = false.B)
  io.GAbusyInst_gr_L2 := GAbusyInst_gr_L2_pre && io.Valid_L2 && !io.killPipe_W
  val GAbusyInst_gr0_M_pre        = WireNext(io.GAbusyInst_gr0_L2, init = false.B)
  io.GAbusyInst_gr_M := GAbusyInst_gr_M_pre && io.Valid_M && !io.killPipe_W

  nxt_gr_bsy_state := MuxCase(gr_bsy_state, Seq(
    (gr_bsy_state === GRBSY_IDLE) && (io.GatherA_M || io.MovgatherD_M) && (io.gvr_wr0_addr_M === elemNo.U) && !io.Stall_R1toM -> GRBSY_C_BUSY,
    (gr_bsy_state === GRBSY_C_BUSY) && (io.GatherA_C || io.MovgatherD_C) && (io.gvr_wr0_addr_C === elemNo.U) -> GRBSY_W_BUSY,
    (gr_bsy_state === GRBSY_W_BUSY) && (io.GatherA_W || io.MovgatherD_W) && (io.gvr_wr0_addr_W === elemNo.U) -> GRBSY_LATEPIPE_BUSY,
    (gr_bsy_state === GRBSY_LATEPIPE_BUSY) && (io.GatherA_D2 || io.MovgatherD_D2) && (io.gvr_wr0_addr_D2 === 0.U) && !gr_gatherD_busy_vec_nxt.orR -> GRBSY_IDLE,
    (gr_bsy_state === GRBSY_LATEPIPE_BUSY) && (io.GatherA_D2 || io.MovgatherD_D2) && (io.gvr_wr0_addr_D2 === 0.U) && gr_gatherD_busy_vec_nxt.orR -> GRBSY_SGE_BUSY,
    (gr_bsy_state === GRBSY_SGE_BUSY) && !gr_gatherD_busy_vec_nxt.orR -> GRBSY_IDLE
  ))

  gr_bsy_state := xcff(io.MyReset, 0.U(3.W), true.B, io.G2W1CLK, !io.WaitClkGate, nxt_gr_bsy_state)

  io.SGstallGr0_inclStall := io.GAbusyInst_gr0_L2_pre && io.GAbusyInst_gr0_M_pre || io.GAbusyInst_gr0_L2_pre && gr_bsy_state(2)
  io.SGstallGr0 := io.GAbusyInst_gr0_M_pre && gr_bsy_state(2)

  gr_dram_nxt := VecInit(Seq.fill(numElems)(io.GSDramID_D2))
  gr_dram := xcff(io.G2generalCLK,io.MyReset,), io.G2generalCLKEn&&io.gr_ga_set, gr_dram_nxt,0.U(numElems.W)

  gr_active_nxt := io.gr_ga_set && io.GSPredicate_D2.orR
  gr_active_set := io.gr_ga_set || ((gr_age === 1.U) && io.ar_Finish_age1 || (gr_age === 0.U) && io.ar_Finish_age0)
  gr_active := xcff(io.G2generalCLK,io.MyReset, io.G2generalCLKEn&&gr_active_set, gr_active_nxt, false.B)

  for (i <- 0 until numElems) {

      //withClockAndReset(io.G2generalCLK, io.myReset.asAsyncReset()) {
    gr_ads(i) := xcff(G2generalCLK,reset,gr_ad_nxt(elemWidth * i + elemWidth-1, elemWidth * i),0.U(elemWidth.W))
    gr_extended_ads(i) := xcff(G2generalCLK,reset,io.gsAddrExtendedW(2 * i + 1, 2 * i),0.U(2.W))

    gr_ready_nxt(i) := io.gr_ga_set && io.GSPredicate_D2(i) &&
      !((io.next_ar_age === 0.U || io.next_ar_age === 1.U) && io.ar_addr_sel(i)(0) && io.ar_addr_set(i))

    gr_ready_set(i) := io.gr_ga_set || io.gr_mgd_set ||
      gr_ready_pres(i) &&
      ((gr_age === 1.U) && (!io.ar_addr_en(i) || io.ar_ele_addr_issued_to_dram_for_ready(i) && !io.ar_addr_age(i)) ||
        (gr_age === 2.U) && io.finish_ar_op && (!io.ar_addr_en(i) || io.ar_ele_addr_issued_to_dram_for_ready(i)))

    gr_ready_pres(i) := xcff(io.MyReset, false.B, io.G2generalCLKEn, io.G2generalCLK, gr_ready_set(i), gr_ready_nxt(i))
    gr_ready(i) := gr_ready_pres(i)
  }

  // Assign output signals
  io.gr_ad := Cat(gr_ads.reverse)
  io.gr_extended_ad := Cat(gr_extended_ads.reverse)
  io.gr_active := gr_active
  io.gr_ga8u := gr_ga8u
  io.gr_dram := gr_dram
  io.gr_ready := gr_ready.asUInt

  io.gr_inprog := gr_inprog
  io.gr_gatherD_busy_vec := gr_gatherD_busy_vec
  io.gr_pipe_busy := gr_pipe_busy
  io.gr_age := gr_age
  io.gr_age0_active := (gr_age === 0.U) && gr_active
  io.gr_age0_dram_id := gr_dram(elemNo) && io.gr_age0_active
  io.gr_age1_active := (gr_age === 1.U) && gr_active
  io.gr_age1_ready := (gr_age === 1.U) && gr_ready.orR
  io.gr_age1_dram_id := gr_dram(elemNo) && io.gr_age1_active
}

/* // Define the xcff function for register instantiation with clock and reset
def xcff[T <: Data](reset: Bool, resetValue: T, enable: Bool, clock: Clock, cond: Bool, data: T): T = {
  val reg = RegInit(resetValue)
  when (reset) {
    reg := resetValue
  } .elsewhen (cond && enable) {
    reg := data
  }
  reg 
}*/

