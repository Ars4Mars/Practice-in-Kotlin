import java.util.*
import kotlinx.coroutines.*

var a = 0
var b = 0
var operation = 0
var answer = 0
val input = Scanner(System.`in`)

fun main(args: Array<String>){
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(2000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }

        //println(a + b)
        //var operation = 0
        println("Welcome to Kotlin calculator! \n choose operation: \n 1- plus \n 2-minus \n 3-multiplay \n 4-divide ")
        inputNumber()
    }
fun inputNumber(){
    println("Welcome to Kotlin calculator! \n \bchoose two numbers")

    a = input.nextInt()
    b = input.nextInt()
    inputOper()
}

fun inputOper(){
     operation = input.nextInt()
    when (operation){
        1-> answer = a+b
        2-> answer = a-b
        3-> answer = a*b
        4-> answer = a/b
    }

    println(answer)

}