package syntax_kotlin

import oop.I1


fun main() {
    val (age, name) = Pair(12,"ccc")
    val (age1, name2, name3) = Triple(12,"ccc", "")

    println("$age" + name)
}
data class DataClass(var abn: Int) : I1 {
    override val b: Int get() = TODO("Not yet implemented")
}

data class DataClass2(var a: Int) :iError {

}

open class Fog(): iError {

}

data class Cat(var height: Int, var weight: Int)
