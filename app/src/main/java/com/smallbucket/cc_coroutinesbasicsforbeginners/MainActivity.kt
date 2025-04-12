package com.smallbucket.cc_coroutinesbasicsforbeginners

//import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.LaunchVsAsyncAwait
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.CoroutineHeirarchy
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.CoroutineScopeCoroutineContext
//import com.smallbucket.cc_coroutinesbasicsforbeginnersasicsforbeginners.my1coroutinescopeandcontext.corroutineHeirarchy
import com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics.PolymorphismAndInheritance
import com.smallbucket.cc_coroutinesbasicsforbeginners.ui.theme.CCCoroutinesBasicsForBeginnersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            coroutineFn(modifier = Modifier)
            basicTextview()
        }
//        coroutineSuspendFn()
//        LaunchVsAsyncAwait()
        CoroutineHeirarchy()
    }
}

@Composable
fun coroutineFn(modifier: Modifier = Modifier) {
    CCCoroutinesBasicsForBeginnersTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Log.d(
                APP_TAG,
                "CoroutineScopeCoroutineContext: main thread = ${Thread.currentThread().name}"
            )
            CoroutineScopeCoroutineContext(innerPadding)
//                    Test(innerPadding)
            // ObjectsClasses(innerPadding)
        }
    }
// output : both threads run on main thread
//
//D  CoroutineScopeCoroutineContext: main thread = main
//D  CoroutineScopeCoroutineContext: increment =  main


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
}

@Composable
fun basicTextview() {

    Text(text = "Hello world", Modifier.padding(5.dp))
}
