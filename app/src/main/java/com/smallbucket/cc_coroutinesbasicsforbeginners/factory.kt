package com.smallbucket.cc_coroutinesbasicsforbeginners

fun main() {
    val pizza = Pizza.create("Peppy Paneer") // Can be called without Factory object
    println(pizza.type)
    println(pizza.toppings)
  //  val pizza2 = Pizza("", "")
// Can no longer make object of Pizza class wthout create() function
}

class Pizza private constructor(val type: String, val toppings: String) {
    companion object Factory {
        fun create(pizzaType: String): Pizza {
            return when (pizzaType) {
                "Tomato" -> Pizza("Tomato", toppings = "Tomato, Cheeze")
                "Peppy Paneer" -> Pizza(
                    "Peppy Paneer",
                    toppings = "Peppy Paneer, cheeze burst, onion, Tomato, Cheeze"
                )
                else -> Pizza("basic", "veggies")
            }
        }
    }
}