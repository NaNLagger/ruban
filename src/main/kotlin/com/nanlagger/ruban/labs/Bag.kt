package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter
import java.util.*

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
    writer.write(bag(30, elems).toString())
    writer.close()
}

fun bag(m: Int, elem: Array<Elem>): Int {
    val dp = Array(elem.size, { Array (m + 1, {0})})
    val vect = Array(elem.size, { Array (m + 1, {Array(elem.size, {0})})})
    for (k in 0..elem.size - 1) {
        for (x in 0..m) {
            val array = ArrayList<Int>()
            var max = 0
            var maxK = 0
            var maxX = 0
            var count = 0
            for (i in 0..elem[k].num) {
                val prev_k = k - 1
                val prev_x = x - i * elem[k].m
                if(prev_x < 0)
                    continue
                val res = (if(prev_k < 0) 0 else dp[prev_k][prev_x]) + i * elem[k].c
                if(max < res) {
                    max = res
                    maxK = prev_k
                    maxX = prev_x
                    count = i
                }
            }
            vect[k][x] = if (maxK < 0) Array(elem.size, { 0 }) else vect[maxK][maxX]
            vect[k][x][k] = count
            dp[k][x] = max

            println("${dp[k][x]} ${vect[k][x].joinToString(",")}")
        }
        println()
    }
    return dp.last().last()
}

class Elem(val m: Int, val c: Int, val num: Int)