package info.shelfunit.venkat.ch013

// from Programming Groovy 2 by Venkat Subramaniam, chapter 13
// EMCDSL is ExpandoMetaClass Domain Specific Language
import java.lang.Integer
import java.util.Calendar

class IntegerEMCDSL { 

  static void main( String[] args ) { 
    Integer.metaClass { 
      daysFromNow = { ->
	Calendar today = Calendar.instance
	today.add( Calendar.DAY_OF_MONTH, delegate )
	today.time
      }

      getDaysFromNow = { ->
	Calendar today = Calendar.instance
	today.add( Calendar.DAY_OF_MONTH, delegate )
	today.time
      }

      'static' { 
	isEven = { val -> val %2 == 0 }
      }
      
      constructor = { Calendar cal ->
	new Integer( cal.get( Calendar.DAY_OF_YEAR ) )
      }

      constructor = { int val ->
	println "Intercepting constructor call"
	def construct = Integer.class.getConstructor( Integer.TYPE )
	construct.newInstance( val )
      }

    } // end metaClass

    println "5.daysFromNow(): ${5.daysFromNow()}"
    println "5.daysFromNow: ${5.daysFromNow}"
    println "Is 2 even?: ${Integer.isEven(2)}"
    println "Is 3 even?: ${Integer.isEven(3)}"
    println "new constructor: ${new Integer( Calendar.instance )}"
    println "Using overridden constructor: new Integer(4): ${new Integer( 4 )}"
    println "Using new constructor: new Integer(Calendar.instance): ${new Integer(Calendar.instance)}"

  } // end main

} // end class IntegerEMCDSL