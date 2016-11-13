lazy val commonSettings = Seq(
    organization := "org.fengbaoxp",
    version := "0.1.0",
    scalaVersion := "2.11.8"
)

lazy val module1 = (project in file("module1")).
    settings(commonSettings: _*).
    settings(
        libraryDependencies ++= Seq(
            "org.apache.spark" % "spark-core" % "1.6.1"
        )
//        libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.1"
    )

lazy val module1_1 = (project in file("module1_1")).
    dependsOn(module1 % "compile->compile").
    settings(commonSettings: _*).
    settings(
    )

lazy val module2 = (project in file("module2")).
    settings(commonSettings: _*).
    settings(
    )

lazy val root = (project in file(".")).
    aggregate(module1_1, module2).
    settings(
        aggregate in update := false
    )
