import java.util.*

fun main(args: Array<String>){
       println("Welcome to Kotlin calculator! \n \bchoose two numbers")
        val input = Scanner(System.`in`)
        val a = input.nextInt()
        val b = input.nextInt()
        //println(a + b)
        //var operation = 0
        println("Welcome to Kotlin calculator! \n choose operation: \n 1- plus \n 2-minus \n 3-multiplay \n 4-divide ")
        var operation = input.nextInt()
        when (operation){
            1-> print(a+b)
            2-> print(a-b)
            3-> print(a*b)
            4-> print(a/b)
        }
    }