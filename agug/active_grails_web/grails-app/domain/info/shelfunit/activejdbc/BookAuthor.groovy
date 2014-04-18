package info.shelfunit.activejdbc

class BookAuthor {
    
    String firstName
    String lastName
    int yearOfBirth
    String country

    static constraints = {
        firstName blank: false
        lastName blank: false
        country blank: false
        yearOfBirth max: 1994
    }
}

