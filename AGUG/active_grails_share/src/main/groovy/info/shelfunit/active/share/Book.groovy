package info.shelfunit.active.share

import org.javalite.activejdbc.Model
import org.javalite.activejdbc.annotations.BelongsTo
import org.javalite.activejdbc.annotations.Table

@Table( "book" )
@BelongsTo(parent = BookAuthor.class, foreignKeyName = "author_id")
class Book extends Model {

  static{ 
    validatePresenceOf( "title" ).message( "Please, provide the book's title" )
    validatePresenceOf( "summary" ).message( "Please, provide a summary for the book" )
    validatePresenceOf( "year_published" ).message( "Please, provide the year the book was published" )
    validateNumericalityOf( "year_published" ).message( "This field must be a number" )
  }

}

