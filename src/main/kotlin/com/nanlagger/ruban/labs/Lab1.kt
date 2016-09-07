package com.nanlagger.ruban.labs

/**
 * Created by admin on 04.09.2016.
 */
object Lab1 {
    val fi = (1f + Math.sqrt(5.0).toFloat()) / 2f

    fun searchMin(f: (Float) -> Float, left: Float, right: Float, e: Float): Float {
        var a = left
        var b = right
        var x1 = b - (b - a) / fi
        var x2 = a + (b - a) / fi
        while (Math.abs(b - a) > e) {
            if(f(x1) >= f(x2)) {
                a = x1
                x1 = x2
                x2 = a + (b - a) / fi
            } else {
                b = x2
                x2 = x1
                x1 = b - (b - a) / fi
            }
        }
        return (a + b) / 2
    }
}