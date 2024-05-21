import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import chiseltest.simulator.{VcsFlags, VcsSimFlags}
import primitives._
//import chiseltest.experimental.{WriteAbsoluteFSDBFileAnnotation, WriteFSDBAnnotation}

// 测试类
class Xacc_lzc32Test extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "Xacc_lzc32"

  it should "correctly compute the leading zero count" in {
    val annotations = Seq(
        VcsBackendAnnotation,
        WriteFsdbAnnotation,
        VcsFlags(Seq("-LDFLAGS","-Wl,--no-as-needed")),//<-----
      ) 
    test(new Xacc_lzc32).withAnnotations(annotations) { dut =>
      // 生成随机测试向量
      val rnd = new scala.util.Random(System.currentTimeMillis())
      val ageVectors = Seq.fill(8)(rnd.nextInt(Int.MaxValue))
      val requestVectors = Seq.fill(8)(rnd.nextInt(Int.MaxValue))

      // 运行测试
      for ((age, request) <- ageVectors zip requestVectors) {
        val binaryRequest = String.format("%32s", Integer.toBinaryString(request)).replace(' ', '0')
       // println(f"Input Request: $binaryRequest")
        val binaryage = String.format("%32s", Integer.toBinaryString(age)).replace(' ', '0')
        println(f"($request,$age):\nInput Req: $binaryRequest\nInput Age: $binaryage")
        val hiPrRequest = request & ~age
        val loPrRequest = request & age

        val binaryH = String.format("%32s", Integer.toBinaryString(hiPrRequest)).reverse.replace(' ', '0').reverse //replace(' ', '0')
       // println(f"Input Request: $binaryRequest")
        val binaryL = String.format("%32s", Integer.toBinaryString(loPrRequest)).reverse.replace(' ', '0').reverse  //padTo(32,0)
        println(f"HI: $binaryH\nLO: $binaryL")
        var tmpH=binaryH.indexOf('1')
        var tmpL=binaryL.indexOf('1')

        //printf(p"tmpH = ${Binary(tmpH)}, tmpL = ${Binary(tmpL)}\n")
        println(f"tmpH = ${tmpH}\ntmpL = ${tmpL}")
        tmpH = if (tmpH == -1) 32 else tmpH
        tmpL = if (tmpL == -1 ) 32 else tmpL
        val tmpHLow5 = tmpH & 0x1f // 提取 tmpH 的低 5 位
        val tmpHLow5Inv = ~tmpHLow5 // 对低 5 位进行按位取反
        val tmpHInv = (tmpH & 0x20) | (tmpHLow5Inv & 0x1f) // 将取反后的低 5 位与 位合并
        val tmpLLow5 = tmpL & 0x1f // 提取 tmpH 的低 5 位
        val tmpLLow5Inv = ~tmpLLow5 // 对低 5 位进行按位取反
        val tmpLInv = (tmpL & 0x20) | (tmpLLow5Inv & 0x1f) // 将取反后的低 5 位与 位合并
        /* val vlzc_h = if (tmpH == -1) 32 else 32 - tmpH
        val vlzc_l = if (tmpL == -1) 32 else 32 - tmpL */

        val expected = if(tmpH == 32) tmpLInv else tmpHInv
          println(f"tmpHInv = ${tmpHInv}\ntmpLInv = ${tmpLInv}")
        dut.io.Age.poke(age.U)
        dut.io.Request.poke(request.U)
        dut.io.Grant.expect(expected.U)
      }
    }
  }
}


class Xacc_lzc32_genericTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "Xacc_lzc32_generic"

  it should "correctly compute the leading zero count" in {
    val annotations = Seq(
        VcsBackendAnnotation,
        WriteFsdbAnnotation,
        VcsFlags(Seq("-LDFLAGS","-Wl,--no-as-needed")),//<-----
      ) 
    test(new Xacc_lzc_generic(32)).withAnnotations(Seq(VcsBackendAnnotation, WriteFsdbAnnotation,VcsFlags(Seq("-LDFLAGS","-Wl,--no-as-needed")))) { dut =>
      val rnd = new scala.util.Random(0L)
      val ageVectors = Seq.fill(8)(rnd.nextInt(Int.MaxValue))
      val requestVectors = Seq.fill(8)(rnd.nextInt(Int.MaxValue))

      // 运行测试
      for ((age, request) <- ageVectors zip requestVectors) {
        val binaryRequest = String.format("%32s", Integer.toBinaryString(request)).replace(' ', '0')
        //println(f"Input Request: $binaryRequest")
        val binaryage = String.format("%32s", Integer.toBinaryString(age)).replace(' ', '0')
        println(f"($request,$age):Input Request: $binaryRequest,Input Age: $binaryage")
        val hiPrRequest = request & ~age
        val loPrRequest = request & age
        val binaryH = String.format("%32s", Integer.toBinaryString(hiPrRequest)).reverse.replace(' ', '0').reverse //replace(' ', '0')
       // println(f"Input Request: $binaryRequest")
        val binaryL = String.format("%32s", Integer.toBinaryString(loPrRequest)).reverse.replace(' ', '0').reverse  //padTo(32,0)
        println(f"HI: $binaryH\nLO: $binaryL")
        var tmpH=binaryH.indexOf('1')
        var tmpL=binaryL.indexOf('1')

        //printf(p"tmpH = ${Binary(tmpH)}, tmpL = ${Binary(tmpL)}\n")
        println(f"tmpH = ${tmpH}\ntmpL = ${tmpL}")
        tmpH = if (tmpH == -1) 32 else tmpH
        tmpL = if (tmpL == -1 ) 32 else tmpL
        val tmpHLow5 = tmpH & 0x1f // 提取 tmpH 的低 5 位
        val tmpHLow5Inv = ~tmpHLow5 // 对低 5 位进行按位取反
        val tmpHInv = (tmpH & 0x20) | (tmpHLow5Inv & 0x1f) // 将取反后的低 5 位与 位合并
        val tmpLLow5 = tmpL & 0x1f // 提取 tmpH 的低 5 位
        val tmpLLow5Inv = ~tmpLLow5 // 对低 5 位进行按位取反
        val tmpLInv = (tmpL & 0x20) | (tmpLLow5Inv & 0x1f) // 将取反后的低 5 位与 位合并
        /* val vlzc_h = if (tmpH == -1) 32 else 32 - tmpH
        val vlzc_l = if (tmpL == -1) 32 else 32 - tmpL */

        val expected = if(tmpH == 32) tmpLInv else tmpHInv
          println(f"tmpHInv = ${tmpHInv}\ntmpLInv = ${tmpLInv}")
        
        // val expected = 32 - hiPrRequest.toBinaryString.reverse.indexOf('1')
        dut.io.Age.poke(age.U)
        dut.io.Request.poke(request.U)
        dut.io.Grant.expect(expected.U)
      }
    }
  }
}


class Xacc_pop_count32Test extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "Xacc_pop_count"

  it should "correctly compute the population count" in {
    val annotations = Seq(
        VcsBackendAnnotation,
        WriteFsdbAnnotation,
        VcsFlags(Seq("-LDFLAGS","-Wl,--no-as-needed")),//<-----
      ) 
    test(new Xacc_pop_count).withAnnotations((annotations)) { dut =>
      // 生成随机测试向量
      val rnd = new scala.util.Random(System.currentTimeMillis())
      val requestVectors = Seq.fill(8)(rnd.nextInt(Int.MaxValue))

      // 运行测试
      for (request <- requestVectors) {
        val binaryFormatted = String.format("%32s", Integer.toBinaryString(request)).replace(' ', '0')
        println(f"Input Request: $binaryFormatted")

        val expected = request.toBinaryString.count(_ == '1')
        dut.io.VecIn.poke(request.U)
        dut.io.SumOut.expect(expected.U)
      }
    }
  }
}