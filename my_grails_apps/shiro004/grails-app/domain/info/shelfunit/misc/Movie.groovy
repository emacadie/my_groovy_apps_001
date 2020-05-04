package info.shelfunit.misc

class Movie {
    
    String title
    Integer year
    String summary

    static constraints = {
        title( blank: false, size: 5..30 )
        summary( blank: false, size: 5..500 )
        year( min: 1900 )
    }
}

