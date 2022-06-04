package io.kexec.heimdall.tool

import io.kexec.heimdall.tool.commands.BlockChangeTimelapseCommand
import io.kexec.heimdall.tool.commands.ChunkExportLoaderCommand
import io.kexec.heimdall.tool.commands.PlayerPositionExport
import io.kexec.heimdall.tool.commands.PlayerSessionExport
import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) = GjallarhornCommand().subcommands(
  BlockChangeTimelapseCommand(),
  PlayerSessionExport(),
  PlayerPositionExport(),
  ChunkExportLoaderCommand()
).main(args)
