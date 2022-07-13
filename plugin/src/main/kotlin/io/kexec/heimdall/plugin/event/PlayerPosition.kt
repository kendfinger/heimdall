package io.kexec.heimdall.plugin.event

import io.kexec.heimdall.table.PlayerPositionTable
import org.bukkit.Location
import org.bukkit.event.player.PlayerMoveEvent
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.insert
import java.time.Instant
import java.util.*

class PlayerPosition(
  val playerUniqueIdentity: UUID,
  val location: Location,
  val timestamp: Instant = Instant.now()
) : HeimdallEvent() {
  constructor(event: PlayerMoveEvent) : this(event.player.uniqueId, event.to)

  override fun store(transaction: Transaction) {
    transaction.apply {
      PlayerPositionTable.insert {
        it[time] = timestamp
        it[player] = playerUniqueIdentity
        it[world] = location.world.uid
        it[x] = location.x
        it[y] = location.y
        it[z] = location.z
        it[pitch] = location.pitch.toDouble()
        it[yaw] = location.yaw.toDouble()
      }
    }
  }
}
