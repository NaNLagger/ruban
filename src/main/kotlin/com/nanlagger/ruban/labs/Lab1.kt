package com.nanlagger.ruban.labs

/**
 * Created by admin on 04.09.2016.
 */
object Lab1 {
    val fi = (1f + Math.sqrt(5.0).toFloat()) / 2f

    fun searchMinUpgrade(f: (Float) -> Float, left: Float, right: Float, e: Float): Float {
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

    fun searchMin(f: (Float) -> Float, left: Float, right: Float, e: Float): Float {
        var a = left
        var b = right
        while (Math.abs(b - a) > e) {
            val x1 = a + (b - a) / 3
            val x2 = b - (b - a) / 3
            if(f(x1) >= f(x2)) {
                a = x1
            } else {
                b = x2
            }
        }
        return (a + b) / 2
    }

    fun searchMin(f: (Float, Float) -> Float, left: Float, right: Float, e: Float): Pair<Float, Float> {
        var a = left
        var b = right
        while (Math.abs(b - a) > e) {
            val x1 = a + (b - a) / 3
            val x2 = b - (b - a) / 3
            val y1 = searchMin({y: Float -> f(x1, y)}, left, right, e)
            val y2 = searchMin({y: Float -> f(x2, y)}, left, right, e)
            if(f(x1, y1) >= f(x2, y2)) {
                a = x1
            } else {
                b = x2
            }
        }
        return Pair((a + b) / 2, searchMin({y: Float -> f((a + b) / 2, y)}, left, right, e))
    }

    fun searchMinUpgrade(f: (Float, Float) -> Float, left: Float, right: Float, e: Float): Pair<Float, Float> {
        var a = left
        var b = right
        var x1 = b - (b - a) / fi
        var x2 = a + (b - a) / fi
        while (Math.abs(b - a) > e) {
            val y1 = searchMinUpgrade({y: Float -> f(x1, y)}, left, right, e)
            val y2 = searchMinUpgrade({y: Float -> f(x2, y)}, left, right, e)
            if(f(x1, y1) >= f(x2, y2)) {
                a = x1
                x1 = x2
                x2 = a + (b - a) / fi
            } else {
                b = x2
                x2 = x1
                x1 = b - (b - a) / fi
            }
        }
        return Pair((a + b) / 2, searchMin({y: Float -> f((a + b) / 2, y)}, left, right, e))
    }
}