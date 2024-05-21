
class ClockModuleWithBusyStall(val numRams: Int=2, val numBanks: Int=2,val numSubbanks: Int=8, val numElems: Int=32) extends Module{
val io=IO(new Bundle({
   //busy stall
       val Subbank_rdbusy_sb              = Output(Vec(numBanks*numSubbanks,Bool()))
       val Subbank_wrbusy_sb              = Output(Vec(numBanks*numSubbanks,Bool()))
       val Subbank_busy_wrconfl_stg1or2_sb= Output(Vec(numBanks*numSubbanks,Bool()))  //what for?
       val Subbank_busy_bank              = Output(Vec(numBanks,Bool()))
       val Subbank_wrbusy_bank            = Output(Vec(numBanks,Bool()))

       val Subbank_pipe_stall_bank_stage1 = Output(Vec(numBanks,Bool()))
       val Subbank_pipe_stall_bank_stage2 = Output(Vec(numBanks,Bool()))
       val Subbank_pipe_stall_bank_stage3 = Output(Vec(numBanks,Bool()))
       val Subbank_pipe_stall_bank_stage5 = Output(Vec(numBanks,Bool()))
       val Subbank_pipe_stall_bank_stage6 = Output(Vec(numBanks,Bool()))
       val elePipeBusyStage1              = Output(Vec(numElems,Bool()))  
       val elePipeBusyStage2              = Output(Vec(numElems,Bool()))
       val elePipeBusyStage3              = Output(Vec(numElems,Bool()))

 //   clock/clken output per elem
       val G3eleStall1CLK         = Output(Vec(numElems, Clock()))
       val G3eleStall1CLKEn       = Output(Vec(numElems, Bool()))
       val G3eleStall2CLK         = Output(Vec(numElems, Clock()))
       val G3eleStall2CLKEn       = Output(Vec(numElems, Bool()))
       val G3eleStall3CLK         = Output(Vec(numElems, Clock()))
       val G3eleStall3CLKEn       = Output(Vec(numElems, Bool()))
 //  clock/clocken output per bank      
       val G3bankStallStage1CLK   = Output(Vec(numBanks, Clock()))
       val G3bankStallStage1CLKEn = Output(Vec(numBanks, Bool())) 
       val G3bankStallStage2CLK   = Output(Vec(numBanks, Clock()))
       val G3bankStallStage2CLKEn = Output(Vec(numBanks, Bool()))
       val G3bankStallStage3CLK   = Output(Vec(numBanks, Clock()))
       val G3bankStallStage3CLKEn = Output(Vec(numBanks, Bool()))
       val G3bankStallStage5CLK   = Output(Vec(numBanks, Clock()))
       val G3bankStallStage5CLKEn = Output(Vec(numBanks, Bool()))
       val G3bankStallStage6CLK   = Output(Vec(numBanks, Clock())) 
       val G3bankStallStage6CLKEn = Output(Vec(numBanks, Bool()))
        
       val G2dramReadPwrCLK       = Output(Vec(numSubbanks, Clock()))
       val G2dramReadPwrDCLK      = Output(Vec(numSubbanks, Clock()))
       val G3dramReadCLK          = Output(Vec(numSubbanks, Clock()))
       val G3dramReadDCLK         = Output(Vec(numSubbanks, Clock()))

       val arBankNumStage1Ele      =Input(Vec(numElems,UInt(log2Ceil(numBanks).W)))
       val arBankNumStage2Ele      =Input(Vec(numElems,UInt(log2Ceil(numBanks).W)))
       val gatherAValidStage1Ele   =Input(Vec(numElems,Bool()))
       val scatterValidStage1Ele   =Input(Vec(numElems,Bool()))
       val scatterIncValidStage1Ele=Input(Vec(numElems,Bool()))
       val scatterValidStage2Ele   =Input(Vec(numElems,Bool()))
       val gatherAValidStage2ElePre=Input(Vec(numElems,Bool()))
       val scatterincValidStage2Ele=Input(Vec(numElems,Bool()))

       val scatter_rmw_wr_req_sb_stage4 = Input(Vec(numBanks*numSubbanks,Bool()))
       // val wr_req_bank_stage5      = Input(Vec(numBanks,Boo()))
       // val wr_req_bank_stage6      = Input(Vec(numBanks,Boo()))
   
     
       val RamRd      =Input(Vec(numRams,Vec(numBanks,Bool())))
       val RamWr      =Input(Vec(numRams,Vec(numBanks,Bool())))
       val RamRdReady =Input(Vec(numRams,Vec(numBanks,Bool())))
       val RamWrReady =Input(Vec(numRams,Vec(numBanks,Bool())))

       val G2generalCLK   = Input(Clock())
       val G2generalCLKEn = Input(Bool())
       val waitClkGate    = Input(Bool())
       val MyReset        = Input(Bool())



}))


 val G2CLK = io.G2generalCLK
 val reset = io.MyReset.asAsyncReset
 val g2GateEnable = io.G2generalCLKEn && !io.waitClkGate
 val G3bankStallStage5CLKEn = Wire(Vec(numBanks,Bool()))
 val G3bankStallStage6CLKEn = Wire(Vec(numBanks,Bool()))
 val gateS5Enable =g2GateEnable&&G3bankStallStage5CLKEn
 val gateS6Enable =g2GateEnable&&G3bankStallStage6CLKEn

 val g3S1CLK = Wire(Vec(numBanks,Clock()))  
 val g3S2CLK = Wire(Vec(numBanks,Clock()))
 val g3S3CLK = Wire(Vec(numBanks,Clock()))
 val g3S5CLK = Wire(Vec(numBanks,Clock()))  
 val g3S6CLK = Wire(Vec(numBanks,Clock()))

val Subbank_pipe_stall_bank_stage1=Wire(Vec(numBanks,Bool()))
val Subbank_pipe_stall_bank_stage2=Wire(Vec(numBanks,Bool()))
val Subbank_pipe_stall_bank_stage3=Wire(Vec(numBanks,Bool()))
val Subbank_pipe_stall_bank_stage5=Wire(Vec(numBanks,Bool()))
val Subbank_pipe_stall_bank_stage6=Wire(Vec(numBanks,Bool()))

io.G3bankStallStage1CLK :=g3S1CLK
io.G3bankStallStage2CLK :=g3S2CLK
io.G3bankStallStage3CLK :=g3S3CLK
io.G3bankStallStage5CLK :=g3S5CLK
io.G3bankStallStage6CLK :=g3S6CLK

 for(i <-0 until numBanks){
     
   //   io.G3bankStallStage1CLKEn(i) :=!Subbank_pipe_stall_bank_stage1(i)  
   //   io.G3bankStallStage2CLKEn(i) :=!Subbank_pipe_stall_bank_stage2(i)
   //   io.G3bankStallStage3CLKEn(i) :=!Subbank_pipe_stall_bank_stage3(i)
     G3bankStallStage5CLKEn(i) :=!Subbank_pipe_stall_bank_stage5(i)
     G3bankStallStage6CLKEn(i) :=!Subbank_pipe_stall_bank_stage6(i)
     
     io.Subbank_pipe_stall_bank_stage1 := Subbank_pipe_stall_bank_stage1
     io.Subbank_pipe_stall_bank_stage2 := Subbank_pipe_stall_bank_stage2
     io.Subbank_pipe_stall_bank_stage3 := Subbank_pipe_stall_bank_stage3
     io.Subbank_pipe_stall_bank_stage5 := Subbank_pipe_stall_bank_stage5
     io.Subbank_pipe_stall_bank_stage6 := Subbank_pipe_stall_bank_stage6
     
  }



 val RamRd_d = Wire(Vec(numRams,Vec(numBanks,Bool())))
 val RamWr_d = Wire(Vec(numRams,Vec(numBanks,Bool())))
 val ram_bank_uncond_rdbusy =Wire(Vec(numRams,Vec(numBanks,Bool())))
 val ram_bank_uncond_wrbusy =Wire(Vec(numRams,Vec(numBanks,Bool())))

 for(mId <- 0 until numRams)
    for(bkId <- 0 until numBanks)
    {
       RamRd_d(mId)(bkId) := xcff(1, G2CLK, reset, g2GateEnable, io.RamRd(mId)(bkId))
       RamWr_d(mId)(bkId) := xcff(1, G2CLK, reset, g2GateEnable, io.RamWr(mId)(bkId))
       val RamBusy   = !io.RamRdReady(mId)(bkId) && RamRd_d(mId)(bkId)
       val RamWrBusy = !io.RamWrReady(mId)(bkId) && RamWr_d(mId)(bkId)
           ram_bank_uncond_rdbusy(mId)(bkId) := RamBusy
           ram_bank_uncond_wrbusy(mId)(bkId) := RamWrBusy
      
    }  

   val bank_uncond_wrbusy =Wire(Vec(numBanks,Bool()))
   val bank_uncond_rdbusy =Wire(Vec(numBanks,Bool()))
   for(bkId <- 0 until numBanks)
   {
     bank_uncond_wrbusy(bkId) := (VecInit((0 until numRams).map{i => ram_bank_uncond_rdbusy(i)(bkId)})).reduce(_||_)  //for tabulate numRams need to be compile constant
     bank_uncond_rdbusy(bkId) := (VecInit((0 until numRams).map{i => ram_bank_uncond_rdbusy(i)(bkId)})).reduce(_||_)
     io.Subbank_wrbusy_bank(bkId):= bank_uncond_wrbusy(bkId)
     io.Subbank_busy_bank(bkId)  := bank_uncond_wrbusy(bkId) || bank_uncond_rdbusy(bkId)
    }

   val wireConst0   = WireInit(false.B)
   val allMemRdBusy = bank_uncond_rdbusy.reduce(_||_) || wireConst0
   val allMemWrBusy = bank_uncond_wrbusy.reduce(_||_)|| wireConst0
   
    // all subbank is synchronizing to bank ? what does the subbank means now？
    for(sbkId <- 0 until numSubbanks)
    {
           io.Subbank_rdbusy_sb(bkId*numSubbanks+sbkId) :=bank_uncond_wrbusy(bkId)
           io.Subbank_wrbusy_sb(bkId*numSubbanks+sbkId) :=bank_uncond_rdbusy(bkId)
           io.Subbank_busy_wrconfl_stg1or2_sb(bkId*numSubbanks+sbkId) := allMemRdBusy||allMemWrBusy
       }

    // stall pipeline  all subbank is the same control?
    //
   //val scatter_rmw_wr_req_bank_sb_stage4 = //Wire(Vec(numBanks,Vec(numSubbanks,Bool())))
   val scatter_rmw_wr_req_bank_sb_stage4 = io.scatter_rmw_wr_req_sb_stage4.grouped(numSubbanks)

   val wr_req_bank_stage5 = Wire(Vec(numBanks,Bool()))
   val wr_req_bank_stage6 = Wire(Vec(numBanks,Bool()))


   val Subbank_pipe_stall_bank_stage1_pre= Wire(VecInit(Seq.fill(numBanks)(false.B)))
   val Subbank_pipe_stall_bank_stage3    = Wire(VecInit(Seq.fill(numBanks)(false.B)))
      io.Subbank_pipe_stall_bank_stage3 := Subbank_pipe_stall_bank_stage3
   for(i <-0 until numBanks) {

       val wr_req_nxt_bank_stage5        = scatter_rmw_wr_req_bank_sb_stage4(i).reduce(_||_)
           wr_req_bank_stage5(i)        := xcff(1,g3S5CLK,reset,gateS5Enable,wr_req_nxt_bank_stage5)

      Subbank_pipe_stall_bank_stage1(i) := Subbank_pipe_stall_bank1_stage1_pre;
      Subbank_pipe_stall_bank_stage1_pre(i) := (io.val_dram_req_bank1_stage1 && (bank_uncond_wrbusy(i) || bank_uncond_rdbusy(i))) || io.val_dram_req_bank1_stage1 && io.Ele_bank_busy_stage1
      Subbank_pipe_stall_bank_stage2(i) := io.val_dram_req_bank1_stage2 && (bank_uncond_wrbusy(i) || bank_uncond_rdbusy(i)) 
       // Subbank_pipe_stall_bank_stage3 = WireInit(false.B)
      Subbank_pipe_stall_bank_stage5(i) := wr_req_bank_stage5(i) && bank_uncond_wrbusy(i)
      wr_req_bank_stage6(i)             := xcff(1,g3S6CLK,reset,gateS6Enable,wr_req_bank_stage5&&(!io.Subbank_pipe_stall_bank_stage5))
      Subbank_pipe_stall_bank_stage6(i) := wr_req_bank_stage6(i) && bank_uncond_wrbusy(i)
      
   }

// The Per Element DRAM busy signals
// These are for the per-element pipeline staging registers.
// These signals are for the per-element pipeline staging registers.

//Intf:arBankNumStage1Ele,scatterValidStage1Ele
//Intf:gatherAValidStage1Ele,scatterValidStage1Ele
// gatherAValidStage2ElePre, scatterValidStage2ElePre

//no meaning?
val arEleStallStage1ForRMWConflict = WireInit(VecInit(numElems, false.B))
val arEleStallStage2ForRMWConflict = WireInit(VecInit(numElems, false.B))
val arEleStallStage3ForRMWConflict = WireInit(VecInit(numElems, false.B))
//val elePipeBusyStage1GatherPre     = Wire(Vec(numElems, Bool()))

/* val elePipeBusyStage1Scatter = VecInit((0 until numElems).map { i => 
  val bits = Wire(Bool())
  bits := MuxLookup(arBankNumStage1Ele(i), false.B, Seq(
    0.U -> ((dram1Bank0UncondWrBusy || dram0Bank0UncondWrBusy) && scatterValidStage1Ele(i)),
    1.U -> ((dram1Bank1UncondWrBusy || dram0Bank1UncondWrBusy) && scatterValidStage1Ele(i))
  ))
  bits
})
 */
val elePipeBusyStage1Scatter = VecInit(arBankNumStage1Ele.zipWithIndex.map {case (bankId,i) => bank_uncond_wrbusy(bankId)&&io.scatterValidStage1Ele(i)})

/* val elePipeBusyStage2Scatter = VecInit((0 until numElems).map { i => 
  val bits = Wire(Bool())
  bits := MuxLookup(arBankStage2Ele(i), false.B, Seq(
    0.U -> ((dram1Bank0UncondWrBusy || dram0Bank0UncondWrBusy) && scatterValidStage2ElePre(i)),
    1.U -> ((dram1Bank1UncondWrBusy || dram0Bank1UncondWrBusy) && scatterValidStage2ElePre(i))
  ))
  bits
}) */

val elePipeBusyStage2Scatter   = VecInit(arBankNumStage2Ele.zipWithIndex.map {case (bankId,i) => bank_uncond_wrbusy(bankId)&&io.scatterValidStage2Ele(i)})

val elePipeBusyStage1GatherPre = VecInit(arBankNumStage1Ele.map {case (bankId) => bank_uncond_wrbusy(bankId)||bank_uncond_rdbusy(bankId)})

val elePipeBusyStage1Gather    = (io.gatherAValidStage1Ele || io.scatterIncValidStage1Ele) && elePipeBusyStage1GatherPre
val elePipeBusyStage2Gather    = VecInit(arBankNumStage2Ele.zipWithIndex.map {
                                  case (bankId,i) => bank_uncond_rdbusy(bankId)&&(io.gatherAValidStage2ElePre(i)||io.scatterincValidStage2Ele(i))
                                 }) /* VecInit((0 until numElems).map { i => 
  val bits = Wire(Bool())
  bits := Mux1H(Seq(
    (arBankStage2Ele(i) === 0.U) -> ((dram1Bank0UncondRdBusy || dram0Bank0UncondRdBusy) && (gatherAValidStage2ElePre(i) || scatterIncValidStage2Ele(i))),
    (arBankStage2Ele(i) === 1.U) -> ((dram1Bank1UncondRdBusy || dram0Bank1UncondRdBusy) && (gatherAValidStage2ElePre(i) || scatterIncValidStage2Ele(i)))
  ))
  bits
}) */ 
val elePipeBusyStage2 = elePipeBusyStage2Scatter ||
                         elePipeBusyStage2Gather ||
                         arEleStallStage2ForRMWConflict ||
                         arEleStallStage3ForRMWConflict

//per elem, per bank
 val eleBankBusyStage1 = VecInit(Seq.tabulate(numBanks).map { bankId =>
  VecInit((0 until numElems).map { i =>
    (io.gatherAValidStage1Ele(i) || io.scatterValidStage1Ele(i)) &&
    (io.arBankNumStage1Ele(i) === bankId.U) &&
    (io.gatherAValidStage2ElePre(i) || io.scatterValidStage2ElePre(i)) &&
    elePipeBusyStage2(i)
  })
})
/* val elePipeBusyStage1GatherPre = VecInit((0 until numElems).map { i => 
  val bits = Wire(Bool())
  bits := MuxLookup(arBankNumStage1Ele(i), false.B, Seq(
    0.U -> ((dram1Bank0UncondRdBusy || dram0Bank0UncondRdBusy) || (dram1Bank0UncondWrBusy || dram0Bank0UncondWrBusy)),
    1.U -> ((dram1Bank1UncondRdBusy || dram0Bank1UncondRdBusy) || (dram1Bank1UncondWrBusy || dram0Bank1UncondWrBusy))
  ))
  bits
}) */
val anyEleBankBusyStage1=eleBankBusyStage1.map(elesOnBank => elesOnBank.asUInt.orR)  //Bank 0, 1
val elePipeBusyStage1Pre = VecInit((0 until numElems).map { i =>
                                          elePipeBusyStage1Scatter(i) || elePipeBusyStage1Gather(i) ||
                                          arEleStallStage1ForRMWConflict(i) || arEleStallStage2ForRMWConflict(i) || arEleStallStage3ForRMWConflict(i) ||
                                          VecInit(seq.tabulate(numBanks){ bankId => anyEleBankBusyStage1(bankId) && (io.arBankNumStage1Ele(i)===bankId.U)}).reduce(_||_) ||
  /* (eleBankBusyStage1(0)(i) && (arBankNumStage1Ele(i) === 0.U)) ||
     (eleBankBusyStage1(1)(i) && (arBankNumStage1Ele(i) === 1.U)) || */
                                            false.B
})

io.elePipeBusyStage1 := elePipeBusyStage1Pre

io.elePipeBusyStage2 := elePipeBusyStage2

val elePipeBusyStage3 = arEleStallStage3ForRMWConflict
                        
io.elePipeBusyStage3 := elePipeBusyStage3

//clock module
for (i <- 0 until numElems) {
    
    io.G3eleStall1CLK(i)   :=Xtclockbuffer(io.G2generalCLK)
    io.G3eleStall1CLKEn(i) := !elePipeBusyStage1Pre(i)
  }

  // G3eleStall2CLK, G3eleStall2CLKEn  
  for (i <- 0 until numElems) {
    io.G3eleStall2CLK(i) := Xtclockbuffer(io.G2generalCLK)
    io.G3eleStall2CLKEn(i) := !elePipeBusyStage2(i)  
  }
  
  // G3eleStall3CLK, G3eleStall3CLKEn
  for (i <- 0 until numElems) {
    io.G3eleStall3CLK(i) := Xtclockbuffer(io.G2generalCLK)
    io.G3eleStall3CLKEn(i) := !elePipeBusyStage3(i)
  }

  // G3bankStallStage1CLK, G3bankStallStage1CLKEn
  for (i <- 0 until numBanks) {
    g3S1CLK(i) := Xtclockbuffer(io.G2generalCLK)
    io.G3bankStallStage1CLKEn(i) := !Subbank_pipe_stall_bank_stage1(i) 
  }

  // G3bankStallStage2CLK, G3bankStallStage2CLKEn
  for (i <- 0 until numBanks) { 
    g3S2CLK(i) := Xtclockbuffer(io.G2generalCLK)
    io.G3bankStallStage2CLKEn(i) := !Subbank_pipe_stall_bank_stage2(i)
  }

  // G3bankStallStage3CLK, G3bankStallStage3CLKEn  
  for (i <- 0 until numBanks) {

    g3S3CLK(i) := Xtclockbuffer(io.G2generalCLK)
    io.G3bankStallStage3CLKEn(i) := !Subbank_pipe_stall_bank_stage3(i)
  }

  // G3bankStallStage5CLK, G3bankStallStage5CLKEn
  for (i <- 0 until numBanks) {
    g3S5CLK(i) := Xtclockbuffer(io.G2generalCLK)
    io.G3bankStallStage5CLKEn(i) := G3bankStallStage5CLKEn(i)
  }

  // G3bankStallStage6CLK, G3bankStallStage6CLKEn
  for (i <- 0 until numBanks) {
    g3S6CLK(i) := Xtclockbuffer(io.G2generalCLK) 
    io.G3bankStallStage6CLKEn(i) :=G3bankStallStage6CLKEn(i)
  } 
  
  // G2dramReadPwrCLK, G2dramReadPwrDCLK  
  for (i <- 0 until numSubbanks) {
    io.G2dramReadPwrCLK(i)  := Xtclockbuffer(io.G1WCLK)
    io.G2dramReadPwrDCLK(i) := Xtclockbuffer(io.G1WCLK)
  }

  // G3dramReadCLK, G3dramReadDCLK
  for (i <- 0 until numSubbanks) {
    io.G3dramReadCLK(i)  := Xtclockbuffer(io.G2generalCLK)
    io.G3dramReadDCLK(i) := Xtclockbuffer(io.G2generalCLK)  
  }

                
}


