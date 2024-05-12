package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() : Unit = coroutineScope {
    prlanch()

//    launch {
//        delay(2000)
//        println("Text 1")
//    }
//
//    launch {
//        delay(1000)
//        println("Text 2")
//    }

}

suspend fun prlanch() : Unit = coroutineScope {
    val job1 = launch {
        delay(1000)
        println("Text 1")
    }

    val job2 = launch {
        delay(2000)
        println("Text 2")
    }

    job1.join()
    job2.join()
    println(job1.isActive)
    println(job2.isCompleted)
}
