package oop

import syntax_kotlin.SimpleInterface
import syntax_kotlin.SimpleInterface2

abstract class Abstract: SimpleInterface, SimpleInterface2, A(){ // cant extend 1+ classes, A2() {
}

open class A1: A2() // A3() A4() cant 1+ class extend
open class A2
open class A3
open class A4

interface I1: I2, I3, I4, I5 {
    val a: Int
        get() = 1
    val b: Int
}
interface I2
interface I3
interface I4
interface I5