package io.kexec.heimdall.tool.commands

import io.kexec.heimdall.tool.util.saveJpegFile
import io.kexec.heimdall.tool.util.savePngFile
import java.awt.image.BufferedImage

enum class ImageFormatType(val id: String, val extension: String, val save: (BufferedImage, String) -> Unit) {
  Png("png", "png", { image, path -> image.savePngFile(path) }),
  Jpeg("jpeg", "jpg", { image, path -> image.saveJpegFile(path) })
}
