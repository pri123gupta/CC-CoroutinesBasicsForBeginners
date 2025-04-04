package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

enum class Day(val num: Int) {
    SUN(1),
    MON(2),
    TUE(3),
    WED(4),
    THR(5),
    FRI(6),
    SAT(7); // semicolon is must when function is added in enum

    fun printFormattedDate() {
        println("Day is $this")
    }
}


fun main() {
    val day = Day.TUE
    println(day) // TUE
    println(day.num) //3
    for (i in Day.values()) {
        println("Day - $i , num - ${i.num}")
    }
    day.printFormattedDate()
}