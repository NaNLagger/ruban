package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter

/**
 * Created by lyashenko_se on 19.09.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("king2.in")
    val c = reader.readLines().map { it.split(" ").map { try { it.toInt() } catch (e: Exception) {0} }.toTypedArray() }.toTypedArray()
    reader.close()

    val writer = FileWriter("king2.out")
    val lad = king(c)
    writer.write(lad.toString())
    writer.close()
}

fun king(c: Array<Array<Int>>): Int {
    c.reverse()
    val f = Array(c.size) { Array<Int>(c.size, {0}) }
    for (i in 0..f.size - 1)
        for (j in 0..f.size - 1) {
            var arr = arrayOf<Int>()
            if(i - 1 >= 0) arr += f[i - 1][j]
            if(j - 1 >= 0) arr += f[i][j - 1]
            if(i - 1 >= 0 && j - 1 >= 0) arr += f[i - 1][j - 1]
            f[i][j] = if(arr.min() == null) f[i][j] else arr.min()!! + c[i][j]
        }
    return f.last().last()
}

fun king2(c: Array<Array<Int>>): Int {
    val f = Array(c.size) { Array<Int>(c.size, {0}) }
    for (i in (0..f.size - 1).reversed())
        for (j in 0..f.size - 1) {
            var arr = arrayOf<Int>()
            if(i + 1 < f.size) arr += f[i + 1][j]
            if(j - 1 >= 0) arr += f[i][j - 1]
            if(i + 1< f.size && j - 1 >= 0) arr += f[i + 1][j - 1]
            f[i][j] = if(i == f.size - 1 && j == 0) f[i][j] else arr.min()!! + c[i][j]
        }
    return f.first().last()
}