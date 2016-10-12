package com.nanlagger.ruban.labs

/**
 * Created by admin on 08.10.2016.
 */

fun main(args: Array<String>) {
    val first = readLine()
    val second = readLine()
    val s = first!!.split(" ")[0].toInt()
    val elems = second!!.split(" ").map { it.toInt() }.toTypedArray()

    print(knapsack(s, elems).toString())
}

fun knapsack(s: Int, elems: Array<Int>): Int {
    val dp = Array(elems.size, { Array (s + 1, {0})})
    for (k in 0..elems.size - 1) {
        for (x in 0..s) {
            dp[k][x] = max1(
                    if(k - 1 < 0) 0 else dp[k - 1][x],
                    if(x - elems[k] < 0) 0 else ( (if(k-1 < 0) 0 else dp[k-1][x - elems[k]]) + elems[k])
            )
        }
    }
    return dp.last().last()
}

fun max1(vararg a: Int): Int {
    return a.max()!!
}