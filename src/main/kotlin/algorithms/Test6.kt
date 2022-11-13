package algorithms


fun main() {
    getHammingDistSum(
        s = "aabbcc",
        k = 2
    )

    getHammingDistSum(
        s = "zzzzz",
        k = 2
    )
}
/*
 * Complete the 'getHammingDistSum' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER k
 */

fun getHammingDistSum(s: String, k: Int): Long {
    // Write your code here
    var turns = arrayListOf<String>()
    var turnMeOn = 0

    s.forEachIndexed { index: Int, c: Char ->
        val nextNum = s.getOrNull(index+1) ?: return@forEachIndexed
        turns.add((c+nextNum.toString()).toString())

    }

    turns.forEachIndexed { index, str ->
        //val nextNum = str.getOrNull(index+1) ?: return@forEachIndexed
        val charArray = str.toCharArray()
        println(charArray.joinToString())


        if (charArray[0].equals(charArray[1])) {

        } else {
            turnMeOn++
        }
    }

    var result = 0
    //check how many turns done
    turns.forEachIndexed { index, s ->

        if (index == turnMeOn || turnMeOn == 0) {
            return@forEachIndexed
        }else {
            result++
        }

    }


    println(turns)
    println(turnMeOn)
    println("Answer: $result")
    return result.toLong()
}


fun getHammingDistSum2(s: String, k: Int): Long {
    // Write your code here
    var turns = arrayListOf<String>()
    var turnMeOn = 0

    s.forEachIndexed { index: Int, c: Char ->
        val nextNum = s.getOrNull(index+1) ?: return@forEachIndexed
        turns.add((c+nextNum.toString()).toString())

    }

    turns.forEachIndexed { index, str ->
        //val nextNum = str.getOrNull(index+1) ?: return@forEachIndexed
        val charArray = str.toCharArray()
        println(charArray.joinToString())
        if (charArray[0].equals(charArray[1])) {

        } else {
            turnMeOn++
        }
    }

    println(turns)
    println(turnMeOn)
    return 0L
}
