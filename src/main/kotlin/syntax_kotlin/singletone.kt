package syntax_kotlin
class Cock() {
    init {
        val (age, name) = Pair(12,"")


    }
    companion object {

        @JvmStatic // will generate getters and setters
        val abc = 1

        fun a() {}
        @JvmStatic
        fun b() {}

        val rebecca = 2
    }
}

object a {
    var a = 1
}