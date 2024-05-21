// xtmux32e.scala
package primitives
import chisel3._
import chisel3.util._

class xtmux32e(val width: Int) extends BlackBox(Map("WIDTH" -> width)) {
  val io = IO(new Bundle {
    val inputs = Input(Vec(32, UInt(width.W)))
    val select = Input(UInt(log2Ceil(32).W))
    val output = Output(UInt(width.W))
  })
}

class xtmux32(val width: Int) extends BlackBox(Map("WIDTH"->width)) {
  val io = IO(new Bundle {
    // 定义输入输出端口
    val out = Output(UInt(width.W)) // 
    val inputs = Input(Vec(32, UInt(width.W))) // 
    val selects = Input(Vec(32, Bool())) // 8个选择信号
  })
}

class xtmux2e(val width: Int) extends BlackBox(Map("WIDTH" -> width)) {
  val io = IO(new Bundle {
    val in0 = Input(UInt(width.W))
    val in1 = Input(UInt(width.W))
    val sel = Input(Bool())
    val out = Output(UInt(width.W))
  })
}

class xtclockBuffer extends BlackBox {
  val io = IO(new Bundle {
    val out = Output(Bool())
    val in = Input(Bool())
  })
}

class xtmux8(val width: Int) extends BlackBox(Map("WIDTH"->width)) {
  val io = IO(new Bundle {
    // 定义输入输出端口
    val out = Output(UInt(width.W)) // 假设输出是18位宽
    val inputs = Input(Vec(8, UInt(width.W))) // 8个输入，每个18位宽
    val selects = Input(Vec(8, Bool())) // 8个选择信号
  })
}

class xtmux2(val width: Int) extends BlackBox(Map("WIDTH"->width)) {
  val io = IO(new Bundle {
    // 定义输入输出端口
    val out = Output(UInt(width.W)) // 
    val inputs = Input(Vec(2, UInt(width.W))) //
    val selects = Input(Vec(2, Bool())) // 
  })
}

class xtmux3(val width: Int) extends BlackBox(Map("WIDTH"->width)) {
  val io = IO(new Bundle {
    // 定义输入输出端口
    val out = Output(UInt(width.W)) 
    val inputs = Input(Vec(3, UInt(width.W))) // 
    val selects = Input(Vec(3, Bool())) //
  })
}

// Generic LZC module: Wrong!
// class Xacc_xtlzc(width: Int) extends Module {
//   val io = IO(new Bundle {
//     val age     = Input(UInt(width.W))
//     val request = Input(UInt(width.W)) 
//     val grant   = Output(UInt((log2Ceil(width) + 1).W))
//   })

//   def lzc(bits: UInt): UInt = {
//     val n = bits.getWidth
//     /* def helper(l: UInt, r: UInt): UInt = {
//       val w = l.getWidth
//       Mux(l.orR, Cat(0.U(1.W), l(w-2,0).andR, ~l(w-1)), Cat(1.U(1.W), helper(r(w/2-1,0), r(w-1, w/2))))
//     } */
//   def helper(l: UInt, r: UInt): UInt = {
//     val w = l.getWidth
//     if (w == 1) {
//        Mux(l.orR, 0.U(1.W), 1.U(1.W))
//      }
//     else {
//       val mid = w / 2
//       Mux(l.orR, Cat(0.U(1.W), l(mid-1,0).andR, ~l(w-1)), Cat(1.U(1.W), helper(r(mid-1,0), r(w-1,mid))))
//     }
//   }
//     helper(bits, bits)
//   }

//   val hiPrRequest = io.request & ~io.age
//   val loPrRequest = io.request & io.age
  
//   val hiPrReqPresent = hiPrRequest.orR
  
//   val tmpOh = lzc(hiPrRequest)
//   val tmpOl = lzc(loPrRequest)

//   io.grant := Mux(hiPrReqPresent, Cat(tmpOh(tmpOh.getWidth-1), ~tmpOh(tmpOh.getWidth-2,0)), 
//                                    Cat(tmpOl(tmpOl.getWidth-1), ~tmpOl(tmpOl.getWidth-2,0)))
// }

class Xacc_lzc_generic(width: Int=32) extends Module {
 // require(width == 64 || width == 128, "Width must be 64 or 128")

  val io = IO(new Bundle {
/*     val in = Input(UInt(width.W))
    val out = Output(UInt((log2Ceil(width) + 1).W)) */
    val Age = Input(UInt(width.W))
    val Request = Input(UInt(width.W))
    val Grant = Output(UInt((log2Ceil(width) + 1).W))
  })

  val HiPrRequest = io.Request & ~io.Age
  val LoPrRequest = io.Request & io.Age
  val HiPrReqPresent = HiPrRequest.orR

  val ih = Reverse(HiPrRequest)
  val il = Reverse(LoPrRequest)

  val tmp_oh = PriorityEncoder(ih)  //-1.U
  val tmp_ol = PriorityEncoder(il)   //-1.U
  println(f"tmp_oh=$tmp_oh,tmp_ol=$tmp_ol")
  val out_h  = Mux((ih === 0.U), width.U, tmp_oh)
  val out_l  = Mux((il === 0.U), width.U, tmp_ol)
  io.Grant  := Mux(HiPrReqPresent, Cat(out_h(5),~out_h(4,0)), Cat(out_l(5),~out_l(4,0)))
}

// 32-bit LZC
// class Xacc_lzc32 extends Xacc_xtlzc(32)
//import chisel3._

class Xacc_lzc32 extends Module {
  val io = IO(new Bundle {
    val Age = Input(UInt(32.W))
    val Request = Input(UInt(32.W))
    val Grant = Output(UInt(6.W))
  })

  val HiPrRequest = io.Request & ~io.Age
  val LoPrRequest = io.Request & io.Age
  val HiPrReqPresent = HiPrRequest.orR

  val ih = HiPrRequest
  val il = LoPrRequest

  val or_31_30l = il(31) | il(30)
  val tmp_o_31_28l = Mux(or_31_30l, Cat(false.B, ~il(31)), Cat(true.B, ~il(29)))
  val or_27_26l = il(27) | il(26)
  val tmp_o_27_24l = Mux(or_27_26l, Cat(false.B, ~il(27)), Cat(true.B, ~il(25)))
  val or_31_28l = or_31_30l | il(29) | il(28)
  val tmp_o_31_24l = Mux(or_31_28l, Cat(false.B, tmp_o_31_28l), Cat(true.B, tmp_o_27_24l))
  val or_23_22l = il(23) | il(22)
  val tmp_o_23_20l = Mux(or_23_22l, Cat(false.B, ~il(23)), Cat(true.B, ~il(21)))
  val or_19_18l = il(19) | il(18)
  val tmp_o_19_16l = Mux(or_19_18l, Cat(false.B, ~il(19)), Cat(true.B, ~il(17)))
  val or_23_20l = or_23_22l | il(21) | il(20)
  val tmp_o_23_16l = Mux(or_23_20l, Cat(false.B, tmp_o_23_20l), Cat(true.B, tmp_o_19_16l))
  val or_31_24l = or_31_28l | or_27_26l | il(25) | il(24)
  val tmp_o_31_16l = Mux(or_31_24l, Cat(false.B, tmp_o_31_24l), Cat(true.B, tmp_o_23_16l))
  val or_15_14l = il(15) | il(14)
  val tmp_o_15_12l = Mux(or_15_14l, Cat(false.B, ~il(15)), Cat(true.B, ~il(13)))
  val or_11_10l = il(11) | il(10)
  val tmp_o_11_8l = Mux(or_11_10l, Cat(false.B, ~il(11)), Cat(true.B, ~il(9)))
  val or_15_12l = or_15_14l | il(13) | il(12) 
  val tmp_o_15_8l = Mux(or_15_12l, Cat(false.B, tmp_o_15_12l), Cat(true.B, tmp_o_11_8l))
  val or_7_6l = il(7) | il(6)
  val tmp_o_7_4l = Mux(or_7_6l, Cat(false.B, ~il(7)), Cat(true.B, ~il(5)))
  val or_3_2l = il(3) | il(2)
  val tmp_o_3_0l = Mux(or_3_2l, Cat(false.B, ~il(3)), Cat(true.B, ~il(1)))
  val or_7_4l = or_7_6l | il(5) | il(4)
  val tmp_o_7_0l = Mux(or_7_4l, Cat(false.B, tmp_o_7_4l), Cat(true.B, tmp_o_3_0l))
  val or_15_8l = or_15_12l | or_11_10l | il(9) | il(8)
  val tmp_o_15_0l = Mux(or_15_8l, Cat(false.B, tmp_o_15_8l), Cat(true.B, tmp_o_7_0l))
  val or_31_16l = or_31_24l | or_23_20l | or_19_18l | il(17) | il(16)
  val tmp_o_31_0l = Mux(or_31_16l, Cat(false.B, tmp_o_31_16l), Cat(true.B, tmp_o_15_0l))
  val or_31_0l = or_31_16l | or_15_8l | or_7_4l | or_3_2l | il(1) | il(0)
  val tmp_ol = Mux(or_31_0l, Cat(false.B, tmp_o_31_0l), Cat(true.B, 0.U(5.W)))

  val or_31_30h = ih(31) | ih(30)
  val tmp_o_31_28h = Mux(or_31_30h, Cat(false.B, ~ih(31)), Cat(true.B, ~ih(29)))
  val or_27_26h = ih(27) | ih(26)
  val tmp_o_27_24h = Mux(or_27_26h, Cat(false.B, ~ih(27)), Cat(true.B, ~ih(25)))
  val or_31_28h = or_31_30h | ih(29) | ih(28)
  val tmp_o_31_24h = Mux(or_31_28h, Cat(false.B, tmp_o_31_28h), Cat(true.B, tmp_o_27_24h))
  val or_23_22h = ih(23) | ih(22)
  val tmp_o_23_20h = Mux(or_23_22h, Cat(false.B, ~ih(23)), Cat(true.B, ~ih(21)))
  val or_19_18h = ih(19) | ih(18)
  val tmp_o_19_16h = Mux(or_19_18h, Cat(false.B, ~ih(19)), Cat(true.B, ~ih(17)))
  val or_23_20h = or_23_22h | ih(21) | ih(20)
  val tmp_o_23_16h = Mux(or_23_20h, Cat(false.B, tmp_o_23_20h), Cat(true.B, tmp_o_19_16h))
  val or_31_24h = or_31_28h | or_27_26h | ih(25) | ih(24)
  val tmp_o_31_16h = Mux(or_31_24h, Cat(false.B, tmp_o_31_24h), Cat(true.B, tmp_o_23_16h))
  val or_15_14h = ih(15) | ih(14)
  val tmp_o_15_12h = Mux(or_15_14h, Cat(false.B, ~ih(15)), Cat(true.B, ~ih(13)))
  val or_11_10h = ih(11) | ih(10)
  val tmp_o_11_8h = Mux(or_11_10h, Cat(false.B, ~ih(11)), Cat(true.B, ~ih(9)))
  val or_15_12h = or_15_14h | ih(13) | ih(12)
  val tmp_o_15_8h = Mux(or_15_12h, Cat(false.B, tmp_o_15_12h), Cat(true.B, tmp_o_11_8h))
  val or_7_6h = ih(7) | ih(6)
  val tmp_o_7_4h = Mux(or_7_6h, Cat(false.B, ~ih(7)), Cat(true.B, ~ih(5)))
  val or_3_2h = ih(3) | ih(2)
  val tmp_o_3_0h = Mux(or_3_2h, Cat(false.B, ~ih(3)), Cat(true.B, ~ih(1)))
  val or_7_4h = or_7_6h | ih(5) | ih(4)
  val tmp_o_7_0h = Mux(or_7_4h, Cat(false.B, tmp_o_7_4h), Cat(true.B, tmp_o_3_0h))
  val or_15_8h = or_15_12h | or_11_10h | ih(9) | ih(8)
  val tmp_o_15_0h = Mux(or_15_8h, Cat(false.B, tmp_o_15_8h), Cat(true.B, tmp_o_7_0h))
  val or_31_16h = or_31_24h | or_23_20h | or_19_18h | ih(17) | ih(16)
  val tmp_o_31_0h = Mux(or_31_16h, Cat(false.B, tmp_o_31_16h), Cat(true.B, tmp_o_15_0h))
  val or_31_0h = or_31_16h | or_15_8h | or_7_4h | or_3_2h | ih(1) | ih(0)
  val tmp_oh = Mux(or_31_0h, Cat(false.B, tmp_o_31_0h), Cat(true.B, 0.U(5.W)))

  io.Grant := Mux(HiPrReqPresent, Cat(tmp_oh(5), ~tmp_oh(4, 0)), Cat(tmp_ol(5), ~tmp_ol(4, 0)))
}

//import chisel3._

class Xacc_lzc16 extends Module {
  val io = IO(new Bundle {
    val Age = Input(UInt(16.W))
    val Request = Input(UInt(16.W))
    val Grant = Output(UInt(5.W))
  })

  val HiPrRequest = io.Request & ~io.Age
  val LoPrRequest = io.Request & io.Age
  val HiPrReqPresent = HiPrRequest.orR

  val ih = HiPrRequest
  val il = LoPrRequest

  val or_15_14l = il(15) | il(14)
  val tmp_o_15_12l = Mux(or_15_14l, Cat(false.B, ~il(15)), Cat(true.B, ~il(13)))
  val or_11_10l = il(11) | il(10)
  val tmp_o_11_8l = Mux(or_11_10l, Cat(false.B, ~il(11)), Cat(true.B, ~il(9)))
  val or_15_12l = or_15_14l | il(13) | il(12)
  val tmp_o_15_8l = Mux(or_15_12l, Cat(false.B, tmp_o_15_12l), Cat(true.B, tmp_o_11_8l))
  val or_7_6l = il(7) | il(6)
  val tmp_o_7_4l = Mux(or_7_6l, Cat(false.B, ~il(7)), Cat(true.B, ~il(5)))
  val or_3_2l = il(3) | il(2)
  val tmp_o_3_0l = Mux(or_3_2l, Cat(false.B, ~il(3)), Cat(true.B, ~il(1)))
  val or_7_4l = or_7_6l | il(5) | il(4)
  val tmp_o_7_0l = Mux(or_7_4l, Cat(false.B, tmp_o_7_4l), Cat(true.B, tmp_o_3_0l))
  val or_15_8l = or_15_12l | or_11_10l | il(9) | il(8)
  val tmp_o_15_0l = Mux(or_15_8l, Cat(false.B, tmp_o_15_8l), Cat(true.B, tmp_o_7_0l))
  val or_15_0l = or_15_8l | or_7_4l | or_3_2l | il(1) | il(0)
  val tmp_ol = Mux(or_15_0l, Cat(false.B, tmp_o_15_0l), Cat(true.B, 0.U(4.W)))

  val or_15_14h = ih(15) | ih(14)
  val tmp_o_15_12h = Mux(or_15_14h, Cat(false.B, ~ih(15)), Cat(true.B, ~ih(13)))
  val or_11_10h = ih(11) | ih(10)
  val tmp_o_11_8h = Mux(or_11_10h, Cat(false.B, ~ih(11)), Cat(true.B, ~ih(9)))
  val or_15_12h = or_15_14h | ih(13) | ih(12)
  val tmp_o_15_8h = Mux(or_15_12h, Cat(false.B, tmp_o_15_12h), Cat(true.B, tmp_o_11_8h))
  val or_7_6h = ih(7) | ih(6)
  val tmp_o_7_4h = Mux(or_7_6h, Cat(false.B, ~ih(7)), Cat(true.B, ~ih(5)))
  val or_3_2h = ih(3) | ih(2)
  val tmp_o_3_0h = Mux(or_3_2h, Cat(false.B, ~ih(3)), Cat(true.B, ~ih(1)))
  val or_7_4h = or_7_6h | ih(5) | ih(4)
  val tmp_o_7_0h = Mux(or_7_4h, Cat(false.B, tmp_o_7_4h), Cat(true.B, tmp_o_3_0h))
  val or_15_8h = or_15_12h | or_11_10h | ih(9) | ih(8)
  val tmp_o_15_0h = Mux(or_15_8h, Cat(false.B, tmp_o_15_8h), Cat(true.B, tmp_o_7_0h))
  val or_15_0h = or_15_8h | or_7_4h | or_3_2h | ih(1) | ih(0)
  val tmp_oh = Mux(or_15_0h, Cat(false.B, tmp_o_15_0h), Cat(true.B, 0.U(4.W)))

  io.Grant := Mux(HiPrReqPresent, Cat(tmp_oh(4), ~tmp_oh(3, 0)), Cat(tmp_ol(4), ~tmp_ol(3, 0)))
}

class Xacc_lzc8 extends Module {
  val io = IO(new Bundle {
    val Age = Input(UInt(8.W))
    val Request = Input(UInt(8.W))
    val Grant = Output(UInt(4.W))
  })

  val HiPrRequest = io.Request & ~io.Age
  val LoPrRequest = io.Request & io.Age
  val HiPrReqPresent = HiPrRequest.orR

  val ih = HiPrRequest
  val il = LoPrRequest

  val or_7_6l = il(7) | il(6)
  val tmp_o_7_4l = Mux(or_7_6l, Cat(false.B, ~il(7)), Cat(true.B, ~il(5)))
  val or_3_2l = il(3) | il(2)
  val tmp_o_3_0l = Mux(or_3_2l, Cat(false.B, ~il(3)), Cat(true.B, ~il(1)))
  val or_7_4l = or_7_6l | il(5) | il(4)
  val tmp_o_7_0l = Mux(or_7_4l, Cat(false.B, tmp_o_7_4l), Cat(true.B, tmp_o_3_0l))
  val or_7_0l = or_7_4l | or_3_2l | il(1) | il(0)
  val tmp_ol = Mux(or_7_0l, Cat(false.B, tmp_o_7_0l), Cat(true.B, 0.U(3.W)))

  val or_7_6h = ih(7) | ih(6)
  val tmp_o_7_4h = Mux(or_7_6h, Cat(false.B, ~ih(7)), Cat(true.B, ~ih(5)))
  val or_3_2h = ih(3) | ih(2)
  val tmp_o_3_0h = Mux(or_3_2h, Cat(false.B, ~ih(3)), Cat(true.B, ~ih(1)))
  val or_7_4h = or_7_6h | ih(5) | ih(4)
  val tmp_o_7_0h = Mux(or_7_4h, Cat(false.B, tmp_o_7_4h), Cat(true.B, tmp_o_3_0h))
  val or_7_0h = or_7_4h | or_3_2h | ih(1) | ih(0)
  val tmp_oh = Mux(or_7_0h, Cat(false.B, tmp_o_7_0h), Cat(true.B, 0.U(3.W)))

  io.Grant := Mux(HiPrReqPresent, Cat(tmp_oh(3), ~tmp_oh(2, 0)), Cat(tmp_ol(3), ~tmp_ol(2, 0)))
}

class Xacc_pop_count extends Module {
  val io = IO(new Bundle {
    val VecIn = Input(UInt(32.W))
    val SumOut = Output(UInt(6.W))
  })
   io.SumOut := PopCount(io.VecIn)
/*   io.SumOut := io.VecIn(0) +
    io.VecIn(1) +
    io.VecIn(2) +
    io.VecIn(3) +
    io.VecIn(4) +

    io.VecIn(5) +
    io.VecIn(6) +
    io.VecIn(7) +
    io.VecIn(8) +
    io.VecIn(9) +
    io.VecIn(10) +
    io.VecIn(11) +
    io.VecIn(12) +
    io.VecIn(13) +
    io.VecIn(14) +
    io.VecIn(15) +
    io.VecIn(16) +
    io.VecIn(17) +
    io.VecIn(18) +
    io.VecIn(19) +
    io.VecIn(20) +
    io.VecIn(21) +
    io.VecIn(22) +
    io.VecIn(23) +
    io.VecIn(24) +
    io.VecIn(25) +
    io.VecIn(26) +
    io.VecIn(27) +
    io.VecIn(28) +
    io.VecIn(29) +
    io.VecIn(30) +
    io.VecIn(31)
 */
}

class Xacc_pop_count2X16 extends Module {
  val io = IO(new Bundle {
    val VecIn = Input(UInt(32.W))
    val SumOut = Output(UInt(6.W))
  })
   val SumOutLo = PopCount(io.VecIn(15,0))
  /* val SumOutLo = io.VecIn(0) +
    io.VecIn(1) +
    io.VecIn(2) +
    io.VecIn(3) +
    io.VecIn(4) +
    io.VecIn(5) +
    io.VecIn(6) +
    io.VecIn(7) +
    io.VecIn(8) +
    io.VecIn(9) +
    io.VecIn(10) +
    io.VecIn(11) +
    io.VecIn(12) +
    io.VecIn(13) +
    io.VecIn(14) +
    io.VecIn(15)
 */
  val SumOutHi = PopCount(io.VecIn(31,16))/* io.VecIn(16) +
    io.VecIn(17) +
    io.VecIn(18) +
    io.VecIn(19) +
    io.VecIn(20) +
    io.VecIn(21) +
    io.VecIn(22) +
    io.VecIn(23) +
    io.VecIn(24) +
    io.VecIn(25) +
    io.VecIn(26) +
    io.VecIn(27) +
    io.VecIn(28) +
    io.VecIn(29) +
    io.VecIn(30) +
    io.VecIn(31)
 */
  io.SumOut := SumOutHi | SumOutLo
}

// 16-bit LZC  
// class Xacc_xtlzc_16 extends Xacc_xtlzc(16)

// 8-bit LZC
// class Xacc_xtlzc_8 extends Xacc_xtlzc(8)


object  primitives{
   def Xtmux32(width:Int,out: UInt, inputs: Seq[UInt], selects: Seq[Bool]): Unit = {
      require(inputs.length == 32 && selects.length == 32, "必须提供32个输入和32个选择信号")
      val xtmuxModule = Module(new xtmux32(width))
      xtmuxModule.io.inputs.zip(inputs).foreach { case (moduleInput, input) => moduleInput := input }
      xtmuxModule.io.selects.zip(selects).foreach { case (moduleSelect, select) => moduleSelect := select }
      out := xtmuxModule.io.out
   }
   def Xtmux8(width:Int,out: UInt, inputs: Seq[UInt], selects: Seq[Bool]): Unit = {
      require(inputs.length == 8 && selects.length == 8, "必须提供8个输入和8个选择信号")
      val xtmuxModule = Module(new xtmux8(width))
      xtmuxModule.io.inputs.zip(inputs).foreach { case (moduleInput, input) => moduleInput := input }
      xtmuxModule.io.selects.zip(selects).foreach { case (moduleSelect, select) => moduleSelect := select }
      out := xtmuxModule.io.out
   }
   def Xtmux2(width:Int,out: UInt, inputs: Seq[UInt], selects: Seq[Bool]): Unit = {
      require(inputs.length == 2 && selects.length == 2, "必须提供2个输入和2个选择信号")
      val xtmuxModule = Module(new xtmux2(width))
      xtmuxModule.io.inputs.zip(inputs).foreach { case (moduleInput, input) => moduleInput := input }
      xtmuxModule.io.selects.zip(selects).foreach { case (moduleSelect, select) => moduleSelect := select }
      out := xtmuxModule.io.out
   }
    def Xtmux3(width:Int,out: UInt, inputs: Seq[UInt], selects: Seq[Bool]): Unit = {
      require(inputs.length == 3 && selects.length == 3, "必须提供8个输入和8个选择信号")
      val xtmuxModule = Module(new xtmux3(width))
      xtmuxModule.io.inputs.zip(inputs).foreach { case (moduleInput, input) => moduleInput := input }
      xtmuxModule.io.selects.zip(selects).foreach { case (moduleSelect, select) => moduleSelect := select }
      out := xtmuxModule.io.out
   }

    def Xtclockbuffer(in: Clock): Clock = {

      val clkBuff= Module(new xtclockBuffer)
      clkBuff.io.in:=in
      val outBuff = Wire(Clock())
          outBuff:=clkBuff.io.out
      outBuff
    }


}


object xcff {
  def apply(n: Int,clock:Clock,reset:Bool, gate:Bool, Input:UInt): UInt = {
      val out=Wire(UInt(n.W))
      withClockAndReset(clock,reset)
      {
        val Reg=RegInit(0.U(n.W))
        when(gate) {
          Reg:=Input
        }
        out:=Reg
        //noinit(Reg)
      }
      out
  }
}

object g_ff {
  def apply(n:Int,gate:Bool, Input:UInt): UInt = {
      val out=Wire(UInt(n.W))
      val Reg=RegInit(0.U(n.W))
      when(gate) {
          Reg:=Input
        }
     out:=Reg 
     out
  }
}
object Xacc_twoAgeArb2 {
  def apply(age: UInt, request: UInt, n: Int): UInt = {
    val HiPrRequest = request & ~age
    val LoPrRequest = request & age

    val HiPrGrant = Wire(UInt(n.W))
    val LoPrGrant = Wire(UInt(n.W))

    for (i <- 0 until n) {
      HiPrGrant(i) := HiPrRequest(i) && ~(HiPrRequest(0, i-1).orR)
      LoPrGrant(i) := LoPrRequest(i) && ~(LoPrRequest(0, i-1).orR)
    }

    val HiPrReqPresent = HiPrRequest.orR
    Mux(HiPrReqPresent, HiPrGrant, LoPrGrant)
  }
}