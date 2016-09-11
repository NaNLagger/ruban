package com.nanlagger.ruban.labs

import com.nanlagger.ruban.utils.TimeTracker

/**
 * Created by admin on 11.09.2016.
 */
fun main(args: Array<String>) {
    val f3 = { args: Array<Float> -> val x = args[0]; val y = args[1]; x * x + x * y + y * y - 4 * x + 3 * y }
    val gx = { args: Array<Float> -> val x = args[0]; val y = args[1]; 2*x + y - 4}
    val gy = { args: Array<Float> -> val x = args[0]; val y = args[1]; x + 2*y + 3}

    TimeTracker.start()
    val res = Lab2.gradient(f3, arrayOf(gx, gy), arrayOf(0f, 0f), 0.01f)
    TimeTracker.print()
    println(res.joinToString(",","(",")"))
}