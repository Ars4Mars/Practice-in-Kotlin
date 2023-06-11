package testfield

fun main() {
    val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
    var result = items.fold(8) { acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        0
    }

}

fun <T, R> Collection<T>.pizdec(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}