package collab.todo

class Keyword {
    
    String name
    String description
    
    static belongsTo = Todo
    static hasMany = [todos: Todo]
    
    static constraints = {
        name(blank:false,validator: {
            if (Keyword.findAllByDescription(it).size() > 0) {
                return false
            }
            return true
        })
    }
    
    String toString() {
        name
    }
}

