package collab.todo

class Category {

    String name
    String description
    Person person
    
    static belongsTo = Person
    static hasMany = [todos: Todo]

    static constraints = {
        name(blank:false)
    }
    
    String toString() {
        name
    }
}

