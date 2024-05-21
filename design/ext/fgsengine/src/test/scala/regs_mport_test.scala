import chisel3._
import chisel3.util._
import chiseltest._

import chiseltest.simulator.{VcsFlags, VcsSimFlags}
import org.scalatest.flatspec.AnyFlatSpec
import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

class RegFileModel(val depth: Int, val regWidth: Int, val numPorts: Int) {
  val regFile = Array.fill(depth)(BigInt(0))

  def updateRegFileModel(addr: Seq[Int], data: Seq[BigInt], we: Seq[BigInt]): Unit = {
    require(addr.length == numPorts && data.length == numPorts && we.length == numPorts, "addr, data, and we vectors must have the same length and match the number of ports")

    // For each entry in the register file
    for (i <- 0 until depth) {
      var oldValue = regFile(i)
      val byteMask = (BigInt(1) << 8) - 1
      var newValue = oldValue

      // Traverse the write ports from lowest to highest priority
     for (byte <- 0 until (regWidth / 8)) {
       var found = false
       breakable{
        for (port <- 0 until numPorts) {
           if ((addr(port) == i) && ((we(port) & (BigInt(1) << byte)) != 0)) {
              val shift = byte * 8
              val byteValue = (data(port) >> shift) & byteMask
              newValue = (newValue & ~(byteMask << shift)) | (byteValue << shift)
              found = true
            }
            if(found) break
          }
        }
          // Once a write is performed for this address, break out of the loop to ensure lower priority writes do not overwrite
          oldValue = newValue
          // Update the register file for the current entry
          regFile(i) = newValue
          // Stop checking other ports for this address
          
        }
      }
      
    }
}



class VecRegSliceTest extends AnyFlatSpec with ChiselScalatestTester {
  "VecRegSlice" should "pass all tests" in {

        val annotations = Seq(
        VcsBackendAnnotation,
        WriteFsdbAnnotation,
        VcsFlags(Seq("-LDFLAGS","-Wl,--no-as-needed")),//<-----
      ) 
    test(new VecRegSlice).withAnnotations(annotations) { dut =>
      // Helper function to generate random data
      def randomData(width: Int) = BigInt(width, scala.util.Random)

      // Initialize and reset the DUT
      // dut.io.localReset.poke(true.B)
      // dut.clock.step(1)
      // dut.io.localReset.poke(false.B)
      dut.reset.poke(true.B)
      dut.clock.step(1)
      dut.reset.poke(false.B)
      dut.clock.step(1)
      // Check if all registers are reset to 0
      for (i <- 0 until dut.numReadPorts) {
        dut.io.rd_addr(i).poke(i.U)
      }
      dut.clock.step(1)
      for (i <- 0 until dut.numReadPorts) {
        dut.io.rd_data(i).expect(0.U)
      }

      // Test parameters
      val numWritePorts = dut.numWritePorts
      val numReadPorts = dut.numReadPorts
      val addrWidth = dut.addrWidth
      val regWidth = dut.regWidth

/*       // Model to track the state of the registers
      val regFile = mutable.Map[Int, BigInt]().withDefaultValue(BigInt(0))

      // Function to update register file model
      def updateRegFileModel(addr: Int, data: BigInt, we: BigInt): Unit = {
        val oldValue = regFile(addr)
        val byteMask = (BigInt(1) << 8) - 1
        var newValue = oldValue
        for (byte <- 0 until (regWidth / 8)) {
          if ((we & (BigInt(1) << byte)) != 0) {
            val shift = byte * 8
            val byteValue = (data >> shift) & byteMask
            newValue = (newValue & ~(byteMask << shift)) | (byteValue << shift)
          }
        }
        regFile(addr) = newValue
      }
 */
     val regModel = new RegFileModel(32,128,4)
     val addr = Seq(1, 2, 1, 3)
     val data = Seq(BigInt(0x12345678), BigInt(0xabcdef01), BigInt(0x87654321), BigInt(0x11223344))
     val we = Seq(BigInt(0xff), BigInt(0xff), BigInt(0xff), BigInt(0xff))
      // Random writes
      for (_ <- 0 until 4) {
        val wrAddr = Seq.fill(numWritePorts)(randomData(addrWidth).toInt)
        val wrData = Seq.fill(numWritePorts)(randomData(regWidth))
        val wrEnables = Seq.fill(numWritePorts)(randomData(regWidth / 8))

        for (i <- 0 until numWritePorts) {
          dut.io.wr_addr(i).poke(wrAddr(i).U)
          dut.io.wr_data(i).poke(wrData(i).U)
          dut.io.we(i).poke(wrEnables(i).U)
          // Update the model
     //     updateRegFileModel(wrAddr(i), wrData(i), wrEnables(i))
        }
        regModel.updateRegFileModel(wrAddr, wrData, wrEnables)
        dut.clock.step(1)
      }

      // Concurrent reads after 1 cycle
      dut.clock.step(1)
      val rdAddr = Seq.fill(numReadPorts)(randomData(addrWidth).toInt)

      for (i <- 0 until numReadPorts) {
        dut.io.rd_addr(i).poke(rdAddr(i).U)
      }
      dut.clock.step(1)

      // Check read data matches expected values
      for (i <- 0 until numReadPorts) {
        val expectedData = regModel.regFile(rdAddr(i))  //getOrElse(rdAddr(i), BigInt(0))
        dut.io.rd_data(i).expect(expectedData.U)
      }

      // Concurrent read and write
      for (_ <- 0 until 4) {
        val wrAddr = Seq.fill(numWritePorts)(randomData(addrWidth).toInt)
        val wrData = Seq.fill(numWritePorts)(randomData(regWidth))
        val wrEnables = Seq.fill(numWritePorts)(randomData(regWidth / 8))
        val rdAddr = Seq.fill(numReadPorts)(randomData(addrWidth).toInt)

        // Capture the old values before writing for checking concurrent read
        val oldValues = rdAddr.map(addr => regModel.regFile(addr))//.getOrElse(addr, BigInt(0)))
       //problem
        for (i <- 0 until numWritePorts) {
          dut.io.wr_addr(i).poke(wrAddr(i).U)
          dut.io.wr_data(i).poke(wrData(i).U)
          dut.io.we(i).poke(wrEnables(i).U)
          // Update the model
          //updateRegFileModel(wrAddr(i), wrData(i), wrEnables(i))
        }
        regModel.updateRegFileModel(wrAddr, wrData, wrEnables)
        for (i <- 0 until numReadPorts) {
          dut.io.rd_addr(i).poke(rdAddr(i).U)
        }
        // Check read data matches old values (before write in this cycle)
        for (i <- 0 until numReadPorts) {
          dut.io.rd_data(i).expect(oldValues(i).U)
        }

         dut.clock.step(1)
      }
    }
  }
}
