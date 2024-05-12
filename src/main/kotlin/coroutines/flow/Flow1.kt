package coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.concurrent.thread


fun basicFlow(): Flow<Int> = flow {
    for (i in 0 until 3) {
        emit(i)
        delay(100)
        emit(i)
    }
}.flowOn(Dispatchers.IO)

var a_state  = MutableStateFlow(1)
var b_shared = MutableSharedFlow<Int>(1)
var a = MutableSharedFlow<Int>(2)



fun main() = runBlocking {
    GlobalScope.launch {
        while (true) {
            a.collect {
                println("<>>>> ${it}")
            }
            delay(100)
        }
    }
    GlobalScope.launch {

        println("8888")

        a.emit(1)

        //delay(100)


        a.emit (2)

        println("<>>>> $}")


        a_state.collect {
            println("a>> ${it}")
        }
        val abb = thread {

        }
        val deffered = GlobalScope.async { 1 }
        GlobalScope.launch {  }
        abb.join()
//        b_shared.collectLatest {
//            println("b>> latest ${it}")
//        }
        b_shared.collect {
            println("b>> ${it}")
        }

        delay(4000)

        //job.cancel()
        //coroutineContext.ensureActive()
    }
    runDefault()

}

fun latestNews() = flow {

    while (true) {
        a_state.value = (0..10).random()

        b_shared.emit((0..10).random())
        b_shared.tryEmit((0..10).random())
        b_shared
        val latestNews = listOf<Int>(1,2,3,4,5)
        emit(latestNews) // Emits the result of the request to the flow
        delay(1000) // Suspends the coroutine for some time
        //return@flow
    }


}

val job = GlobalScope.launch { latestNews().cancellable().collect {
    println(">> ${it}  ")
}
}

fun runDefault() = runBlocking {
    println("Flow1")
    job.join()
    delay(4000)


    //job.cancel()

//    basicFlow().collect {
//        println(it)
//    }
//    latestNews().collect { int ->
//        //it
//        println(int)
//        println("weelll")
//    }
}