package syntax_kotlin

fun main() {
    val newObject= object {
        val one = "Hello"
        val two = "World"
        override fun toString() = "$one $two"
    }
    newObject.one
}
