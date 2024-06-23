 // Elem Active Request  Registers Staging Pipeline
import chisel3._
import chisel3.util._
import primitives._
import primitives.primitives_wrapper._

class ArElemsActiveLogic(val elemNum: Int=32, val elemWidth:Int=16,val sbkWidth: Int=64,val bkNum:Int=2,val sbkNum:Int=8, val grNum:Int=8,val srNum:Int=2) extends Module {
  val dramIDWidth = log2Ceil(bkNum)
  val io = IO(new Bundle {
//output
         val ar_addr_set                       = Output(Vec(elemNum,Bool()))    
         val ar_addr_sel                       = Output(Vec(elemNum,Bool())) 
         val ar_age_set                        = Output(Vec(elemNum,Bool()))
         val ar_addr_age                       = Output(Vec(elemNum,Bool()))
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
         val ar_gr_age0_mux_sel                = Output(Vec(elemNum,UInt(grNum.W)))       //[7:0]
         val ar_sr_age1_mux_sel                = Output(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_sr_age2_mux_sel                = Output(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_sr_age0_mux_sel                = Output(Vec(elemNum,UInt(srNum.W)))       //[1:0]
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
         val gr_ready                           =Input(Vec(grNum,UInt(elemNum.W)))
         val gr_age                             =Input(Vec(grNum,UInt(4.W)))
         val ar_Finish_age0                    =Input(Bool())
         val ar_Finish_age1                    =Input(Bool())
         val gr_extended_ad                    =Input(Vec(grNum,Vec(elemNum,UInt(2.W))))
         val gr_ad                             =Input(Vec(grNum,Vec(elemNum,UInt(elemWidth.W))))
         val sr_ready                          =Input(Vec(srNum,UInt(elemNum.W)))
         val sr_age                            =Input(Vec(srNum,UInt(4.W)))
         val sr_addr                           =Input(Vec(srNum,UInt((2+elemWidth).W)))
         val sr_sc8                            =Input(Vec(srNum,Bool()))
         val sr_sc16                           =Input(Vec(srNum,Bool())) 
         val sr_inc16                          =Input(Vec(srNum,Bool()))  
         val sr_next_addr_D2                   =Input(UInt(log2Ceil(srNum).W))
         val GatherA_D2                        =Input(Bool())  
         val Scatter_D2                        =Input(Bool()) 
         val GSDramID_D2                       =Input(UInt(log2Ceil(bkNum).W))
         val gr_dram                           =Input(Vec(grNum,UInt((elemNum*dramIDWidth).W)))
         val sr_dram                           =Input(Vec(srNum,UInt((elemNum*dramIDWidth).W)))
         val GSDramAddr_D2                     =Input(UInt((2+elemWidth).W))
         val GSPredicate_D2                    =Input(Vec(elemNum,Bool()))   
         val ScatterInc_D2                     =Input(Bool())  
         val G2eleSize_1B_D2                   =Input(Bool()) 
         val G2eleSize_2B_D2                   =Input(Bool()) 
         val G2eleSize_4B_D2                   =Input(Bool()) 
         val gvr_wr0_addr_D2                   =Input(UInt(log2Ceil(grNum).W))    //gather reg number

         val G2generalCLKEn                    =Input(Bool())      
         val G2generalCLK                      =Input(Clock())    
         val MyReset                           =Input(Bool())
         val WaitClkGate                       =Input(Bool())  

         val next_ar_age                       =Input(UInt(4.W))
         val ar_en_age0_ele                    =Output(Vec(elemNum,Bool())) 
         val ar_en_age1_ele                    =Output(Vec(elemNum,Bool()))
         //kill_age1_scatter_grant
         //ar_first_scatter_mask_age0
})
 
//glue interface
         val ar_addr_set                       = Wire(Vec(elemNum,Bool()))    
         val ar_addr_sel                       = Wire(Vec(elemNum,UInt(3.W))) 
         val ar_age_set                        = Wire(Vec(elemNum,Bool()))
         val ar_dram_id                        = Wire(Vec(elemNum,UInt(log2Ceil(sbkNum).W)))
         val ar_addr                           = Wire(Vec(elemNum,UInt((elemWidth+2).W)))   //[17:0] 
         val ar_addr_bank                      = Wire(Vec(elemNum,Bool()))
         val ar_addr_sbvec                     = Wire(Vec(elemNum,UInt(sbkNum.W)) )         //[7:0] 
         val ar_addr_sc8                       = Wire(Vec(elemNum,Bool()))
         val ar_scatter_age0                   = Wire(Vec(elemNum,Bool())) 
         val ar_addr_sc16                      = Wire(Vec(elemNum,Bool()))
         val ar_addr_inc16                     = Wire(Vec(elemNum,Bool()))
         val ar_gr_age1or0_mux_sel             = Wire(Vec(elemNum,UInt(grNum.W)))       //[7:0]  
         val ar_sr_age1or0_mux_sel             = Wire(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_gr_age1_mux_sel                = Wire(Vec(elemNum,UInt(grNum.W)))       //[7:0] 
         val ar_gr_age2_mux_sel                = Wire(Vec(elemNum,UInt(grNum.W)))       //[7:0] 
         val ar_gr_age0_mux_sel                = Wire(Vec(elemNum,UInt(grNum.W)))       //[7:0]
         val ar_sr_age1_mux_sel                = Wire(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_sr_age2_mux_sel                = Wire(Vec(elemNum,UInt(srNum.W)))       //[1:0] 
         val ar_sr_age0_mux_sel                = Wire(Vec(elemNum,UInt(srNum.W)))       //[1:0]
         val ar_grsr_num                       = Wire(Vec(elemNum,UInt(log2Ceil(grNum).W)))       // [2:0] 
         val ar_bank_num_stage1                = Wire(Vec(elemNum,UInt(log2Ceil(bkNum).W)))
         val ar_subbank_num_stage1             = Wire(Vec(elemNum,UInt(log2Ceil(sbkNum).W)))      //[2:0] 
         val ar_en_age0                        = Wire(Vec(elemNum,Bool()))
         val ar_en_age1                        = Wire(Vec(elemNum,Bool()))  
         val ar_addr_en                        = Wire(Vec(elemNum,Bool()))
         val ar_ele_addr_issued_to_dram_for_ready  = Wire(Vec(elemNum,Bool()))
         val ar_addr_en_nxt                        = Wire(Vec(elemNum,Bool()))
         val ar_addr_age_nxt                       = Wire(Vec(elemNum,Bool()))
         val ar_addr_age                       = Wire(Vec(elemNum,Bool()))
         val next_ar_age                       = io.next_ar_age
         val sr_next_addr_D2                   = io.sr_next_addr_D2
         val gr_dram                           = io.gr_dram
         val sr_dram                           = io.sr_dram
         //val gr_ad                                 = Wire (Vec(grNum,Vec(elemNum,UInt(elemWidth.W))))
            io.ar_addr_set                         :=ar_addr_set                                 
            io.ar_addr_sel                         :=ar_addr_sel 
            io.ar_addr_age                         :=ar_addr_age                             
            io.ar_age_set                          :=ar_age_set                                  
            io.ar_dram_id                          :=ar_dram_id                                  
            io.ar_addr                             :=ar_addr                                     
            io.ar_addr_bank                        :=ar_addr_bank                                
            io.ar_addr_sbvec                       :=ar_addr_sbvec                               
            io.ar_addr_sc8                         :=ar_addr_sc8                                 
            io.ar_scatter_age0                     :=ar_scatter_age0                             
            io.ar_addr_sc16                        :=ar_addr_sc16                                
            io.ar_addr_inc16                       :=ar_addr_inc16                               
            io.ar_gr_age1or0_mux_sel               :=ar_gr_age1or0_mux_sel                       
            io.ar_sr_age1or0_mux_sel               :=ar_sr_age1or0_mux_sel                       
            io.ar_gr_age1_mux_sel                  :=ar_gr_age1_mux_sel                          
            io.ar_gr_age2_mux_sel                  :=ar_gr_age2_mux_sel                          
            io.ar_gr_age0_mux_sel                  :=ar_gr_age0_mux_sel                          
            io.ar_sr_age1_mux_sel                  :=ar_sr_age1_mux_sel                          
            io.ar_sr_age2_mux_sel                  :=ar_sr_age2_mux_sel                          
            io.ar_sr_age0_mux_sel                  :=ar_sr_age0_mux_sel                          
            io.ar_grsr_num                         :=ar_grsr_num                                 
            io.ar_bank_num_stage1                  :=ar_bank_num_stage1                          
            io.ar_subbank_num_stage1               :=ar_subbank_num_stage1                       
            io.ar_en_age0                          :=ar_en_age0                                  
            io.ar_en_age1                          :=ar_en_age1                                  
            io.ar_addr_en                          :=ar_addr_en 
            io.ar_ele_addr_issued_to_dram_for_ready:=ar_ele_addr_issued_to_dram_for_ready
            io.ar_addr_en_nxt                      :=ar_addr_en_nxt                      
            io.ar_addr_age_nxt                     :=ar_addr_age_nxt                     

            val gr_ready                          =io.gr_ready         
            val gr_age                            =io.gr_age           
            val ar_Finish_age0                    =io.ar_Finish_age0  
            val ar_Finish_age1                    =io.ar_Finish_age1  
            val gr_extended_ad                    =io.gr_extended_ad  
            val gr_ad                             =io.gr_ad           
            val sr_ready                          =io.sr_ready         
            val sr_age                            =io.sr_age  
            val sr_addr                           =io.sr_addr  
            val sr_sc8                            =io.sr_sc8   
            val sr_sc16                           =io.sr_sc16  
            val sr_inc16                          =io.sr_inc16      
            val GatherA_D2                        =io.GatherA_D2      
            val Scatter_D2                        =io.Scatter_D2      
            val GSPredicate_D2                    =io.GSPredicate_D2  
            val ScatterInc_D2                     =io.ScatterInc_D2   
            val G2eleSize_1B_D2                   =io.G2eleSize_1B_D2 
            val G2eleSize_2B_D2                   =io.G2eleSize_2B_D2 
            val G2eleSize_4B_D2                   =io.G2eleSize_4B_D2 
            val gvr_wr0_addr_D2                   =io.gvr_wr0_addr_D2                             
//end of glue logic

          

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

//val ar_bank_num_stage    = Wire(Vec(elemNum,Bool()))
//val ar_subbank_num_stage1= Wire(Vec(elemNum,UInt(log2Ceil(sbkNum).W)))

val ar_gr_age_nxt_pre     = Wire(Vec(elemNum,Bool()))
val ar_sr_age_nxt_pre     = Wire(Vec(elemNum,Bool()))
val ar_gr_age_nxt         = Wire(Vec(elemNum,Bool()))
val ar_sr_age_nxt         = Wire(Vec(elemNum,Bool()))
val ar_dram_id_nxt        = Wire(Vec(elemNum,UInt(log2Ceil(sbkNum).W)))
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
//val ar_addr_en_nxt        = Wire(Vec(elemNum,Bool()))
val ar_age_nxt            = Wire(Vec(elemNum,Bool()))
val finish_ar_op          =  io.ar_Finish_age0 || io.ar_Finish_age1
for(ele <- 0 until elemNum){
	io.ar_addr_set(ele)	       := !io.ar_addr_en(ele) || io.ar_ele_addr_issued_to_dram_for_ready(ele)					
  io.ar_addr_sel(ele)  	     := Cat((io.ar_gr_age1or0_mux_sel(ele).orR),   (io.ar_sr_age1or0_mux_sel(ele).orR), 
                                !((io.ar_gr_age1or0_mux_sel(ele).orR) || (io.ar_sr_age1or0_mux_sel(ele).orR)))
  io.ar_gr_age2_mux_sel(ele) :=  Cat(io.gr_ready.zip(io.gr_age).map{ case (ready,age) => ready(ele)&&finish_ar_op&&(age===2.U(4.W))}) & 
                              (~Fill(8,io.ar_sr_age0_mux_sel(ele).orR)) &  (~Fill(8,io.ar_sr_age1_mux_sel(ele).orR))
                       
  io.ar_gr_age1_mux_sel(ele) := Cat(io.gr_ready.zip(io.gr_age).map{ case (ready,age) => ready(ele)&&(age===1.U(4.W))}) &  (~Fill(8,ar_sr_age0_mux_sel(ele).orR))

  io.ar_gr_age0_mux_sel(ele) := Cat(io.gr_ready.zip(io.gr_age).map{case (ready,age) => ready(ele)&&(age===0.U(4.W))})
  io.ar_sr_age2_mux_sel(ele) := Cat(io.sr_ready.zip(sr_age).map{ case (ready,age) => ready(ele) && (age===2.U(4.W) && finish_ar_op)})&Fill(srNum, !(io.ar_gr_age0_mux_sel(ele).orR))&Fill(srNum, !(io.ar_gr_age1_mux_sel(ele).orR))
  io.ar_sr_age1_mux_sel(ele) := Cat(io.sr_ready.zip(sr_age).map{ case (ready,age) => ready(ele) && (age===1.U(4.W))})&Fill(srNum,!(io.ar_gr_age0_mux_sel(ele).orR))  //{2{!(|ar_gr_age0_mux_sel0)}}
  io.ar_sr_age0_mux_sel(ele) := Cat(io.sr_ready.zip(sr_age).map{ case (ready,age) => ready(ele) && (age===0.U(4.W))})

io.ar_gr_age1or0_mux_sel(ele) := Mux(io.ar_gr_age0_mux_sel(ele).orR , io.ar_gr_age0_mux_sel(ele),
                                 Mux(io.ar_gr_age1_mux_sel(ele).orR , io.ar_gr_age1_mux_sel(ele), io.ar_gr_age2_mux_sel(ele)))
io.ar_sr_age1or0_mux_sel(ele) := Mux(io.ar_sr_age0_mux_sel(ele).orR , io.ar_sr_age0_mux_sel(ele) ,
                                 Mux( io.ar_sr_age1_mux_sel(ele).orR , io.ar_sr_age1_mux_sel(ele),io.ar_sr_age2_mux_sel(ele)))
 
val grAddrEle = gr_extended_ad.zip(gr_ad).map{ case (ex,ad) => Cat(ex(ele),ad(ele))}
ar_gr_addr_nxt(ele):=Xtmux8(18,grAddrEle,io.ar_gr_age1or0_mux_sel(ele).asBools.toSeq)

ar_sr_addr_nxt(ele):=Xtmux2(18,sr_addr,ar_sr_age1or0_mux_sel(ele).asBools.toSeq)

ar_addr_nxt(ele)   :=Xtmux3(18,VecInit(ar_gr_addr_nxt(ele),ar_sr_addr_nxt(ele),io.GSDramAddr_D2(ele)),ar_addr_sel(ele).asBools.toSeq)

val grEleDramIdVec = VecInit(gr_dram.map{ grDramID=> grDramID(ele*dramIDWidth+dramIDWidth-1,ele*dramIDWidth) })
ar_gr_dram_id_nxt(ele) := Xtmux8(1,grEleDramIdVec,ar_gr_age1or0_mux_sel(ele).asBools.toSeq)

val srEleDramIdVec = VecInit(sr_dram.map{ srDramID=> srDramID(ele*dramIDWidth+dramIDWidth-1,ele*dramIDWidth) })
ar_sr_dram_id_nxt(ele) := Xtmux2(1,srEleDramIdVec,ar_sr_age1or0_mux_sel(ele).asBools.toSeq)

ar_dram_id_nxt(ele) := Xtmux3(1,VecInit(ar_gr_dram_id_nxt(ele), ar_sr_dram_id_nxt(ele), io.GSDramID_D2),ar_addr_sel(ele).asBools.toSeq)
// -----------> ar_en
val grEleReadyVec =VecInit(gr_ready.map( grRdy => grRdy(ele)))
ar_gr_en_nxt(ele) := Xtmux8(1,grEleReadyVec,ar_gr_age1or0_mux_sel(ele).asBools.toSeq)

val srEleReadyVec =VecInit(sr_ready.map( srRdy => srRdy(ele)))
ar_sr_en_nxt(ele)       := Xtmux2(1,srEleReadyVec,ar_sr_age1or0_mux_sel(ele).asBools.toSeq)
ar_addr_en_nxt_pre(ele) := Xtmux3(1,VecInit(ar_gr_en_nxt(ele), ar_sr_en_nxt(ele), ((io.GatherA_D2 || io.Scatter_D2) && io.GSPredicate_D2(ele))), ar_addr_sel(ele).asBools.toSeq)
// -----------> ar_sc8/16
ar_sr_sc8_nxt(ele)   := Xtmux2 (1,sr_sc8, ar_sr_age1or0_mux_sel(ele).asBools.toSeq)
ar_addr_sc8_nxt(ele) := Xtmux3 (1,Seq(0.U(1.W), ar_sr_sc8_nxt(ele), (io.Scatter_D2 && !io.ScatterInc_D2 && io.G2eleSize_1B_D2)), ar_addr_sel(ele).asBools.toSeq)
ar_sr_sc16_nxt(ele)  := Xtmux2 (1,sr_sc16, ar_sr_age1or0_mux_sel(ele).asBools.toSeq)
ar_addr_sc16_nxt(ele):= Xtmux3 (1,Seq(0.U(1.W), ar_sr_sc16_nxt(ele), (io.Scatter_D2 && !io.ScatterInc_D2 && (io.G2eleSize_2B_D2 || io.G2eleSize_4B_D2))), ar_addr_sel(ele).asBools.toSeq)
// -----------> ar_inc16
ar_sr_inc16_nxt(ele)  :=Xtmux2 (1,sr_inc16, ar_sr_age1or0_mux_sel(ele).asBools.toSeq)
ar_addr_inc16_nxt(ele):=Xtmux3 (1,Seq(0.U(1.W), ar_sr_inc16_nxt.asUInt, (io.ScatterInc_D2).asUInt), ar_addr_sel(ele).asBools.toSeq)
// -----------> ar_grsr_num
ar_gr_num_nxt(ele):=Xtmux8 (3,VecInit(Seq.tabulate(grNum)(i => /* (grNum-1 - i) */i.U(log2Ceil(grNum).W))), ar_gr_age1or0_mux_sel(ele).asBools.toSeq)
ar_sr_num_nxt(ele):=Xtmux2 (3,VecInit(Seq.tabulate(srNum)(i => /* (srNum-1 - i) */i.U(log2Ceil(grNum).W))), ar_sr_age1or0_mux_sel(ele).asBools.toSeq)
ar_inst_grsr_num_nxt(ele) :=  Mux(io.GatherA_D2 , gvr_wr0_addr_D2 , Mux(io.Scatter_D2 , sr_next_addr_D2 , 0.U(3.W) ))   //sr_next_addr -> sr reg entry id
ar_grsr_num_nxt(ele):= Xtmux3 (3,Seq(ar_gr_num_nxt(ele), ar_sr_num_nxt(ele), ar_inst_grsr_num_nxt(ele)), ar_addr_sel(ele).asBools.toSeq)

// -----------> ar_age
val grAgeNew= VecInit(gr_age.map{age => age(1) && !(ar_Finish_age0 && ar_Finish_age1) ||  age(0)&& !(ar_Finish_age0) })
ar_gr_age_nxt_pre(ele):=Xtmux8 (1,grAgeNew, ar_gr_age1or0_mux_sel(ele).asBools.toSeq)
val srAgeNew= VecInit(sr_age.map{age => age(1) && !(ar_Finish_age0 && ar_Finish_age1) ||  age(0)&& !(ar_Finish_age0) })
ar_sr_age_nxt_pre(ele):=Xtmux2 (1,srAgeNew, ar_sr_age1or0_mux_sel(ele).asBools.toSeq)

ar_gr_age_nxt(ele) := ar_gr_age_nxt_pre(ele)
ar_sr_age_nxt(ele) := ar_sr_age_nxt_pre(ele)

ar_age_nxt(ele) := Xtmux3 (1, VecInit(ar_gr_age_nxt(ele), ar_sr_age_nxt(ele), next_ar_age(0)), ar_addr_sel(ele).asBools.toSeq)

ar_age_set(ele)     := !ar_addr_en(ele)|| ar_ele_addr_issued_to_dram_for_ready(ele)|| (ar_addr_age(ele) && (ar_Finish_age0))

ar_addr_age_nxt(ele):= ar_age_nxt(ele) &&	!(ar_addr_en(ele)
						&& !ar_ele_addr_issued_to_dram_for_ready(ele)
						&& ar_addr_age(ele) && (ar_Finish_age0))

ar_addr_en_nxt(ele) := ar_addr_en_nxt_pre(ele) && !(ar_addr_sel(ele)(0) && (next_ar_age(3,1).orR))
val bitsSbkBytes = log2Ceil(sbkWidth/8)
val bitsSbk=log2Ceil(sbkNum)
val bitsBnk=log2Ceil(bkNum)
val bankStartBit=bitsSbkBytes+bitsSbk
val bankEndBit  =bankStartBit+bitsBnk-1
for(idx <- 0 until sbkNum){
     ar_addr_sbvec_nxt(ele)(idx) :=  (ar_addr_nxt(ele)(bitsSbk+bitsSbkBytes-1,bitsSbkBytes)=== idx.U(log2Ceil(sbkNum).W)) && ar_addr_en_nxt(ele)
     }
ar_addr_bank_nxt(ele) := ar_addr_nxt(ele)(bankEndBit,bankStartBit) 
   // ar_addr_sbvec    := ar_addr_sbvec_reg
withClockAndReset(io.G2generalCLK,io.MyReset.asAsyncReset) {
    val ar_addr_sbvec_nxt_reg    =RegInit(0.U(sbkNum.W))
    val ar_addr_bank_reg         =RegInit(0.U(sbkNum.W))
    val ar_addr_reg              =RegInit(0.U((elemWidth+2).W))
    val ar_dram_id_reg           =RegInit(0.U(bitsBnk.W)) 
    val ar_addr_en_reg           =RegInit(false.B)       
    val ar_addr_sc8_reg          =RegInit(false.B)       
    val ar_addr_sc16_reg         =RegInit(false.B)       
    val ar_grsr_num_reg          =RegInit(0.U(log2Ceil(grNum).W))       
    val ar_addr_age_reg          =RegInit(false.B)   
    val dataGate =  (!io.WaitClkGate) && (io.G2generalCLKEn) && (ar_addr_set(ele))

    ar_addr_sbvec_nxt_reg   :=Mux(dataGate,ar_addr_sbvec_nxt(ele), ar_addr_sbvec_nxt_reg )
    ar_addr_bank_reg        :=Mux(dataGate,ar_addr_bank_nxt(ele) , ar_addr_bank_reg      )
    ar_addr_reg             :=Mux(dataGate,ar_addr_nxt(ele)      , ar_addr_reg           )
    ar_dram_id_reg          :=Mux(dataGate,ar_dram_id_nxt(ele)   , ar_dram_id_reg       )
    ar_addr_en_reg          :=Mux(dataGate,ar_addr_en_nxt(ele)   , ar_addr_en_reg        )
    ar_addr_sc8_reg         :=Mux(dataGate,ar_addr_sc8_nxt(ele)  , ar_addr_sc8_reg       )
    ar_addr_sc16_reg        :=Mux(dataGate,ar_addr_sc16_nxt(ele) , ar_addr_sc16_reg      )
    ar_grsr_num_reg         :=Mux(dataGate,ar_grsr_num_nxt(ele)  , ar_grsr_num_reg       )
    ar_addr_age_reg         :=Mux(dataGate,ar_addr_age_nxt(ele) , ar_addr_age_reg      )

    ar_addr_sbvec(ele)      :=ar_addr_sbvec_nxt_reg
    ar_addr_bank(ele)       :=ar_addr_bank_reg     
    ar_addr(ele)            :=ar_addr_reg          
    ar_dram_id(ele)         :=ar_dram_id_reg      
    ar_addr_en(ele)         :=ar_addr_en_reg       
    ar_addr_sc8(ele)        :=ar_addr_sc8_reg      
    ar_addr_sc16(ele)       :=ar_addr_sc16_reg     
    ar_grsr_num(ele)        :=ar_grsr_num_reg      
    ar_addr_age(ele)        :=ar_addr_age_reg     
    
  }

  io.ar_scatter_age0(ele)         := ar_addr_en(ele) && (ar_addr_sc8(ele) || ar_addr_sc16(ele)) && !ar_addr_age(ele)
  io.ar_en_age0_ele(ele)          := ar_addr_en(ele) && !ar_addr_age(ele)
  io.ar_en_age1_ele(ele)          := ar_addr_en(ele) && ar_addr_age(ele)
 // io.kill_age1_scatter_grant(ele) := !ar_first_scatter_mask_age0(ele)
}  //end of foreach ele

//bank0?  bank req signals

} 


class ElementStagingPipeline(val numBanks: Int=2,val numSubbanks: Int=8, val numElems: Int=32, val sbkWidth: Int=64, val grNum: Int=8, val numSrs: Int=2 ) extends Module {
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

    val G3eleStall1CLKEn        = Input(Vec(numElems,Bool())) 
    val G3eleStall2CLKEn        = Input(Vec(numElems,Bool()))
    val G3eleStall3CLKEn        = Input(Vec(numElems,Bool()))
    val G3eleStall1CLK          = Input(Vec(numElems,Clock()))
    val G3eleStall2CLK          = Input(Vec(numElems,Clock()))
    val G3eleStall3CLK          = Input(Vec(numElems,Clock()))
    val G2generalCLK            = Input(Clock())
    val G2generalCLKEn          = Input(Bool())
    val MyReset                 = Input(Bool())
    val WaitClkGate             = Input(Bool())
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
    val G2Enable = (~io.WaitClkGate) && io.G2generalCLKEn

    val G3Stall1Enable = (Fill(numElems,G2Enable) & io.G3eleStall1CLKEn.asUInt).asBools
    val G3Stall2Enable = (Fill(numElems,G2Enable) & io.G3eleStall2CLKEn.asUInt).asBools
    val G3Stall3Enable = (Fill(numElems,G2Enable) & io.G3eleStall3CLKEn.asUInt).asBools
    val G3eleStall1CLK =io.G3eleStall1CLK
    val G3eleStall2CLK =io.G3eleStall2CLK
    val G3eleStall3CLK =io.G3eleStall3CLK
    val G2generalCLK   =io.G2generalCLK 
    val pipe_busy_stage1        =io.pipe_busy_stage1
    val pipe_busy_stage2        =io.pipe_busy_stage2
    val pipe_busy_stage3        =io.pipe_busy_stage3
    val pipe_busy_stage2_gather = io.pipe_busy_stage2_gather
    val MyReset        =io.MyReset.asAsyncReset
    val bkBits=log2Ceil(numBanks)    //1
    val sbkBits=log2Ceil(numSubbanks) //3
    val sbkWByteBits = log2Ceil(sbkWidth/8)  //3
    val bkStartBit  = sbkWByteBits+sbkBits //6
    val bkEndBit    = bkStartBit + bkBits-1 //6
    val sbkStartBit = sbkWByteBits    //3
    val sbkEndBit   = sbkWByteBits + sbkBits -1 //5
    val maxNumRegs  = grNum.max(numSrs)
    val regIdBits   = log2Ceil(maxNumRegs)   //3
    val grIdBits    = log2Ceil(grNum)    //3
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
    val ar_addr_age             = io.ar_addr_age
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
    val ar_byte_num_stage1 = xcff_i(G3eleStall1CLK(ele), MyReset, G3Stall1Enable(ele), io.ar_addr(ele)(sbkWByteBits-1, 0), 0.U(sbkWByteBits.W))
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
    val scatterinc_valid_stage2_onesht = xcff_i(G2generalCLK, MyReset, G2Enable, scatterinc_valid_stage1 && !pipe_busy_stage1(ele), false.B)  
    val ar_bank_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), ar_bank_num_stage1, false.B)
    val ar_byte_num_stage2 = xcff_i(G3eleStall2CLK(ele), MyReset, G3Stall2Enable(ele), ar_byte_num_stage1, 0.U(sbkWByteBits.W))  
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
    val ar_gr_num_stage4_p1     = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage3,    0.U(grIdBits.W))
    val ar_gr_num_stage4_p2     = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p1, 0.U(grIdBits.W))
    val ar_gr_num_stage4_p3     = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p2, 0.U(grIdBits.W))
    val ar_gr_num_stage4_p4     = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p3, 0.U(grIdBits.W))
    val ar_gr_num_stage4        = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_gr_num_stage4_p4,    0.U(grIdBits.W))
    val argr_bank_stage4_p1     = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage3,    0.U(bkBits.W))
    val argr_bank_stage4_p2     = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p1, 0.U(bkBits.W))
    val argr_bank_stage4_p3     = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p2, 0.U(bkBits.W))
    val argr_bank_stage4_p4     = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p3, 0.U(bkBits.W))
    val argr_bank_stage4        = xcff_i(G2generalCLK, io.MyReset,G2Enable, argr_bank_stage4_p4,    0.U(bkBits.W))
    val gatherA_valid_stage4_p1 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage3,    false.B)
    val gatherA_valid_stage4_p2 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p1, false.B)
    val gatherA_valid_stage4_p3 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p2, false.B)
    val gatherA_valid_stage4_p4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p3, false.B)
    val gatherA_valid_stage4    = xcff_i(G2generalCLK, io.MyReset,G2Enable, gatherA_valid_stage4_p4,    false.B)    
    val scatterinc_valid_stage4_p1 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage3 && !pipe_busy_stage3(ele), false.B)
    val scatterinc_valid_stage4_p2 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p1, false.B)
    val scatterinc_valid_stage4_p3 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p2, false.B)
    val scatterinc_valid_stage4_p4 = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p3, false.B)
    val scatterinc_valid_stage4    = xcff_i(G2generalCLK, io.MyReset,G2Enable, scatterinc_valid_stage4_p4, false.B)
    val ar_byte_num_stage4_p1      = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage3, false.B)
    val ar_byte_num_stage4_p2      = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage4_p1, false.B)
    val ar_byte_num_stage4_p3      = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage4_p2, false.B)
    val ar_byte_num_stage4_p4      = xcff_i(G2generalCLK, io.MyReset,G2Enable, ar_byte_num_stage4_p3, false.B)
    val ar_byte_num_stage4         = xcff_i(G2generalCLK, MyReset,G2Enable, ar_byte_num_stage4_p4, 0.U(srIdBits.W))
    val ar_sr_num_stage4_p1        = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage3,      0.U(srIdBits.W))
    val ar_sr_num_stage4_p2        = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p1,   0.U(srIdBits.W))
    val ar_sr_num_stage4_p3        = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p2,   0.U(srIdBits.W)) 
    val ar_sr_num_stage4_p4        = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p3,   0.U(srIdBits.W))
    val ar_sr_num_stage4           = xcff_i(G2generalCLK, MyReset,G2Enable, ar_sr_num_stage4_p4,   0.U(srIdBits.W))

    // Stage 5 signals
    val ar_gr_num_stage5     = xcff_i(G2generalCLK, MyReset, G2Enable, ar_gr_num_stage4, 0.U(grIdBits.W))
    val gatherA_valid_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, gatherA_valid_stage4, false.B)
    // Stage 5 signals (continued)
    val ar_byte_num_stage5       = xcff_i(G2generalCLK, MyReset, G2Enable, ar_byte_num_stage4, false.B)
    val scatter_valid_stage5_nxt = scatter_valid_stage2
    val scatter_valid_stage5_pre = xcff_i(G2generalCLK, MyReset, G2Enable, scatter_valid_stage5_nxt, false.B)
    val scatterinc_valid_stage5  = xcff_i(G2generalCLK, MyReset, G2Enable, scatterinc_valid_stage4, false.B)
    val scatter_valid_stage5     = scatter_valid_stage5_pre || scatterinc_valid_stage5

    val arsr_bank_stage5_nxt = ar_bank_stage2
    val arsr_bank_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, arsr_bank_stage5_nxt, 0.U(bkBits.W))
    val argr_bank_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, argr_bank_stage4,     0.U(bkBits.W))

    val ar_sr_num_stage5_nxt = Mux(scatterinc_valid_stage4, ar_sr_num_stage4, ar_grsr_num_stage2)
    val ar_sr_num_stage5 = xcff_i(G2generalCLK, MyReset, G2Enable, ar_sr_num_stage5_nxt, 0.U(srIdBits.W))

    // Stage 6 signals
    val arsr_bank_stage6 = xcff_i(G2generalCLK, MyReset, G2Enable, arsr_bank_stage5, 0.U(bkBits.W))
    val ar_sr_num_stage6 = xcff_i(G2generalCLK, MyReset, G2Enable, ar_sr_num_stage5, 0.U(srIdBits.W))

    // Outputs
    io.ele_bank_select(ele) := argr_bank_stage5
    for(rId <- 0 until grNum)
      io.gr_sge_data_wr_stage5(ele)(rId) := (ar_gr_num_stage5 === rId.U) && gatherA_valid_stage5
  }
}