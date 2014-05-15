package info.shelfunit.venkat.ch012

// from Programming Groovy 2 by Venkat Subramaniam, chapter 12

class SecondCar { 
  def check() { System.out.println "check called..." }

  def start() { System.out.println "start called..." }

  def drive() { System.out.println "drive called" }

} // end class SecondCar { 

class SecondCallIntercepter { 

  static void main( String[] args ) {
    SecondCar.metaClass.invokeMethod = { String name, closureArgs ->
      System.out.print "Call to ${name} intercepted"
      if ( name != 'check' ) {
	System.out.print "running filter..."
	// we can put null here since we know it is null
	SecondCar.metaClass.getMetaMethod( 'check' ).invoke( delegate, null )
      }
      def validMethod = SecondCar.metaClass.getMetaMethod( name, closureArgs )
      if ( validMethod != null ) {
	validMethod.invoke( delegate, closureArgs )
      } else { 
	SecondCar.metaClass.invokeMissingMethod( delegate, name, closureArgs )
      }
    } // end closure
    
    def car = new SecondCar()

    car.start()
    car.drive()
    car.check()

    try {
      car.speed()
    } catch ( Exception ex ) { 
      println ex
    }

  } // end method main

} // end class SecondCallIntercepter
