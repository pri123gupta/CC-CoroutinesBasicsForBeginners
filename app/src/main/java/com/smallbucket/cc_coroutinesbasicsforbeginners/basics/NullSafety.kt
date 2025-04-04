package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

fun main() {
    val gender = "Male" // M F Others, non nullable data type
    val gender2: String? = null // When we dont know

    gender2?.toUpperCase()
    println(gender2?.toUpperCase()) // null
    gender2?.let {
        println("Line 1")
        println("Line 2")
        println("Line 3 $gender2") // Line 3 null
        println("Line 4 $it")      // Line 4 null
        println("Line 5 ")
    }
    val selectedVal: String? = gender2 // type inference, kotlin detects its type as nullable string
    var selectedValue: String = gender2 ?: "NA" // Elvis operator
    var value = gender2!!.toUpperCase()


}