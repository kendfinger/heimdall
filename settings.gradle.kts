rootProject.name = "heimdall"

pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://gitlab.com/api/v4/projects/37752100/packages/maven")
  }
}

include("common")
include("plugin")
include("tool")
