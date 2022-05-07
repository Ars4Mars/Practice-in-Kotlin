package multithreading

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun main() = coroutineScope {


    var asd = async {
        delay(1000)
        println("Third")
        true
    }
    var asd2 = async {
        delay(1000)
        println("Second")
        true
    }

    if (asd.await() && asd2.await()) {
        println("YYYYEEEEEYYY")
    }


//    var a = CoroutineScope(Dispatchers.Default).launch {
//        asyncLoader()
//    }


}

suspend fun asyncLoader() = CoroutineScope(Dispatchers.Default).launch {

}