package oop

fun main() {
    SimpleSealedClass.Load
}

class SealedFeaturesCheck : SealedClass(1,2) {
    override var b: Int
        get() = TODO("Not yet implemented")
        set(value) {}
}

class SealedFeaturesCheck2(override var a: Int) : SealedInterface {
    override fun pizdec() {
        TODO("Not yet implemented")
    }
}

class SealedFeturesCheck3: SimpleSealedClass()