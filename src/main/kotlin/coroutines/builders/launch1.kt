package coroutines.builders

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() {

    main3()
}
fun main3() = runBlocking {
    GlobalScope.async {

        launch {
            println(1)
        }
        launch {
            println(2)
        }
        launch {
            println(3)
        }
        launch {
            println(4)
        }

    }
    CoroutineScope(CoroutineName("")+Dispatchers.Unconfined)
    GlobalScope.async {
        this.coroutineContext[Job.Key]
        //Continuation
        launch {
            println(101)
        }
        launch {
            println(202)
        }
        launch {
            println(303)
        }
        launch {
            println(404)
        }

    }
    delay(1000)
}