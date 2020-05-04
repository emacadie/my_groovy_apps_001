package info.shelfunit.constraints

class SizeClass {
    
    String firstString
    int firstInt
    // static hasMany = [ maxClasses: MaxClass,  minClasses: MinClass ]
    // static hasMany = [ minClasses: MinClass ]

    static constraints = {
        firstString size: 5..15
        firstInt size: 5..15
        // maxClasses size: 2..5
        // minClasses min: 2, maxSize: 5
    }
}

