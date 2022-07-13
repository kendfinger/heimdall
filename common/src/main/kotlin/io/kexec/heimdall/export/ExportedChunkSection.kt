package io.kexec.heimdall.export

import kotlinx.serialization.Serializable

@Serializable
data class ExportedChunkSection(
  val x: Int,
  val z: Int,
  val blocks: List<ExportedBlock>
)
