
class FGS_DbgExcControl(val sram1Base:UInt,val sram1Size:Int, val sram0Base:UInt, val sram0Size:Int, val dbreakNum:Int, val xLen:Int=32) extends Module {
  val io=IO(new Bundle{
  
    val SGInvalidateSclCache  = Output(Bool())
    val DBreak1ExcSG_L2       = Output(Bool())

    val WaitClkGate           = Input(Bool())
    val G1W1CLK               = Input(Clock())
    val G2SCLK                = Input(Clock())
    val LSVAddrBase_L2        = Input(UInt(xLen.W))    //32 or 64 bit system?
    val DBREAKC_SG_ps_C6      = Input(Vec(dbreakNum,UInt(2.W)))    // 2 bit control for each dbreak
    val DBreakA_ps_C6_Vec     = Input(Vec(dbreakNum,UInt(xLen.W)))   
    val Scatter_L2_pre        = Input(Bool())
    val GatherA_L2_pre        = Input(Bool())
  
    val val_dram_req_sb_stage2 = Input(Vec(bkNum,Vec(sbkNum,Bool())))
    val sc8_req_bank_stage2    = Input(Vec(bkNum,Bool()))
    val sc16_req_bank_stage2   = Input(Vec(bkNum,Bool()))
    val inc16_req_bank_stage2  = Input(Vec(bkNum,Bool()))
    val dram_id_req_bank_stage2= Input(Vec(bkNum,Bool()))
  })
  
   
/* 
wire DBREAKA_inrange0_dram0;
assign DBREAKA_inrange0_dram0 = (DBREAKA0_ps_C6 >= 32'he9000000) && (DBREAKA0_ps_C6 < 32'he9040000);
wire DBREAKA_inrange1_dram0;
assign DBREAKA_inrange1_dram0 = (DBREAKA1_ps_C6 >= 32'he9000000) && (DBREAKA1_ps_C6 < 32'he9040000); */

val DBREAKA_inrange_dram0 =(0 until dbreakNum).tabulate{ i => DBreakA_ps_C6_Vec(i)>sram0Base && DBreakA_ps_C6_Vec(i) < sram0Base+sram0Size} 
val DBREAKA_inrange_dram1 =(0 until dbreakNum).tabulate{ i => DBreakA_ps_C6_Vec(i)>sram1Base && DBreakA_ps_C6_Vec(i) < sram1Base+sram1Size} 
/* 
wire DBREAKA_inrange0_dram1;
assign DBREAKA_inrange0_dram1 = (DBREAKA0_ps_C6 >= 32'he9040000) && (DBREAKA0_ps_C6 < 32'he9080000);
wire DBREAKA_inrange1_dram1;
assign DBREAKA_inrange1_dram1 = (DBREAKA1_ps_C6 >= 32'he9040000) && (DBREAKA1_ps_C6 < 32'he9080000); */

val DBREAKA_gt_BaseAddr_L2 = (0 until dbreakNum).tabulate{i => DBreakA_ps_C6_Vec(i) > io.LSVAddrBase_L2 }
/* wire DBREAKA0_gt_BaseAddr_L2;
assign	DBREAKA0_gt_BaseAddr_L2 = (DBREAKA0_ps_C6 >= LSVAddrBase_L2); */
/* wire DBREAKA1_gt_BaseAddr_L2;
assign	DBREAKA1_gt_BaseAddr_L2 = (DBREAKA1_ps_C6 >= LSVAddrBase_L2); */

// wire SGDBreakExc0_dram1_L2;

// assign	SGDBreakExc0_dram1_L2 = DBREAKA0_gt_BaseAddr_L2 && BaseAddrInRange1_L2 && DBREAKA_inrange0_dram1 &&
// 					(DBREAKC_SG0_ps_C6[1] && Scatter_L2_pre ||
// 					 DBREAKC_SG0_ps_C6[0] && GatherA_L2_pre); 

// wire SGDBreakExc0_dram0_L2;

// assign	SGDBreakExc0_dram0_L2 = DBREAKA0_gt_BaseAddr_L2 && BaseAddrInRange0_L2 && DBREAKA_inrange0_dram0 &&
// 					(DBREAKC_SG0_ps_C6[1] && Scatter_L2_pre ||
// 					 DBREAKC_SG0_ps_C6[0] && GatherA_L2_pre); 

val DBreakExcSG_L2 = Wire(Vec(dbreakNum,Bool))
val SGDBreakExc_dram0_L2 = Wire(Vec(dbreakNum,Bool()))
val SGDBreakExc_dram1_L2 = Wire(Vec(dbreakNum,Bool()))

    for(i <- 0 until dbreakNum) {
       SGDBreakExc_dram0_L2(i) := DBREAKA_gt_BaseAddr_L2(i) && BaseAddrInRange0_L2 && DBREAKA_inrange_dram0(i)  && 
                                  (io.DBREAKC_SG_ps_C6(i)(1) && io.Scatter_L2_pre || io.DBREAKC_SG_ps_C6(i)(0) && io.GatherA_L2_pre)
       SGDBreakExc_dram1_L2(i) := DBREAKA_gt_BaseAddr_L2(i) && BaseAddrInRange1_L2 && DBREAKA_inrange_dram1(i)  && 
                                  (io.DBREAKC_SG_ps_C6(i)(1) && io.Scatter_L2_pre || io.DBREAKC_SG_ps_C6(i)(0) && io.GatherA_L2_pre)

   }

   for(i <-0 until dbreakNum) 
         DBreakExcSG_L2(i) := SGDBreakExc_dram0_L2(i) || SGDBreakExc_dram1_L2(i)
/* assign	DBreak0ExcSG_L2 = SGDBreakExc0_dram0_L2 ||
                          SGDBreakExc0_dram1_L2;
 */

/* wire SGDBreakExc1_dram1_L2;

assign	SGDBreakExc1_dram1_L2 = DBREAKA1_gt_BaseAddr_L2 && BaseAddrInRange1_L2 && DBREAKA_inrange1_dram1 &&
					(DBREAKC_SG1_ps_C6[1] && Scatter_L2_pre ||
					 DBREAKC_SG1_ps_C6[0] && GatherA_L2_pre); 

wire SGDBreakExc1_dram0_L2;

assign	SGDBreakExc1_dram0_L2 = DBREAKA1_gt_BaseAddr_L2 && BaseAddrInRange0_L2 && DBREAKA_inrange1_dram0 &&
					(DBREAKC_SG1_ps_C6[1] && Scatter_L2_pre ||
					 DBREAKC_SG1_ps_C6[0] && GatherA_L2_pre); 
assign	DBreak1ExcSG_L2 = SGDBreakExc1_dram0_L2 ||
                          SGDBreakExc1_dram1_L2; */

// Logic to Invalidate Scalar Cache for LL DRAM
val dram_region_vec = Wire(Vec(2,UInt(sbkNum.W)))
val mW = Wire(Vec(bkNum,Bool))
    mW(i) := io.sc8_req_bank_stage2(i) || io.sc8_req_bank_stage2(i) || io.inc16_req_bank_stage2(i)

  for(sbkId <- 0 until bkNum*sbkNum)
  {
       dram_region_vec(0)(sbkId) := io.val_dram_req_sb_stage2(sbkId) && mW(sbkId/sbkNum) && dram_id_req_bank_stage2(sbkId/sbkNum)
       dram_region_vec(1)(sbkId) := io.val_dram_req_sb_stage2(sbkId) && mW(sbkId/sbkNum) && !dram_id_req_bank_stage2(sbkId/sbkNum)
  }

/*  assign	dram_region0_access = |dram_region0_vec || dram_region0_access_state && !MemBarrier_inst_W;
 assign	dram_region1_access = |dram_region1_vec || dram_region1_access_state && !MemBarrier_inst_W; */
 val dram_region_access_state = Wire(Vec(memNum,Bool()))
 val dram_region_access = dram_region_vec.zip(dram_region_access_state){(rV,acc_state) => rV.orR || acc_state }
 
 dram_region0_access_state := xcff(1,io.G1WCLK,io.MyReset,!io.WaitClkGate,io.dram_region_access(0))
 dram_region1_access_state := xcff(1,io.G1WCLK,io.MyReset,!io.WaitClkGate,io.dram_region_access(1))
 dram_region0_access_L1    := xcff(1,io.G2SCLK,io.MyReset,!io.WaitClkGate&&io.G2SCLKEn,dram_region0_access_state ) 
 dram_region1_access_L1    := xcff(1,io.G2SCLK,io.MyReset,!io.WaitClkGate&&io.G2SCLKEn,dram_region1_access_state ) 
/* wire [15:0] dram_region0_vec;
wire [15:0] dram_region1_vec;
assign	dram_region0_vec[0] = val_dram_req_sb0_stage2 && (sc8_req_bank0_stage2 || c || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[0] = val_dram_req_sb0_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[1] = val_dram_req_sb1_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[1] = val_dram_req_sb1_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[2] = val_dram_req_sb2_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[2] = val_dram_req_sb2_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[3] = val_dram_req_sb3_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[3] = val_dram_req_sb3_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[4] = val_dram_req_sb4_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[4] = val_dram_req_sb4_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[5] = val_dram_req_sb5_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[5] = val_dram_req_sb5_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[6] = val_dram_req_sb6_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[6] = val_dram_req_sb6_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[7] = val_dram_req_sb7_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) && !dram_id_req_bank0_stage2;
assign	dram_region1_vec[7] = val_dram_req_sb7_stage2 && (sc8_req_bank0_stage2 || sc16_req_bank0_stage2 || inc16_req_bank0_stage2) &&  dram_id_req_bank0_stage2;
assign	dram_region0_vec[8] = val_dram_req_sb8_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[8] = val_dram_req_sb8_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2;
assign	dram_region0_vec[9] = val_dram_req_sb9_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[9] = val_dram_req_sb9_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2;
assign	dram_region0_vec[10] = val_dram_req_sb10_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[10] = val_dram_req_sb10_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2;
assign	dram_region0_vec[11] = val_dram_req_sb11_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[11] = val_dram_req_sb11_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2;
assign	dram_region0_vec[12] = val_dram_req_sb12_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[12] = val_dram_req_sb12_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2;
assign	dram_region0_vec[13] = val_dram_req_sb13_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[13] = val_dram_req_sb13_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2;
assign	dram_region0_vec[14] = val_dram_req_sb14_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[14] = val_dram_req_sb14_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2;
assign	dram_region0_vec[15] = val_dram_req_sb15_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) && !dram_id_req_bank1_stage2;
assign	dram_region1_vec[15] = val_dram_req_sb15_stage2 && (sc8_req_bank1_stage2 || sc16_req_bank1_stage2 || inc16_req_bank1_stage2) &&  dram_id_req_bank1_stage2; */
// wire dram_region0_access_state;
// wire dram_region1_access_state;
// wire dram_region0_access_L1;
// wire dram_region1_access_L1;
// wire dram_region0_access;
// wire dram_region1_access;
// wire SGInvalidateSclCache_nxt;
// reg dram_region0_access_state_reg;
// assign dram_region0_access_state = dram_region0_access_state_reg;
// always @(posedge G1WCLK or posedge MyReset) dram_region0_access_state_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
//     ((~WaitClkGate)) ? dram_region0_access : dram_region0_access_state_reg;
// reg dram_region1_access_state_reg;
// assign dram_region1_access_state = dram_region1_access_state_reg;
// always @(posedge G1WCLK or posedge MyReset) dram_region1_access_state_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
//     ((~WaitClkGate)) ? dram_region1_access : dram_region1_access_state_reg;
// reg dram_region0_access_L1_reg;
// assign dram_region0_access_L1 = dram_region0_access_L1_reg;
// always @(posedge G2SCLK or posedge MyReset) dram_region0_access_L1_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
//     ((~WaitClkGate) & (G2SCLKEn)) ? dram_region0_access_state : dram_region0_access_L1_reg;
// reg dram_region1_access_L1_reg;
// assign dram_region1_access_L1 = dram_region1_access_L1_reg;
// always @(posedge G2SCLK or posedge MyReset) dram_region1_access_L1_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
//     ((~WaitClkGate) & (G2SCLKEn)) ? dram_region1_access_state : dram_region1_access_L1_reg;
// MemBarrier_inst_C1 is MEMW_C1 || EXTW_C1 || EXCW_C1




//assign SGInvalidateSclCache_nxt = (dram_region0_access_state || dram_region1_access_state) && (ScatterW_A_pre || MemBarrier_inst_C1) && Valid_A;
val  SGInvalidateSclCache_nxt = (dram_region0_access_state || dram_region1_access_state) && (io.ScatterW_A_pre || io.MemBarrier_inst_C1) && io.Valid_A;
// reg SGInvalidateSclCache_reg;
// assign SGInvalidateSclCache = SGInvalidateSclCache_reg;
// always @(posedge G1WCLK or posedge MyReset) SGInvalidateSclCache_reg <= `XT_SEQ_DELAY MyReset ? 1'b0 :
//     ((~WaitClkGate)) ? SGInvalidateSclCache_nxt : SGInvalidateSclCache_reg;
io.SGInvalidateSclCache := xcff(1,io.G1W1CLK,io.MyReset,!io.WaitClkGate,SGInvalidateSclCache_nxt)

io.ScatterToDRAM0 := dram_region0_access_L1
io.ScatterToDRAM1 := dram_region1_access_L1
/* 
assign ScatterToDRAM0 = dram_region0_access_L1;
assign ScatterToDRAM1 = dram_region1_access_L1;
*/

}


