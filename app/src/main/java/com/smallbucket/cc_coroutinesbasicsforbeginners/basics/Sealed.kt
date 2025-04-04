package com.smallbucket.cc_coroutinesbasicsforbeginners.basics


sealed class Tile
class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()

fun main() {
    /*   val redTile = Red(type = "Mushroom", 25)
       val redTile2 = Red(type = "Fire", 30)
       println("${redTile.type} -  ${redTile.points}")*/

    val tile: Tile = Red("Mushroom", 25)// bcoz types inherit sealed class
    val points = when (tile) {
        is Red -> tile.points * 2
        is Blue -> tile.points * 5
    }
    println(points) //50
}