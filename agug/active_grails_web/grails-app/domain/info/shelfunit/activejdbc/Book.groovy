package info.shelfunit.activejdbc

class Book {

    String title
    String summary
    BookAuthor author
    int yearPublished
    
    // static belongsTo = [author: BookAuthor]
    static belongsTo = [BookAuthor]
    static mapping = {
        summary type: 'text'
    }
    static constraints = {
        title blank: false
        summary blank: false
        yearPublished blank: false
    }
}

