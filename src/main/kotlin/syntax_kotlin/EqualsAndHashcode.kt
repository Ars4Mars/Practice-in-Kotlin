package syntax_kotlin

import oop.A

fun main() {
    val a = "privet"
    val b = "privet"
    println(a == b )
    println(a === b)

    println("===========")
    val first =  Dom(1, "1")
    val second = Dom(1, "1")

    println(first == second) // equals
    println(first === second) // references

    //Structural equality (== - a check for equals())
    //
    //Referential equality (=== - two references point to the same object)

    println("==============")

    println("${12.0.compareTo(12)}") // 0 - is equal
    println("${12.0.compareTo(-12)}") // 1 - is more
    println("${-12.0.compareTo(12)}") // 0 - is equal
    println("${11.0.compareTo(12)}") // 0 - is smaller
}

data class Dom(var a : Int,var b: String): A()
