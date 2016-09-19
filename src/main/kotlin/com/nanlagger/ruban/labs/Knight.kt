package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter

/**
 * Created by lyashenko_se on 19.09.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("knight.in")
    val lines = reader.readLines()
    val size = lines.first().split(" ").map { it.toInt() }
    reader.close()

    val writer = FileWriter("knight.out")
    val lad = knight(size[0], size[1])
    writer.write(lad.toString())
    writer.close()
}

fun knight(n: Int, m: Int): Int {
    val f = Array(n) { Array<Int>(m, {0}) }
    val sum = {i: Int, j: Int, g: Array<Array<Int>> ->
        val first = try { g[i - 2][j - 1] } catch (e: IndexOutOfBoundsException) { 0 }
        val second = try { g[i - 1][j - 2] } catch (e: IndexOutOfBoundsException) { 0 }
        first + second
    }
    for (i in 0..n-1)
        for (j in 0..m-1) {
            if(i == 0 && j == 0)
                f[i][j] = 1
            else
                f[i][j] = sum(i,j,f)
        }
    return f.last().last()
}