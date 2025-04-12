package com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun CoroutineHeirarchy() {
    GlobalScope.launch(Dispatchers.Main) {
//        executeFn()
//        executeFn2()
//        executeFn3()
        executeFn4()
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun executeFn() {
    val parentJob = GlobalScope.launch(Dispatchers.Main) {
        Log.d(APP_TAG, "parent - coroutine context = ${coroutineContext} ")
        // o/p coroutine context = [StandaloneCoroutine{Active}@998872, Dispatchers.Main]

        // 1. Here in child jobs we can directly access launch{} or async{} , no need to define coroutine context explicitly
        // 2. child jobs inherits the context of parent
        val childJob1 = launch(Dispatchers.IO) {

            Log.d(APP_TAG, "child1 - coroutine context = ${coroutineContext} ")
            // o/p child1 - coroutine context = [StandaloneCoroutine{Active}@313d167, Dispatchers.Main]
        }

//        val childJob2 = launch {
//            Log.d(APP_TAG, "child2 - coroutine context = ${coroutineContext} ")
//            //o/p child2 - coroutine context = [StandaloneCoroutine{Active}@5e7bb14, Dispatchers.Main]
//        }

    }
}

suspend fun executeFn2() {
    val parent = GlobalScope.launch(Dispatchers.Main) {
        Log.d(APP_TAG, "parent job started ")
        val child = launch(Dispatchers.IO) {
            Log.d(APP_TAG, "child job started ")
            delay(5000)
            Log.d(APP_TAG, "child job ended ")
        }
        delay(3000)
        Log.d(APP_TAG, "parent job ended ")
    }
    delay(1000)
    parent.cancel()
    parent.join()
    Log.d(APP_TAG, "parent completed ")
}

suspend fun executeFn3() {
    val parent = GlobalScope.launch(Dispatchers.Main) {
        Log.d(APP_TAG, "parent job started ")
        val child = launch(Dispatchers.IO) {
            Log.d(APP_TAG, "child job started ")
            delay(5000)
            Log.d(APP_TAG, "child job ended ")
        }

        delay(3000)
        Log.d(APP_TAG, "child job cancelled ")
        child.cancel()
        Log.d(APP_TAG, "parent job ended ")
    }
    parent.join()
    Log.d(APP_TAG, "parent completed ")
}
// parent job started
//child job started
//parent job ended
//parent completed


suspend fun executeFn4() {
    val parent = GlobalScope.launch(Dispatchers.Main) {
        Log.d(APP_TAG, "parent job started ")
        val child = launch(Dispatchers.IO) {
            try {
                Log.d(APP_TAG, "child job started ")
                delay(5000)
                Log.d(APP_TAG, "child job ended ")
            } catch (e: CancellationException) {
                Log.d(APP_TAG, "child job cancelled ")
            }
        }
        delay(3000)
        child.cancel()
        Log.d(APP_TAG, "parent ended ")
    }
    parent.join()
    Log.d(APP_TAG, "parent completed ")
}