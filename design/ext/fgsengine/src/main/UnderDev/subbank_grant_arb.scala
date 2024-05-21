//31203-33425
class ARSubbankAddrArb(val numElems: Int=32, val numSubbanks: Int=8, val numBanks: Int=2/* ,sbkNo: Int=8,bkId:Int */) extends Module {
  val io = IO(new Bundle {
    val ArAddrAgeVec                   = Input(UInt(numElem.W))
    val ArAddrSBVec                    = Input(Vec(numElem,UInt(numSubbank.W)))
    val ArAddrBankVec                  = Input(Vec(numElem, UInt(log2Ceil(numSubbank).W)))
    val ArEleAddrIssuedToDramVecStage1 = Input(UInt(numElem.W))
    val ArAddrGrant                    = Output(Vec(numSubbanks*numBanks,UInt(numElem.W)))
  })

for(subbankId <- 0 until numBanks*numSubbanks){
   val ar_req_addr_for_arb_sb =((0 until numElem).map { i =>
    io.ArAddrSBVec(i)(subbankId) && (io.ArAddrBankVec(i) === subbankId.U) && !io.ArEleAddrIssuedToDramVecStage1(i)
  }).toVector

  io.ArAddrGrant(subbankId) :=Xacc_twoAgeArb2(ar_addr_age_vec,ar_req_addr_for_arb_sb,numElem)
 }
}