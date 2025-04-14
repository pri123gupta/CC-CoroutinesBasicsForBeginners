package com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.input.key.Key.Companion.D
import com.smallbucket.cc_coroutinesbasicsforbeginners.basicTextview
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class ChannelsActivity : ComponentActivity() {

    val channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to Channels")
        }
        producer()
        consumer()
    }

    fun producer() {
        CoroutineScope(Dispatchers.Main).launch {
            channel.send(1)
            channel.send(2)
        }
    }

    fun consumer() {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d(APP_TAG, "consumer: ${channel.receive()} ") //o/p consumer: 1
            Log.d(APP_TAG, "consumer: ${channel.receive()} ") //o/p consumer: 2
        }
    }
}

