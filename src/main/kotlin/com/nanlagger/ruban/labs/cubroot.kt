package com.nanlagger.ruban.labs

import java.io.FileReader
import java.io.FileWriter
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

/**
 * Created by lyashenko_se on 13.10.2016.
 */

fun main(args: Array<String>) {
    val reader = FileReader("cubroot.in")
    val lines = reader.readLines()
    val n = lines.first().split(" ").map { try { it.toInt() } catch (e: Exception) { 0 } }.toTypedArray()
    val f = funcx3(n[0], n[1], n[2], n[3])
    val g = funcdx(n[0], n[1], n[2])
    reader.close()

    val writer = FileWriter("cubroot.out")
    writer.write(method(f, g, -1000.0, 0.00000000001).toString())
    writer.close()
}

fun method(f: (Double) -> BigDecimal, fdx: (Double) -> BigDecimal, start: Double, e: Double): Double {
    var x0 = start
    var x1 = try { x0 - f(x0).divide(fdx(x0), 30, RoundingMode.HALF_UP).toDouble() } catch (e: ArithmeticException) { x0 }
    while (Math.abs(x1 - x0) > e) {
        x0 = x1
        x1 = x0 - f(x0).divide(fdx(x0), 30, RoundingMode.HALF_UP).toDouble()
    }
    return x1
}

fun funcx3(a: Int, b: Int, c: Int, d: Int): (Double) -> BigDecimal {
    val bigA = BigDecimal(a)
    val bigB = BigDecimal(b)
    val bigC = BigDecimal(c)
    val bigD = BigDecimal(d)
    return {
        x: Double ->
        val bigX = BigDecimal(x)
        bigA * bigX.pow(3) + bigB * bigX.pow(2) + bigC * bigX + bigD
    }
}

fun funcdx(a: Int, b: Int, c: Int): (Double) -> BigDecimal {
    val bigA = BigDecimal(a)
    val bigB = BigDecimal(b)
    val bigC = BigDecimal(c)
    return {
        x: Double ->
        val bigX = BigDecimal(x)
        BigDecimal(3) * bigA * bigX.pow(2) + BigDecimal(2) * bigB * bigX + bigC
    }
}

fun method2(f: (Double) -> Double, fdx: (Double) -> Double, start: Double, e: Double): Double {
    var x0 = start
    var x1 = x0 - f(x0)/fdx(x0)
    while (Math.abs(x1 - x0) > e) {
        x0 = x1
        x1 = x0 - f(x0)/fdx(x0)
    }
    return x1
}

fun fx(a: Int, b: Int, c: Int, d: Int): (Double) -> Double {
    return {
        x: Double ->
        a*x*x*x + b*x*x + c*x + d
    }
}

fun fxdx(a: Int, b: Int, c: Int): (Double) -> Double {
    return {
        x: Double ->
        3*a*x*x + 2*b*x + c
    }
}