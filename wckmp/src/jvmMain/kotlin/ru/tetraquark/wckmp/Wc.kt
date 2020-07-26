package ru.tetraquark.wckmp

import java.io.File
import java.io.IOException

actual class Wc {

    actual fun linesCount(fileName: String): Int? {
        return try {
            File(fileName).readLines().size
        } catch (ioCause: IOException) {
            return null
        }
    }
}
