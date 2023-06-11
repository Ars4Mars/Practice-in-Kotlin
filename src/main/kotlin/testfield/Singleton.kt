package testfield

class Singleton private constructor() {
    var incr = 0
    companion object {

        @Volatile
        private var instance: Singleton? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: Singleton().also { instance = it }
            }
    }

    fun doSomething(): String {
        incr++
        return "Doing something ${incr}"
    }
}

object SingleTwo {
    var incr = 0

    fun doSomething(): String {
        incr++
        return "Doing something ${incr}"
    }
}

class SingleThree {
    var incr = 0

    fun doSomething(): String {
        incr++
        return "Doing something ${incr}"
    }
}

fun main() {
    println("\nSingleton ✅")
    println(">> ${Singleton.getInstance().doSomething()}")
    println(">> ${Singleton.getInstance().doSomething()}")
    println(">> ${Singleton.getInstance().doSomething()}")

    println("\nSingleton ✅")
    println(">> ${SingleTwo.doSomething()}")
    println(">> ${SingleTwo.doSomething()}")
    println(">> ${SingleTwo.doSomething()}")

    println("\nSingleton ❌")
    println(">> ${SingleThree().doSomething()}")
    println(">> ${SingleThree().doSomething()}")
    println(">> ${SingleThree().doSomething()}")
}