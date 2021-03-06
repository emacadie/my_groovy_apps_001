package info.shelfunit.active.share

import org.javalite.activejdbc.Model
import org.javalite.activejdbc.annotations.IdGenerator
// import org.javalite.activejdbc.annotations.IdName

import org.javalite.activejdbc.annotations.Table

// @IdName( "single_state_id" )
// @IdGenerator( "hibernate_sequence" )
@Table( "single_state" )
class SingleState extends Model {
    
    public SingleState() {
        super()
    }

  static { 
    validatePresenceOf( "state_name" ).message( "Please, provide the state's name" )
    validatePresenceOf( "largest_city" ).message( "Please, provide the name of the state's largest city" )
    validatePresenceOf( "capital_city" ).message( "Please, provide the name of the state's capital city" )
    validatePresenceOf( "version" ).message( "Please, provide a version number. 0 is a good choice" )
    validateNumericalityOf( "population" ).message( "This field must be a number" )
  }    
  
  def methodMissing( String name, args ) {
  }

}

