package arrays

fun main() {
    val arr = arrayListOf(1,2,3,4,5)

    println("<>> ${arr.indexOfFirst { it == 3 }}")
}