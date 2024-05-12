package syntax_kotlin

//private class Persona(age: T) {
//    var age: T = age
//}


class Personx<T>(age: T){
    var age: T = age
    init {
        this.age= age
        println(age)
    }
}
fun main(){
    var ageInt = Personx(30)
    var ageString = Personx("40")
}