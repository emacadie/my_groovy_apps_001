package info.shelfunit.active.share

import org.javalite.activejdbc.Model
import org.javalite.activejdbc.annotations.Table

@Table( "book_author" )
class BookAuthor extends Model {

  static{ 
    validatePresenceOf( "title" ).message( "Please, provide the book's title" )
    validatePresenceOf( "summary" ).message( "Please, provide a summary for the book" )
    validatePresenceOf( "year_published" ).message( "Please, provide the year the book was published" )
  }

}

