package testfield

import com.sun.org.apache.xalan.internal.lib.ExsltMath.abs

fun main() {
    var latA  =56.35257982648909//, 55.79914480447769
    var lonA  = 37.24612198770046//, 37.583546647801995


    var latB = 56.34786001872271
    var lonB = 37.323443284258246

    println((abs(latA-latB)) + (abs(lonA-lonB)))
}