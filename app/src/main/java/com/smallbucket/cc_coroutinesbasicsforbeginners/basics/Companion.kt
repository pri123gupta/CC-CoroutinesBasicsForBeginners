package com.smallbucket.cc_coroutinesbasicsforbeginners.basics


class MyClass_ {         //Class

}

object MyObject {        // object

}

class MyClass {
    companion object MyObject {
        @JvmStatic
        fun f() {
            println("hello i m f from f()")
        }
    }

    object AnotherObject {
        fun g() {
            println("This is g from g()")
        }
    }
}

fun main() {
    MyClass.f()        // hello i m f from f()
    MyClass.AnotherObject.g()  // This is g from g()
}