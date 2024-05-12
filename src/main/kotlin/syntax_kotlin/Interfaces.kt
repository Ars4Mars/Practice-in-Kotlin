package syntax_kotlin

import kotlinx.coroutines.*
import testfield.Interface2

suspend fun main(): Unit = coroutineScope {
    runBlocking {  }
    val job = launch(SupervisorJob()) {
        val job1 : Job = launch {
            delay(1000)
            throw RuntimeException()
        }
        val job2 : Job = launch {
            delay(2000)
            println("will not printed")
        }
        job1.join()
        job2.join()
        async {  }.await()
        //Number
    }
    job.join()

//    supervisorScope {
//        launch {
//            delay(1000)
//            throw RuntimeException()
//        }
//        launch {
//            delay(2000)
//            println("will not printed")
//        }
//    }


//    try {
//        launch {
//            delay(1000)
//            throw RuntimeException()
//        }
//    }catch (e: Exception) {
//        // can`t catch exception :(((
//        println("CATCHA!!")
//    }
}

data class Asd(
    val ddd: ArrayList<Int>)