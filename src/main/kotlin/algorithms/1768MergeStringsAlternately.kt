package algorithms

fun main() {
    println(mergeAlternately("abc","prb"))
}

fun mergeAlternately(word1: String, word2: String): String {

    var newStr = ""
    var cumIndx = 0

    repeat(word1.length + word2.length) {
        if(it <= word1.length-1) {
            newStr += word1[it]
            cumIndx++
        }

        if(it <= word2.length-1) {
            newStr += word2[it]
            cumIndx++
        }

    }

    return newStr
}