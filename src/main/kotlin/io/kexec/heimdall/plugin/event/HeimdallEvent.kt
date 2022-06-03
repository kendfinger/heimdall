package io.kexec.heimdall.plugin.event

import org.jetbrains.exposed.sql.Transaction

abstract class HeimdallEvent {
  abstract fun store(transaction: Transaction)
}
