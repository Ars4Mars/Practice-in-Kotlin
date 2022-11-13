package coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

//https://waynestalk.com/en/kotlin-coroutine-flow-tutorial-en/
var z_state  = MutableStateFlow(1)
var x_shared = MutableSharedFlow<Int>(1)

var SCAN_FILTERS = mutableListOf<String>()

fun main() = runBlocking {
    println("size: ${SCAN_FILTERS.size} ${SCAN_FILTERS.isNotEmpty()}")
    z_state.emit(1)
    x_shared.tryEmit(1)
    CoroutineScope(coroutineContext).launch {
        z_state.collect {

            println("z>> ${it}")
        }
    }

    CoroutineScope(coroutineContext).launch {
        x_shared.collect {

            println("x>> ${it}")
        }
        x_shared
            .map {

            }


    }

    async {
        while (true) {
            z_state.value = (0..10).random()

            x_shared.emit((0..10).random())
            x_shared.tryEmit((0..10).random())

            delay(1000) // Suspends the coroutine for some time
        }
    }.await()

}