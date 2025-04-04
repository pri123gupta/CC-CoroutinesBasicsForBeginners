package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics

fun main() {
//    InheritanceConcept()
    overridingAndInheritanceConcept()
}





fun InheritanceConcept() {
//    val parent = Parent()
//    println(parent.name)
//    parent.myMethod()

    val child = Child()     //Parent's constructor is called , Child's constructor is called

    println(child.name)     // parent
    println(child.name2)    // child
    child.myMethod()        // I am in parent class
    child.myMethod2()       // I am in child class
//    println("--------------")

}

open class Parent {     // Super class , we have to make it open to make it super class
    init {
        println("Parent's constructor is called ")
    }

    val name = "parent"
    fun myMethod() {
        println("I am in parent class")
    }
}

class Child : Parent() {    // Sub class


    init {
        println("Child's constructor is called")
    }

    //   val name2 = "child"  // Compile time error(property is already inherited from super class)
    val name2 = "child"
    fun myMethod2() {
        println("I am in child class")
    }
}


class SmartPhone : Phone() {
    fun playMovies() {}
    fun takePictures() {}
    fun getLocation() {}


}

class BasicPhone() : Phone() {
    fun getScreenInfo() {

    }
}

open class Phone {
    val name = "Keypad"
    val type = "Basic 1100"
    val volume = 10

    fun makeCall() {}
    fun display() {}
    fun power() {}
    fun getScreenOff() {}
}