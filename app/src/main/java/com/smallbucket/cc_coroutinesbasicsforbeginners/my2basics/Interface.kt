package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics

/*
interface Draggable{
    val dragSpeed :Int
    fun drag()
}

abstract class Shape :Draggable{
    abstract fun area(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
    override val dragSpeed: Int
        get() = 10

    override fun drag() = println("Circle is dragging")

}

class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
    override val dragSpeed: Int
        get() = 20

    override fun drag() = println("Square is dragging")
}

class Triangle(val base: Double, val width: Double) : Shape() {
    override fun area(): Double = 0.5 * base * width
    override val dragSpeed: Int
        get() = 30

    override fun drag() = println("Triangle is dragging")
}

class Player(name:String):Draggable{
    override val dragSpeed: Int
        get() = 40

    override fun drag() = println("Player is dragging")
}

fun dragObjects(objs: Array<Shape>){
    for (obj in objs){
        obj.drag()
    }
}
fun dragObjects2(objs:Array<Draggable>){
    for (obj in objs){
        obj.drag()
        println(obj.dragSpeed)
    }
}

fun main() {

//    dragObjects(arrayOf(Circle(4.0), Square(4.0), Triangle(4.0,5.0),
//        Circle(3.0) ))
    dragObjects2(arrayOf(Circle(4.0), Square(4.0), Triangle(4.0,5.0),
        Circle(3.0) , Player(name = "test")))

}
*/


class Interface {
    val i=0
}