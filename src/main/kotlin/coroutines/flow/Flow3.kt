package coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect


var shared_1 = MutableSharedFlow<Int>(5,0,BufferOverflow.SUSPEND)
var state_1  = MutableStateFlow(1)



fun main() = runBlocking<Unit>{



    GlobalScope.launch {

    }
    shared_1.tryEmit(3)
    shared_1.tryEmit(4)
    shared_1.tryEmit(2)


    observer()
    shared_1.tryEmit(3)

    shared_1.tryEmit(4)

    shared_1.tryEmit(5)
    println("<>>>> ${shared_1.replayCache.joinToString()}")

//    state_1.emit(0)
//    state_1.emit(3)
//    state_1.emit(4)


}

suspend fun observer() {
    GlobalScope.async {
//        state_1.emit(2)
//
//        state_1.collect {
//            println("<>> ${it}")
//        }


        println("<>> it}")
        shared_1.collect {
            println("<>> ${it}")


        }

    }//.await()
}