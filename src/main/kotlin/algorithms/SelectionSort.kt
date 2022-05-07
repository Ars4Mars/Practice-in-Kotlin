package algorithms

class SelectionSort {

    fun calc(arr : Array<Int>) {

        //
        for (i in arr.indices) {

            var indexMIN = i
            for ( j in i+1 until arr.size ) {
                if (arr[j] < arr[indexMIN]) {
                    indexMIN = j
                }
            }


        }
    }
}