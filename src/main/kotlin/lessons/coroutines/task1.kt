package lessons.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() {
    crt1()
}

fun crt1() = runBlocking {
    println("Start!!!")
    GlobalScope.launch {
        val time = measureTimeMillis {
            val one  = calc1()
            val two = calc2()
            println("The answer is ${one + two}, ")
        }
    }
    withContext(Dispatchers.IO) {

    }

    // start coroutine for some result
    val time = async {
        val one  = calc1()
        val two = calc2()
        println("The answer is ${one + two}, ")
    }
    println("E0F  by ${time.await()}")

}

suspend fun calc2(): Int {
    println("2")
    delay(1000)

    return 10
}

suspend fun calc1(): Int {
    println("1")
    delay(1000)
    return 10
}

fun calc3() {

}
