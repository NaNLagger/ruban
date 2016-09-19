package com.nanlagger.ruban

import com.nanlagger.ruban.labs.Lab1
import com.nanlagger.ruban.utils.TimeTracker

/**
 * Created by admin on 04.09.2016.
 */
fun main(args: Array<String>) {
    val f = {x: Double -> x*x - 2*x - 4}
    val f2 = {x: Double, y: Double -> 4*x*x+5*x+3*x*y+4*y+y*y}
    val f3 = {x: Double, y: Double -> x*x - x*y + y*y - 4*x + 3*y}
    val f4 = {x: Double, y: Double -> (x*x - y)*(x*x - y) + (y - 0.7f)*(y - 0.7f)}
    var res: Double
    var res2: Pair<Double, Double>

//    TimeTracker.start()
//    res = Lab1.searchMin(f, -10f, 10f, 0.000001f)
//    TimeTracker.print()
//    println(res)
//
//    TimeTracker.start()
//    res = Lab1.searchMinUpgrade(f, -10f, 10f, 0.000001f)
//    TimeTracker.print()
//    println(res)
//
//    TimeTracker.start()
//    res2 = Lab1.searchMin(f2, -10f, 10f, 0.000001f)
//    TimeTracker.print()
//    println(res2)
//
//    TimeTracker.start()
//    res2 = Lab1.searchMinUpgrade(f2, -10f, 10f, 0.000001f)
//    TimeTracker.print()
//    println(res2)

    TimeTracker.start()
    res2 = Lab1.searchMinUpgrade(f3, -10.0, 10.0, 0.000001)
    TimeTracker.print()
    println(String.format("%.6f, %.6f", res2.first, res2.second))
    println(String.format("%.6f", f3(res2.first, res2.second)))

    TimeTracker.start()
    res2 = Lab1.searchMinUpgrade(f4, -10.0, 10.0, 0.000001)
    TimeTracker.print()
    println(String.format("%.6f, %.6f", res2.first, res2.second))
    println(String.format("%.6f", f4(res2.first, res2.second)))
}