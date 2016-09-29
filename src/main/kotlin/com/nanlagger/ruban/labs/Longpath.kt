package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter
import java.util.*

/**
 * Created by lyashenko_se on 22.09.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("longpath.in")
    val lines = reader.readLines()
    val size = lines.first().split(" ").map { it.toInt() }
    val entity = HashMap<Int, ArrayList<Int>>()
    for(i in 1..lines.size-1) {
        val temp = lines[i].split(" ").map { try {it.toInt()} catch (e: Exception) {0} }
        if(!entity.containsKey(temp[1]))
            entity[temp[1]] = ArrayList()
        entity[temp[1]]!! += temp[0]
    }
    reader.close()

    val writer = FileWriter("longpath.out")
    val lad = try {longpath(entity)} catch (e: ArrayIndexOutOfBoundsException) { 0 }
    writer.write(lad.toString())
    writer.close()
}

fun longpath(entity: HashMap<Int, ArrayList<Int>>): Int {
    val f = Array<Int>(100001, {0})
    for(i in 1..f.size - 1) {
        f[i] = if(!entity.containsKey(i)) 0 else entity[i]!!.map { f[it] }.max()!! + 1
    }
    return f.max()!!
}