package info.shelfunit.misc

class Book {
    
    String title
    String author
    int pages
    String summary

    static constraints = {
        title blank: false
        author blank: false
        pages blank: false
        summary blank: false
    }
}

