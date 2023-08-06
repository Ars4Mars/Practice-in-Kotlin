package oop


fun main() {
//    var a = SealedInterface
//
//    var b : SealedClass = AB()
//    when(b) {
//        SealedClass().
//    }
}

sealed class SimpleSealedClass {
    object Load
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
    open fun pizdec()
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