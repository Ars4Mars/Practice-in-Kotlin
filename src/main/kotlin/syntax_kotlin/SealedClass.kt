package syntax_kotlin

import oop.I1
import oop.I2


fun main() {
//    var a = SealedInterface
//
//    var b : SealedClass = AB()
//    when(b) {
//        SealedClass().
//    }
    val a = SimpleSealedClass.Load2
    when(a) {
        SimpleSealedClass.Load2 -> {}
        else -> {}
    }

//    val err : IOError = IOError
//
//    when(err) {
//        is DatabaseError -> TODO()
//        is FileReadError -> TODO()
//        else -> {}
//    }
}
sealed interface iError {
    //var pizdecx: Int = 1 // error
    // var a = listOf<Int>() // error

    object A: iError
}

sealed class IOError(): iError {
    var pizdecx: Int = 1
    var a = listOf<Int>()
}

class FileReadError(val file: String): IOError()
class DatabaseError(val source: Int): IOError()

object RuntimeError : iError
fun log(e: iError) = when(e) {
    is FileReadError -> { println("Error while reading file ${e.file}") }
    is DatabaseError -> { println("Error while reading from database ${e.source}") }
    RuntimeError ->  { println("Runtime error") }
    // оператор `else` не требуется, потому что мы покрыли все возможные случаи
    is DataClass2 -> TODO()
    is Fog -> TODO()
    iError.A -> TODO()
}

fun logEnum(e: EnumX) = when(e) {
    EnumX.ONE -> { println("Error while reading file $") }
    EnumX.TWO -> println()
    EnumX.THREE -> println()
    // оператор `else` не требуется, потому что мы покрыли все возможные случаи
}

sealed class SimpleSealedClass {
    object Load
    object Load2
    object Load3
}
//enum class SSM: EnumX {
//    ONE, TWO, THREE
//}

enum class EnumX {
    ONE, TWO, THREE
}

sealed class SealedClass(override var a: Int, v: Int) : I1, I2 {//: A(), SimpleInterface, SealedInterface, SimpleInterface2 {
    abstract override var b : Int
    val c = 12
}

class AB : SealedClass(1,2), SealedInterface {

    sealed class SC {}
    override var b: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun equals(other: Any?): Boolean {
        return this === other
    }

    override fun hashCode(): Int {
        return System.identityHashCode(this)
    }

    override fun pizdec() {
       // super.pizdec()
    }
}

class AF : SimpleInterface {
    override fun well() {
        TODO("Not yet implemented")
    }

    override var a: Int
        get() = TODO("Not yet implemented")
        set(value) {}

}

sealed interface SealedInterface {
    open fun pizdec() {
        println()
    }
    var a: Int
    //val c = 12 error
    class Loading()
    object Error
}

interface SimpleInterface {
    fun well()
    var a: Int
}

interface SimpleInterface2 {}