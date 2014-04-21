package info.shelfunit.active.share

import org.javalite.activejdbc.Model
import org.javalite.activejdbc.annotations.Table

@Table( "book_author" )
class BookAuthor extends Model {
        firstName blank: false
        lastName blank: false
        country blank: false
        yearOfBirth max: 1994
  static{ 
    validatePresenceOf( "first_name" ).message( "Please, provide the book's title" )
    validatePresenceOf( "last_name" ).message( "Please, provide a summary for the book" )
    validatePresenceOf( "country" ).message( "Please, provide the year the book was published" )
    validatePresenceOf( "year_of_birth" ).message( "Please, provide the year the book was published" )
  }

}

