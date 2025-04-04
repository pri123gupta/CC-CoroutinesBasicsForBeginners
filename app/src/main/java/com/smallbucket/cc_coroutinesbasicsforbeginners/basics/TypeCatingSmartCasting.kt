package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

interface Draggable {
    fun drag()
}

abstract class Shape : Draggable {
    abstract fun area(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
    override fun drag() = println("Circle is dragging")

}

class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
    override fun drag() = println("Square is dragging")
}

class Triangle(val base: Double, val width: Double) : Shape() {
    override fun area(): Double = 0.5 * base * width
    override fun drag() = println("Triangle is dragging")
}

class Player(name: String) : Draggable {
    fun saymyname(){
        println("hello world")
    }
    override fun drag() = println("Player is dragging")
}

fun dragObjects(objs: Array<Shape>) {
    for (obj in objs) {
        obj.drag()
    }
}

fun dragObjects2(objs: Array<Draggable>) {
    for (obj in objs) {
        obj.drag()
    }
}

fun main() {
    val circle = Circle(4.0)
    val player = Player("Smiley")
    val arr: Array<Draggable> = arrayOf(circle, player
//        , Test() // NOT draggable
    )

    for (obj in arr) {
        if (obj is Circle) {
            println(obj.area())
            println("This is circle")
        } else {
            (obj as Player).saymyname()
        }
    }

}
class Test{

}
fun TypeCatingSmartCasting() {
}