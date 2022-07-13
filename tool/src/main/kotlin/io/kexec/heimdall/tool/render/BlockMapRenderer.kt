package io.kexec.heimdall.tool.render

import io.kexec.heimdall.tool.state.BlockStateMap
import io.kexec.heimdall.tool.state.ChangelogSlice

interface BlockMapRenderer<T> {
  fun render(slice: ChangelogSlice, map: BlockStateMap): T
}
