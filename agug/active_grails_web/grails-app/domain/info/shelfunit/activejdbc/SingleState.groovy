package info.shelfunit.activejdbc

class SingleState {
    
    String name
    int population
    String largestCity
    String capitalCity
    
    static constraints = {
        name blank: false, unique: true
        largestCity blank: false
        capitalCity blank: false
        population min: 10000
    }
}

