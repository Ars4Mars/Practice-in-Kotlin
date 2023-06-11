package algorithms


fun main() {
    println(
        maximumWealth(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(3, 2, 1),
            )
        )
    )
    println(
        maximumWealth(
            arrayOf(
                intArrayOf(1, 5),
                intArrayOf(3, 7),
                intArrayOf(3, 5),
            )
        )
    )
}

fun maximumWealth(accounts: Array<IntArray>): Int {
    var arrayOfUsers = arrayOf<Int>()

    accounts.forEach {
        arrayOfUsers += it.sum()
    }
    //println(arrayOfUsers.joinToString())
    var maxV = 0
    arrayOfUsers.forEach {
        if (it > maxV) {
            maxV = it
        }
    }

    return maxV
}

fun maximumWealth2(accounts: Array<IntArray>) = accounts.map { it.sum() }.maxOrNull() ?: 0