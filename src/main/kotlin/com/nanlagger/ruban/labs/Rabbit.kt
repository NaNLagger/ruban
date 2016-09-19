package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter

/**
 * Created by lyashenko_se on 19.09.2016.
 */
fun main(args: Array<String>) {
    val reader = FileReader("lepus.in")
    val lines = reader.readLines()
    val c = lines[1].map {
        when(it) {
            'w' -> -2000
            '.' -> 0
            else -> 1
        }
    }
    reader.close()

    val writer = FileWriter("lepus.out")
    val lad = rabbit(c.toTypedArray())
    writer.write(if(lad < 0) (-1).toString() else lad.toString())
    writer.close()
}

fun rabbit(c: Array<Int>): Int {
    val f = Array<Int>(
            c.size,
            { i -> 0 }
    )
    for(i in 0..f.size - 1) {
        var arr = arrayOf<Int>()
        if(i - 1 >= 0) arr += f[i - 1]
        if(i - 3 >= 0) arr += f[i - 3]
        if(i - 5 >= 0) arr += f[i - 5]
        f[i] = if(i < 1) f[i] else arr.max()!! + c[i]
    }
    return f.last()
}
