package com.smallbucket.cc_coroutinesbasicsforbeginners.my1coroutinescopeandcontext

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun LaunchVsAsyncAwait() {
//   launchSyntax()
    CoroutineScope(Dispatchers.Main).launch {
        launchEg1()
//        asyncEg1()
    }
}

suspend fun asyncEg1() {
    printFollowersUsingAsync()
    printFollowersUsingAsyncCombined()
}

suspend fun launchEg1() {
//    printFollowersUsingLaunch()
    printFollowersUsingLaunchCombined()
}

suspend fun launchSyntax() {
    val job: Job = CoroutineScope(Dispatchers.Main).launch { }
    job.join()
}

suspend fun getFbFollowers(): Int {
    delay(1000) // suppose api call takes 1 sec to bring data of followers
    return 54
}

suspend fun getInstaFollowers(): Int {
    delay(1000) // suppose api call takes 1 sec to bring data of followers
    return 72
}

suspend fun printFollowersUsingLaunch() {
    var fbFollowers = 0
    var instaFollowers = 0
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        fbFollowers = getFbFollowers()
    }
    val job2 = CoroutineScope(Dispatchers.Main).launch {
        instaFollowers = getInstaFollowers()
    }
    job.join()
    job2.join()
    Log.d(APP_TAG, "Fb - ${fbFollowers} , Insta - ${instaFollowers}") // Fb - 54 , Insta - 72
}


suspend fun printFollowersUsingAsync() {
    val defered1 = CoroutineScope(Dispatchers.Main).async {
        // returns Deferred<T>, T is return type of last statement of this function
        getFbFollowers()
        // "22" // Deferred<String>
        // 22 // Deferred<Int>
    }
    // job.await() means we shall wait for async operation
    // Log.d(APP_TAG, "Fb Followers UsingAsync : ${defered1.await()}") // Fb Followers UsingAsync : 54

    val defered2 = CoroutineScope(Dispatchers.Main).async {
        getInstaFollowers()
    }

    Log.d(
        APP_TAG,
        "Fb - ${defered1.await()} , Insta - ${defered2.await()}  (Async)"
    ) // Fb - 54 , Insta - 72  (Async)")

}

suspend fun printFollowersUsingAsyncCombined() {
    val def1 = CoroutineScope(Dispatchers.Main).async {

    }

}

suspend fun printFollowersUsingLaunchCombined() {
    CoroutineScope(Dispatchers.Main).launch {
        var fbFollowers = async { getFbFollowers() }
        var instaFollowers = async { getInstaFollowers() }
        Log.d(APP_TAG, "Fb - ${fbFollowers.await()} , Insta - ${instaFollowers.await()} ")
    }
}