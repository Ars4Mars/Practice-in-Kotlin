package syntax_kotlin

fun main() {
    val a = XC(12)

    var x1 = a?.run { /** this */ null }  // return from lambda
    var x2 = a?.let { /** it, copy */ null }  // return from lambda

    var x3 = a?.apply { /** this */ null }   // return modificated x
    var x4 = a?.also { /** it, copy */ null }   // return modificated x

    println(x1)
    println(x2)
    println(x3)
    println(x4)
    //////
    println("//////////////")

    var y1 = a?.run   { /** this */ avr + 12     }  // return from lambda
    var y2 = a?.let   { /** it, copy */ it.avr + 12 }  // return from lambda
    var y3 = a?.apply { /** this */     avr = 44 }  // return modificated x
    var y4 = a?.also  { /** it, copy */ it.avr = 44 }  // return modificated x

    println(y1)
    println(y2)
    println(y3)
    println(y4)
}

data class XC(var avr: Int)