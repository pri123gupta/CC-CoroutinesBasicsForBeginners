package com.smallbucket.cc_coroutinesbasicsforbeginners

//import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.LaunchVsAsyncAwait
//import com.smallbucket.cc_coroutinesbasicsforbeginnersasicsforbeginners.my1coroutinescopeandcontext.corroutineHeirarchy
//import com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels.FlowBuilderActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.APP_TAG
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.CoroutineScopeCoroutineContext
import com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext.MainViewModel
import com.smallbucket.cc_coroutinesbasicsforbeginners.my2basics.PolymorphismAndInheritance
import com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels.SharedFlowActivity
import com.smallbucket.cc_coroutinesbasicsforbeginners.my3flowschannels.StateFlowActivity
import com.smallbucket.cc_coroutinesbasicsforbeginners.ui.theme.CCCoroutinesBasicsForBeginnersTheme

class MainActivity : ComponentActivity() {
    lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            coroutineFn(modifier = Modifier)
            basicTextview()
        }
//        coroutineSuspendFn()
//        LaunchVsAsyncAwait()
//        CoroutineHeirarchy()
//        WithContextRunblocking()

        /*      vm = ViewModelProvider(this).get(MainViewModel::class.java) // ViewModelScopeFn()
              lifecycleScope.launch {
                  delay(2000)
                  startActivity(Intent(this@MainActivity, FlowsChannelsActivity2::class.java))
                  finish() // to destroy lifecycleScope
              }*/
        // Output - after 2 sec. vm is destroyed
//        hello from me
//        hello from me
//        hello from me
//        hello from me
//        hello from me
//        vm destroyed      // after 2 sec. vm is destroyed

//        startActivity(Intent(this@MainActivity, FlowsActivity::class.java))
//        startActivity(Intent(this@MainActivity, ChannelsActivity::class.java))
//        startActivity(Intent(this@MainActivity, FlowBuilderActivity::class.java))
        //startActivity(Intent(this@MainActivity, FlowOperatorsTerminalMapFilterBufferActivity::class.java))
//        startActivity(Intent(this@MainActivity, ContextPreservationFlowOnExceptionHandlingActivity::class.java))
//        startActivity(Intent(this@MainActivity, SharedFlowActivity::class.java))
        startActivity(Intent(this@MainActivity, StateFlowActivity::class.java))


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
fun basicTextview(text: String = "Hello World") {

    Column(
        Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, Modifier.padding(5.dp))
    }
}
