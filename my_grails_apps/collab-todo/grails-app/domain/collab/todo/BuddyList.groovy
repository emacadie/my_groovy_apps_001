package collab.todo

class BuddyList {
    
    String name
    String description
    
    static belongsTo = Person
    static hasMany = [members: BuddyListMember]

    static constraints = {
        name(blank:false)
    }
    
    String toString() {
        name
    }
}

