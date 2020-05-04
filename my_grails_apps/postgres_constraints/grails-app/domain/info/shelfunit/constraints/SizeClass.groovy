package info.shelfunit.constraints

class SizeClass {

    String firstString
    int firstInt
    // static hasMany = [ maxClasses: MaxClass,  minClasses: MinClass ]
    // static hasMany = [ minClasses: MinClass ]
    static hasMany = [ uniqueClasses: UniqueClass ]

    static constraints = {
        firstString size: 5..15
        firstInt size: 5..15
        // maxClasses size: 2..5
        // minClasses min: 2, maxSize: 5
        // uniqueClasses size: 2..5 // allows me to create a record w/0, but complains on edit
        // uniqueClasses range: 2..5 // this does nothing
        uniqueClasses minSize: 2, maxSize: 5 // I can add record w/0, complains on edit, or creating w/ 1
    }
}

