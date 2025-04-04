package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics

fun main() {
    val text = "hello world"
    println(text.alter())
    calculateTimeAndRun { loops(100000000) }
}

fun String.alter(): String {
    return this.toUpperCase()
}

fun loops(n: Long) {
    for (i in 1..n) {

    }
}

fun calculateTimeAndRun(fn: () -> Unit) {
    val start = System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("time taken = ${end - start} ms")
}