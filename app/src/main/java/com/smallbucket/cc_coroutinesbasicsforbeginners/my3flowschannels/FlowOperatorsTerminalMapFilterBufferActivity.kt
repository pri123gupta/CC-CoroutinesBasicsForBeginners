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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class FlowOperatorsTerminalMapFilterBufferActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to FlowOperatorsTerminalMapFilterBufferActivity")
        }

//        fewFunctions()
        fnEmitManually()
//        someMoreFns()
//        someMoreFns2()
//        fnsMapFilter()
//        fnsMapFilterUserDefined()
//        fnBuffer()
    }
}

fun fnEmitManually() {
    GlobalScope.launch(Dispatchers.Main) {
        producers()
            .onStart {
                emit(-1)
                Log.d(APP_TAG, "onStarting out  ") // when emitting and production is started,
                // runs only once before all items are produced
            }
            .onCompletion {
                emit(6)
                Log.d(
                    APP_TAG,
                    "onCompletion     "
                ) // After all items are emitted and completed
            }.onEach {
                Log.d(
                    APP_TAG,
                    "onEach About to emit $it  "
                ) // When single item is about to emit, it is called
            }
            .collect {
                Log.d(APP_TAG, "collect: $it")
            }
    }
}

private fun fnBuffer() {
    GlobalScope.launch(Dispatchers.Main) {
        val time = measureTimeMillis {
            producer()
                .buffer(3) // random value
                .collect {
                    delay(1500)
                    Log.d(APP_TAG, "collected = $it")  //1,2,3
                }
        }
        Log.d(APP_TAG, "time = $time")  //
    }
}

private fun fnsMapFilterUserDefined() {
    GlobalScope.launch(Dispatchers.Main) {
        getNotes()
            .map {
                FormattedNote(
                    isActive = it.isActive,
                    title = it.title.uppercase(),
                    description = it.description
                )
            }.filter { it.isActive }
            .collect {
                Log.d(APP_TAG, "Collected = $it")
            }
    }
}

data class Note(val id: Int, val isActive: Boolean, val title: String, val description: String)
data class FormattedNote(val isActive: Boolean, val title: String, val description: String)

private fun getNotes(): Flow<Note> {
    val list = listOf(
        Note(1, true, "First", "First desc"),
        Note(2, true, "Second", "Second desc"),
        Note(3, false, "Third", "Third desc")
    )
    return list.asFlow()
}

private fun fnsMapFilter() {
    GlobalScope.launch(Dispatchers.Main) {
        val result: List<Int> = producers().toList() // Assembles all elements to a list
        Log.d(APP_TAG, "List = $result")
    }
}

private fun someMoreFns2() {
    GlobalScope.launch(Dispatchers.Main) {
        val result: List<Int> = producers().toList() // Assembles all elements to a list
        Log.d(APP_TAG, "List = $result")
    }
}

private fun someMoreFns() {
    GlobalScope.launch(Dispatchers.Main) {
        val result: Int = producers().first() // First element emitted
        Log.d(APP_TAG, "first = $result")
    }
}

private fun fewFunctions() {
    GlobalScope.launch(Dispatchers.Main) {
        producers()
            .onStart {
                Log.d(APP_TAG, "onStarting out  ") // when emitting and production is started,
                // runs only once before all items are produced
            }
            .onCompletion {
                Log.d(
                    APP_TAG,
                    "onCompletion     "
                ) // After all items are emitted and completed
            }.onEach {
                Log.d(
                    APP_TAG,
                    "onEach About to emit $it  "
                ) // When single item is about to emit, it is called
            }
            .collect {
                Log.d(APP_TAG, "collect: $it")
            }
    }
}

fun producers() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach {
        delay(1000)
        emit(it)
    }
}