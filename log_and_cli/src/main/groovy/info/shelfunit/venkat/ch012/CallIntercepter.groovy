package info.shelfunit.venkat.ch012

// from Programming Groovy 2 by Venkat Subramaniam, chapter 12

import groovy.lang.GroovyInterceptable 

class Car implements GroovyInterceptable { 
  def check() { System.out.println "check called..." }

  def start() { System.out.println "start called..." }

  def drive() { System.out.println "drive called..." }

  def invokeMethod( String name, args ) { 
    System.out.println "Call to ${name} intercepted..."

    if ( name != 'check' ) { 
      System.out.print "running filter..."
      Car.metaClass.getMetaMethod( 'check' ).invoke( this, null )
    }

    def validMethod = Car.metaClass.getMetaMethod( name, args )

    if ( validMethod != null ) { 
      System.out.print  ' - validMethod != null  - '
      validMethod.invoke( this, args )
    } else { 
      Car.metaClass.invokeMethod( this, name, args )
    }

  } // end invokeMethod

} // end class Car

class CallIntercepter { 

  static void main( String[] args ) { 
    def car = new Car()
    car.start()
    car.drive()
    car.check()

    try { 
      car.speed()
    } catch ( Exception ex ) {
      println ex
    }

  } // end method main

} // end class CallIntercepter 
