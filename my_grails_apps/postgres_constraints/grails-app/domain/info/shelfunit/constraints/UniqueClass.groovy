package info.shelfunit.constraints

class UniqueClass {
    
    String firstString
    int firstInt

    static constraints = {
        firstString unique: true
        firstInt unique: true
    }
}

