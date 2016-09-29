package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter

/**
 * Created by lyashenko_se on 29.09.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("bag.in")
    val elems = reader.readLines().map {
        var array = it.split(" ").map { it.toInt() }
        Elem(array[0], array[1], array[2])
    }.toTypedArray()
    reader.close()

    val writer = FileWriter("bag.out")
    writer.close()
}


class Elem(val m: Int, val c: Int, val num: Int)