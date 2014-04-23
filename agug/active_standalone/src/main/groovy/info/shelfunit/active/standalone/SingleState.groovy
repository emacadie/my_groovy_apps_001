package info.shelfunit.active.standalone

import org.javalite.activejdbc.LazyList
import org.javalite.activejdbc.Model

class SingleState extends Model {
    
    static performedMagic = false
    static theTokens = []
    static ff = []
    static String methodName
    /*
    static {
        SingleState.metaClass.'static'.findByLargestCity { String arg ->
                    println "In the body for the static method, here is arg: ${arg}"
                    SingleState.where( "largest_city = ?", ":" + arg )
                }
                
        getMetaModel().getAttributeNamesSkipGenerated().each { theProp ->
                println "next prop is ${theProp}"
                theTokens.clear()
                ff.clear()
                theTokens = theProp.tokenize('_')
                
                theTokens.each { ff << it.capitalize() }
                println "making static method ${'findBy' + ff.join()}"
                methodName = 'get' + ff.join()
                SingleState.metaClass.'static'."${'findBy' + ff.join()}" { Object arg ->
                    println "In the body for the static method, here is arg: ${arg}"
                    // SingleState.where( "${theProp} = ?", arg )
                }
                println "done making static method ${'findBy' + ff.join()}"
                
                println "Making setter"
                this.metaClass."${'set' + ff.join()}" { Object arg ->
                    this.set( theProp, arg )
                }
                
         } // end each
         
    }
    */
    public SingleState() {
        super()
        // make getters and setters for instance
        getMetaModel().getAttributeNamesSkipGenerated().each { theProp ->
            println "next prop is ${theProp}"
            theTokens.clear()
            ff.clear()
            theTokens = theProp.tokenize('_')
                
            theTokens.each { ff << it.capitalize() }
            println "Trying to make ${'get' + ff.join()}"
            methodName = 'get' + ff.join()
            this.metaClass."${'get' + ff.join()}" { ->
                    delegate.get( theProp )
            }
            println "Making setter"
            this.metaClass."${'set' + ff.join()}" { Object arg ->
                    this.set( theProp, arg )
            }
        } // end each
        println "Look at me!!"
        if ( !performedMagic ) {
            println "making static method findByLargestCity"
            // Book.metaClass.static.create << { String title -> new Book(title:title) }
            SingleState.metaClass.static.findByLargestCity = { String arg ->
                    // println "In the body for the static method, here is arg: ${arg}"
                    SingleState.where( "largest_city = ?", ":${arg}"  )
                }
            /*
            // ===> [largest_city, capital_city, state_name, population]
            getMetaModel().getAttributeNamesSkipGenerated().each { theProp ->
                println "next prop is ${theProp}"
                theTokens.clear()
                ff.clear()
                theTokens = theProp.tokenize('_')
                
                theTokens.each { ff << it.capitalize() }
                println "making static method ${'findBy' + ff.join()}"
                methodName = 'get' + ff.join()
                SingleState.metaClass.'static'."${'findBy' + ff.join()}" { Object arg ->
                    // println "In the body for the static method, here is arg: ${arg}"
                    SingleState.where( "${theProp} = ?", arg )
                }
                /*
                println "Trying to make ${'get' + ff.join()}"
                methodName = 'get' + ff.join()
                this.metaClass."${'get' + ff.join()}" { ->
                    delegate.get( theProp )
                }
                println "Making setter"
                this.metaClass."${'set' + ff.join()}" { Object arg ->
                    this.set( theProp, arg )
                }
                
            } // end each
            */
            performedMagic = true
        }
                
                
                /*
groovy:000> ff = []
===> []
groovy:000> lcTokens.each { ff << it.capitalize() }
===> [largest, city]
groovy:000> ff
===> [Largest, City]
gg = []
===> []
groovy:000> gg[0] = 'get'
===> get
groovy:000> lcTokens.each { gg << it.capitalize() }
===> [largest, city]
groovy:000> gg
===> [get, Largest, City]
groovy:000> gg.join()
===> getLargestCity

getters = []
setter = []

 largest_city
next prop is capital_city
next prop is state_name
next prop is population
                
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


