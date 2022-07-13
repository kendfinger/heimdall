import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("lgbt.mystic.foundation.concrete-root") version "0.3.0"
}

allprojects {
  group = "io.kexec"
  version = "0.1"

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs =
        freeCompilerArgs + "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
    }
  }
}

concrete {
  minecraftServerPath.set("server")
  paperVersionGroup.set("1.19")
  paperApiVersion.set("1.19-R0.1-SNAPSHOT")
  acceptServerEula.set(true)
}
