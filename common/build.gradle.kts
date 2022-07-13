plugins {
  id("lgbt.mystic.foundation.concrete-library")
}

dependencies {
  api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")

  api("org.postgresql:postgresql:42.3.6")
  api("org.jetbrains.exposed:exposed-jdbc:0.38.2")
  api("org.jetbrains.exposed:exposed-java-time:0.38.2")
  api("com.zaxxer:HikariCP:5.0.1")
}
