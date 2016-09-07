package com.nanlagger.ruban

import com.nanlagger.ruban.labs.Lab1

/**
 * Created by admin on 04.09.2016.
 */
fun main(args: Array<String>) {
    val f = {x: Float -> x*x - 2*x - 4}
    val f2 = {x: Float, y: Float -> 4*x*x+5*x+3*x*y+4*y+y*y}
    var res: Float
    var res2: Pair<Float, Float>

    TimeTracker.start()
    res = Lab1.searchMin(f, -10f, 10f, 0.000001f)
    TimeTracker.print()
    println(res)

    TimeTracker.start()
    res = Lab1.searchMinUpgrade(f, -10f, 10f, 0.000001f)
    TimeTracker.print()
    println(res)

    TimeTracker.start()
    res2 = Lab1.searchMin(f2, -10f, 10f, 0.000001f)
    TimeTracker.print()
    println(res2)

    TimeTracker.start()
    res2 = Lab1.searchMinUpgrade(f2, -10f, 10f, 0.000001f)
    TimeTracker.print()
    println(res2)
}

object TimeTracker {
    private var startTime: Long = System.nanoTime()

    fun print() {
        val time = System.nanoTime() - startTime
        println("Время выполнения: ${time / 1000000} ms ${time % 1000000} ns")
    }

    fun start() {
        startTime = System.nanoTime()
    }
}