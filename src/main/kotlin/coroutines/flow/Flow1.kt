package coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.concurrent.Future


fun basicFlow(): Flow<Int> = flow {
    for (i in 0 until 3) {
        emit(i)
        delay(100)
        emit(i)
    }
}.flowOn(Dispatchers.IO)

fun main() {

    runDefault()
    GlobalScope.launch {
        delay(4000)

        job.cancel()
        //coroutineContext.ensureActive()
    }
}

fun latestNews() = flow {

    while (true) {
        val latestNews = listOf<Int>(1,2,3,4,5)
        emit(latestNews) // Emits the result of the request to the flow
        delay(1000) // Suspends the coroutine for some time
        return@flow
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