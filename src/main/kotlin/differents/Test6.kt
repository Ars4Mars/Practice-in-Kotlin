package differents


fun main() {
    val simpleLambda : () -> Unit = { println("Hello") }

    val lambda : (String, String) -> String = { first: String, last: String ->

        "My name is $first $last"
    }



    var l = lambda("p","p")
}