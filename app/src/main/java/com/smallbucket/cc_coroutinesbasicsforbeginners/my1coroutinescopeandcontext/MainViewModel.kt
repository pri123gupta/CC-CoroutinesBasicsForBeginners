package com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    init {
        viewModelScope.launch {
            while (true){
                delay(500)
                Log.d(APP_TAG, "hello from me ")
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        Log.d(APP_TAG, " vm destroyed ")
    }
}