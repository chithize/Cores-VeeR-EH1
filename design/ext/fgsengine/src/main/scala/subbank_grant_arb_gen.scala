//31203-33425
import chisel3._
import chisel3.util._
import primitives._

class ARSubbankAddrArb(val numElems: Int=32, val numSubbanks: Int=8, val numBanks: Int=2/* ,sbkNo: Int=8,bkId:Int */) extends Module {
  val io = IO(new Bundle {
    val ar_addr_age_vec                       = Input(UInt(numElems.W))
    val ar_addr_sbvec                         = Input(Vec(numElems,UInt(numSubbanks.W)))
    val ar_addr_bank_vec                      = Input(Vec(numElems, UInt(log2Ceil(numSubbanks).W)))
    val ar_ele_addr_issued_to_dram_vec_stage1 = Input(UInt(numElems.W))
    val ar_addr_grant                         = Output(Vec(numSubbanks*numBanks,UInt(numElems.W)))
  })

for(subbankId <- 0 until numBanks*numSubbanks){
   val ar_req_addr_for_arb_sb =((0 until numElems).map { i =>
    io.ar_addr_sbvec(i)(subbankId) && (io.ar_addr_bank_vec(i) === subbankId.U) && !io.ar_ele_addr_issued_to_dram_vec_stage1(i)
  }).toVector

  io.ar_addr_grant(subbankId) :=Xacc_twoAgeArb2(io.ar_addr_age_vec,Cat(ar_req_addr_for_arb_sb.reverse),numElems)
 }
}