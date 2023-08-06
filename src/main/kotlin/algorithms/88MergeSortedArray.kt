package algorithms

fun main() {
    merge(intArrayOf(1,2,3,0,0,0),3, intArrayOf(2,5,6),3)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    val mergedArray = (nums1.take(m)+nums2.take(n)).sorted()

    println(" ${mergedArray.joinToString()}")
}