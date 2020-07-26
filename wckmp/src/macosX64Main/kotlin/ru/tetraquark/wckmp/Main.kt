package ru.tetraquark.wckmp

fun main(args: Array<String>) {
    val resultList = multithreadLinesCounter(args.asList())

    println("------------------------------------")

    resultList.forEach(::printFileLinesCount)
}
