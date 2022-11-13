package arrays

fun <E> Iterable<E>.replace(old: E, new: E) = map { if (it == old) new else it }

fun main() {
    var arrays = arrayListOf<Int>(1,2,3,4,5,6)

    arrays = arrays.replace(2,100) as ArrayList<Int>

    println("${arrays.joinToString()}")
}