package syntax_kotlin

import oop.A

sealed interface SealIntrf

// public
sealed class sealedclass_simple : A() {
    abstract fun obj()
    fun objYavn() {}
}


// final
data class Pizdec(var a: Int = 1): sealedclass_simple() {
    override fun obj() {
        TODO("Not yet implemented")
    }
}

data class Pizdec2(var a: Int = 1): A()

// can`t:
//data class Pizdec3(var a: Int = 1): Pizdec()
