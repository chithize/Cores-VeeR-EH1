import chisel3._
import chisel3.util._
//line 100840-103975
//xbar_mux_sel1_sb0_hw0_datasel_stage  xbar sel for each elem or half word
// Mux(addr/grant) ----> sbk/hw sel 
// resp/scatter datasel mux
class XBarMux4Hw_DataSel(val numBanks: Int=2, val numSubBanks: Int=8, val numSbWidth: Int=64,val numElems: Int=32,val numHw: Int=4) extends Module {
  val bitsArb=elemIdWidth+1   //5+1
  val io = IO(new Bundle{
    //val xbarMuxSelInputs = Input(Vec(numBanks, Vec(numSubBanks, Vec(numHw, UInt(5.W)))))
    val xbar_mux_sel_sb_hw_datasel_stage= Output(Vec(numBanks,Vec(numSubBanks, Vec(numHw, UInt(log2Ceil(numElems).W)))))
    val ar_data_grant_bank_sb_hw_stage2 = Output(Vec(numBanks,Vec(numSubBanks, Vec(numHw, UInt(bitsArb.W)))))
    val scatterinc_amount_sb_hw_stage5  = Output(Vec(numBanks*numSubBanks,Vec(numHw,UInt(bitsArb.W))))
  // for resp selection
    val ar_subbank_num_stage2_ele       = Input(Vec(numElems,UInt(log2Ceil(numSubBanks))))
    val ar_byte_num_stage2_ele          = Input(Vec(numElems,UInt(log2Ceil(numSbWidth))))
    val val_dram_req_sb_stage2          = Input(Vec(numBanks*numSubBanks, Bool()))

  // for scatter out sbhw selection
    val ar_addr                             = Input(Vec(numElems,UInt(addrWidth.W)))
    val ar_byte_addr                        = Input(Vec(numElems,Bool()))
    val ar_addr_grant_sb_raw                = Input(Vec(numSubBanks*numBanks,UInt(numElems.W)))
    val ar_addr_age_reverse_vec             = Input(Vec(numElems,Bool()))
    val ar_req_addr_for_arb_sb              = Input(Vec(numSubBanks*numBanks,UInt(numElems.W)))
    val ar_byte_num_stage1_ele              = Input(Vec(numElems,UInt(3.W)))
    val any_scatter_valid_stage1_ele        = Input(Vec(numElems,Bool()))
    val ar_inc16_stage1_ele                 = Input(Vec(numElems,Bool()))
    val kill_ar_addr_grant_sb               = Input(Vec(numSubBanks*numBanks,UInt(numElems.W)))
    val ar_addr_age                         = Input(Vec(numElems,Bool()))
    val kill_age0_grant                     = Input(Bool())
    val kill_age1_grant                     = Input(Bool())

    val G2generalCLK                         = Input(Clock()) 
    val G2generalCLKEn                       = Input(Bool())
    val G3bankStallStage2CLK                 = Input(Vec(numBanks,Clock()))
    val G3bankStallStage3CLK                 = Input(Vec(numBanks,Clock()))
    val G3bankStallStage2CLKEn               = Input(Vec(numBanks,Bool()))  
    val G3bankStallStage3CLKEn               = Input(Vec(numBanks,Bool())) 
    val G3bankStallStage5CLK                 = Input(Vec(numBanks,Clock()))
    val G3bankStallStage5CLKEn               = Input(Vec(numBanks,Bool()))
    val waitClkGate                          = Input(Bool())   
    val MyReset                              = Input(Bool()) 
    val G3eleStall1CLK                       = Input(Vec(numElems,Clock())) 
    val G3eleStall1CLKEn                     = Input(Vec(numElems,Bool()))  
     })

  val enable = !io.waitClkGate && io.G2generalCLKEn
  val g2Enable= enable
  val g2CLK =io.G2generalCLK
  val s5enable  = VecInit(io.G3bankStallStage5CLKEn.map(s5clken => s5clken&&enable))
  val reset = io.MyReset.asAsyncReset
  val elemIdWidth = log2Ceil(numElems)
  val g2GateEnable= enable
  val gateStage2  = g2GateEnable && (io.G3bankStallStage2CLKEn)
  val gateStage3  = g2GateEnable && (io.G3bankStallStage3CLKEn)
  val eleS1GateEnable = VecInit(io.G3eleStall1CLKEn.map(s1eleEnable => s1eleEnable&&g2GateEnable))

  def genMatchVec(addr: Vec[UInt], ar_byte_addr: Vec[Bool]): Vec[UInt] = {
  //val matchVec = Wire(Vec(numElems, UInt(numElems.W)))
  //matchVec := DontCare
    val matchVec = WireInit(VecInit(Fill(numElems)(0.U(numElems.W))))
    for (i <- (elemCount - 1) to 0 by -1) {
      for (j <- 0 until i) {
        val addrMatch = addr(i)(17, 7) === addr(j)(17, 7) &&
                      ar_byte_addr(i)=== ar_byte_addr(j)
        matchVec(i).bitSet(j, addrMatch)
      }
      matchVec(i).bitSet(i, true.B)
      for (n <- 1 until (numElems - i)) {
        matchVec(i).bitSet(i + n, matchVec(i + n)(i))
     }
   }
  matchVec
 }

 val ar_data_grant_bank_sb_hw_stage2 = Wire(Vec(numBanks, Vec(numSubBanks, Vec(numHw, UInt(bitsArb.W)))))
 val pop_count_sum_bank_sb_hw_stage1 = Wire(Vec(numBanks, Vec(numSubBanks, Vec(numHw, UInt(elemIdWidth.W)))))
 io.ar_data_grant_bank_sb_hw_stage2 <> ar_data_grant_bank_sb_hw_stage24
 io.pop_count_sum_bank_sb_hw_stage1 <> pop_count_sum_bank_sb_hw_stage1


 // xbar_mux_sel_bank_sb_hw
  for ( bank <- 0 until numBanks) {
    for ( subBank <- 0 until numSubBanks) {
      for ( hw <- 0 until numHw) {
        val elemNo = numSubBanks*subBank+hw
        val stage2 =  Cat(io.ar_subbank_num_stage2_ele(elemNo),io.ar_byte_num_stage2_ele(elemNo)(2,1))  // addr---> sbank/hw 0d
        val dataSelStageValid = ar_data_grant_bank_sb_hw_stage2(bank)(subBank)(hw)(bitsArb-1)&&io.val_dram_req_sb_stage2(bank*numSubBanks+subBank)
        val dataGrant = io.ar_data_grant_bank_sb_hw_stage2(bank)(subBank)(hw)(bitsArb-2,0)

        // Implementing the multiplexer logic
        val stage3Nxt   = Mux(dataSelStageValid, dataGrant, stage2)

        val xbarMuxSelBkSbk_s3   = xcff(elemIdWidth,io.G2generalCLK,reset,enable,stage3Nxt           )
        val xbarMuxSelBkSbk_s4p1 = xcff(elemIdWidth,io.G2generalCLK,reset,enable,xbarMuxSelBkSbk_s3  )
        val xbarMuxSelBkSbk_s4p2 = xcff(elemIdWidth,io.G2generalCLK,reset,enable,xbarMuxSelBkSbk_s4p1)
        val xbarMuxSelBkSbk_s4p3 = xcff(elemIdWidth,io.G2generalCLK,reset,enable,xbarMuxSelBkSbk_s4p2)
        val xbarMuxSelBkSbk_s4p4 = xcff(elemIdWidth,io.G2generalCLK,reset,enable,xbarMuxSelBkSbk_s4p3)
        val xbarMuxSelBkSbk_s4   = xcff(elemIdWidth,io.G2generalCLK,reset,enable,xbarMuxSelBkSbk_s4p4)
      
        val xbarMuxSelBkSbk_s5   = xcff(elemIdWidth,io.G3bankStallStage5CLK(bank),io.MyReset,s5enable(bank),xbarMuxSelBkSbk_s4  )

        io.xbar_mux_sel_sb_hw_datasel_stage(bank)(subBank)(hw) := Mux(dataSelStageValid,xbarMuxSelBkSbk_s5,dataGrant)
      }
    }
  }

// to get ar_data_grant_bank_sb_hw_stage2

val ar_ele_match_addr_vec = genMatchVec(ar_addr,ar_byte_addr)   //32(numElems) Vecs(Matches)
val sel = io.ar_addr_grant_sb_raw
val ar_winning_ele_match_vec_for_sb=VecInit(sel.map(sel_sb => Xtmux32(ar_ele_match_addr_vec,sel_sb)))

//get sb
val ar_ele_addr_granted_for_sb = Wire(Vec(numElems,Vec(numSubBanks*numBanks,Bool())))
val ar_ele_addr_granted_for_sb_stage1  = Wire(Vec(numElems,Vec(numSubBanks*numBanks,Bool())))
//line 63591-78052
for(i <- 0 until numElems)
   for(sbkIdx <- 0 until numSubBanks*numBanks){
        ar_ele_addr_granted_for_sb(i)(sbkIdx) := ar_req_addr_for_arb_sb(sbkIdx)(i).asBool &&
                                                 ar_winning_ele_match_vec_for_sb(sbkIdx)(i).asBool && 
                                                 (!(kill_ar_addr_grant_sb(sbkIdx)(i).asBool))  &&
                                                 (!(!io.ar_addr_age(i).asBool&&io.kill_age0_grant)) &&
                                                 !(io.ar_addr_age(i).asBool &&io.kill_age1_grant)
       ar_ele_addr_granted_for_sb_stage1(i)(sbkIdx) := xcff(1, io.G3eleStall1CLK(i),io.MyReset,eleS1GateEnable(i), ar_ele_addr_granted_for_sb(i)(sbkIdx))
  }


val entry_elig_for_bank_sb_hw           =Wire(Vec(numElems,Vec(numBanks,Vec(numSubBanks,Vec(numHw,Bool())))))
val ar_req_data_bank_sb_hw              =Wire(Vec(numBanks,Vec(numSubBanks,Vec(numHw,UInt(numElems.W)))))
//  80453---88646
// sc/scinc entries  for each elem per bank per sbk, per numHw
for(eId <- 0 until numElems)
  for(bkId <- 0 until numBanks)
    for(sbkId <- 0 until numSubBanks)
       for(hwId <- 0 until numHw)
          entry_elig_for_bank_sb_hw(eId)(bkId)(sbkId)(hwId) := ar_ele_addr_granted_for_sb_stage1(eId)(bkId*numSubBanks+sbkId) &&
                                                              (ar_byte_num_stage1_ele(eId)(2,1) === hwId.U(2.W)) &&
                                                              (any_scatter_valid_stage1_ele(eId) ||ar_inc16_stage1_ele(eId))
for( bkId <- 0 until numBanks)
   for( sbkId <- 0 until numSubBanks)
       for( hwId <- 0 until numHw)
       {
          ar_req_data_bank_sb_hw(bkId)(sbkId)(hwId) :=  (Seq.tabulate(numElems) {i => entry_elig_for_bank_sb_hw(i)(bkId)(sbkId)(hwId)}).reverse.reduce(Cat(_,_))
          //---------------------------------   
          //wire [5:0] ar_data_grant_bank1_sb7_hw3_stage1;
          val ar_data_grant_bank_sb_hw_stage1 = Wire(UInt(bitsArb.W))
               ar_data_grant_bank_sb_hw_stage1:= Xacc_lzc32(ar_addr_age_reverse_vec,ar_req_data_bank_sb_hw(bkId)(sbkId)(hwId))
          
          /* Xacc_lzc32 ar_data_ele_arb_bank1_sb7_hw3 (
          	.Age		(ar_addr_age_reverse_vec),
          	.Request	(ar_req_data_bank1_sb7_hw3),
          	.Grant		(ar_data_grant_bank1_sb7_hw3_stage1)
          	); */
          
          //wire [5:0] pop_count_sum_bank1_sb7_hw3_stage1;
              pop_count_sum_bank_sb_hw_stage1(bkId)(sbkId)(hwId) := Xacc_pop_count(ar_req_data_bank_sb_hw(bkId)(sbkId)(hwId))
          /* Xacc_pop_count pop_count_bank1_sb7_hw3 (
          	.VecIn	(ar_req_data_bank1_sb7_hw3),
          	.SumOut	(pop_count_sum_bank1_sb7_hw3_stage1)
          	); */
          /* wire [5:0] ar_data_grant_bank1_sb7_hw3_stage2_nxt;
          wire [5:0] ar_data_grant_bank1_sb7_hw3_stage2;
          wire [5:0] ar_data_grant_bank1_sb7_hw3_stage3;
          assign	ar_data_grant_bank1_sb7_hw3_stage2_nxt =
          				ar_data_grant_bank1_sb7_hw3_stage1; */
          /* reg [5:0] ar_data_grant_bank1_sb7_hw3_stage2_reg;
          assign ar_data_grant_bank1_sb7_hw3_stage2 = ar_data_grant_bank1_sb7_hw3_stage2_reg;
          always @(posedge G3bankStallStage2CLK1 or posedge MyReset) ar_data_grant_bank1_sb7_hw3_stage2_reg <= `XT_SEQ_DELAY MyReset ? 6'b0 :
              ((~WaitClkGate) & (G2generalCLKEn) & (G3bankStallStage2CLKEn1)) ? ar_data_grant_bank1_sb7_hw3_stage2_nxt : ar_data_grant_bank1_sb7_hw3_stage2_reg; */
          
           ar_data_grant_bank_sb_hw_stage2(bkId)(sbkId)(hwId)=xcff(bitsArb,io.G3bankStallStage2CLK(bkId),io.MyReset,gateStage2(bkId),ar_data_grant_bank_sb_hw_stage1)
         
          val ar_data_grant_bank_sb_hw_stage3= xcff(bitsArb,io.G3bankStallStage3CLK(bkId),io.MyReset,gateStage3(bkId),ar_data_grant_bank_sb_hw_stage2(bkId)(sbkId)(hwId))
          
          /* reg [5:0] ar_data_grant_bank1_sb7_hw3_stage3_reg;
          assign ar_data_grant_bank1_sb7_hw3_stage3 = ar_data_grant_bank1_sb7_hw3_stage3_reg;
          always @(posedge G3bankStallStage3CLK1 or posedge MyReset) ar_data_grant_bank1_sb7_hw3_stage3_reg <= `XT_SEQ_DELAY MyReset ? 6'b0 :
              ((~WaitClkGate) & (G2generalCLKEn) & (G3bankStallStage3CLKEn1)) ? ar_data_grant_bank1_sb7_hw3_stage2 : ar_data_grant_bank1_sb7_hw3_stage3_reg;
           */
          	//ar_data_grant_scatter_valid_bank_sb_hw_stage2(bkId)(sbkId)(hwId) := !ar_data_grant_bank_sb_hw_stage2(5) && val_dram_req_sb_stage2(sbId+bkId*numSubBanks)
          								// val_dram_req_sb_stage2 , unified
      }
//val  scatterinc_amount_sb_hw_stage1        =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]
//val  scatterinc_amount_sb_hw_stage2_nxt    =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]   
//val  scatterinc_amount_sb_hw_stage2        =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]
//val  scatterinc_amount_sb_hw_stage3        =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]
//val  scatterinc_amount_sb_hw_stage4_p1     =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]  
//val  scatterinc_amount_sb_hw_stage4_p2     =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]  
//val  scatterinc_amount_sb_hw_stage4_p3     =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]  
//val  scatterinc_amount_sb_hw_stage4_p4     =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]  
//val  scatterinc_amount_sb_hw_stage4        =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]
//val  scatterinc_amount_sb_hw_stage5        =wire(Vec(numSubbanks*numBanks,UInt(6.W))) //[5:0]


  for(sbId <- 0 until sbkNum*numBanks)
  {
    val bkId   = sbId / sbkNum
    val _sbkId = sbId % sbkNum
    //val s1CLK=io.
    val s2CLK=io.G3bankStallStage2CLK(bkId)
    val s3CLK=io.G3bankStallStage3CLK(bkId)
    val s4CLK=io.G2generalCLK
    val s5CLK=io.G2generalCLK
    val s2Enable=g2Enable&&io.G3bankStallStage2CLKEn(bkId)
    val s3Enable=g2Enable&&io.G3bankStallStage3CLKEn(bkId)
    val s4Enable=g2Enable
    val s5Enable=g2Enable
    for(hwId <- 0 until numHw )
    {
        val scatterinc_amount_sb_hw_stage1            = pop_count_sum_bank_sb_hw_stage1(bkId)(_sbId)(hwId)
        val scatterinc_amount_sb_hw_stage2            = xcff(6,s2CLK,reset,s2Enable,scatterinc_amount_sb_hw_stage1    )
        val scatterinc_amount_sb_hw_stage3            = xcff(6,s3CLK,reset,s3Enable,scatterinc_amount_sb_hw_stage2    )
        val scatterinc_amount_sb_hw_stage4_p1         = xcff(6,G2CLK,reset,g2Enable,scatterinc_amount_sb_hw_stage3    )
        val scatterinc_amount_sb_hw_stage4_p2         = xcff(6,G2CLK,reset,g2Enable,scatterinc_amount_sb_hw_stage4_p1 )
        val scatterinc_amount_sb_hw_stage4_p3         = xcff(6,G2CLK,reset,g2Enable,scatterinc_amount_sb_hw_stage4_p2 )
        val scatterinc_amount_sb_hw_stage4_p4         = xcff(6,G2CLK,reset,g2Enable,scatterinc_amount_sb_hw_stage4_p3 )
        val scatterinc_amount_sb_hw_stage4            = xcff(6,G2CLK,reset,g2Enable,scatterinc_amount_sb_hw_stage4_p4 )
        io.scatterinc_amount_sb_hw_stage5(sbId)(hwId):= xcff(6,G2CLK,reset,g2Enable,scatterinc_amount_sb_hw_stage4    )  
     }
  }

}

/* //resp to elem direct sel
class DataRSPGrantDatasel() extends Module{

val io=IO(new Bundle{



    })

} */

// out:ar_ele_addr_granted_for_sb_stage1
/* class Elem2SubbankGrantLogic extends Module{

    val io=IO(new Bundle{

      val ar_ele_addr_granted_for_sb_stage1   =Output(Vec(numSubBanks*numBanks,UInt(eleNum.W)))


    })



} */

//line 63591-78052
/* class Elem2SubbankGrantLogic(val numElements: Int, val numSBs: Int) extends Module {
  val io = IO(new Bundle {
    val G2generalCLKEn    = Input(Bool())
    val G3eleStall1CLKEn0 = Input(Bool())
    val G3eleStall2CLKEn0 = Input(Bool())
    val G3eleStall3CLKEn0 = Input(Bool())
    // 添加其他 I/O 端口
  })

  // 
  val ar_ele_addr_granted = Vec(numElements, Vec(numSBs, Wire(Bool())))
  val ar_ele_stall_stage1_for_rmw_conflict = Vec(numElements, Vec(numSBs, Wire(Bool())))
  val ar_ele_stall_stage2_for_rmw_conflict = Vec(numElements, Vec(numSBs, Wire(Bool())))
  val ar_ele_stall_stage3_for_rmw_conflict = Vec(numElements, Vec(numSBs, Wire(Bool())))

  // 
  for (ele <- 0 until numElements) {
    for (sb <- 0 until numSBs) {
      ar_ele_addr_granted(ele)(sb) := ar_winning_ele_match_vec_for_sbX(ele) && !kill_ar_addr_grant_sbX(ele) && ar_req_addr_for_arb_sbX(ele) &&
        !(!ar_addr_age0 && kill_age0_grant(ele)) &&
        !(ar_addr_age0 && kill_age1_grant(ele))

      ar_ele_stall_stage1_for_rmw_conflict(ele)(sb) := false.B
      ar_ele_stall_stage2_for_rmw_conflict(ele)(sb) := false.B
      ar_ele_stall_stage3_for_rmw_conflict(ele)(sb) := false.B

      // 使用注释 @@ 添加 net 名称
      val ar_ele_addr_granted_for_sbX_stage1 = RegEnable(ar_ele_addr_granted(ele)(sb), io.G2generalCLKEn && io.G3eleStall1CLKEn0)
        @@ printf("ar_ele%d_addr_granted_for_sb%d_stage1", ele, sb)
      val ar_ele_addr_granted_for_sbX_stage2 = RegEnable(ar_ele_addr_granted_for_sbX_stage1 && !Ele0_pipe_busy_stage1, io.G2generalCLKEn && io.G3eleStall2CLKEn0)
        @@ printf("ar_ele%d_addr_granted_for_sb%d_stage2", ele, sb)
      val ar_ele_addr_granted_for_sbX_stage3 = RegEnable(ar_ele_addr_granted_for_sbX_stage2 && !Ele0_pipe_busy_stage2, io.G2generalCLKEn && io.G3eleStall3CLKEn0)
        @@ printf("ar_ele%d_addr_granted_for_sb%d_stage3", ele, sb)
    }
  }
}
 */
// scatter data to subbank/half word sel

// ---  92743
// req to sb/hw
//ar_req_data_bank0_sb0_hw0 - bank1_sb7_hw3
//input
/* class DataSCGrant_Datasel(val numBanks: Int=2,val numSubBanks: Int=8,val numHw: Int=4, val  numElems: Int=32, val addrWidth: Int=18) extends Module {
val bitsArb=log2Ceil(numElems)+1
val io=IO(new Bundle{

     val ar_data_grant_bank_sb_hw_stage2     = Output(Vec(numBanks,Vec(numSubBanks,Vec(numHw,UInt(bitsArb.W)))))
     val pop_count_sum_bank_sb_hw_stage1     = Output(Vec(numBanks,Vec(numSubBanks,Vec(numHw,UInt(bitsArb.W)))))

     val ar_addr                             = Input(Vec(numElems,UInt(addrWidth.W)))
     val ar_byte_addr                        = Input(Vec(numElems,Bool()))
     val ar_addr_grant_sb_raw                = Input(Vec(numSubBanks*numBanks,UInt(numElems.W)))
     val ar_addr_age_reverse_vec             = Input(Vec(numElems,Bool()))
     val ar_req_addr_for_arb_sb              = Input(Vec(numSubBanks*numBanks,UInt(numElems.W)))
     val ar_byte_num_stage1_ele              = Input(Vec(numElems,UInt(3.W)))
     val any_scatter_valid_stage1_ele        = Input(Vec(numElems,Bool()))
     val ar_inc16_stage1_ele                 = Input(Vec(numElems,Bool()))

     val kill_ar_addr_grant_sb               = Input(Vec(numSubBanks*numBanks,UInt(numElems.W)))
     val ar_addr_age                         = Input(Vec(numElems,Bool()))
     val kill_age0_grant                     = Input(Bool())
     val kill_age1_grant                     = Input(Bool())
     
     val WaitClkGate                         = Input(Bool())
     val MyReset                             = Input(Bool()) 
     val G2generalCLK                        = Input(Clock())
     val G2generalCLKEn                      = Input(Bool()) 
     val G3bankStallStage2CLK                = Input(Vec(numBanks,Clock()))
     val G3bankStallStage3CLK                = Input(Vec(numBanks,Clock()))
     val G3bankStallStage2CLKEn              = Input(Vec(numBanks,Bool()))  
     val G3bankStallStage3CLKEn              = Input(Vec(numBanks,Bool())) 
     val G3eleStall1CLK                      = Input(Vec(numElems,Clock())) 
     val G3eleStall1CLKEn                    = Input(Vec(numElems,Bool()))  
    })


val g2GateEnable= (!io.WaitClkGate) && (io.G2generalCLKEn)
val gateStage2  = g2GateEnable && (io.G3bankStallStage2CLKEn)
val gateStage3  = g2GateEnable && (io.G3bankStallStage3CLKEn)
val eleS1GateEnable = VecInit(io.G3eleStall1CLKEn.map(s1eleEnable => s1eleEnable&&g2GateEnable))

 def genMatchVec(addr: Vec[UInt], ar_byte_addr: Vec[Bool]): Vec[UInt] = {
  //val matchVec = Wire(Vec(numElems, UInt(numElems.W)))
  //matchVec := DontCare
  val matchVec = WireInit(VecInit(Fill(numElems)(0.U(numElems.W))))
  for (i <- (elemCount - 1) to 0 by -1) {
    for (j <- 0 until i) {
      val addrMatch = addr(i)(17, 7) === addr(j)(17, 7) &&
                      ar_byte_addr(i)=== ar_byte_addr(j)
      matchVec(i).bitSet(j, addrMatch)
    }
     matchVec(i).bitSet(i, true.B)

    for (n <- 1 until (numElems - i)) {
     matchVec(i).bitSet(i + n, matchVec(i + n)(i))
    }
  }
  matchVec
}

val ar_ele_match_addr_vec = genMatchVec(ar_addr,ar_byte_addr)   //32(numElems) Vecs(Matches)
val sel =io.ar_addr_grant_sb_raw
val ar_winning_ele_match_vec_for_sb=VecInit(sel.map(sel_sb => Xtmux32(ar_ele_match_addr_vec,sel_sb)))

//get sb
val ar_ele_addr_granted_for_sb = Wire(Vec(numElems,Vec(numSubBanks*numBanks,Bool())))
val ar_ele_addr_granted_for_sb_stage1  = Wire(Vec(numElems,Vec(numSubBanks*numBanks,Bool())))
for(i <- 0 until numElems)
   for(sbkIdx <- 0 until numSubBanks*numBanks){
        ar_ele_addr_granted_for_sb(i)(sbkIdx) := ar_req_addr_for_arb_sb(sbkIdx)(i).asBool &&
                                                 ar_winning_ele_match_vec_for_sb(sbkIdx)(i).asBool && 
                                                 (!(kill_ar_addr_grant_sb(sbkIdx)(i).asBool))  &&
                                                 (!(!io.ar_addr_age(i).asBool&&io.kill_age0_grant)) &&
                                                 !(io.ar_addr_age(i).asBool &&io.kill_age1_grant)}
       ar_ele_addr_granted_for_sb_stage1(i)(sbkIdx) := xcff(1, io.G3eleStall1CLK(i),io.MyReset,eleS1GateEnable(i), ar_ele_addr_granted_for_sb(i)(sbkIdx))
  }


val entry_elig_for_bank_sb_hw           =Wire(Vec(numElems,Vec(numBanks,Vec(numSubBanks,Vec(numHw,Bool())))))
val ar_req_data_bank_sb_hw              =Wire(Vec(numBanks,Vec(numSubBanks,Vec(numHw,UInt(numElems.W)))))
//  80453---88646
// sc/scinc entries  for each elem per bank per sbk, per numHw
for(eId <- 0 until numElems)
  for(bkId <- 0 until numBanks)
    for(sbkId <- 0 until numSubBanks)
       for(hwId <- 0 until numHw)
          entry_elig_for_bank_sb_hw(eId)(bkId)(sbkId)(hwId) := ar_ele_addr_granted_for_sb_stage1(eId)(bkId*numSubBanks+sbkId) &&
                                                              (ar_byte_num_stage1_ele(eId)(2,1) === hwId.U(2.W)) &&
                                                              (any_scatter_valid_stage1_ele(eId) ||ar_inc16_stage1_ele(eId))
for(val bkId <- 0 until numBanks)
   for(val sbkId <- 0 until numSubBanks)
       for(val hwId <- 0 until numHw)
       {
          ar_req_data_bank_sb_hw(bkId)(sbkId)(hwId) :=  (Seq.tabulate(numElems) {i => entry_elig_for_bank_sb_hw(i)(bkId)(sbkId)(hwId)}).reverse.reduce(Cat(_,_))
          //---------------------------------   
          //wire [5:0] ar_data_grant_bank1_sb7_hw3_stage1;
          val ar_data_grant_bank_sb_hw_stage1 = Wire(UInt(bitsArb).W))
               ar_data_grant_bank_sb_hw_stage1:= Xacc_lzc32(ar_addr_age_reverse_vec,ar_req_data_bank_sb_hw(bkId)(sbkId)(hwId))
          
          /* Xacc_lzc32 ar_data_ele_arb_bank1_sb7_hw3 (
          	.Age		(ar_addr_age_reverse_vec),
          	.Request	(ar_req_data_bank1_sb7_hw3),
          	.Grant		(ar_data_grant_bank1_sb7_hw3_stage1)
          	); */
          
          //wire [5:0] pop_count_sum_bank1_sb7_hw3_stage1;
              pop_count_sum_bank_sb_hw_stage1(bkId)(sbkId)(hwId) = Xacc_pop_count(ar_req_data_bank_sb_hw(bkId)(sbkId)(hwId))
          /* Xacc_pop_count pop_count_bank1_sb7_hw3 (
          	.VecIn	(ar_req_data_bank1_sb7_hw3),
          	.SumOut	(pop_count_sum_bank1_sb7_hw3_stage1)
          	); */
          /* wire [5:0] ar_data_grant_bank1_sb7_hw3_stage2_nxt;
          wire [5:0] ar_data_grant_bank1_sb7_hw3_stage2;
          wire [5:0] ar_data_grant_bank1_sb7_hw3_stage3;
          assign	ar_data_grant_bank1_sb7_hw3_stage2_nxt =
          				ar_data_grant_bank1_sb7_hw3_stage1; */
          /* reg [5:0] ar_data_grant_bank1_sb7_hw3_stage2_reg;
          assign ar_data_grant_bank1_sb7_hw3_stage2 = ar_data_grant_bank1_sb7_hw3_stage2_reg;
          always @(posedge G3bankStallStage2CLK1 or posedge MyReset) ar_data_grant_bank1_sb7_hw3_stage2_reg <= `XT_SEQ_DELAY MyReset ? 6'b0 :
              ((~WaitClkGate) & (G2generalCLKEn) & (G3bankStallStage2CLKEn1)) ? ar_data_grant_bank1_sb7_hw3_stage2_nxt : ar_data_grant_bank1_sb7_hw3_stage2_reg; */
          
           ar_data_grant_bank_sb_hw_stage2(bkId)(sbkId)(hwId)=xcff(io.G3bankStallStage2CLK(bkId),io.MyReset,gateStage2(bkId),ar_data_grant_bank_sb_hw_stage1)
         
          val ar_data_grant_bank_sb_hw_stage3= xcff(io.G3bankStallStage3CLK(bkId),io.MyReset,gateStage3(bkId),ar_data_grant_bank_sb_hw_stage2(bkId)(sbkId)(hwId))
          
          /* reg [5:0] ar_data_grant_bank1_sb7_hw3_stage3_reg;
          assign ar_data_grant_bank1_sb7_hw3_stage3 = ar_data_grant_bank1_sb7_hw3_stage3_reg;
          always @(posedge G3bankStallStage3CLK1 or posedge MyReset) ar_data_grant_bank1_sb7_hw3_stage3_reg <= `XT_SEQ_DELAY MyReset ? 6'b0 :
              ((~WaitClkGate) & (G2generalCLKEn) & (G3bankStallStage3CLKEn1)) ? ar_data_grant_bank1_sb7_hw3_stage2 : ar_data_grant_bank1_sb7_hw3_stage3_reg;
           */
          	//ar_data_grant_scatter_valid_bank_sb_hw_stage2(bkId)(sbkId)(hwId) := !ar_data_grant_bank_sb_hw_stage2(5) && val_dram_req_sb_stage2(sbId+bkId*numSubBanks)
          								// val_dram_req_sb_stage2 , unified
      }

}    */