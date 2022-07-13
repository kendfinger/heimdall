package io.kexec.heimdall.tool.commands

import io.kexec.heimdall.tool.render.*
import io.kexec.heimdall.tool.state.BlockExpanse
import org.jetbrains.exposed.sql.Database

@Suppress("unused")
enum class ImageRenderType(
  val id: String,
  val createNewRenderer: (BlockExpanse, Database) -> BlockImageRenderer
) {
  BlockDiversity("block-diversity", { expanse, _ -> BlockDiversityRenderer(expanse) }),
  HeightMap("height-map", { expanse, _ -> BlockHeightMapRenderer(expanse) }),
  PlayerPosition("player-position", { expanse, db -> PlayerLocationShareRenderer(expanse, db) }),
  GraphicalSession("graphical", { expanse, _ -> LaunchGraphicalRenderSession(expanse) })
}
