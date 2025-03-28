package com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.concurrent.thread

val APP_TAG = "Pri_coroutinesbasicsforbeginners : "
@Composable
fun CoroutineScopeCoroutineContext(innerPadding: PaddingValues) {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString(), Modifier.padding(innerPadding))
        Button(onClick = {
            Log.d(APP_TAG, "CoroutineScopeCoroutineContext: increment =  ${Thread.currentThread().name}")
            count++
        }) {
            Text(text = "Increment counter", Modifier.padding(5.dp))
        }

        Button(onClick = {
            thread {
                for (i in 1..10000000){
                    Log.d(APP_TAG, "CoroutineScopeCoroutineContext: loop =  ${Thread.currentThread().name}")

                }
            }

        }) {
            Text(text = "Long running task", Modifier.padding(5.dp))
        }
    }
}