package testfield

import java.util.*

fun main() {
    val locale = Locale("en", "RU")
    val iso = locale.isO3Country
    val name = locale.getDisplayCountry()
    val code = locale.country

    val lookingForCity = "France"
    var answer = ""
    Locale.getISOCountries().forEach {
        if (Locale("en", it).displayCountry == lookingForCity) {
            answer = it
        }
    }
    println(">>> ${answer}")

    println(" ${iso} ${name} ${code}")
}

fun String.displayCountry() : String? = Locale.getISOCountries()
    .find { Locale("en", it.toString()).displayCountry == this }
