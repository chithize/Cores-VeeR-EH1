//ThisBuild / scalaVersion := "2.13.8"
val chiselVersion = "3.5.4"
// val scalaVersion = "2.13.8"

// def scalacOptionsVersion(scalaVersion: String): Seq[String] = {
//   Seq() ++ {
//     // If we're building with Scala > 2.11, enable the compile option
//     //  switch to support our anonymous Bundle definitions:
//     //  https://github.com/scala/bug/issues/10047
//     CrossVersion.partialVersion(scalaVersion) match {
//       case Some((2, scalaMajor: Long)) if scalaMajor < 12 => Seq()
//       case _ => Seq("-Xsource:2.13")
//     }
//   }
// }

// def javacOptionsVersion(scalaVersion: String): Seq[String] = {
//   Seq() ++ {
//     // Scala 2.12 requires Java 8. We continue to generate
//     //  Java 7 compatible code for Scala 2.11
//     //  for compatibility with old clients.
//     CrossVersion.partialVersion(scalaVersion) match {
//       case Some((2, scalaMajor: Long)) if scalaMajor < 12 =>
//         Seq("-source", "1.7", "-target", "1.7")
//       case _ =>
//         Seq("-source", "1.8", "-target", "1.8")
//     }
//   }
// }

// scalacOptions ++= scalacOptionsVersion(scalaVersion.value)
// javacOptions ++= javacOptionsVersion(scalaVersion.value)

lazy val fgsengine = (project in file("."))
  .settings(
    name := "fgstop",
    scalaVersion := "2.13.8",
    scalacOptions ++= Seq(
      "-language:reflectiveCalls",
      "-deprecation",
      "-feature",
      "-Xcheckinit",
    ),
    addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % "3.5.4" cross CrossVersion.full),
    libraryDependencies ++= Seq(
      "edu.berkeley.cs" %% "chisel3" % "3.5.6",
      "edu.berkeley.cs" %% "firrtl" % "1.5.4",
      "edu.berkeley.cs" %% "chiseltest" % "0.5.6" % "test"
    ),
     Compile / runMain := Def.inputTaskDyn {
      val args = Def.spaceDelimited("<mainClass> <arg>").parsed
      val mainClass = args.head //"topMain"
      val mainArgs = args.tail  //"-td generated_verilog"
      Def.taskDyn {
        (Compile / run).toTask(s" $mainClass  ${mainArgs.mkString(" ")}")   //-td generated_verilog --emission-options disable-randomization
      }
    }.evaluated 
  )

//  lazy val genRTL = taskKey[Unit]("Generate Verilog")
// genRTL := {
//       val mainClass = "topMain" // 你的实际模块类名
//       val targetDir = "generated_verilog"

//       // 设置生成Verilog的参数
//       val chiselArgs = " topMain -td generated_verilog --emission-options=disableRegisterRandomization"
//      // val chiselArgs = Seq(mainClass, "-td", targetDir, "--emission-options", "disable-randomization")

//       // 调用runMain任务并传递参数
//       (Compile / runMain).toTask(" topMain generated_vv").value
//     }

// lazy val root = (project in file("."))
//   .aggregate(fgsengine)
//   .settings(
//     genRTL := {
//       val mainClass = "topMain" // 你的实际模块类名
//       val targetDir = "generated_verilog"

//       // 设置生成Verilog的参数
//       val chiselArgs = " topMain -td generated_verilog --emission-options=disableRegisterRandomization"
//      // val chiselArgs = Seq(mainClass, "-td", targetDir, "--emission-options", "disable-randomization")

//       // 调用runMain任务并传递参数
//       (Compile / runMain).toTask(" topMain -td generated_verilog --emission-options=disableRegisterRandomization").value
//     }
//   )



//  lazy val genRTL = taskKey[Unit]("Generate Verilog")

//   genRTL := {
//    val mainClass = "topMain" // Replace with your actual module class name
//   // val targetDir = "generated"

//   // Arguments for ChiselStage
//   //val chiselArgs = Array("--target-dir", targetDir, "--emission-options", "disable-randomization")

//   // Run the main class with the specified arguments
//   (Compile / runMain).toTask(" topMain").value
// }


/* lazy val root = (project in file("."))
  .settings(
    name := "fsengine",
    version := "0.1",
    libraryDependencies ++= Seq(
      "edu.berkeley.cs" %% "chisel" % chiselVersion,
    //  "edu.berkeley.cs" %% "firrtl" % chiselVersion,
      "edu.berkeley.cs" %% "chiseltest" % "0.5.4" 
    ),
    addCompilerPlugin("edu.berkeley.cs" % "chisel-plugin" % chiselVersion cross CrossVersion.full),
    Compile / run := (Compile / run).dependsOn(Compile / compile).evaluated
  )

lazy val genRTL = taskKey[Unit]("Generate Verilog")

genRTL := {
  val mainClass = "Modules_Verilog_Gen" // Replace with your actual module class name
  val targetDir = "generated"

  // Arguments for ChiselStage
  val chiselArgs = Array("--target-dir", targetDir, "--emission-options", "disable-randomization")

  // Run the main class with the specified arguments
  (Compile / runMain).toTask(" Modules_Verilog_Gen --target-dir generated --emission-options disable-randomization").value
}
 */