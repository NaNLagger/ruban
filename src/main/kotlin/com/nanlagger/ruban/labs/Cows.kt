package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter

/**
 * Created by lyashenko_se on 12.10.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("cows.in")
    val lines = reader.readLines()
    val n = lines[0].split(" ").map { it.toInt() }.toTypedArray()
    val arr = lines[1].split(" ").map { it.toInt() }.toTypedArray()
    reader.close()

    val writer = FileWriter("cows.out")
    writer.write(cows(n[1], arr).toString())
    writer.close()
}

fun cows(n: Int, arr: Array<Int>): Int {
    var l = arr[0]
    var r = arr.last() / n
    var max = 0
    while (r != l) {
        val i = l + (r - l) / 2
        val tempMax = data(arr, i, n)
        if (tempMax > Int.MIN_VALUE) {
            l = i + 1
            max = tempMax
        } else
            r = i
    }
    return max
}

fun data(arr: Array<Int>, len: Int, count: Int): Int {
    var indexLast = 0
    var z = 1
    var min = Int.MAX_VALUE
    for (i in 1..arr.size - 1) {
        val temp = arr[i] - arr[indexLast]
        if (temp >= len) {
            if(min > temp)
                min = temp
            indexLast = i
            z++
        }
    }
    if (count > z)
        return Int.MIN_VALUE
    return min
}
