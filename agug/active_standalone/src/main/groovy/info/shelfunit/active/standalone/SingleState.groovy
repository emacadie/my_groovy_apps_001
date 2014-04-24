package info.shelfunit.active.standalone

// import org.javalite.activejdbc.LazyList
import org.javalite.activejdbc.Model

class SingleState extends Model {
    
    static performedMagic = false
    static theTokens = []
    static capTokens = []
    /*
    static {
        println "making static method findByLargestCity"
        SingleState.metaClass.static.findByLargestCity = { String arg ->
            SingleState.where( "largest_city = ?", arg )
        }
        
        getMetaModel().getAttributeNamesSkipGenerated().each { theProp ->
            println "next prop is ${theProp}"
            theTokens.clear()
            capTokens.clear()
            theTokens = theProp.tokenize( '_' )
                
            theTokens.each { capTokens << it.capitalize() }
            println "Trying to make ${'get' + capTokens.join()}"
            
            SingleState.metaClass."${'get' + capTokens.join()}" { ->
                    delegate.get( theProp )
            }
            println "Making setter"
            SingleState.metaClass."${'set' + capTokens.join()}" { Object arg ->
                    delegate.set( theProp, arg )
            }
        } // end each
    }
    */
    // This was in static
     /*
        getMetaModel().getAttributeNamesSkipGenerated().each { theProp ->
                println "next prop is ${theProp}"
                theTokens.clear()
                capTokens.clear()
                theTokens = theProp.tokenize('_')
                
                theTokens.each { capTokens << it.capitalize() }
                println "making static method ${'findBy' + capTokens.join()}"
                methodName = 'get' + capTokens.join()
                SingleState.metaClass.'static'."${'findBy' + capTokens.join()}" { Object arg ->
                    println "In the body for the static method, here is arg: ${arg}"
                    // SingleState.where( "${theProp} = ?", arg )
                }
                println "done making static method ${'findBy' + capTokens.join()}"
                
                println "Making setter"
                this.metaClass."${'set' + capTokens.join()}" { Object arg ->
                    this.set( theProp, arg )
                }
                
         } // end each
         */
    
    public SingleState() {
        super()
        
        /*
        println "Look at me!!"
        if ( !performedMagic ) {
            performedMagic = true
        }
        */
    }

  static{ 
    validatePresenceOf( "state_name" ).message( "Please, provide the state's name" )
    validatePresenceOf( "largest_city" ).message( "Please, provide the name of the state's largest city" )
    validatePresenceOf( "capital_city" ).message( "Please, provide the name of the state's capital city" )
  }    
  
  def methodMissing( String name, args ) {
      println "Method name is ${name}, args are ${args}"
  }

}


