package collab.todo

class Person {
    
    static transients = [ "confirmPassword" ]

    String personName
    String firstName
    String lastName
    String email
    String password
    String confirmPassword
    
    static hasMany = [todos: Todo, categories: Category, buddyLists: BuddyList]

    static constraints = {
        personName(blank:false,unique:true, maxSize:16)
        firstName(blank:false)
        lastName(blank:false)
        email(nullable:true)
        password(nullable:true, minLength:8)
    }

    String toString () {
        "$lastName, $firstName"
    }
    
    static mapping = {
        tablePerHierarchy true
    }
}

/*
class Admin extends Person {
    String department
}
*/
