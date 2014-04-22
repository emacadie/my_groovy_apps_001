package info.shelfunit.active.standalone

import org.javalite.activejdbc.Model

class BookAuthor extends Model {

  static{ 
    validatePresenceOf( "first_name" ).message( "Please, provide the book's title" )
    validatePresenceOf( "last_name" ).message( "Please, provide a summary for the book" )
    validatePresenceOf( "country" ).message( "Please, provide the year the book was published" )
    validatePresenceOf( "year_of_birth" ).message( "Please, provide the year the book was published" )
  }

}

