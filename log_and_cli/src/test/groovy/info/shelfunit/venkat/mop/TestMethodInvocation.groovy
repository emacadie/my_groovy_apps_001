package info.shelfunit.venkat.mop

// from Programming Groovy 2 by Venkat Subramaniam

class TestMethodInvocation extends GroovyTestCase { 
  
  void testInterceptedMethodCallonPOJO() { 
    def val = new Integer( 3 )
    Integer.metaClass.toString = {  -> 'intercepted' }
    assertEquals "intercepted", val.toString()
  }

  void testInterceptableCalled() { 
    def obj = new AnInterceptable()
    assertEquals 'intercepted', obj.existingMethod()
    assertEquals 'intercepted', obj.nonExistingMethod()
    
  }

} // end class TestMethodInvocation

class AnInterceptable implements GroovyInterceptable { 
  def existingMethod() { }
  def invokeMethod( String name, args ) { 
    'intercepted'
  }
} // end class  AnInterceptable 

