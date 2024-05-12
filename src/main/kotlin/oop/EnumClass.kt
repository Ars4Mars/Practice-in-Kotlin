package oop

open class Oper(override val b: Int) : A(), I1
enum class EnumClass {
}

sealed class DAF: A()

abstract class Rev :A () {
    var a = 1
    fun a() {
        println()
    }
}

interface Ver : I1, I2 {
    //var a = 1
    open fun ver1() {
        var b = 1
        println("sdf")
    }
}