package io.kexec.heimdall.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class HeimdallGradlePlugin : Plugin<Project> {
  override fun apply(project: Project) {
    project.extensions.create<HeimdallExtension>("heimdall")
    val setupPaperServer = project.tasks.create<SetupPaperServer>("setupPaperServer")
    project.afterEvaluate { ->
      setupPaperServer.dependsOn(project.tasks.getByName("shadowJar"))
    }
    val runPaperServer = project.tasks.create<RunPaperServer>("runPaperServer")
    runPaperServer.dependsOn(setupPaperServer)
  }
}
