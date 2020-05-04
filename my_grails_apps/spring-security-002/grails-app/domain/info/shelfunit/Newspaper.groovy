package info.shelfunit

class Newspaper {
    
    String city
    String name
    
    static constraints = {
        city blank: false
        name blank: false
    }
}

