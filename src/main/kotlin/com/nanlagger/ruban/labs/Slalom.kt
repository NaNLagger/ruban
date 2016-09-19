package com.nanlagger.ruban.labs

/**
 * Created by lyashenko_se on 19.09.2016.
 */

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val arr = Array(n) { i ->  Array<Int>(i + 1, {0}) }
    for (i in 0..n-1) {
        arr[i] = readLine()!!.split(" ").map { try {it.toInt()} catch (e: Exception) {0} }.toTypedArray()
    }
    print(slalom(arr))
}

fun slalom(c: Array<Array<Int>>): Int {
    val f = Array(c.size) { i -> Array<Int>(i + 1, {0}) }
    for (i in 0..f.size - 1)
        for (j in 0..f[i].size - 1) {
            var arr = arrayOf<Int>()
            try { arr += f[i - 1][j] } catch (e: IndexOutOfBoundsException) { }
            try { arr += f[i - 1][j - 1] } catch (e: IndexOutOfBoundsException) { }
            f[i][j] = if(arr.min() == null) c[i][j] else arr.max()!! + c[i][j]
        }
    return f.last().max()!!
}