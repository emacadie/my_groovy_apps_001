package info.shelfunit

class Book {
    
    SecUser owner
    String title
    String author
    
    static belongsTo = [SecUser]

    static constraints = {
        title blank: false
        author blank: false
    }
}

