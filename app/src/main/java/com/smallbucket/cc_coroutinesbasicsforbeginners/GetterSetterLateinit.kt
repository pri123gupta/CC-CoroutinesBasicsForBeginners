package com.smallbucket.cc_coroutinesbasicsforbeginners

fun getterSetterLateInit() {
    val ob = Calculator() // no constructor, so default constructor is added
    println(ob.add(2, 3))    //5

    val p1 = Person3("abc", 21)
    println(p1.age)            // 21, For getting value
    p1.age = 23                // 23,For setting value
    println(p1.age)            // 23, For getting value
    p1.age = -24               // should not be allowed, hence we applied setter for validation
    println(p1.age)            // Age cannot be -ve
    println(p1.name)

}

class Person3(nameParam: String, ageParam: Int) {
    var name = nameParam
        get() {
            println("Name getter is called")
            return field.toUpperCase()
        }
    var age = ageParam
        set(value) {
            if (value > 0)
                field = value
            else
                println("Age cannot be -ve")
        }
    var email :String = ""
        get() = field
        set(value) {
            field = value
        }

}

class Calculator // no constructor
{
    lateinit var message: String
    fun add(a: Int, b: Int) = a + b
    fun multiply(a: Int, b: Int) = a * b
}