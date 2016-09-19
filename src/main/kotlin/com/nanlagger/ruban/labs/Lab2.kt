package com.nanlagger.ruban.labs

import java.util.*

/**
 * Created by admin on 10.09.2016.
 */
object Lab2 {

    fun gradient(f: (Array<Double>) -> Double, g: Array<(Array<Double>) -> Double>, x0: Array<Double>, e: Double): Array<Double> {
        var x: Array<Double>
        var x1 = x0
        var len: Double
        var p = 0
        do {
            p+=1
            x = x1
            val grad = gradFunc(g, x)
            println("p: $p -> x: ${x.joinToString(",", "(", ")")} | grad: ${grad.joinToString(",", "(", ")")}")
            val h = {
                t: Double ->
                x1 = arrayOf<Double>()
                for (i in 0..(x.size - 1)) {
                    x1 += x[i] - t * grad[i]
                }
                f(x1)
            }
            val min_t = Lab1.searchMinUpgrade(h, -10.0, 10.0, e * 0.00001)
            len = Math.sqrt(x.mapIndexed { i, fl -> fl - x1[i] }.fold(0.0, { sum, x -> sum + x*x}).toDouble())
        } while (len > e)
        return x1
    }

    fun gradFunc(g: Array<(Array<Double>) -> Double>, x: Array<Double>): Array<Double> {
        val res = ArrayList<Double>()
        for (gx in g) {
            res += gx(x)
        }
        return res.toTypedArray()
    }
}