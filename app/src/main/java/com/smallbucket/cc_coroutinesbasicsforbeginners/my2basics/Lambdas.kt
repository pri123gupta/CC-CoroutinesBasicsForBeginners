package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics

fun main() {
    val fn: (a: Int, b: Int) -> Int = ::sum
    val lambda1: (Int, Int) -> Int = { x: Int, y: Int -> x + y }   // this is called lambda fn

    val multiLineLambda: () -> Int = {
        println("hello lambda")
        val a = 2 + 3
        "Hello world"       // by default last line is the returned one
        2
    }
// Since lambda is a function, it is called like a function is called
    multiLineLambda()       // hello lambda

    // To print the returned value of lambda, print the function
    println(multiLineLambda())
    // o/p hello lambda    (From function calling)
    //2                     (Returned value is printed)

    val singleParamLambda = { x: Int -> x * x }
    val lambda2: (Int) -> Int = { x -> x * x }
    val sayHi: (String) -> Unit = { msg: String -> println("Hello $msg") } // returns nothing
    val sayHi2: (String) -> Unit = { msg -> println("Hi $msg") }

    val singleParam: (Int) -> Int = { x -> x + x }
    val simplifySingleParam: (Int) -> Int = { it + it }

    calculator(a = 2, b = 3, op = { a, b -> a + b })
    calculator(
        a = 2,
        b = 3
    ) { a, b -> a + b }//Removing lambda out of paranthesis, whenever lambda is last parameter
}

fun calculator(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

fun sum(a: Int, b: Int) = a + b