package com.smallbucket.cc_coroutinesbasicsforbeginners.basics

fun main() {
    val ar = arrayOf(1, 2, 3)
    try {
        println(ar[4])  // Exception  Index 4 out of bounds
    } catch (e: NullPointerException) {
        println("Pls check null obj")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Pls check array index")
    } catch (e: Exception) { // Last catch block
        println("Pls check exception")
        e.printStackTrace()
    } finally {
        println("This will run no matter what")
    }
    createUserList(1)
    createUserList(-1)
}
fun createUserList(count:Int){
    if(count<0){
      throw IllegalArgumentException("Count cannot be less than zero") // raise exception
    }else{
        println("user list contains $count users")
    }
}