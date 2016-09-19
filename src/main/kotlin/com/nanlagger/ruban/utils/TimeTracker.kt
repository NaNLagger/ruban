package com.nanlagger.ruban.utils

/**
 * Created by admin on 11.09.2016.
 */
object TimeTracker {
    private var startTime: Long = System.nanoTime()

    fun print() {
        val time = System.nanoTime() - startTime
        println("Время выполнения: ${time / 1000000} ms ${time % 1000000} ns")
    }

    fun start() {
        startTime = System.nanoTime()
    }

    fun get() = (System.nanoTime() - startTime) / 1000000
}