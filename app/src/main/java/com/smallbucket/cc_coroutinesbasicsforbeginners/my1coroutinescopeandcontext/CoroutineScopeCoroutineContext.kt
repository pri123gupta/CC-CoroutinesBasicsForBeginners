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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

val APP_TAG = "Pri_coroutinesbasicsforbeginners : "

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun CoroutineScopeCoroutineContext(innerPadding: PaddingValues) {
   counterBasicCoroutinFn(innerPadding)
}


@Composable
fun counterBasicCoroutinFn(innerPadding: PaddingValues) {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString(), Modifier.padding(innerPadding))
        Button(onClick = {
            Log.d(
                APP_TAG,
                "CoroutineScopeCoroutineContext: increment =  ${Thread.currentThread().name}"
            )
            count++
        }) {
            Text(text = "Increment counter", Modifier.padding(5.dp))
        }

        /*  Button(onClick = {
              thread (start = true){
                  for (i in 1..100000000000L) {
                      Log.d(
                          APP_TAG,
                          "CoroutineScopeCoroutineContext: loop =  ${Thread.currentThread().name}"
                      )

                  }
              }
          }) {
              Text(text = "Long running task", Modifier.padding(5.dp))
          }*/
        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d(
                    APP_TAG,
                    "CoroutineScopeCoroutineContext: 1- loop =  ${Thread.currentThread().name}"
                )
            }

            GlobalScope.launch(Dispatchers.Main) {
                Log.d(
                    APP_TAG,
                    "CoroutineScopeCoroutineContext: 2- loop =  ${Thread.currentThread().name}"
                )
            }
            MainScope().launch {
                Log.d(
                    APP_TAG,
                    "CoroutineScopeCoroutineContext: 3- loop =  ${Thread.currentThread().name}"
                )
            }
        }) {
            Text(text = "Long running task", Modifier.padding(5.dp))
        }
    }
}
suspend fun task1(){ // no api call/IO operation so suspend is redundant , &not needed
    Log.d(APP_TAG, " start task 1")
    delay(1000)
    Log.d(APP_TAG, " end task 1 ")
}

suspend fun task2(){ // yield is io operation so not redundant
    Log.d(APP_TAG, " start task 2")
    yield() // yield is suspension point
    Log.d(APP_TAG, " end task 2 ")
}

fun coroutineSuspendFn(){
    CoroutineScope(Dispatchers.Main).launch {
        task1()
    }
    CoroutineScope(Dispatchers.Main).launch {
        task2()
    }
}
