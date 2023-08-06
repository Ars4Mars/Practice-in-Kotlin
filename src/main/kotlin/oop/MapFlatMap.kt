package oop

fun main() {
    // one to one
    val list1 = listOf(1.5, 2.5, 4.5, 5.5)
    println(list1.map { it.toInt() }) // [1, 2, 3, 4, 5]

    // one to many things
    val list = listOf("123", "45")
    println(list.flatMap { it.toList() }) // [1, 2, 3, 4, 5]
}