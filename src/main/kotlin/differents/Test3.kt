package differents

import differents.User.UserBuilder

//CONFIGURATOR

fun main(){
    val user1 = UserBuilder("Lokesh", "Gupta")
        .age(30)
        .phone("1234567")
        .address("Fake address 1234")
        .build()

    val user2 = UserBuilder("","")
        .address("")
        .build()

    user2.address
    user1.phone
}

class User private constructor(builder: UserBuilder) {

    //constructor() : this()
    //All getter, and NO setter to provde immutability
    //All final attributes
    val firstName // required
            : String
    val lastName // required
            : String
    val age // optional
            : Int
    val phone // optional
            : String?
    val address // optional
            : String?

    override fun toString(): String {
        return "differents.User: " + firstName + ", " + lastName + ", " + age + ", " + phone + ", " + address
    }

    class UserBuilder(val firstName: String, val lastName: String) {
        var age = 0
        var phone: String? = null
        var address: String? = null
        fun age(age: Int): UserBuilder {
            this.age = age
            return this
        }

        fun phone(phone: String?): UserBuilder {
            this.phone = phone
            return this
        }

        fun address(address: String?): UserBuilder {
            this.address = address
            return this
        }

        //Return the finally consrcuted differents.User object
        fun build(): User {
            val user = User(this)
            validateUserObject(user)
            return user
        }

        private fun validateUserObject(user: User) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }

    init {
        firstName = builder.firstName
        lastName = builder.lastName
        age = builder.age
        phone = builder.phone
        address = builder.address
    }
}