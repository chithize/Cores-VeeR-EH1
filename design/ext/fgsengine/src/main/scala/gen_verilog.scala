import primitives._
// import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
// import firrtl.options.{TargetDirAnnotation, OutputFileAnnotation}

import chisel3._
import chisel3.stage.{ChiselStage, ChiselGeneratorAnnotation}
import firrtl.options.TargetDirAnnotation
import firrtl.EmitAllModulesAnnotation
import firrtl.AnnotationSeq
import firrtl.SystemVerilogEmitter
import firrtl.VerilogEmitter
/* import firrtl.options.TargetDirAnnotation

//import firrtl.stage.RandomizeRegisterAnnotation
import firrtl.annotations.RandomizeRegisterAnnotation
 */
object Modules_Verilog_Gen extends App {
  

 // chisel3.emitVerilog(new Xacc_lzc_generic(32),Array("--target-dir", "generated"))
//  chisel3.emitVerilog(new VecRegSlice)
// object VecRegSliceGen extends App {
  val numRegs = 32
  val regWidth = 128
  val numWritePorts = 4
  val numReadPorts = 6

  val verilogFileName = s"VecRegSlice_${regWidth}bit_${numReadPorts}r${numWritePorts}w.v"
  (new ChiselStage).emitVerilog(
    new VecRegSlice(numRegs, regWidth, numWritePorts, numReadPorts),
    Array("--target-dir", "generated", "--output-file", verilogFileName,
          "--emission-options=disableMemRandomization,disableRegisterRandomization")
  )
//}

  
  /*  val outputDir = "generated_verilog"
  
  (new ChiselStage).execute(
    Array("-X", "verilog"),
    Seq(
      ChiselGeneratorAnnotation(() => new VecRegSlice),
      TargetDirAnnotation(outputDir),
      EmitAllModulesAnnotation,
      RandomizeRegisterAnnotation
    )
  ) */
//  val chiselArgs = Array("--emission-options", "disableRandInit")
  
//   // Dynamically create an instance of the main class
//   //val moduleClass = Class.forName("VecRegSlice").newInstance().asInstanceOf[() => chisel3.Module]

//   val annotations = Seq(
//     ChiselGeneratorAnnotation(new VecRegSlice ),
//     TargetDirAnnotation("generated"),
//     OutputFileAnnotation("VecRegSlice") // Use the mainClass as the base for the output file name
//   )

//   // Execute ChiselStage with the specified arguments and annotations
//   (new ChiselStage).execute(chiselArgs, annotations)
}


object topMain extends App {
  val outputDir = args(0)
  println(outputDir)
  val chiselArgs =
    Array(
/*    "--target",
      "systemverilog",  */
      "--target-dir",
      "generated",
      "-X",
      "verilog",
/*       "--frandomize-registers",
      "false", */
      "--emission-options=disableMemRandomization,disableRegisterRandomization",
     /*  "--disable-all-randomization",
      "--strip-debug-info", "-lower-memories", */
    )
  // (new ChiselStage).execute(
  //   Array("--target-dir", outputDir),
  //   Seq(
  //     ChiselGeneratorAnnotation(() => new VecRegSlice),
  //     EmitAllModulesAnnotation
  //   )
  // )

  // ChiselStage.emitSystemVerilogFile(
  //     new VecRegSlice,
  //     chiselArgs ++ Array("--split-verilog"),
  //     Array("--disable-all-randomization", "--strip-debug-info", "-lower-memories"),
  //   )

  (new ChiselStage).execute(
    chiselArgs,
    AnnotationSeq(
      Seq(
     // ChiselGeneratorAnnotation(() => new VecRegSlice),
      ChiselGeneratorAnnotation(() => new XBarMux4Hw_DataSel),
      //EmitAllModulesAnnotation(classOf[SystemVerilogEmitter])
      EmitAllModulesAnnotation(classOf[VerilogEmitter])
      ),
   )
  )
}

// 在这里定义你的 SubModule 和 TopModule
