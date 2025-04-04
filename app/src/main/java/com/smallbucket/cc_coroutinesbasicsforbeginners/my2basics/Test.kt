package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import kotlin.math.pow


@Composable
fun Test(modifier: PaddingValues) {
//    overloadingFunctionsKotlin()
    arraysConcept()

}

fun arraysConcept() {
    val nums = arrayOf("One", "two", "three")
    val arr1 = arrayOf(1, 2, 3) // Implicit
    val arr2 = arrayOf<Int>(3, 4, 5) // Explicit

    for (i in arr1) {
        println(APP_TAG + i)
    }
    for ((i, e) in nums.withIndex()) {
        println(APP_TAG + "$i - $e")
    }
    println(APP_TAG + nums[0])                   // One
    println(APP_TAG + nums.get(0))               // One
    println(APP_TAG + nums.set(2, "TWO"))          // kotlin.Unit
    println(APP_TAG + nums.get(2))               // TWO
    println(APP_TAG + nums.size)                   //3
//    println(APP_TAG + nums[3]) // App crash, ArrayIndexOutOfBoundsException
    println(APP_TAG + nums.asList())
}

fun overloadingFunctionsKotlin() {
    //    println(APP_TAG+" Sum is = "+addition(3, 4))
//    println(APP_TAG+" Sum is = "+addition(3.0,4.0))
    val fn = ::additionOfTwo
    println(APP_TAG + fn(2, 3))
    println(APP_TAG + power(2.0, 3.0))
}

fun additionOfTwo(a: Int, b: Int) = a + b
fun addition(a: Int, b: Int) = a + b
fun addition(a: Double, b: Double) = a + b

fun power(a: Double, b: Double): Double {
    return a.pow(b)
}