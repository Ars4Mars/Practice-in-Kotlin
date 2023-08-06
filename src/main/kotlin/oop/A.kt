package oop

//only with open
open class A {
    open var cv = 1

    open fun pizdec() {}

    fun nepizdec() {}
}

class B : A() {
    override var cv: Int = 1

    init {
        pizdec()
    }

    override fun pizdec() {
        super.pizdec()
    }
}
