package coroutines.observer

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

interface Observer<T> {
    fun onChange(newValue: T?)
}

class Observable<T>(initialValue: T? = null) {

    // List ov observers watching this value for changes
    private val observers = mutableListOf<Observer<T>>()

    // The real value of this observer
    // Doesn't need a custom getter, but the setter
    // we override to allow notifying all observers
    var value: T? = initialValue
        set(value) {
            field = value
            notifyObservers()
        }

    fun observe(observer: Observer<T>) {
        observers.add(observer)
    }

    private fun notifyObservers() {

        observers.forEach { observer ->
            observer.onChange(value)
        }

    }

}

// Extension function so we don't need to instantiate IObserver
fun <T> Observable<T>. observe(block: (T?) -> Unit) {
    observe(object : Observer<T> {
        override fun onChange(newValue: T?) {
            block(newValue)
        }
    })
}

fun main() = runBlocking {

    // New observable with false initial value
    val skyIsBlue = Observable<ArrayList<Int>>(arrayListOf(1,2,3,4))

    // Normal way to observe (too verbose, so use extension fun below
    /*skyIsBlue.observe(object : IObserver<T> {
        override fun onChange(newValue: T?) {
            // ...
        }
    })*/

    // Add an observer to get change updates
    skyIsBlue.observe {
        println("Observer hit, new value = $it")
    }

    async {

        while (true) {
            skyIsBlue.value = arrayListOf((0..10).random())
            delay(100)
            if ((0..3).random() == 3){
                // return is mean exit from async and continue code below
                return@async
            }
        }

    }.await()
    // Now change the value - the observer should hit
    println("WEEEELELLLLLLLLL")
    skyIsBlue.value = arrayListOf((0..10).random())

}