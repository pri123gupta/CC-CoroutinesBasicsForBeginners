package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics

import kotlin.math.pow

fun main() {
    var fn: (a: Double, b: Double) -> Double = ::sum      // Assign functions to variables
    val pow: (a: Double, b: Double) -> Double = ::powerOf
    // fn = pow    // same data type

    //var gn: (a: Double, b: Double) -> Double = ::pow
    //  fn = hello("test")      // type mismatch compile time error
    println(fn(2.0, 3.0)) // 5.0
    println(pow(2.0, 3.0)) //8.0
    calculator(2.0, 3.0, ::sum) //5.0
}

fun sum(a: Double, b: Double) = a + b
fun powerOf(a: Double, b: Double): Double = a.pow(b)
fun hello(a: String): Unit = println("hello")

fun calculator(a: Double, b: Double, gn: (Double, Double) -> Double) {
    val result = gn(a, b)
    println(result)
}