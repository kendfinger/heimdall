package io.kexec.heimdall.gradle

import org.gradle.api.provider.Property

interface HeimdallExtension {
  val paperVersionGroup: Property<String>
  val minecraftServerPath: Property<String>
}
