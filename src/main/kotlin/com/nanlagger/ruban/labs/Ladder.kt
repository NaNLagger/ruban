package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter


/**
 * Created by lyashenko_se on 19.09.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("ladder.in")
    val lines = reader.readLines()
    val c = lines[1].split(" ").map { it.toInt() }
    reader.close()

    val writer = FileWriter("ladder.out")
    val lad = ladder(c.toTypedArray())
    writer.write(lad.toString())
    writer.close()
}

fun ladder(c: Array<Int>): Int {
    val f = Array<Int>(
            c.size,
            { j -> 0 }
    )
    for(i in 0..f.size - 1) {
        f[i] = (if(i < 1) f[i] else max(f[i - 1], if(i < 2) 0 else f[i - 2])) + c[i]
    }
    return f.last()
}

fun max(vararg a: Int): Int {
    return a.max()!!
}