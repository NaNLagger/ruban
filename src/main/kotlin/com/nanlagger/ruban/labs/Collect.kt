package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter

/**
 * Created by admin on 08.10.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("collect.in")
    val lines = reader.readLines()
    val collect = lines[1].split(" ").map { it.toInt() }.toTypedArray()
    val keys = lines[3].split(" ").map { it.toInt() }.toTypedArray()
    reader.close()

    val writer = FileWriter("collect.out")
    for(i in keys)
        writer.write(if(searchBin(collect, i)) "YES\n" else "NO\n")
    writer.close()
}

fun searchBin(data: Array<Int>, x: Int): Boolean {
    var l = 0
    var r = data.size
    while (r != l) {
        val i = l + (r - l) / 2
        if (data[i] == x)
            return true
        else if (data[i] > x)
            r = i
        else
            l = i + 1
    }
    return false
}