package differents
val months = listOf("January", "February", "March")

var ar = arrayListOf<Double>( 5.0, 1.0, 6.3266664, 1.0, 5.4466667, 1.0, 5.36, 6.0866666, 1.0, 4.85, 5.0533333, 5.3333335, 5.3133335, 4.633333, 1.0, 4.0, 4.0, 4.0, 5.5866666, 4.8733335, 5.113333, 5.2066665, 5.2933335, 5.4866667, 5.366667, 5.4466667, 4.5133333, 5.4933333, 5.3333335, 5.346667, 5.54, 5.54, 1.0, 4.0, 6.193333, 5.4533334, 3.6066666, 4.0, 3.6966667, 4.5266666, 5.8, 5.5133333, 4.44, 1.0, 6.1066666, 4.0, 4.8766665, 4.0, 5.4333334, 6.5866666, 5.7533336, 3.3999999, 6.113333, 5.6066666, 4.2799997, 3.1833334, 5.366667, 3.9766667, 4.0, 5.0933332, 5.16, 7.06, 4.2933335, 4.0, 5.5466666, 4.84, 5.2)

fun main(){


    println(">>>> ${ar.average()}")

    val test4 = Test4()
    test4.rep()
    val test5 = Test5()
    test5.rep()
    println()

    var b = months.filterNot { it == "January" }   // with explicit parameter name
    var a=  months.filter { it == "January" }             // with implicit parameter name "it"

    println(">> ${a.joinToString()}   >. ${b.joinToString()}")
}

abstract class lol() {
    var w: Int = 0


    abstract fun rep()

}

class Test4() : lol() {

    override fun rep() {

        w = 100
        println("differents.Test4 rep = ${w}")
    }
}

class Test5() : lol() {

    fun pop(){

    }

    override fun rep() {
        println("differents.Test5 rep = ${w}")
    }
}