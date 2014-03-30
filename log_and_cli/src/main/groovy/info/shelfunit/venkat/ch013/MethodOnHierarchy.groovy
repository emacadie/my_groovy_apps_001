package info.shelfunit.venkat.ch013

// from Programming Groovy 2 by Venkat Subramaniam, chapter 13
import java.lang.Integer
import java.lang.Long
import java.lang.Number
import java.util.Calendar


class MethodOnHierarchy { 

  def doStuffPage200() { 
    println "In doStuffPage200"
    def daysFromNow = { ->
      Calendar today = Calendar.instance
      today.add( Calendar.DAY_OF_MONTH, ( int ) delegate )
      today.time
    }

    Integer.metaClass.daysFromNow = daysFromNow
    Long.metaClass.daysFromNow = daysFromNow

    println "5.daysFromNow: ${5.daysFromNow()}"
    println "5L.daysFromNow: ${5L.daysFromNow()}"

    // add a method on Number
    Number.metaClass.someMethod = { ->
      "someMethod called"
    }

    println "2.someMethod(): ${2.someMethod()}"
    println "2L.someMethod(): ${2L.someMethod()}"

  } // doStuffPage200

  static void main( String[] args ) { 
    MethodOnHierarchy moh = new MethodOnHierarchy()
    moh.doStuffPage200() 
  } // end main

} // end class MethodOnHierarchy
