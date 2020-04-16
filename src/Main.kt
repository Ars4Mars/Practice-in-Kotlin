import java.util.*
import kotlinx.coroutines.*

var a = 0
var b = 0
var operation = 0
val input = Scanner(System.`in`)
fun main(args: Array<String>){
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(2000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }

        //println(a + b)
        //var operation = 0
        println("Welcome to Kotlin calculator! \n choose operation: \n 1- plus \n 2-minus \n 3-multiplay \n 4-divide ")
        InputNumber()
    }
fun InputNumber(){
    println("Welcome to Kotlin calculator! \n \bchoose two numbers")

    a = input.nextInt()
    b = input.nextInt()
    InputOper()
}

fun InputOper(){
     operation = input.nextInt()
    when (operation){
        1-> print(a+b)
        2-> print(a-b)
        3-> print(a*b)
        4-> print(a/b)
    }

}