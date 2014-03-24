package info.shelfunit.venkat.mop

// from Programming Groovy 2 by Venkat Subramaniam, chapter 11                 
class TestAccessingObject extends GroovyTestCase { 
  
  void testPrintInfo() { 
    def usrRequestedProperty = 'bytes'
    def usrRequestedMethod = 'toUpperCase'
    
    def str = 'hello'

    assertEquals str[usrRequestedProperty], [104, 101, 108, 108, 111]
    assertEquals str."$usrRequestedProperty", [104, 101, 108, 108, 111]
    assertEquals str."$usrRequestedMethod"(), 'HELLO'
    assertEquals str.invokeMethod(usrRequestedMethod, null), 'HELLO'
    
  }

} // end class TestAccessingObject
