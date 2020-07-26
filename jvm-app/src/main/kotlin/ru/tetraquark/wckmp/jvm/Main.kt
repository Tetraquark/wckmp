package ru.tetraquark.wckmp.jvm

import ru.tetraquark.wckmp.multithreadLinesCounter
import ru.tetraquark.wckmp.printFileLinesCount

fun main(args: Array<String>) {
    val resultList = multithreadLinesCounter(args.asList())

    println("------------------------------------")

    resultList.forEach(::printFileLinesCount)
}
