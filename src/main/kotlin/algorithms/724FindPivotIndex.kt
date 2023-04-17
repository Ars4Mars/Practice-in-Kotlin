package algorithms


fun main() {
    println(pivotIndex(intArrayOf(1,7,3,6,5,6)))
}

fun pivotIndex(nums: IntArray) : Int {
    var rsum = nums.sum()
    var lsum = 0
    for (i in nums.indices) {
        rsum -= nums[i]
        if (rsum == lsum) return i
        lsum += nums[i]
    }
    return -1
}
fun pivotIndex2(nums: IntArray): Int {
    if (nums.size == 3) return -1
    var arr = arrayListOf<Int>()
    var arrRevers = arrayListOf<Int>()

    var sum = 0
    nums.forEachIndexed { index, i ->
        sum += i
        arr.add(sum)
    }

    var sumRevers = 0
    nums.toList().asReversed().forEachIndexed { indexZ, z ->
        sumRevers += z
        arrRevers.add(sumRevers)
    }

    println(arr.joinToString())
    println(arrRevers.joinToString())

    //
    arr.forEachIndexed { index, i ->

        if (arrRevers.contains(i)) {
            return index+1
        }
//        if (i==arrRevers[index]) {
//
//        }
    }
    return -1
}
