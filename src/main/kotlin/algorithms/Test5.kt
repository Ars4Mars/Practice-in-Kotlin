package algorithms

fun main() {
    println(getOptimalStringLength(
        countA = 3,
        countB = 5,
        maxA = 1,
        maxB = 1
    ))
    println(getOptimalStringLength(
        countA = 2,
        countB = 4,
        maxA = 2,
        maxB = 1
    ))
    println(getOptimalStringLength(
        countA = 3,
        countB = 3,
        maxA = 3,
        maxB = 3
    ))
}

fun getOptimalStringLength(countA: Int, countB: Int, maxA: Int, maxB: Int): Long {
    var raw = arrayListOf<Int>()
    var result = arrayListOf<Int>()


    repeat(countA+countB) {
        if (it % 2 == 0) {
            raw.add(maxA)
        }else {
            raw.add(maxB)
        }
    }
    var alreadyCombined = true
    raw.forEachIndexed { index, i ->

        if (countA > countB && alreadyCombined) {
            result.add(i)

        }else {
            result.add(i)
        }
        alreadyCombined != alreadyCombined
    }


    return result.size.toLong()
}