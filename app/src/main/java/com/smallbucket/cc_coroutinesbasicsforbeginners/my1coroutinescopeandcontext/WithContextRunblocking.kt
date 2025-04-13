package com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun WithContextRunblocking() {
    GlobalScope.launch {
//        executeTask()
//        main0()

    }
}

suspend fun executeTask() {
    Log.d(APP_TAG, "Before ")
    GlobalScope.launch {
        delay(1000)
        Log.d(APP_TAG, "Inside ")
    }
    Log.d(APP_TAG, "After ")
}


fun main0() {
    GlobalScope.launch {
        delay(1000)
        println("World ")
    }
    println("Hello ")
    Thread.sleep(2000)
}

fun main() {
    runBlocking {
        launch {
            delay(1000)
            println("World ")
        }
        println("Hello ")
    }
}













