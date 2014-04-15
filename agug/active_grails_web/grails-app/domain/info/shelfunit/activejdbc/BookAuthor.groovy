package info.shelfunit.activejdbc

class BookAuthor {
    
    String firstName
    String lastName
    int yearOfBirth
    String country

    static constraints = {
        name blank: false, unique: true
        firstName blank: false
        lastName blank: false
        country blank: false
        yearOfBirth min: 1994
    }
}

