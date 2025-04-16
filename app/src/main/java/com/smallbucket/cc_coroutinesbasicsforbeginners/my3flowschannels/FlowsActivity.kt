package com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.smallbucket.cc_coroutinesbasicsforbeginners.basicTextview
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.MainViewModel
//import com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels.flowExample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FlowsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            basicTextview("Welcome to Flows")
        }
        flowExample()
    }
}
fun flowExample() {
    GlobalScope.launch(Dispatchers.Main) {
        getUSername().forEach {   // Consumer
            Log.d(APP_TAG, "flowExample: $it")
        }
    }

    Log.d(APP_TAG, "flowExample: End")
}

suspend fun getUSername(): MutableList<String> { // Producer
    val list = mutableListOf<String>()
    list.add(getUSerId(1))
    list.add(getUSerId(2))
    list.add(getUSerId(3))
    return list
}

suspend fun getUSerId(id: Int): String {
    delay(1000)  // Suppose Network call
    return "User$id"
}