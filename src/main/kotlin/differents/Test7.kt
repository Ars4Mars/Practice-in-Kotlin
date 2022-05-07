package differents

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    createPostAsync("",{

    }) {

    }
}

fun createPostAsync(token : String, answer : (Int) -> Unit,fail : (Int) -> Unit ) {
    GlobalScope.launch {
        delay(3000)
        answer(99)
        fail(66) // error
    }
}