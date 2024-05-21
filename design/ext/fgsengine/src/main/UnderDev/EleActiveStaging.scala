 // Elem Active Request  Registers Staging Pipeline
import chisel3._
import chisel3.util._

class ArElemsActiveLogic(val elemNum: Int=32, val elemWidth:Int=16,val bkNum:Int=2,val sbkNum:Int=8, val grNum:Int=8,val srNum:Int=2) extends Module {
  val io = IO(new Bundle {
//output
         val ar_addr_set                       = Output(Vec(elemNum,Bool))    
         val addr_sel                          = Output(Vec(elemNum,Bool)) 
         val ar_age_set                        = Output(Vec(elemNum,Bool()))
         val ar_dram_id                        = Output(Vec(elemNum,Bool()))
         val ar_addr                           = Output(Vec(elemNum,UInt((elemWidth+2).W)))   //[17:0] 
         val ar_addr_bank                      = Output(Vec(elemNum,Bool()))
         val ar_addr_sbvec                     = Output(Vec(elemNum,UInt(sbkNum.W)) )         //[7:0] 
         val ar_addr_sc8                       = Output(Vec(elemNum,Bool()))
         val ar_scatter_age0                   = Output(Vec(elemNum,Bool())) 
         val ar_addr_sc16                      = Output(Vec(elemNum,Bool()))
         val ar_addr_inc16                     = Output(Vec(elemNum,Bool()))
         val ar_gr_age1or0_mux_sel             = Output(Vec(elemNum,UInt(grNum.W)))       //[7:0]  
         val ar_sr_age1or0_mux_sel             = Output(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_gr_age1_mux_sel                = Output(Vec(elemNum,UInt(grNum.W)))       //[7:0] 
         val ar_gr_age2_mux_sel                = Output(Vec(elemNum,UInt(grNum.W)))       //[7:0] 
         val ar_sr_age1_mux_sel                = Output(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_sr_age2_mux_sel                = Output(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_grsr_num                       = Output(Vec(elemNum,UInt(log2Ceil(grNum).W)))       // [2:0] 
         val ar_bank_num_stage1                = Output(Vec(elemNum,UInt(log2Ceil(bkNum).W)))
         val ar_subbank_num_stage1             = Output(Vec(elemNum,UInt(log2Ceil(sbkNum).W)))      //[2:0] 
         val ar_en_age0                        = Output(Vec(elemNum,Bool()))
         val ar_en_age1                        = Output(Vec(elemNum,Bool()))  
         val ar_addr_en                        = Output(Vec(elemNum,Bool()))
         val ar_ele_addr_issued_to_dram_for_ready  = Output(Vec(elemNum,Bool()))
         val ar_addr_en_nxt                    = Output(Vec(elemNum,Bool()))
         val ar_addr_age_nxt                   = Output(Vec(elemNum,Bool()))
//input 
         val grReady                           =Input(Vec(grNum,UInt(numElems.W)))
         val grAge                             =Input(Vec(grNum,UInt(4.W)))
         val ar_Finish_age0                    =Input(Bool())
         val ar_Finish_age1                    =Input(Bool())
         val gr_extended_ad                    =Input(Vec(grNum,Vec(elemNum,UInt(2.W))))
         val gr_ad                             =Input(Vec(grNum,Vec(elemNum,UInt(elemWidth.W))))
//todo sr_next_addr_D2
         val GatherA_D2                        =Input(Bool())  
         val Scatter_D2                        =Input(Bool()) 
         val GSPredicate_D2                    =Input(Vec(numElems,Bool()))   
         val ScatterInc_D2                     =Input(Bool())  
         val G2eleSize_1B_D2                   =Input(Bool()) 
         val G2eleSize_2B_D2                   =Input(Bool()) 
         val G2eleSize_4B_D2                   =Input(Bool()) 
         val gvr_wr0_addr_D2                   =Input(UInt(log2Ceil(numGrs)))    //gather reg number
})
val dramIDWidth = log2Ceil(bkNum)
val ar_gr_addr_nxt       = Wire(Vec(elemNum,UInt((elemWidth+2).W)))
val ar_sr_addr_nxt       = Wire(Vec(elemNum,UInt((elemWidth+2).W)))
val ar_gr_dram_id_nxt    = Wire(Vec(elemNum,Bool()))
val ar_sr_dram_id_nxt    = Wire(Vec(elemNum,Bool()))
val ar_gr_en_nxt         = Wire(Vec(elemNum,Bool()))
val ar_sr_en_nxt         = Wire(Vec(elemNum,Bool()))
val ar_gr_num_nxt        = Wire(Vec(elemNum,UInt(log2Ceil(grNum).W)))
val ar_sr_num_nxt        = Wire(Vec(elemNum,UInt(log2Ceil(grNum).W)))
val ar_inst_grsr_num_nxt = Wire(Vec(elemNum,UInt(log2Ceil(grNum).W)))
val ar_grsr_num_nxt      = Wire(Vec(elemNum,UInt(log2Ceil(grNum).W)))
val ar_grsr_num          = Wire(Vec(elemNum,UInt(log2Ceil(grNum).W)))
val ar_bank_num_stage    = Wire(Vec(elemNum,Bool()))
val ar_subbank_num_stage1= Wire(Vec(elemNum,UInt(log2Ceil(sbkNum).W)))

val ar_gr_age_nxt_pre     = Wire(Vec(elemNum,Bool()))
val ar_sr_age_nxt_pre     = Wire(Vec(elemNum,Bool()))
val ar_gr_age_nxt         = Wire(Vec(elemNum,Bool()))
val ar_sr_age_nxt         = Wire(Vec(elemNum,Bool()))
val ar_dram_id_nxt        = Wire(Vec(elemNum,Bool()))
val ar_addr_nxt           = Wire(Vec(elemNum,UInt((elemWidth+2).W)))
val ar_addr_bank_nxt      = Wire(Vec(elemNum,Bool()))
val ar_addr_sbvec_nxt     = Wire(Vec(elemNum,UInt(sbkNum.W)))
val ar_sr_sc8_nxt         = Wire(Vec(elemNum,Bool()))
val ar_addr_sc8_nxt       = Wire(Vec(elemNum,Bool()))
val ar_sr_sc16_nxt        = Wire(Vec(elemNum,Bool())) 
val ar_addr_sc16_nxt      = Wire(Vec(elemNum,Bool()))
val ar_sr_inc16_nxt       = Wire(Vec(elemNum,Bool()))
val ar_addr_inc16_nxt     = Wire(Vec(elemNum,Bool()))
val ar_addr_en_nxt_pre    = Wire(Vec(elemNum,Bool()))
val ar_addr_en_nxt        = Wire(Vec(elemNum,Bool()))
val ar_age_nxt            = Wire(Vec(elemNum,Bool()))
val finish_ar_op          =  io.ar_Finish_age0 || io.ar_Finish_age1
for(ele <- 0 until elemNum){
	  ar_addr_set(ele)	   := !ar_addr_en(ele) || ar_ele_addr_issued_to_dram_for_ready(ele)					
    ar_addr_sel(ele)  	 := Cat((ar_gr_age1or0_mux_sel.orR), (ar_sr_age1or0_mux_sel.orR), 
                                !((ar_gr_age1or0_mux_sel.orR) || (ar_sr_age1or0_mux_sel.orR)));
    ar_gr_age2_mux_sel(ele) :=  Cat(grReady.zip(grAge).map((ready,age) => ready(ele)&&finish_ar_op&&(age===2.U(4.W)))) & 
                              (~Fill(8,ar_sr_age0_mux_sel.orR)) &  (~Fill(8,ar_sr_age1_mux_sel.orR))
                              /* {gr7_ready[0] && finish_ar_op && (gr7_age == 4'd2),
                                  gr6_ready[0] && finish_ar_op && (gr6_age == 4'd2),
                                  gr5_ready[0] && finish_ar_op && (gr5_age == 4'd2),
                                  gr4_ready[0] && finish_ar_op && (gr4_age == 4'd2),
                                  gr3_ready[0] && finish_ar_op && (gr3_age == 4'd2),
                                  gr2_ready[0] && finish_ar_op && (gr2_age == 4'd2),
                                  gr1_ready[0] && finish_ar_op && (gr1_age == 4'd2),
                                  gr0_ready[0] && finish_ar_op && (gr0_age == 4'd2)} *//* 	& {8{!(|ar_sr_age0_mux_sel0)}}
			                            & {8{!(|ar_sr_age1_mux_sel0)}}; */
                       
   ar_gr_age1_mux_sel(ele)  :=  Cat(grReady.zip(grAge).map((ready,age) => ready(ele)&&(age===1.U(4.W)))) &  (~Fill(8,ar_sr_age0_mux_sel.orR))
                    /* {gr7_ready[0] && (gr7_age == 4'd1),
                          gr6_ready[0] && (gr6_age == 4'd1),
                          gr5_ready[0] && (gr5_age == 4'd1),
                          gr4_ready[0] && (gr4_age == 4'd1),
                          gr3_ready[0] && (gr3_age == 4'd1),
                          gr2_ready[0] && (gr2_age == 4'd1),
                          gr1_ready[0] && (gr1_age == 4'd1),
                          gr0_ready[0] && (gr0_age == 4'd1)}
			& {8{!(|ar_sr_age0_mux_sel0)}}; */
    ar_gr_age0_mux_sel(ele) :=  Cat(grReady.zip(grAge).map((ready,age) => ready(ele)&&(age===0.U(4.W))))/* {gr7_ready[0] && (gr7_age == 4'd0),
                          gr6_ready[0] && (gr6_age == 4'd0),
                          gr5_ready[0] && (gr5_age == 4'd0),
                          gr4_ready[0] && (gr4_age == 4'd0),
                          gr3_ready[0] && (gr3_age == 4'd0),
                          gr2_ready[0] && (gr2_age == 4'd0),
                          gr1_ready[0] && (gr1_age == 4'd0),
                          gr0_ready[0] && (gr0_age == 4'd0)}; */
  ar_sr_age2_mux_sel(ele) := Cat(srReady.zip(srAgeEle).map((ready,age) => ready && (age===2.U(4.W) && finish_ar_op)))
                         /* sr1_ready[0] && finish_ar_op && (sr1_age == 4'd2),
                          sr0_ready[0] && finish_ar_op && (sr0_age == 4'd2) */
			                     &  Fill(srNum, !(ar_gr_age0_mux_sel.orR)) // {2{!(|ar_gr_age0_mux_sel0)}}
			                     &  Fill(srNum, !(ar_gr_age1_mux_sel.orR));
  ar_sr_age1_mux_sel(ele) :=  Cat(srReady.zip(srAgeEle).map((ready,age) => ready && (age===1.U(4.W)))) /* {sr1_ready[0] && (sr1_age == 4'd1),
                          sr0_ready[0] && (sr0_age == 4'd1)} */
			          & Fill(srNum,!(ar_gr_age0_mux_sel.orR))  //{2{!(|ar_gr_age0_mux_sel0)}};
 ar_sr_age0_mux_sel(ele) := Cat(srReady.zip(srAgeEle).map((ready,age) => ready && (age===0.U(4.W))))
                         /* {sr1_ready[0] && (sr1_age == 4'd0),
                          sr0_ready[0] && (sr0_age == 4'd0)}; */
// There can only be, at most, one age0 and one age1.
ar_gr_age1or0_mux_sel(ele) = ar_gr_age0_mux_sel(ele).orR ? ar_gr_age0_mux_sel(ele) : ar_gr_age1_mux_sel(ele).orR ? ar_gr_age1_mux_sel(ele): ar_gr_age2_mux_sel(ele);
ar_sr_age1or0_mux_sel(ele) = ar_sr_age0_mux_sel(ele).orR ? ar_sr_age0_mux_sel(ele) : ar_sr_age1_mux_sel(ele).orR ? ar_sr_age1_mux_sel(ele): ar_sr_age2_mux_sel(ele);
 
val grAddrEle = gr_extended_ad.zip(gr_ad_ele).map{(ex,ad)=>Cat(ex(1,0),ad)}
Xtmux8(18,ar_gr_addr_nxt(ele),grAddrEle,ar_gr_age1or0_mux_sel(ele))

// -----------> ar_addr
  /* xtmux8 #(18) ar_gr_addr_mux0(ar_gr_addr_nxt, {gr7_extended_ad[1:0], gr7_ad[15:0]},
                   {gr6_extended_ad[1:0], gr6_ad[15:0]},
                   {gr5_extended_ad[1:0], gr5_ad[15:0]},
                   {gr4_extended_ad[1:0], gr4_ad[15:0]},
                   {gr3_extended_ad[1:0], gr3_ad[15:0]},
                   {gr2_extended_ad[1:0], gr2_ad[15:0]},
                   {gr1_extended_ad[1:0], gr1_ad[15:0]},
                   {gr0_extended_ad[1:0], gr0_ad[15:0]}, ar_gr_age1or0_mux_sel0[7],
                   ar_gr_age1or0_mux_sel0[6],
                   ar_gr_age1or0_mux_sel0[5],
                   ar_gr_age1or0_mux_sel0[4],
                   ar_gr_age1or0_mux_sel0[3],
                   ar_gr_age1or0_mux_sel0[2],
                   ar_gr_age1or0_mux_sel0[1],
                   ar_gr_age1or0_mux_sel0[0]); */
 /*  xtmux2 #(18) ar_sr_addr_mux0(ar_sr_addr_nxt, sr1_addr[17:0],
                   sr0_addr[17:0], ar_sr_age1or0_mux_sel0[1],
                   ar_sr_age1or0_mux_sel0[0]); */
Xtmux2(18,ar_sr_addr_nxt(ele),sr_addr,ar_sr_age1or0_mux_sel(ele))
/* xtmux3 #(18) ar_addr_mux0(ar_addr_nxt, ar_gr_addr_nxt, ar_sr_addr_nxt, GSDramAddr0_D2, ar_addr_sel0[2], ar_addr_sel0[1], ar_addr_sel0[0]);
 */

Xtmux3(18,ar_addr_nxt(ele),VecInit(ar_gr_addr_nxt(ele),ar_sr_addr_nxt(ele),io.GSDramAddr0_D2),ar_addr_sel)
// -----------> ar_dram_id
//val grDram,
val grEleDramIdVec = VecInit(gr_dram.map{ grDramID=> grDramID(ele*dramIDWidth+dramIDWidth-1,ele*dramIDWidth) })
Xtmux8(1,ar_gr_dram_id_nxt(ele),grEleDramIdVec,ar_gr_age1or0_mux_sel(ele))
 /*  xtmux8 #(1) ar_gr_dram_id_mux0(ar_gr_dram_id_nxt, gr7_dram[0:0],
                   gr6_dram[0:0],
                   gr5_dram[0:0],
                   gr4_dram[0:0],
                   gr3_dram[0:0],
                   gr2_dram[0:0],
                   gr1_dram[0:0],
                   gr0_dram[0:0], ar_gr_age1or0_mux_sel0[7],
                   ar_gr_age1or0_mux_sel0[6],
                   ar_gr_age1or0_mux_sel0[5],
                   ar_gr_age1or0_mux_sel0[4],
                   ar_gr_age1or0_mux_sel0[3],
                   ar_gr_age1or0_mux_sel0[2],
                   ar_gr_age1or0_mux_sel0[1],
                   ar_gr_age1or0_mux_sel0[0]); */
val srEleDramIdVec = VecInit(sr_dram.map{ srDramID=> srDramID(ele*dramIDWidth+dramIDWidth-1,ele*dramIDWidth) })
Xtmux2(1,ar_sr_dram_id_nxt(ele),srEleDramIdVec,ar_sr_age1or0_mux_sel0(ele))
 /*  xtmux2 #(1) ar_sr_dram_id_mux0(ar_sr_dram_id_nxt, sr1_dram[0:0],
                   sr0_dram[0:0], ar_sr_age1or0_mux_sel0[1],
                   ar_sr_age1or0_mux_sel0[0]); */
 /*  xtmux3 #(1) ar_dram_id_mux0(ar_dram_id_nxt, ar_gr_dram_id_nxt, ar_sr_dram_id_nxt, GSDramID_D2, ar_addr_sel0[2], ar_addr_sel0[1], ar_addr_sel0[0]);
 */
Xtmux3(1,ar_dram_id_nxt(ele), VecInit(ar_gr_dram_id_nxt(ele), ar_sr_dram_id_nxt(ele), GSDramID_D2),ar_addr_sel(ele))
// -----------> ar_en
 /*  xtmux8 #(1) ar_gr_en_mux0(ar_gr_en_nxt, gr7_ready[0],
                   gr6_ready[0],
                   gr5_ready[0],
                   gr4_ready[0],
                   gr3_ready[0],
                   gr2_ready[0],
                   gr1_ready[0],
                   gr0_ready[0], ar_gr_age1or0_mux_sel0[7],
                   ar_gr_age1or0_mux_sel0[6],
                   ar_gr_age1or0_mux_sel0[5],
                   ar_gr_age1or0_mux_sel0[4],
                   ar_gr_age1or0_mux_sel0[3],
                   ar_gr_age1or0_mux_sel0[2],
                   ar_gr_age1or0_mux_sel0[1],
                   ar_gr_age1or0_mux_sel0[0]); */
val grEleReadyVec =VecInit(gr_ready.map( grRdy => grRdy(ele)))
Xtmux8(1,ar_gr_en_nxt(ele),grEleReadyVec,ar_gr_age1or0_mux_sel(ele))
//   xtmux2 #(1) ar_sr_en_mux0(ar_sr_en_nxt, sr1_ready[0],
//                    sr0_ready[0], ar_sr_age1or0_mux_sel0[1],
//                    ar_sr_age1or0_mux_sel0[0]);
val srEleReadyVec =VecInit(sr_ready.map( srRdy => srRdy(ele)))
Xtmux2(1,ar_sr_en_nxt(ele),srEleReadyVec,ar_sr_age1or0_mux_sel(ele))
Xtmux3(1,ar_addr_en_nxt_pre(ele), VecInit(ar_gr_en_nxt(ele), ar_sr_en_nxt(ele), ((GatherA_D2 || Scatter_D2) && GSPredicate_D2(ele))), ar_addr_sel(ele))
// -----------> ar_sc8/16
Xtmux2 (1,ar_sr_sc8_nxt(ele), sr_sc8, ar_sr_age1or0_mux_sel(ele))
Xtmux3 (1,ar_addr_sc8_nxt(ele), vecInit(0.U(1.W), ar_sr_sc8_nxt(ele), (Scatter_D2 && !ScatterInc_D2 && G2eleSize_1B_D2)), ar_addr_sel);
Xtmux2 (1,ar_sr_sc16_nxt(ele), sr_sc16, ar_sr_age1or0_mux_sel(ele));
Xtmux3 (1,ar_addr_sc16_nxt(ele), VecInit(0.U(1.W), ar_sr_sc16_nxt(ele), (Scatter_D2 && !ScatterInc_D2 && (G2eleSize_2B_D2 || G2eleSize_4B_D2))), ar_addr_sel);
// -----------> ar_inc16
Xtmux2 (1,ar_sr_inc16_nxt(ele), sr_inc16, ar_sr_age1or0_mux_sel(ele));
Xtmux3 (1,ar_addr_inc16_nxt(ele), VecInit(1'b0, ar_sr_inc16_nxt, ScatterInc_D2), ar_addr_sel(ele));
// -----------> ar_grsr_num
Xtmux8 (3,ar_gr_num_nxt(ele), VecInit(Seq.tabulate(grNum)(i => /* (grNum-1 - i) */i.U(log2Ceil(grNum).W))), ar_gr_age1or0_mux_sel(ele))
Xtmux2 (3,ar_sr_num_nxt(ele), VecInit(Seq.tabulate(srNum)(i => /* (srNum-1 - i) */i.U(log2Ceil(grNum).W))), ar_sr_age1or0_mux_sel(ele));
ar_inst_grsr_num_nxt :=  GatherA_D2 ? gvr_wr0_addr_D2 :	Scatter_D2 ? sr_next_addr_D2 : 0.U(3.W)    //sr_next_addr -> sr reg entry id
Xtmux3 (3,ar_grsr_num_nxt(ele), ar_gr_num_nxt(ele), ar_sr_num_nxt(ele), ar_inst_grsr_num_nxt, ar_addr_sel(ele));

// -----------> ar_age
val grAgeNew= VecInit(gr_age.map{age => age(1) && !(ar_Finish_age0 && ar_Finish_age1) ||  age(0)&& !(ar_Finish_age0) })/* (gr7_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr7_age[0] && !ar_Finish_age0)),
                   ((gr6_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr6_age[0] && !ar_Finish_age0)),
                   ((gr5_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr5_age[0] && !ar_Finish_age0)),
                   ((gr4_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr4_age[0] && !ar_Finish_age0)),
                   ((gr3_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr3_age[0] && !ar_Finish_age0)),
                   ((gr2_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr2_age[0] && !ar_Finish_age0)),
                   ((gr1_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr1_age[0] && !ar_Finish_age0)),
                   ((gr0_age[1] && !(ar_Finish_age0 && ar_Finish_age1)) || (gr0_age[0] && !ar_Finish_age0)), */

Xtmux8 (1,ar_gr_age_nxt_pre(ele), grAgeNew, ar_gr_age1or0_mux_sel(ele))
val srAgeNew= VecInit(sr_age.map{age => age(1) && !(ar_Finish_age0 && ar_Finish_age1) ||  age(0)&& !(ar_Finish_age0) })
Xtmux2 (1,ar_sr_age_nxt_pre(ele),  srAgeNew, ar_sr_age1or0_mux_sel(ele))

ar_gr_age_nxt(ele) := ar_gr_age_nxt_pre(ele)
ar_sr_age_nxt(ele) := ar_sr_age_nxt_pre(ele)

Xtmux3 (1, ar_age_nxt(ele), VecInit(ar_gr_age_nxt(ele), ar_sr_age_nxt(ele), next_ar_age[0]), ar_addr_sel(ele));

ar_age_set(ele)     := !ar_addr_en(ele)|| ar_ele_addr_issued_to_dram_for_ready(ele)
					    	|| (ar_addr_age(ele) && (ar_Finish_age0));

ar_addr_age_nxt(ele):= ar_age_nxt(ele) &&	!(ar_addr_en(ele)
						&& !ar_ele_addr_issued_to_dram_for_ready(ele)
						&& ar_addr_age(ele) && (ar_Finish_age0))

ar_addr_en_nxt(ele) := ar_addr_en_nxt_pre(ele) && !(ar_addr_sel(0) && (next_ar_age(3,1).orR))
val bitsSbkBytes = log2Ceil(sbkWidth/8)
val bitsSbk=log2Ceil(sbkNum)
val bitsBnk=log2Ceil(bkNum)
val bankStartBit=bitsSbkBytes+bitsSbk
val bankEndBit  =bankStartBit+bitsBnk-1
for(val idx ->0 until sbkNum){
    ar_addr_sbvec_nxt(ele)(idx) :=  (ar_addr_nxt(ele)(bitsSbk+bitsSbkBytes-1,bitsSbkBytes)=== idx.U(log2Ceil(sbkNum).W)) && ar_addr_en_nxt(ele)
}
ar_addr_bank_nxt(ele) := ar_addr_nxt(ele)(bankEndBit,bankStartBit); 
   // ar_addr_sbvec    := ar_addr_sbvec_reg;
withClockAndReset(io.G2generalCLK,io.MyReset.asAsyncReset) {
    val ar_addr_sbvec_nxt_reg    =RegInit(0.U(sbkNum.W))
    val ar_addr_bank_reg         =RegInit(0.U(sbkNum.W))
    val ar_addr_reg              =RegInit(0.U((eleWidth+2).W))
    val ar_dram_id_reg           =RegInit(0.U(bitsBnk.W)) 
    val ar_addr_en_reg           =RegInit(false.B)       
    val ar_addr_sc8_reg          =RegInit(false.B)       
    val ar_addr_sc16_reg         =RegInit(false.B)       
    val ar_grsr_num_reg          =RegInit(0.U(log2Ceil(grNum).W))       
    val ar_addr_age0_reg         =RegInit(false.B)   
    val dataGate =  (!io.WaitClkGate) && (io.G2generalCLKEn) && (ar_addr_set(ele))

    ar_addr_sbvec_nxt_reg   :=Mux(dataGate,ar_addr_sbvec_nxt(ele), ar_addr_sbvec_nxt_reg )
    ar_addr_bank_reg        :=Mux(dataGate,ar_addr_bank_nxt(ele) , ar_addr_bank_reg      )
    ar_addr_reg             :=Mux(dataGate,ar_addr_nxt(ele)      , ar_addr_reg           )
    ar_dram_id0_reg         :=Mux(dataGate,ar_dram_id_nxt(ele)   , ar_dram_id_reg       )
    ar_addr_en_reg          :=Mux(dataGate,ar_addr_en_nxt(ele)   , ar_addr_en_reg        )
    ar_addr_sc8_reg         :=Mux(dataGate,ar_addr_sc8_nxt(ele)  , ar_addr_sc8_reg       )
    ar_addr_sc16_reg        :=Mux(dataGate,ar_addr_sc16_nxt(ele) , ar_addr_sc16_reg      )
    ar_grsr_num_reg         :=Mux(dataGate,ar_grsr_num_nxt(ele)  , ar_grsr_num_reg       )
    ar_addr_age_reg         :=Mux(dataGate,ar_addr_age_nxt(ele) , ar_addr_age_reg      )

    ar_addr_sbvec(ele)      :=ar_addr_sbvec_nxt_reg
    ar_addr_bank(ele)       :=ar_addr_bank_reg     
    ar_addr(ele)            :=ar_addr_reg          
    ar_dram_id0(ele)        :=ar_dram_id0_reg      
    ar_addr_en(ele)         :=ar_addr_en_reg       
    ar_addr_sc8(ele)        :=ar_addr_sc8_reg      
    ar_addr_sc16(ele)       :=ar_addr_sc16_reg     
    ar_grsr_num(ele)        :=ar_grsr_num_reg      
    ar_addr_age(ele)        :=ar_addr_age_reg     
    
  }

  io.ar_scatter_age0(ele)         := ar_addr_en(ele) && (ar_addr_sc8(ele) || ar_addr_sc16(ele)) && !ar_addr_age(ele);
  io.ar_en_age0_ele(ele)          := ar_addr_en(ele) && !ar_addr_age(ele);
  io.ar_en_age1_ele(ele)          := ar_addr_en(ele) && ar_addr_age(ele);
  io.kill_age1_scatter_grant(ele) := !ar_first_scatter_mask_age0(ele);
}  //end of foreach ele

//bank0?  bank req signals

// val updateEnable=(!io.WaitClkGate) && io.G2generalCLKEn && io.G3bankStallStage1CLKEn0
// withClockAndReset(io.G3bankStallStage1CLK0,io.MyReset.asAsyncReset)
// {
//   val sc8_req_bank0_stage1_reg     =RegInit(false.B)
//   val sc16_req_bank0_stage1_reg    =RegInit(false.B)
//   val inc16_req_bank0_stage1_reg   =RegInit(false.B)
//   val dram_id_req_bank0_stage1_reg =RegInit(false.B)
//  //reset to value assignment is necessary?
//       sc8_req_bank0_stage1_reg    := Mux(io.MyReset,false.B,Mux(updateEnable,sc8_req_nxt_bank0_stage1,    sc8_req_bank0_stage1_reg    )) 
//       sc16_req_bank0_stage1_reg   := Mux(io.MyReset,false.B,Mux(updateEnable,sc16_req_nxt_bank0_stage1,   sc16_req_bank0_stage1_reg   )) 
//       inc16_req_bank0_stage1_reg  := Mux(io.MyReset,false.B,Mux(updateEnable,inc16_req_nxt_bank0_stage1,  inc16_req_bank0_stage1_reg  ))  
//       dram_id_req_bank0_stage1_reg:= Mux(io.MyReset,false.B,Mux(updateEnable,dram_id_req_nxt_bank0_stage1,dram_id_req_bank0_stage1_reg))     

//       sc8_req_bank0_stage1        :=sc8_req_bank0_stage1_reg      
//       sc16_req_bank0_stage1       :=sc16_req_bank0_stage1_reg    
//       inc16_req_bank0_stage1      :=inc16_req_bank0_stage1_reg     
//       dram_id_req_bank0_stage1    :=dram_id_req_bank0_stage1_reg    

//   }
} 


class ElementStagingPipeline(val numBanks: Int=2,val numSubbanks: Int=8, val numElems: Int=32, val sbkWidth: Int=64, val numGrs: Int=8, val numSrs: Int=2 ) extends Module {
  val io = IO(new Bundle {

    val arBankNumStage1Ele      = Output(Vec(numElems,UInt(log2Ceil(numBanks).W)))
    val gatherAValidStage1Ele   = Output(Vec(numElems,Bool()))
    val scatterValidStage1Ele   = Output(Vec(numElems,Bool()))
    val scatterIncValidStage1Ele= Output(Vec(numElems,Bool()))
    val arBankNumStage2Ele      = Output(Vec(numElems,UInt(log2Ceil(numBanks).W)))
    val scatterValidStage2Ele   = Output(Vec(numElems,Bool()))
    val gatherAValidStage2ElePre= Output(Vec(numElems,Bool()))
    val scatterincValidStage2Ele= Output(Vec(numElems,Bool()))
 
    val ele_bank_select         = Output(Vec(numElems, Bool()))
    val gr_sge_data_wr_stage5   = Output(Vec(numElems, Vec(8, Bool())))
   
    val ar_addr                 = Input(Vec(numElems, UInt(7.W)))
    val ar_addr_age             = Input(Vec(numElems, Bool()))
    val ar_grsr_num             = Input(Vec(numElems, UInt(3.W)))
    val ar_addr_sc8             = Input(Vec(numElems, Bool()))
    val ar_addr_sc16            = Input(Vec(numElems, Bool()))
    val ar_addr_inc16           = Input(Vec(numElems, Bool()))
    val ar_addr_issued_to_dram  = Input(Vec(numElems, Bool()))
    
    val pipe_busy_stage1        = Input(Vec(numElems, Bool()))
    val pipe_busy_stage2        = Input(Vec(numElems, Bool()))
    val pipe_busy_stage2_gather = Input(Vec(numElems, Bool()))
    val pipe_busy_stage3        = Input(Vec(numElems, Bool()))
  })

  def xcff_i[T <: Data](clk: Clock, reset: Reset, gateEnable: Bool, next: T, init: T) = {
    withClockAndReset(clk, reset){
      val reg = RegInit(init)
      when (gateEnable) {
        reg := next
      }
      reg
    }
  }
    val G2Enable = (~WaitClkGate) && G2generalCLKEn
    val G3Stall1Enable = (Fill(numElems)(G2Enable) & G3eleStall1CLKEn.asUInt).asBools
    val G3Stall2Enable = (Fill(numElems)(G2Enable) & G3eleStall2CLKEn.asUInt).asBools
    val G3Stall3Enable = (Fill(numElems)(G2Enable) & G3eleStall3CLKEn.asUInt).asBools
    val bkBits=log2Ceil(numBanks)    //1
    val sbkBits=log2Ceil(numSubbanks) //3
    val sbkWByteBitS = log2Ceil(sbkWidth/8)  //3
    val bkStartBit  = sbkWByteBits+sbkBits //6
    val bkEndBit    = bkStartBit + bkBits-1 //6
    val sbkStartBit = sbkWByteBits    //3
    val sbkEndBit   = sbkWByteBits + sbkBits -1 //5
    val maxNumRegs  = numGrs.max(numSrs)
    val regIdBits   = log2Ceil(maxNumRegs)   //3
    val grIdBits    = log2Ceil(numGrs)    //3
    val srIdBits    = log2Ceil(numSrs)    //1
    
    val ar_bank_num_stage1      = Wire(Vec(numElems,UInt(log2Ceil(numBanks).W)))
    val gatherA_valid_stage1    = Wire(Vec(numElems,Bool()))
    val scatter_valid_stage1    = Wire(Vec(numElems,Bool()))
    val scatterinc_valid_stage1 = Wire(Vec(numElems,Bool())) 
    val scatterinc_valid_stage2 = Wire(Vec(numElems,Bool())) 
    val ar_bank_stage2          = Wire(Vec(numElems,UInt(log2Ceil(numBanks).W)))     
    val gatherA_valid_stage2_pre= Wire(Vec(numElems,Bool()))
    val gatherA_valid_stage2    = Wire(Vec(numElems,Bool()))    
    val scatter_valid_stage2    = Wire(Vec(numElems,Bool())) 

    io.arBankNumStage1Ele      := ar_bank_num_stage1
    io.gatherAValidStage1Ele   := gatherA_valid_stage1
    io.scatterValidStage1Ele   := scatter_valid_stage1
    io.scatterIncValidStage1Ele:= scatterinc_valid_stage1
    io.arBankNumStage2Ele      := ar_bank_stage2
    io.scatterValidStage2Ele   := scatter_valid_stage2
    io.gatherAValidStage2ElePre:= gatherA_valid_stage2_pre
    io.scatterincValidStage2Ele:= scatterinc_valid_stage2

  for (ele <- 0 until numElems) {
    // Stage 1 signals
    val ar_bank_num_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr(ele)(bkEndBit,bkStartBit), false.B)
    val ar_byte_num_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr(ele)(sbkWByteBit-1, 0), 0.U(sbkWByteBit.W))
    val ar_subbank_num_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr(ele)(sbkEndBit, sbkStartBit), 0.U(sbkBits.W))
    val ar_age_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr_age(ele), false.B)
    val ar_grsr_num_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_grsr_num(ele), 0.U(regIdBits.W))
    val ar_sc8_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr_sc8(ele), false.B)
    val ar_sc16_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr_sc16(ele), false.B)  
    val ar_inc16_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr_inc16(ele), false.B)
    val gatherA_valid_stage1 = io.ar_addr_issued_to_dram(ele) && !(ar_sc8_stage1 || ar_sc16_stage1 || ar_inc16_stage1)
    val any_scatter_valid_stage1 = ar_sc8_stage1 || ar_sc16_stage1
    val scatter_valid_stage1 = io.ar_addr_issued_to_dram(ele) && any_scatter_valid_stage1
    val scatterinc_valid_stage1 = io.ar_addr_issued_to_dram(ele) && ar_inc16_stage1

    // Stage 2 signals 
    val ar_grsr_num_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), ar_grsr_num_stage1, 0.U(regIdBits.W))
    val ar_sr_num_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), ar_grsr_num_stage1(0), false.B)
    val scatter_valid_stage2_pre = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), scatter_valid_stage1 && !pipe_busy_stage1(ele), false.B)
    val scatterinc_valid_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), scatterinc_valid_stage1 && !pipe_busy_stage1(ele), false.B)
    val scatterinc_valid_stage2_onesht = xcff_i(G2generalCLK, MyReset, G2generalCLKEn, scatterinc_valid_stage1 && !pipe_busy_stage1(ele), false.B)  
    val ar_bank_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), ar_bank_num_stage1, false.B)
    val ar_byte_num_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), ar_byte_num_stage1, 0.U(sbkWByteBit.W))  
    val ar_subbank_num_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), ar_subbank_num_stage1, 0.U(sbkBits.W))
    val gatherA_valid_stage2_pre = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), gatherA_valid_stage1 && !pipe_busy_stage1(ele), false.B)
    val gatherA_valid_stage2 = gatherA_valid_stage2_pre && !pipe_busy_stage2_gather(ele)
    val scatter_valid_stage2 = scatter_valid_stage2_pre && !pipe_busy_stage2(ele) && !scatterinc_valid_stage2
    
    // Stage 3 signals
    val ar_gr_num_stage3 = xcff_i(G3eleStall3CLK(ele), MyReset, G3Stall3Enable(ele), ar_grsr_num_stage2(grIdBits-1,0), 0.U(grIdBits.W))
    val ar_sr_num_stage3 = xcff_i(G3eleStall3CLK(ele), MyReset, G3Stall3Enable(ele), ar_grsr_num_stage2(srIdBits-1,0), false.B)
    val argr_bank_stage3 = xcff_i(G3eleStall3CLK(ele), MyReset, G3Stall3Enable(ele), ar_bank_stage2,                   0.U(bkBits.W))
    val gatherA_valid_stage3 = xcff_i(G3eleStall3CLK(ele), MyReset, G3Stall3Enable(ele), gatherA_valid_stage2, false.B)
    val ar_byte_num_stage3 = xcff_i(G3eleStall3CLK(ele), MyReset, G3Stall3Enable(ele), ar_byte_num_stage2(0),  false.B)
    val scatterinc_valid_stage3 = xcff_i(G3eleStall3CLK(ele), MyReset, G3Stall3Enable(ele), scatterinc_valid_stage2 && !pipe_busy_stage2(ele), false.B)

    // Stage 4 signals
    val ar_gr_num_stage4_p1 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage3,    0.U(grIdBits.W))
    val ar_gr_num_stage4_p2 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p1, 0.U(grIdBits.W))
    val ar_gr_num_stage4_p3 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p2, 0.U(grIdBits.W))
    val ar_gr_num_stage4_p4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p3, 0.U(grIdBits.W))
    val ar_gr_num_stage4    = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p4,    0.U(grIdBits.W))
    val argr_bank_stage4_p1 = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage3,    0.U(bkBits.W))
    val argr_bank_stage4_p2 = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p1, 0.U(bkBits.W))
    val argr_bank_stage4_p3 = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p2, 0.U(bkBits.W))
    val argr_bank_stage4_p4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p3, 0.U(bkBits.W))
    val argr_bank_stage4    = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p4,    0.U(bkBits.W))
    val gatherA_valid_stage4_p1 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage3,    false.B)
    val gatherA_valid_stage4_p2 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p1, false.B)
    val gatherA_valid_stage4_p3 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p2, false.B)
    val gatherA_valid_stage4_p4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p3, false.B)
    val gatherA_valid_stage4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p4,    false.B)    
    val scatterinc_valid_stage4_p1 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage3 && !pipe_busy_stage3(ele), false.B)
    val scatterinc_valid_stage4_p2 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p1, false.B)
    val scatterinc_valid_stage4_p3 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p2, false.B)
    val scatterinc_valid_stage4_p4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p3, false.B)
    val scatterinc_valid_stage4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p4, false.B)
    val ar_byte_num_stage4_p1 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage3, false.B)
    val ar_byte_num_stage4_p2 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage4_p1, false.B)
    val ar_byte_num_stage4_p3 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage4_p2, false.B)
    val ar_byte_num_stage4_p4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage4_p3, false.B)
    val ar_byte_num_stage4  = xcff_i(G2generalCLK, MyReset,G2Enable, ar_byte_num_stage4_p4, 0.U(srIdBits.W))
    val ar_sr_num_stage4_p1 = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage3,      0.U(srIdBits.W))
    val ar_sr_num_stage4_p2 = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p1,   0.U(srIdBits.W))
    val ar_sr_num_stage4_p3 = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p2,   0.U(srIdBits.W)) 
    val ar_sr_num_stage4_p4 = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p3,   0.U(srIdBits.W))
    val ar_sr_num_stage4    = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p4,   0.U(srIdBits.W))

    // Stage 5 signals
    val ar_gr_num_stage5     = xcff_i(G2generalCLK, MyReset, G2Enable, ar_gr_num_stage4, 0.U(grIdBits.W))
    val gatherA_valid_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, gatherA_valid_stage4, false.B)
    // Stage 5 signals (continued)
    val ar_byte_num_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, ar_byte_num_stage4, false.B)
    val scatter_valid_stage5_nxt = scatter_valid_stage2
    val scatter_valid_stage5_pre = xcff_i(G2generalCLK, MyReset, G2Enable, scatter_valid_stage5_nxt, false.B)
    val scatterinc_valid_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, scatterinc_valid_stage4, false.B)
    val scatter_valid_stage5 = scatter_valid_stage5_pre || scatterinc_valid_stage5

    val arsr_bank_stage5_nxt = ar_bank_stage2
    val arsr_bank_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, arsr_bank_stage5_nxt, 0.U(bkBits.W))
    val argr_bank_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, argr_bank_stage4,     0.U(bkBits.W))

    val ar_sr_num_stage5_nxt = Mux(scatterinc_valid_stage4, ar_sr_num_stage4, ar_grsr_num_stage2)
    val ar_sr_num_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, ar_sr_num_stage5_nxt, 0.U(srIdBits))

    // Stage 6 signals
    val arsr_bank_stage6 = xcff_i(G2generalCLK, MyReset, G2Enable, arsr_bank_stage5, 0.U(bkBits.W))
    val ar_sr_num_stage6 = xcff_i(G2generalCLK, MyReset, G2Enable, ar_sr_num_stage5, 0.U(srIdBits))

    // Outputs
    io.ele_bank_select(ele) := argr_bank_stage5
    for(rId <- 0 until numGrs)
      io.gr_sge_data_wr_stage5(ele)(rId) := (ar_gr_num_stage5 === rId.U) && gatherA_valid_stage5
    // io.gr_sge_data_wr_stage5(ele)(1) := (ar_gr_num_stage5 === 1.U) && gatherA_valid_stage5
    // io.gr_sge_data_wr_stage5(ele)(2) := (ar_gr_num_stage5 === 2.U) && gatherA_valid_stage5
    // io.gr_sge_data_wr_stage5(ele)(3) := (ar_gr_num_stage5 === 3.U) && gatherA_valid_stage5
    // io.gr_sge_data_wr_stage5(ele)(4) := (ar_gr_num_stage5 === 4.U) && gatherA_valid_stage5
    // io.gr_sge_data_wr_stage5(ele)(5) := (ar_gr_num_stage5 === 5.U) && gatherA_valid_stage5
    // io.gr_sge_data_wr_stage5(ele)(6) := (ar_gr_num_stage5 === 6.U) && gatherA_valid_stage5
    // io.gr_sge_data_wr_stage5(ele)(7) := (ar_gr_num_stage5 === 7.U) && gatherA_valid_stage5
  }
}