package filters

fun main() {

    var res = "string-333".replace("[^0-9\\-]".toRegex(), "")

    println(res)
}