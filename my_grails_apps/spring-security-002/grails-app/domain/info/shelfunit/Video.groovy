package info.shelfunit

class Video {

    String author
    String name
    int minutes
    int seconds
    
    static constraints = {
        author blank: false
        name blank: false
        minutes nullable: false, min: 0
        seconds nullable: false, min: 0
    }
}

