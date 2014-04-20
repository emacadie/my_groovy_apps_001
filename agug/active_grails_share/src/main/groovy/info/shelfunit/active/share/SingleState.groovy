package info.shelfunit.active.share

import org.javalite.activejdbc.Model
import org.javalite.activejdbc.annotations.Table

@Table( "single_state" )
class SingleState extends Model {

  static{ 
    validatePresenceOf( "state_name" ).message( "Please, provide the state's name" )
    validatePresenceOf( "largest_city" ).message( "Please, provide the name of the state's largest city" )
    validatePresenceOf( "capital_city" ).message( "Please, provide the name of the state's capital city" )
  }    

}

