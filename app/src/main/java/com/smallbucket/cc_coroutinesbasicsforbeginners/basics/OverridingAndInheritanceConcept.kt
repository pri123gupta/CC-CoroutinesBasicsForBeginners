package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

fun overridingAndInheritanceConcept() {
//    main2()

}

fun main() {
    val onePlus = OnePlus()
    /*  println(onePlus.name) //oneplus
      println(onePlus.volume) //10
      println(onePlus.screen_size)//5.5
      onePlus.makeCall() //5.5
      onePlus.powerOff() //Shutting down

      val generalMobile = Mobile(type = "General")
      onePlus.display() //HD mobile display
      generalMobile.display() // Simple Mobile display
      val samsung = Samsung(typeParam = "samsung")
      samsung.display() //samsung Extra HD mobile display*/
    println(onePlus.toString())
}

open class Mobile(val type: String) {
    open val name = "100"
    val volume = 10
    val screen_size = 5.5
    fun makeCall() {
        println("Calling")
    }

    fun powerOff() {
        println("Shutting down")
    }

    open fun display() {
        println("$type Mobile display")
    }
}

class OnePlus : Mobile("Smartphone") {
    override val name = "oneplus"
    override fun display() {
        super.display() // call parent function
        println("OnePlus display")
    }

    override fun toString(): String {
        return "Name : $name , size $screen_size"
    }
}

class Samsung(typeParam: String) : Mobile(typeParam) {
    override val name = "samsung"
    override fun display() {
        println("$type Extra HD mobile display")
    }

    override fun toString(): String {
        return super.toString()
    }
}