package ru.tetraquark.wckmp

import java.util.concurrent.Callable
import java.util.concurrent.Executors

actual fun multithreadLinesCounter(fileNames: List<String>, wc: Wc): List<Pair<String, Int?>> {
    if (fileNames.isEmpty()) return emptyList()

    val executor = Executors.newFixedThreadPool(fileNames.size)

    return fileNames.asSequence().map { fileName ->
        fileName to executor.submit(Callable {
            wc.linesCount(fileName)
        })
    }.map { pair ->
        runCatching {
            pair.second.get()
        }.fold(
            onSuccess = { pair.first to it },
            onFailure = { pair.first to null }
        )
    }.toList().also {
        executor.shutdown()
    }
}
