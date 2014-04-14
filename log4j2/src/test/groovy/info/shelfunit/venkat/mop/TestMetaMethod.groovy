package info.shelfunit.venkat.mop

// from Programming Groovy 2 by Venkat Subramaniam, chapter 11

import java.lang.Integer

class TestMetaMethod extends GroovyTestCase { 
  
  void testHelloString() { 
    def str = "Hello"
    def methodName = 'toUpperCase'
    def methodOfInterest = str.metaClass.getMetaMethod( methodName )
    assertEquals 'HELLO', methodOfInterest.invoke( str )
  }

  void testRespondsTo() { 
    def str = "hello"
    def toUpperCase = String.metaClass.respondsTo(str, 'toUpperCase') ? 'yes': 'no'
    assertEquals 'yes', toUpperCase
    // you can add args to "resondsTo" which are the args of the method you are looking at
    def compareTo = String.metaClass.respondsTo(str, 'compareTo', "test") ? 'yes' : 'no'
    assertEquals 'yes', compareTo
    
    def toUpperCase5 = String.metaClass.respondsTo(str, 'toUpperCase', 5) ? 'yes' : 'no'
    assertEquals 'no', toUpperCase5
  }

} // end class TestMetaMethod


