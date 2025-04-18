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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SharedFlowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to SharedFlow")
        }
        GlobalScope.launch {
            val list: Flow<Int> = producers2OfSharedFlow()
            list.collect {
                Log.d(APP_TAG, "Item A - ${it.toString()}")
            }
        }
        GlobalScope.launch {
            val list: Flow<Int> = producers2OfSharedFlow()
            delay(2500)
            list.collect {
                Log.d(APP_TAG, "Item B - ${it.toString()}")
            }
        }
    }
}

fun producers2OfSharedFlow(): Flow<Int> {
    val mutableSharedFlow = MutableSharedFlow<Int>(
        replay = 2
    )
    val list = listOf(1, 2, 3, 4, 5)
    GlobalScope.launch {
        list.forEach {
            mutableSharedFlow.emit(it)
            delay(1000)
        }
    }
    return mutableSharedFlow
}