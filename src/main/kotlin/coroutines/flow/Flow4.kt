package coroutines.flow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Here I checked replycahce and etc
 */

var outputBytesRead           = MutableSharedFlow<Int>(10,0, BufferOverflow.SUSPEND)


fun main() = runBlocking<Unit>{
    launch1()

    repeat(11) {
        outputBytesRead.emit(it)
        delay(300)
    }
    launch2()
}

suspend fun launch1() {
    GlobalScope.launch {
        outputBytesRead.collect {
            println("> ${it}")
        }
    }


    println("<> ${outputBytesRead.replayCache.joinToString()}")

}

suspend fun launch2()  {
    GlobalScope.launch {
        outputBytesRead.collect {
            println(">> ${it}")
        }

    }

    println("<>>> ${outputBytesRead.replayCache.joinToString()}")

}