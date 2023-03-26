package algorithms

fun main() {
    println(runningSum(intArrayOf(1,2,3,4)).joinToString())
    //println(runningSum(intArrayOf(1,2,3,4)))

}

fun runningSum(nums: IntArray): IntArray {
    var presum = 0
    var newArray = IntArray(nums.size)

    nums.forEachIndexed { index, i ->
        presum += i
        newArray[index] = presum
    }

    return  newArray
}