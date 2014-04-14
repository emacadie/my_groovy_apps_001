package info.shelfunit.venkat.mop

// from Programming Groovy 2 by Venkat Subramaniam, chapter 11

import java.lang.Integer

class TestMethodInvocation extends GroovyTestCase { 
  
  void testInterceptedMethodCallonPOJO() { 
    def val = new Integer( 3 )
    // this changes the toString method for all instances of Integer
    // POJOs in Groovy have metaClass property, they do not in Java apps
    Integer.metaClass.toString = {  -> 'intercepted' }
    assertEquals "intercepted", val.toString()
  }

  void testInterceptableCalled() { 
    def obj = new AnInterceptable()
    // if an object implements GroovyInterceptable interface, all
    // methods are routed there first
    assertEquals 'intercepted', obj.existingMethod()
    assertEquals 'intercepted', obj.nonExistingMethod()
    assertEquals 'intercepted', obj.otherMethod()
  }

  void testInterceptedExistingMethodCalled() { 
    AGroovyObject.metaClass.existingMethod2 = { -> 'intercepted' }
    def obj = new AGroovyObject()
    assertEquals 'intercepted', obj.existingMethod2()
  }

  void testUnInterceptedExistingMethodCalled() { 
    def obj = new AGroovyObject()
    assertEquals 'existingMethod', obj.existingMethod()
  }

  void testPropertyThatIsClosureCalled() { 
    def obj = new AGroovyObject()
    assertEquals 'closure called', obj.closureProp()
  }

  void testMethodMissingCalledOnlyForNonExistent() { 
    def obj = new ClassWithInvokeAndMissingMethod()
    assertEquals 'existingMethod', obj.existingMethod()
    assertEquals 'missing called', obj.nonExistingMethod()
  }

  void testMethodFailsOnNonExistent() { 
    def obj = new TestMethodInvocation()
    shouldFail( MissingMethodException ) { obj.nonExistingMethod() }
  }

} // end class TestMethodInvocation

class AnInterceptable implements GroovyInterceptable { 
  def existingMethod() { }
  def invokeMethod( String name, args ) { 
    'intercepted'
  }

  // so far, does not return 'this is the other method' 
  // as of page 179, this is not covered
  def otherMethod() { 
    return 'this is the other method'
  }

} // end class AnInterceptable 

class AGroovyObject { 
  def existingMethod() { 'existingMethod' }
  def existingMethod2() { 'existingMethod2' }
  def closureProp = { 'closure called' }
} // end class AGroovyObject

class ClassWithInvokeAndMissingMethod { 
  def existingMethod() { 'existingMethod' }
  def invokeMethod( String name, args ) { 'invoke called' }
  def methodMissing( String name, args ) { 'missing called' }
} // end class ClassWithInvokeAndMissingMethod

