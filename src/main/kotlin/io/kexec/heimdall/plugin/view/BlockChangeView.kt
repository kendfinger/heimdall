package io.kexec.heimdall.plugin.view

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp

object BlockChangeView : Table("block_changes") {
  val isBreak = bool("break")
  val time = timestamp("time")
  val player = uuid("player")
  val world = uuid("world")
  val x = double("x")
  val y = double("y")
  val z = double("z")
  val pitch = double("pitch")
  val yaw = double("yaw")
  val block = text("block")
}
