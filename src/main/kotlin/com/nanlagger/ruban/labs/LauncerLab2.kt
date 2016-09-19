package com.nanlagger.ruban.labs

import com.nanlagger.ruban.utils.TimeTracker

/**
 * Created by admin on 11.09.2016.
 */
fun main(args: Array<String>) {
    val f3 = { args: Array<Double> -> val x = args[0]; val y = args[1]; x * x - x * y + y * y - 4 * x + 3 * y }
    val gx = { args: Array<Double> -> val x = args[0]; val y = args[1]; 2*x - y - 4}
    val gy = { args: Array<Double> -> val x = args[0]; val y = args[1]; -x + 2*y + 3}
    val f4 = { args: Array<Double> -> val x = args[0]; val y = args[1]; (x*x - y)*(x*x - y) + (y - 0.7f)*(y - 0.7f) }
    val gx1 = { args: Array<Double> -> val x = args[0]; val y = args[1]; 4 * x * (x * x - y)}
    val gy1 = { args: Array<Double> -> val x = args[0]; val y = args[1]; 2 * (x * x - y) + 2 * (y - 0.7f)}

    var res = Lab2.gradient(f3, arrayOf(gx, gy), arrayOf(0.0, 0.0), 0.000001)
    var y = f3(res)
    println(res.joinToString(",","(",")"))
    println(y)

    res = Lab2.gradient(f4, arrayOf(gx1, gy1), arrayOf(-10.0, 10.0), 0.000001)
    y = f4(res)
    println(res.joinToString(",","(",")"))
    println(String.format("%.5f", y))
}