package com.nanlagger.ruban.labs

import com.nanlagger.ruban.utils.TimeTracker
import java.util.*

/**
 * Created by lyashenko_se on 19.09.2016.
 */

val mLvl = HashMap<Int, Int>()
val f = Array<Int>(300001, {0})

fun main(args: Array<String>) {
    val n = Integer.valueOf(readLine())
    val arr = Array<Int>(n, {0})
    for (i in 0..n - 1) {
        val s = readLine()
        arr[i] = try { Integer.valueOf(s) } catch (e: Exception) {
            0
        }
    }
    for (w in arr)
        println(balls(w))
}

//fun main(args: Array<String>) {
//    TimeTracker.start()
//    for(i in 0..300000)
//        balls(i)
//        //println(balls(i))
//    TimeTracker.print()
//}

fun balls(n: Int): Int {
    if(f[n] != 0)
        return f[n]
    //var j = 1
    for(i in 0..n) {
        if (f[i] != 0)
            continue
        var min = Int.MAX_VALUE
        var j = 1
        var lvlValue = lvl(j)
        while (i - lvlValue >= 0) {
            min = if(f[i - lvlValue] <= min)  f[i - lvlValue] else min
            j++
            lvlValue = lvl(j)
        }
        f[i] = if(i == 0) f[i] else min + 1
    }
    return f[n]
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