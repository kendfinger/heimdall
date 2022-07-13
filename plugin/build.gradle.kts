plugins {
  id("lgbt.mystic.foundation.concrete-plugin")
}

dependencies {
  implementation("com.charleskorn.kaml:kaml:0.45.0")
  api(project(":common"))
}
