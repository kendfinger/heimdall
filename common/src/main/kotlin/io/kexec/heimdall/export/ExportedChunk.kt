package io.kexec.heimdall.export

import kotlinx.serialization.Serializable

@Serializable
data class ExportedChunk(
  val x: Int,
  val z: Int,
  val sections: List<ExportedChunkSection>
)
