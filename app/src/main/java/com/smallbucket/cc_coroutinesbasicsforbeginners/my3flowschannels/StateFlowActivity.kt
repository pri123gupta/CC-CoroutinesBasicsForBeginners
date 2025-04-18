package com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.smallbucket.cc_coroutinesbasicsforbeginners.basicTextview
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StateFlowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to StateFlow")
        }

        GlobalScope.launch {
            val result = producersReturningStateFlow()
            // whatever value is present is our stateflow, we can access that
            Log.d(APP_TAG, "Result - ${result.value}")
        }
//        consumerOfSharedFlow2()
//        consumerOfSharedFlowWithDelayedConsumer()
    }
}

fun consumerOfSharedFlow2() {
    GlobalScope.launch {
        val list: Flow<Int> = producers2OfSharedFlow()
        delay(2500)
        list.collect {
            Log.d(APP_TAG, "Item A - ${it}")
        }
    }
}

fun producerOfStateFlow(): Flow<Int> {
    val stateFlow = MutableStateFlow<Int>(10) // 10 is initial value of preserved state
    GlobalScope.launch {
        delay(2000)
        stateFlow.emit(20)
        delay(2000)
        stateFlow.emit(30)
    }
    return stateFlow
}

fun producers2OfSharedFlowWithDelayedConsumer(): Flow<Int> {
    val mutableSharedFlow = MutableSharedFlow<Int>()
    val list = listOf(1, 2, 3, 4, 5)
    GlobalScope.launch {
        list.forEach {
            mutableSharedFlow.emit(it)
            Log.d(APP_TAG, "Emitting  - $it ")
            delay(1000)
        }
    }
    return mutableSharedFlow
}

fun consumerOfSharedFlowWithDelayedConsumer() {
    GlobalScope.launch {
        producerOfStateFlow().collect {
            delay(6000)
            Log.d(APP_TAG, "collect - $it")
        }
    }
}

fun producersReturningStateFlow(): StateFlow<Int> {
    val mutableStateFlow = MutableStateFlow(10)

    GlobalScope.launch {
        delay(2000)
        mutableStateFlow.emit(20)
        delay(2000)
        mutableStateFlow.emit(20)
    }
    return mutableStateFlow
}