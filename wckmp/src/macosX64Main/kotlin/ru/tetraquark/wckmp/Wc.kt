package ru.tetraquark.wckmp

import platform.posix.*

actual class Wc {

    actual fun linesCount(fileName: String): Int? {
        return fopen(fileName, "r")?.let { fp ->
            var lines = 0
            while (feof(fp) == 0) {
                if (fgetc(fp) == '\n'.toInt()) lines++
            }
            fclose(fp)
            lines
        }
    }
}
