package collab.todo

class BuddyListMember {
    
    String name
    String description
    
    static belongsTo = BuddyList

    static constraints = {
        name(blank:false)
    }
    
    String toString() {
        name
    }
}

