package io.kexec.heimdall.export

import kotlinx.serialization.Serializable

@Serializable
data class ExportedBlock(
  val type: String
)
