package io.kexec.heimdall.plugin.buffer

import io.kexec.heimdall.plugin.event.HeimdallEvent
import org.jetbrains.exposed.sql.Transaction

class EventBuffer {
  private var events = mutableListOf<HeimdallEvent>()

  fun flush(transaction: Transaction): Long {
    val referenceOfEvents = events
    this.events = mutableListOf()
    var count = 0L
    while (referenceOfEvents.isNotEmpty()) {
      val event = referenceOfEvents.removeAt(0)
      event.store(transaction)
      count++
    }
    return count
  }

  fun push(event: HeimdallEvent) {
    events.add(event)
  }

  fun clear() {
    events = mutableListOf()
  }
}
