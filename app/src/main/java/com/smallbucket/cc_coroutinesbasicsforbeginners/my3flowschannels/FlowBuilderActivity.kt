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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowBuilderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to Producer Consumer")
        }
        flowBuilders()
    }
}
private fun flowBuilders() {

    GlobalScope.launch {
        val data: Flow<Int> = producer() // this is producer
        data.collect { // This is consumer
            Log.d(APP_TAG, "consumer - A : $it")
        }
    }
    GlobalScope.launch {
        val data: Flow<Int> = producer() // this is producer
        delay(2500)
        data.collect { // This is consumer
            Log.d(APP_TAG, "consumer - B : $it")
        }
    }
}
fun producer() = flow<Int> { // Note - this is a suspend block.
    // Note - By default flows create coroutine scope, which it manages itself
    val list = listOf(1, 2, 3, 4, 5) // stream of integers
    list.forEach {
        delay(1000)
        emit(it)
    }
}