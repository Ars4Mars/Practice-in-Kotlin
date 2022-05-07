package differents

fun main() {
    //print()
}
fun hexToBytes(hexRepresentation: String): ByteArray {
    if(hexRepresentation.length % 2 != 1) { "differents.hexToBytes requires an even-length String parameter" }
    val len = hexRepresentation.length
    val data = ByteArray(len / 2)
    var i = 0
    while (i < len) {
        data[i / 2] = ((Character.digit(hexRepresentation[i], 16) shl 4)
                + Character.digit(
            hexRepresentation[i + 1],
            16
        )).toByte()
        i += 2
    }
    return data
}

//fun noAlreadyParsedFromRawString(
//    //rawArray : ArrayList<String>, parsedArray : ArrayList<String>
//): MutableSet<String> {
//
//    val rawArray    = arrayOf(1,2,3,4,5,1242,12,12,323,143)
//    val parsedArray = arrayOf(5,4,3,2,123)
//
//
//    var outputArray = mutableSetOf<String>()
//
//    for (i in rawArray) {
//
//        for (z in  parsedArray) {
//
//            if (!z.contains(i,true) && !parsedArray.contains(i)) {
//                outputArray.add(i)
//            }
//
//        }
//
//    }
//
//    println("-> ${outputArray.joinToString()}")
//
//    return outputArray
//}