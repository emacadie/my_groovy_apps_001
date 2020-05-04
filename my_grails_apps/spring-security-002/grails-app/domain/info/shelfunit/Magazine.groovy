package info.shelfunit

class Magazine {
    
    SecUser owner
    String title
    String topic
    
    static belongsTo = [SecUser]

    static constraints = {
        title blank: false
        topic blank: false
    }
}

