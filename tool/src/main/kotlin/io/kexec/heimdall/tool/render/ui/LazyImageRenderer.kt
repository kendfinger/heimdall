package io.kexec.heimdall.tool.render.ui

import io.kexec.heimdall.tool.render.BlockImageRenderer
import io.kexec.heimdall.tool.state.BlockStateMap
import io.kexec.heimdall.tool.state.ChangelogSlice
import java.awt.Graphics
import javax.swing.JComponent

class LazyImageRenderer(val map: BlockStateMap, private val renderer: BlockImageRenderer) : JComponent() {
  private val image by lazy {
    renderer.render(ChangelogSlice.none, map)
  }

  override fun paint(g: Graphics?) {
    g?.drawImage(image, 0, 0, this)
  }

  override fun paintComponent(g: Graphics?) {
    g?.drawImage(image, 0, 0, this)
  }
}
