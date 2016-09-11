package com.nanlagger.ruban.labs

import java.util.*

/**
 * Created by admin on 10.09.2016.
 */
object Lab2 {

    fun gradient(f: (Array<Float>) -> Float, g: Array<(Array<Float>) -> Float>, x0: Array<Float>, e: Float): Array<Float> {
        var x: Array<Float>
        var x1 = x0
        var len: Float
        do {
            x = x1
            val grad = gradFunc(g, x)
            val h = {
                t: Float ->
                x1 = arrayOf<Float>()
                for (i in 0..(x.size - 1)) {
                    x1 += x[i] - t * grad[i]
                }
                f(x1)
            }
            val min_t = Lab1.searchMinUpgrade(h, -10f, 10f, e * 0.00001f)
            len = Math.sqrt(x.mapIndexed { i, fl -> fl - x1[i] }.fold(0f, { sum, x -> sum + x*x}).toDouble()).toFloat()
        } while (len > e)
        return x1
    }

    fun gradFunc(g: Array<(Array<Float>) -> Float>, x: Array<Float>): Array<Float> {
        val res = ArrayList<Float>()
        for (gx in g) {
            res += gx(x)
        }
        return res.toTypedArray()
    }
}