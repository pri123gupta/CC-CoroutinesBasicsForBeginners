package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

fun main() {
    val obj = Container(3)
    val a: Int = obj.data // Int
    val obj2 = Container<Int>(4)
    obj2.getValue() // Int

    val objs = Container<String>("hello")
    objs.getValue()// string
    val list: List<String> = listOf<String>()
    add(1,2,3,5,7,8,8)  //34
    add(1,1,1,1,1,1,1,1) //8
}

fun add(vararg values: Int) {
    var sum = 0
    for ( i in values){
        sum +=i
    }
    println(sum)
}

class Container<T>(var data: T) {
    fun setValue(value: T) {
        data = value
    }

    fun getValue(): T {
        return data
    }
}