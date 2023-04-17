package algorithms

fun main() {
    isIsomorphic("egg","add")
    isIsomorphic("foo","bar")
    isIsomorphic("paper","title")
}

//fun isIsomorphic(s1: String, s2: String): Boolean {
//    val m = IntArray(512)
//    for (i in 0 until s1.length) {
//        if (m[s1[i].code] != m[s2[i].code + 256]) return false
//        m[s2[i].code + 256] = i + 1
//        m[s1[i].code] = m[s2[i].code + 256]
//    }
//    return true
//}
fun isIsomorphic(s1: String, s2: String): Boolean {
    var m = IntArray(512)
    for (i in 0 until s1.length) {
        if (m[s1[i].toInt()] != m[s2[i].code + 256]) return false
        m[s2[i].code + 256] = i + 1
        m[s1[i].code] = m[s2[i].code + 256]
    }
    return true
}