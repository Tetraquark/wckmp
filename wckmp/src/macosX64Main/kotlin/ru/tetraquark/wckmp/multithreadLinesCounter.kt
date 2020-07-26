package ru.tetraquark.wckmp

import kotlin.native.concurrent.TransferMode
import kotlin.native.concurrent.Worker
import kotlin.native.concurrent.freeze

actual fun multithreadLinesCounter(fileNames: List<String>, wc: Wc): List<Pair<String, Int?>> {
    if (fileNames.isEmpty()) return emptyList()

    wc.freeze()

    return fileNames.asSequence()
        .map {
            it to Worker.start(false)
        }.map { pair ->
            pair.second.execute(
                mode = TransferMode.SAFE,
                producer = { pair.first to wc },
                job = { it.second.linesCount(it.first) }
            ).consume {
                pair.first to it
            }
        }.toList()
}
