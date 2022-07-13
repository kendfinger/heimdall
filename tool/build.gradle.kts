plugins {
  id("lgbt.mystic.foundation.concrete-library")
  id("com.github.johnrengelman.shadow")
}

dependencies {
  api(project(":common"))

  implementation("com.github.ajalt.clikt:clikt:3.5.0")
  implementation("org.slf4j:slf4j-simple:1.7.36")
}

tasks.jar {
  manifest.attributes(
    "Main-Class" to "io.kexec.heimdall.tool.MainKt"
  )
}

tasks.assemble {
  dependsOn("shadowJar")
}
