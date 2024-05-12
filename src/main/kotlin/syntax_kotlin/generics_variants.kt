package syntax_kotlin


// variantnost
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // Всё в порядке, т.к. T — out-параметр
    // ...
}

/////////////////////////////////////////////////////////////////////////

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return value
    }
}

val parameterizedProducer = ParameterizedProducer("string")

val ref: ParameterizedProducer<Any> = parameterizedProducer

//assertTrue(ref is ParameterizedProducer<Any>)



class ParameterizedConsumer<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

val parameterizedConsumer = ParameterizedConsumer<Number>()

val ref2: ParameterizedConsumer<Double> = parameterizedConsumer

//assertTrue(ref2 is ParameterizedConsumer<Double>)