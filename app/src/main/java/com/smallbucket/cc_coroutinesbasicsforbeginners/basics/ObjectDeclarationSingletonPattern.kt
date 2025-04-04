package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

interface Cloneable {
    fun clone()
}

object SharingWidget { // by default singleton
    private var fbLikes = 0
    private var twitterLikes = 0
    private var gmailLikes = 0
    fun increaseFbLikes() = fbLikes++
    fun increaseTwitterLikes() = twitterLikes++
    fun increaseGmailLikes() = gmailLikes++
    fun display() = println("FB = $fbLikes , Twitter = $twitterLikes , Gmail = $gmailLikes")
}


object A_1 {            //Object created without class
    val num = 10
}

object B_1 {            //Object created without class
    val count = 20
    fun display() {
        println("Printing B")
    }
}

fun objectDeclaration() {
    ObjectWithoutClasses()
    SingletonPattern()
}

fun ObjectWithoutClasses() {
    println(A_1.num)   //10
    println(B_1.count) //20
    B_1.display()      // Printing B
}

fun SingletonPattern() {
    SharingWidget.increaseFbLikes()
    SharingWidget.increaseTwitterLikes()
    SharingWidget.increaseTwitterLikes()
    SharingWidget.increaseTwitterLikes()
    SharingWidget.display()
}

fun anonymousObject() {
    val testObj = object {} // this is anonymous object as an expression
    val obj = object {
        val num = 10
        fun display() {
            println("This is display method")
        }
    }
    println(obj.num)
    obj.display()
}

fun anonymousObjectWithInterface() {
    val obj = object : Cloneable {
        override fun clone() {

            println("Cloning...")
        }
    }
    obj.clone()
}

fun anonymousObjectWithInterfaceForClass() {
    val obj = object : Person4(name = "Spider") {  // We are inheriting person class
        override fun displayFullName() {
            super.displayFullName()
            println("Anonymous - $name")
        }
    }
    obj.displayFullName()
}

open class Person4(val name: String) {
    open fun displayFullName() {
        println("Full Name - $name")
    }
}

fun main() {
    //ObjectWithoutClasses()
//    SingletonPattern()

//    anonymousObject()
//    anonymousObjectWithInterface()
    anonymousObjectWithInterfaceForClass()
}





