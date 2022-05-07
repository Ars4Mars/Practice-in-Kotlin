package differents

import java.io.File
import java.util.*


fun main() {


    //differents.noAlreadyParsedFromRaw ()
    findInArrayEquals()

}

fun noAlreadyParsedFromRaw(rawArray : Array<File>, parsedArray : Array<File>) {

    //1
    val rawArray    = arrayOf(1,2,3,4,5,12423,12,12,323,143)
    val parsedArray = arrayOf(5,4,3,2,123)

    var outputArray = mutableSetOf<Int>()

    //2
    println(Arrays.toString(rawArray     ))
    println(Arrays.toString(parsedArray  ))

    //3
    val iArray = rawArray.intersect(parsedArray.toList()).toIntArray() // find same elements
    for (i in rawArray) {

//        for (z in  parsedArray) {
//            if (z != i) {
//                parsedArray.contains()
//            }
//        }
        if (!parsedArray.contains(i)) {
            outputArray.add(i)
        }

    }

    //4
    println(Arrays.toString(iArray))
    println("-> ${outputArray.joinToString()}")
}

fun findInArrayEquals(
    //rawArray : Array<File>, parsedArray : Array<File>
) {
    val rawArray    = arrayOf(1,2,3,4,5,1242,12,12,323,143)
    val parsedArray = arrayOf(5,4,3,2,123)

    var outputArray = mutableSetOf<Int>()

    //2
    println(Arrays.toString(rawArray     ))
    println(Arrays.toString(parsedArray  ))

    //3
    val iArray = rawArray.intersect(parsedArray.toList()).toIntArray() // find same elements
    for (i in rawArray) {

        for (z in  parsedArray) {
            if (z != i && !parsedArray.contains(i)) {
                outputArray.add(i)
            }
        }

    }
    println("${outputArray.toString()} <<")
}


fun intersec4() {

    //1
    val rawArray    = arrayOf(1,2,3,4,5,12423,12,12,323,143)
    val parsedArray = arrayOf(5,4,3,2,123)

    var outputArray = mutableSetOf<Int>()

    //2
    println(Arrays.toString(rawArray     ))
    println(Arrays.toString(parsedArray  ))

    //3
    val iArray = rawArray.intersect(parsedArray.toList()).toIntArray()

    for ( i in 0 until iArray.size ) {
        for (v in 0 until rawArray.size) {

            if (iArray[i] != rawArray[v]) {
                outputArray.add(rawArray[v])

            }
        }
    }
    //4
    println(Arrays.toString(iArray))
    println("-> ${outputArray.joinToString()}")
}

fun intersec() {

    //1
    val firstArray = arrayOf(1,2,3,4,5)
    val secondArray = arrayOf(2,5,6,7)

    //2
    println(Arrays.toString(firstArray))
    println(Arrays.toString(secondArray))

    //3
    val iArray = firstArray.intersect(secondArray.toList()).toIntArray()

    //4
    println(Arrays.toString(iArray))
}

fun intersec2() {

    val a = listOf(1, 2, 3, 3, 4, 5, 5, 5, 6)
    val b = listOf(1, 3, 3, 3, 4, 4, 5, 6, 6, 7)

    var counter = 0

    var asd = arrayListOf<Int>()

    a.intersect(b).forEach { x -> counter += listOf(a.count {it == x}, b.count {it == x}).minOrNull()!! }

    println(counter)

}