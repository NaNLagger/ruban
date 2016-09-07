package com.nanlagger.ruban

import com.nanlagger.ruban.labs.Lab1

/**
 * Created by admin on 04.09.2016.
 */
fun main(args: Array<String>) {
    val f = {x: Float -> 4*x*x + 2*x + 4}
    println(String.format("%.2f", Lab1.searchMin(f, -10f, 10f, 0.001f)))
}