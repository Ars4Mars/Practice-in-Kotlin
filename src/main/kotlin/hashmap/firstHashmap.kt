package hashmap

fun main() {
    println(foo(arrayOf(-1,2,5,9,2,-4),8).joinToString())

}

fun foo(items: Array<Int>, value: Int): Array<Int> {
    val hSet = HashSet<Int>()
    println("<>>> ${items.indices.joinToString()}")
    items.indices.forEach {
        val diff = value - items[it]

        if (hSet.contains(diff))

            return arrayOf(diff, items[it])
        hSet.add(items[it])

    }

    return arrayOf()
}