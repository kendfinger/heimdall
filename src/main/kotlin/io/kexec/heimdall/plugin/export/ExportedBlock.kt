package io.kexec.heimdall.plugin.export

import kotlinx.serialization.Serializable

@Serializable
data class ExportedBlock(
  val type: String
)
