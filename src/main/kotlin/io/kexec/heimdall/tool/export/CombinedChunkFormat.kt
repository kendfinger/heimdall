package io.kexec.heimdall.tool.export

import io.kexec.heimdall.tool.state.BlockExpanse
import io.kexec.heimdall.tool.state.SparseBlockStateMap
import kotlinx.serialization.Serializable

@Serializable
class CombinedChunkFormat(
  val expanse: BlockExpanse,
  val map: SparseBlockStateMap
)
