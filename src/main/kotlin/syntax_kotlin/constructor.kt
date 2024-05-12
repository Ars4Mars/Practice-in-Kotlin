package syntax_kotlin

//class Person(val pets: MutableList<Pet> = mutableListOf())
//
//class Pet {
//    constructor(owner: Person) {
//        owner.pets.add(this) // adds this pet to the list of its owner's pets
//    }
//}


class Persona(private var name: String, num: Int) {
    // cant use var vals in secondary constructor
    //constructor(var name2: String, var parent: String): this(name2)

    constructor(name3: Int, parent: String): this(parent, num = 777) {
        name3
    }


    fun pip() {
       // name3
    }
    init {
        println("init block")
    }
}