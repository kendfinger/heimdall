import io.kexec.heimdall.gradle.HeimdallProjectPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  id("io.kexec.heimdall.gradle")
}

allprojects {
  repositories {
    mavenCentral()
    maven {
      name = "papermc"
      url = uri("https://papermc.io/repo/repository/maven-public/")
    }

    maven {
      name = "sonatype"
      url = uri("https://oss.sonatype.org/content/groups/public/")
    }
  }
}

tasks.assemble {
  dependsOn("updateManifests")
}

plugins.apply("org.jetbrains.kotlin.jvm")
plugins.apply("org.jetbrains.kotlin.plugin.serialization")
plugins.apply("com.github.johnrengelman.shadow")
plugins.apply(HeimdallProjectPlugin::class)

group = "io.kexec"
version = "0.1"

dependencies {
  // Kotlin dependencies
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  implementation("com.charleskorn.kaml:kaml:0.44.0")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")

  // Paper API
  compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")

  implementation("org.postgresql:postgresql:42.3.4")
  implementation("org.jetbrains.exposed:exposed-jdbc:0.38.2")
  implementation("org.jetbrains.exposed:exposed-java-time:0.38.2")
  implementation("com.zaxxer:HikariCP:5.0.1")

  implementation("com.github.ajalt.clikt:clikt:3.4.2")
}

java {
  val javaVersion = JavaVersion.toVersion(17)
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs =
      freeCompilerArgs + "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
  }
}

tasks.processResources {
  val props = mapOf("version" to version)
  inputs.properties(props)
  filteringCharset = "UTF-8"
  filesMatching("plugin.yml") {
    expand(props)
  }
}

tasks.assemble {
  dependsOn("shadowJar")
}

heimdall {
  minecraftServerPath.set("server")
  paperVersionGroup.set("1.18")
}
