package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG

@Composable
fun ObjectsClasses(innerPadding: PaddingValues) {

}


fun constructorsPrimarySecondary() {
    val car = Automobile(
        "Car", 4, 5,
//        true,
        engineType = "Petrol"
    ) // Default values
    val car2 = Automobile(
        "Car2", 4, 5,
//        true,
        engineType = "Diesel"
    ) // Default values
    car.maxSeat
    car.drive()
    car.tyres
//    car.hasAirbags // Compile time error, it doesn't have this property, but parameter

    val person2 = Person2(nameParam = "A", ageParam = 21) // no parameters
    person2.age = 18         // properties of Person class
    println(person2.age)    //18
    println(person2.name)   // "" Empty string
    // So, we cannot provide values to this class, so we add params to person class

    val personB = Person2("B", 20)
    println(personB.age)    //20
    println(personB.name)   // B
    println()
    val personC = Person2(nameParam = "C", ageParam = 19)
    println(personC.name)

    val car3 = Automobile("Car", "Petrol")
    val car4 = Automobile("Car2", "Diesel")
}

class Person2(nameParam: String, ageParam: Int)
// hasAirbags is not its property
{ // No
    // Primary properties,but params
    val name = "$nameParam - Clan" // properties
    var age = ageParam   // properties
    val canVote: Boolean = age > 18  // property based on ageParam
}

class Automobile(
    val name: String,
    val tyres: Int,
    val maxSeat: Int,
    engineType: String
) // This is primary constructor
{

    init {
        println("$name is created")
    }

    //    var airbag = hasAirbags // now this is a property
    init {
        println("Second initializer block")
    }

    constructor(nameParams: String, engineParams: String) :
            this(nameParams, 4, 5, engineParams) // Secondary constructor

    fun drive() {}
    fun applyBrakes() {}
}

class EmptyClassWithoutConstructor {}
// This is empty class without any constructor
// it has No constructor, no properties , no methods , no use

fun classes2() {
    val i = 20
    println(APP_TAG + i.plus(30))
    println(APP_TAG + i.toFloat())
    val person = Person(name = "A", age = 21)
    val person2 = Person(name = "B", age = 17)
    println(APP_TAG + person.canVote())
    println(APP_TAG + person2.canVote())
    person2.age = 22
    println(APP_TAG + person2.canVote())
}

fun classes1() {
    val mustang = Car(name = "Mustang", type = "Diesel", kmRun = 10)
    val beetle = Car(name = "Beetle", type = "Petrol", kmRun = 15)
    // We access properties using dot(.) operator
    println(APP_TAG + mustang.name)
    println(APP_TAG + mustang.type)
    println(APP_TAG + mustang.kmRun)
    println(APP_TAG + beetle.name)
    println(APP_TAG + beetle.type)
    println(APP_TAG + beetle.kmRun)

    mustang.driveCar()
    beetle.driveCar()
}

class Car(val name: String, val type: String, var kmRun: Int)  // Properties
{
    fun driveCar() { // methods
        println(APP_TAG + "$name Car is driving")
    }

    fun applyBrakes() {
        println(APP_TAG + "$name Applied Brakes")
    }
}

class Person(val name: String, var age: Int) //properties
{
    // method
    fun canVote(): Boolean {
        return age > 18
    }
}