package com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics

fun AccessModifiers(){

}

open class A1{
   public val p=10
   private val q=20
   internal val r=30
   protected val s=40
}
class B: A1(){
    fun display(){
        println(p)   // 10
       // println(q) // error
        println(r)   //30
        println(s)   //40
    }
}
fun main() {
    val a= B()
    a.display()
}