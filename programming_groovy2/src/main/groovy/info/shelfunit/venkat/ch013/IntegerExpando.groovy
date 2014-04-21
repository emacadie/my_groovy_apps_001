package info.shelfunit.venkat.ch013

// from Programming Groovy 2 by Venkat Subramaniam, chapter 13

import java.lang.Integer
import java.util.Calendar

class IntegerExpando { 

  def doStuffPage199() { 
    println "\nIn doStuffPage199"
    // This also works with Integer.metaClass."daysFromNow" 
    // and Integer.metaClass.'daysFromNow'
    Integer.metaClass.daysFromNow = { ->
      Calendar today = Calendar.instance
      today.add( Calendar.DAY_OF_MONTH, delegate )
      today.time
    }
    println "5.daysFromNow(): ${5.daysFromNow()}"

    println "Now as property"
    // now we can make daysFromNow a property
    Integer.metaClass.getDaysFromNow = { ->
      Calendar today = Calendar.instance
      today.add( Calendar.DAY_OF_MONTH, delegate )
      today.time
    }
    println "5.daysFromNow: ${5.daysFromNow}"
  }

  def doStuffPage201() { 
    println "\nIn doStuffPage201"
    // adding static method
    Integer.metaClass.'static'.isEven = { val -> val % 2 == 0 }
    println "Is 2 even?: ${Integer.isEven(2)}"
    println "Is 3 even?: ${Integer.isEven(3)}"
    // adding constructor
    Integer.metaClass.constructor << { Calendar cal ->
      new Integer( cal.get( Calendar.DAY_OF_YEAR ) )
    }
    println "new constructor: ${new Integer( Calendar.instance )}"

    Integer.metaClass.constructor = { int val ->
      println "Intercepting constructor call"
      def constructor = Integer.class.getConstructor( Integer.TYPE )
      constructor.newInstance( val )
    }
    println "Using overridden constructor: new Integer(4): ${new Integer(4)}"
    println "Using new constructor: new Integer(Calendar.instance): ${new Integer(Calendar.instance)}"
  }

  static void main( String[] args ) { 
    IntegerExpando iex = new IntegerExpando()
    iex.doStuffPage199()
    iex.doStuffPage201()
  }

} // end class IntegerExpando
