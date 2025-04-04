package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

fun main() {
//    applyFn()
//    letFn()
//    letFn2()
    withFn()
//    runFn()



}
fun runFn(){

    val emp: Employee = Employee()
    emp.run {
        // this is available here
        age= 32
        name="hi world"
    }
    println(emp) //Employee(name=hi world, age=32)
}

fun withFn(){
    val emp: Employee = Employee()
    with(emp){
        // this
        age= 31
        name= "hello world"
    }
  var a: Unit =   with(emp){
        // this
        age= 31
        name= "hello world"
    }
    var b: Int =   with(emp){
        // this
        age= 31
        name= "hello world"
        2
    }
}

fun letFn2() {
    val emp: Employee? = null
    emp?.age
    emp?.name
    // everytime we have to apply safe call (?), so we use let
    emp?.let {
        // we get a not null object in this scope, not need to add safe call
        it.age = 30
        it.name ="hello"
    }
}

fun letFn() {
    val emp = Employee()
    // Now, to access the properties we have to write emp object again and again , to resolve it we use lt

    emp.age = 20
    emp.name = "Test"

    val a: Unit = emp.let {
        println(it.name) //Test
        println(it.age)  //20
        // println returns nothing
    }
    val b: Int = emp.let {
        println(it.name) //Test
        println(it.age)  //20
        2
        // 2 return type is Int
    }
    val c: String = emp.let {
        println(it.name) //Test
        println(it.age)  //20
        "hello"
        // hello's return type is String
    }


}

fun applyFn() {
    val emp = Employee()
    // Now, we have to set all properties one by one like age , name etc.
    emp.age = 20
    emp.name = "Test"
    // but we also have a utility fn to save time & provide values to properties
    // 1. apply has a scope that contains this , this points to current object.
    // 2. Return value of apply fn is always the object.
    val result: Employee = emp.apply {
        age = 30
        name = "Abacus"
    }
    println(emp)    //Employee(name=Abacus, age=30)
    println(result) //Employee(name=Abacus, age=30)
}

data class Employee(var name: String = "", var age: Int = 18)