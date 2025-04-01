package com.smallbucket.cc_coroutinesbasicsforbeginners

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import com.smallbucket.cc_coroutinesbasicsforbeginners.ui.theme.CCCoroutinesBasicsForBeginnersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CCCoroutinesBasicsForBeginnersTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Log.d(APP_TAG, "CoroutineScopeCoroutineContext: main thread = ${Thread.currentThread().name}")

//                    CoroutineScopeCoroutineContext(innerPadding)
//                    Test(innerPadding)
                    ObjectsClasses(innerPadding)
                }
            }
        }
    }
}


fun main() {
//    classes1()
//    classes2()
//    constructorsPrimarySecondary()
//    getterSetterLateInit()
//    InheritanceConcept()
//    overridingAndInheritanceConcept()
//    Polymorphism()
        PolymorphismAndInheritance()


}

// output : both threads run on main thread
//
//D  CoroutineScopeCoroutineContext: main thread = main
//D  CoroutineScopeCoroutineContext: increment =  main
