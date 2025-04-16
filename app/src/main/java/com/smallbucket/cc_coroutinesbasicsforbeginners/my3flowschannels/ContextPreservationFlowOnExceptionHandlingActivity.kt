package com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.smallbucket.cc_coroutinesbasicsforbeginners.basicTextview
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ContextPreservationFlowOnExceptionHandlingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to ContextPreservationFlowOnExceptionHandling")
        }
        GlobalScope.launch(Dispatchers.Main) {
            try {
                producerHandlingErrorItselfEmitCallback()
                    .collect {
                        Log.d(APP_TAG, "Collector thread = ${Thread.currentThread().name}, collected = $it")
                    }
            } catch (e: Exception) {
                Log.d(APP_TAG, "Exception=${e.message.toString()}")
            }
        }
//        fnFlowOn()
//      producerError()
//        consumerError()
    }
}

private fun consumerError() {
    GlobalScope.launch(Dispatchers.Main) {
        try {
            producerz()
                .collect {
                    Log.d(APP_TAG, "Collector thread = ${Thread.currentThread().name}")
                    throw Exception("Error in Collector")
                }
        } catch (e: Exception) {
            Log.d(APP_TAG, "Exception=${e.message.toString()}")
        }
    }
}

private fun producerError() {
    GlobalScope.launch(Dispatchers.Main) {
        try {
            producerzz()
                .collect {
                    Log.d(APP_TAG, "Collector thread = ${Thread.currentThread().name}")
                }
        } catch (e: Exception) {
            Log.d(APP_TAG, "Exception=${e.message.toString()}")
        }
    }
}

private fun fnFlowOn() {
    GlobalScope.launch(Dispatchers.Main) {
        producerz()
            .map {
                delay(1000)
                Log.d(APP_TAG, "Map thread = ${Thread.currentThread().name}")
                it * 2
            }
            .flowOn(Dispatchers.IO)
            .filter {
                Log.d(APP_TAG, "Filter thread = ${Thread.currentThread().name}")
                it < 8
            }
            .flowOn(Dispatchers.Main)
            .collect {
                Log.d(APP_TAG, "Collector thread = ${Thread.currentThread().name}")
            }
    }

}

fun producerzz() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach {
        delay(1000)
        Log.d(APP_TAG, "Emitter thread = ${Thread.currentThread().name}")
        emit(it)
        throw Exception("Error in Emitter")
    }
}

fun producerz() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach {
        delay(1000)
        Log.d(APP_TAG, "Emitter thread = ${Thread.currentThread().name}")
        emit(it)
    }
}

fun producerHandlingErrorItself() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach {
        delay(1000)
        Log.d(APP_TAG, "Emitter thread = ${Thread.currentThread().name}")
        emit(it)
        throw Exception("Error in Emitter")
    }
}.catch {  // to handle producer's exception
    // we can also emit callback elements here
    Log.d(APP_TAG, "Emitter catch - ${it.message.toString()}")
}
fun producerHandlingErrorItselfEmitCallback() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach {
        delay(1000)
        Log.d(APP_TAG, "Emitter thread = ${Thread.currentThread().name}")
        emit(it)
        throw Exception("Error in Emitter")
    }
}.catch {  // to handle producer's exception
    // we can also emit callback elements here
    Log.d(APP_TAG, "Emitter catch - ${it.message.toString()}")
    emit(-1)
}