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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class FlowOperatorsTerminalMapFilterBufferActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to FlowOperatorsTerminalMapFilterBufferActivity")
        }
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
}

fun producers() = flow<Int> {
    val list = listOf(1, 2, 3, 4, 5)
    list.forEach {
        delay(1000)
        Log.d(APP_TAG, "produced $it")
        emit(it)
    }
}