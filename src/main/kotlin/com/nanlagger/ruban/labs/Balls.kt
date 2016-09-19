package com.nanlagger.ruban.labs

import com.nanlagger.ruban.utils.TimeTracker
import java.util.*

/**
 * Created by lyashenko_se on 19.09.2016.
 */

val mLvl = HashMap<Int, Int>()

fun main(args: Array<String>) {
    val n = Integer.valueOf(readLine())
    val arr = Array<Int>(n, {0})
    for (i in 0..n - 1)
        arr[i] = try { Integer.valueOf(readLine()) } catch (e: Exception) {0}
    for (w in arr)
        println(balls(w))
}

//fun main(args: Array<String>) {
//    var max = 0L
//    var maxW = 0
//    for (i in 0..10) {
//        val l = i * 10000
//        val r = (i+1) * 10000
//        for (w in l..r) {
//            TimeTracker.start()
//            balls(w)
//            //println("$w -> ${balls(w)} , ${TimeTracker.get()}")
//            if (max < TimeTracker.get()) {
//                max = TimeTracker.get()
//                maxW = w
//            }
//        }
//        println("Max: $max, $maxW")
//    }
//    println("Max: $max, $maxW")
//}

fun balls(n: Int): Int {
    val f = Array<Int>(n + 1, {0})
    for(i in 0..n) {
        var min = Int.MAX_VALUE
        var j = 1
        var lvlValue = lvl(j)
        while (i - lvlValue >= 0) {
            min = if(f[i - lvlValue] < min) f[i - lvlValue] else min
            j++
            lvlValue = lvl(j)
        }
        f[i] = if(i == 0) f[i] else min + 1
    }
    return f.last()
}

fun lvl(n: Int): Int {
    if(mLvl.containsKey(n))
        return mLvl[n]!!
    var sum = 0
    var res = 0
    for (i in 0..n) {
        sum += i
        res += sum
    }
    mLvl[n] = res
    return res
}