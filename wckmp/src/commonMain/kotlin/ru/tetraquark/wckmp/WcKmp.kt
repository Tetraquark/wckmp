package ru.tetraquark.wckmp

expect fun multithreadLinesCounter(
    fileNames: List<String>,
    wc: Wc = Wc()
): List<Pair<String, Int?>>

fun printFileLinesCount(fileLinesCount: Pair<String, Int?>) =
    println("${fileLinesCount.first} : ${fileLinesCount.second ?: "Error"}")
