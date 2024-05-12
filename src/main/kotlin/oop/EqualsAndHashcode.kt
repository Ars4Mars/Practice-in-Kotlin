package oop

fun main() {
    data class Storage(private val name: String, private val capacity: Int)

    val storage1 = Storage("master", 1024)
    val storage2 = Storage("master", 102)
    println(storage1 == storage2)
    println(storage1.equals( storage2))
    println(storage1.hashCode() ==  (storage2.hashCode()))
}

data class Pop(var a : String) : A()
open class EqualsAndHashcode
//class ABB() : Pop()
