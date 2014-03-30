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
	today.add( Calender.DAY_OF_MONTH, delegate )
	today.time
      }

      getDaysFromNow = { ->
	Calendar today = Calendar.instance
	today.add( Calender.DAY_OF_MONTH, delegate )
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
  } // end main

} // end class IntegerEMCDSL