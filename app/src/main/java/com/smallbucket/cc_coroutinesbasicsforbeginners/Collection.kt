package com.smallbucket.cc_coroutinesbasicsforbeginners

fun main() {
//    ListsAll()
    mapsAll()
}

fun mapsAll() {
    val students = mutableMapOf<Int, String>()
    students.put(1, "Ryan")
    students.put(2, "John")
    students.put(3, "Katie")
    println(students)       // {1=Ryan, 2=John, 3=Katie}
    println(students.get(2)) // John
    println(students.get(4))    // null , since this key doesn't exist
    students[4] = "Test"        //set
    println(students.get(4))    //Test
    println(students)

    for ((i, e) in students) {
        println("Keys = $i , element = $e")
//o/p
//        Keys = 1 , element = Ryan
//        Keys = 2 , element = John
//        Keys = 3 , element = Katie
    }

    // immutable map
    val map = mapOf<Int, String>()
//    map.put                   // compile time error
    // Since we cannot use put method , how will we initialise the elements
    val map2 = mapOf<Int, String>(1 to "Ryan", 2 to "John", 3 to "Katie")
    println(map2)                 // {1=Ryan, 2=John, 3=Katie}
}


fun ListsAll() {
    val nums: List<Int> = listOf(1, 2, 3) // immutable list
    println(nums.indexOf(3))
    println(nums.contains(4)) // false, since not present in list

    // nums.add  // no such function being immutable list
    // nums[1]=0  // error
    val num: MutableList<Int> = mutableListOf(1, 2, 3) // mutable list
    num[1] = 8
    num.add(5)
    num.remove(1)
    println(num)

    val list2 = listOf(11, 12)
    num.addAll(list2)
    println(num)
}