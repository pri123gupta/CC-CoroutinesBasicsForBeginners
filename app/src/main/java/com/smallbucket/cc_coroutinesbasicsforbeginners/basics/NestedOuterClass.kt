package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

fun main() {
    var obj = Outer()
    obj.i
    val inner = Outer().Nested()
    inner.test()// I am in nested class 0
}

class Outer {
    var i = 0

    inner class Nested {
        fun test() {
            println("I am in nested class $i") // No compile time error
        }
    }
}