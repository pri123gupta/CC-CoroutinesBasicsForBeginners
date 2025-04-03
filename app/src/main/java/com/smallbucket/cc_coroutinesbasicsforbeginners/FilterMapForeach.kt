package com.smallbucket.cc_coroutinesbasicsforbeginners

import androidx.compose.ui.input.key.Key.Companion.D

fun main() {
//    filterFn()
//    UserdefinedFilter()
//    mapFn()
    forEachFn()
}

fun forEachFn() {

    val nums: List<Int> = listOf(1, 2, 3, 4, 5)
    val list = listOf(
        User("A", 5),
        User("B", 10),
        User("C", 15),
        User("D", 20),
        User("E", 25)
    )
    for (i in nums){
        println(i)
    }
    // o/p
//    1
//    2
//    3
//    4
//    5
    list.forEach {
        println("Name = ${it.name} , age = ${it.age}")
    }
    // o/p
//    1
//    2
//    3
//    4
//    5

    nums.forEach {
        println(it)
    }
//    o/p
//    Name = A , age = 5
//    Name = B , age = 10
//    Name = C , age = 15
//    Name = D , age = 20
//    Name = E , age = 25
}

fun mapFn() {
    // map is used to convert one list to another form/list
    val nums: List<Int> = listOf(1, 2, 3, 4, 5)
    val map: List<Int> = nums.map { it * it }
    println(map)    //[1, 4, 9, 16, 25]
    val map2: List<PaidUser> = nums.map {
        PaidUser(name = "NAME $it", id = it, type = "TYPE $it")
    }
    println(map2)    //[PaidUser(id=1, name=NAME 1, type=TYPE 1), PaidUser(id=2, name=NAME 2,
// type=TYPE 2), PaidUser(id=3, name=NAME 3, type=TYPE 3),
// PaidUser(id=4, name=NAME 4, type=TYPE 4), PaidUser(id=5, name=NAME 5, type=TYPE 5)]


}

data class PaidUser(
    val id: Int, val name: String,
    val type: String
)

fun UserdefinedFilter() {
    val list = listOf(
        User("A", 5),
        User("B", 10),
        User("C", 15),
        User("D", 20),
        User("E", 25)
    )
    val filteredList = list.filter { it.age == 20 }
    println(filteredList) //[User(name=D, age=20)]
    val filteredList2 = list.filter { it.age > 15 }
    println(filteredList2) // [User(name=D, age=20), User(name=E, age=25)]
}

fun filterFn() {
    val nums = listOf(1, 2, 3, 4, 5)
    val filteredList = nums.filter { it % 2 == 0 }
    println(filteredList)      //[2, 4]

    val filteredList2 = nums.filter(::isOdd)            // Alternatively

    val filteredList3 = nums.filter({ num: Int ->        // Alternatively
        num % 2 != 0
    })
    val filteredList4 = nums.filter({ it % 2 != 0 })         // Alternatively
    val filteredList5 = nums.filter { it % 2 != 0 }          // Alternatively

    println(filteredList2)  //[1, 3, 5]
    println(filteredList3) //[1, 3, 5]
    println(filteredList4) //[1, 3, 5]
    println(filteredList5) //[1, 3, 5]
}

data class User(val name: String, val age: Int)

fun isOdd(num: Int): Boolean {
    return num % 2 != 0
}