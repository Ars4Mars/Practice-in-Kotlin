package functions

fun main() {
    var str = "WHOWHO"

    var a = str.let { it }
    var b = str.run { this }

    var c = str.also { it }
    var d = str.apply{ this }

    val f = with(str) { this }


}