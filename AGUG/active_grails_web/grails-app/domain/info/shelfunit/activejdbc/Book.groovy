package info.shelfunit.activejdbc

class Book {

    // int book_id
    String title
    String summary
    BookAuthor author
    int yearPublished
    int numberOfPages
    
    // static belongsTo = [author: BookAuthor]
    static belongsTo = [BookAuthor]

    static constraints = {
        title blank: false
        summary blank: false 
        yearPublished blank: false
        numberOfPages blank: false, range: 10..1000
    }
    
    static mapping = {
        summary type: 'text'
        id column: 'book_id'
        id generator:'sequence', params:[ sequence:'book_id_seq' ]
    }
}

