package info.shelfunit.venkat.ch012

// from Programming Groovy 2 by Venkat Subramaniam, chapter 12

import java.lang.Integer

class IntegerIntercepter { 

  static void main( String[] mainArgs ) { 
    Integer.metaClass.invokeMethod = { String name, args ->
      System.out.println "Call to ${name} intercepted on ${delegate}..."
      def validMethod = Integer.metaClass.getMetaMethod( name, args )
      
      if ( validMethod == null ) { 
	Integer.metaClass.invokeMissingMethod( delegate, name, args )
      } else { 
	System.out.println "running pre-filter"
	def result = validMethod.invoke( delegate, args ) // remove this for around-advice
	System.out.println "running post-filter"
	result
      }
    } // end closure

    println "Integer.metaClass.getClass().name: ${println Integer.metaClass.getClass().name}"

    println 5.floatValue()
    println 5.intValue()
    try { 
      println 5.empty()
    } catch ( Exception ex ) { 
      println ex
    }

  } // end main

} // end class IntegerIntercepter 
