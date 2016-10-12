package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by lyashenko_se on 12.10.2016.
 */
fun main(args: Array<String>) {
    val reader = FileReader("forest.in")
    val lines = reader.readLines()
    val v = lines[0].split(" ").map { it.toInt() }.toTypedArray()
    val a = lines[1].toDouble()
    reader.close()

    val writer = FileWriter("forest.out")
    writer.write(forest(v[0],v[1],a).toString())
    writer.close()
}

fun forest(vp: Int, vf: Int, a: Double): Double {
    val f = {
        x: Double ->
        var aKat = BigDecimal(1 - a)
        var bKat = BigDecimal(x)
        val sp = sqrt(aKat.multiply(aKat).plus(bKat.multiply(bKat)), 30) //Math.sqrt((1 - a) * (1 - a) + x*x)
        aKat = BigDecimal(a)
        bKat = BigDecimal(1 - x)
        val sf = sqrt(aKat.multiply(aKat).plus(bKat.multiply(bKat)), 30)
        sp.divide(BigDecimal(vp), 30, RoundingMode.HALF_UP).plus(sf.divide(BigDecimal(vf), 30, RoundingMode.HALF_UP))
    }
    return searchMin(f, 0.0, 1.0, 0.00000000000001)
}

fun searchMin(f: (Double) -> BigDecimal, left: Double, right: Double, e: Double): Double {
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
        println("${(a + b) / 2} -> ${f((a + b) / 2)}")
    }
    return (a + b) / 2
}

fun sqrt(A: BigDecimal, SCALE: Int): BigDecimal {
    var x0 = BigDecimal("0")
    var x1 = BigDecimal(Math.sqrt(A.toDouble()))
    while (!x0.equals(x1)) {
        x0 = x1
        x1 = A.divide(x0, SCALE, BigDecimal.ROUND_HALF_UP)
        x1 = x1.add(x0)
        x1 = x1.divide(BigDecimal.valueOf(2), SCALE, BigDecimal.ROUND_HALF_UP)

    }
    return x1
}