package info.shelfunit.venkat.ch013

// from Programming Groovy 2 by Venkat Subramaniam, chapter 13


class Person { 
  
  Person( arg ) {
    name = arg
  }
  def setName( arg ) { } // make it private
  String name
  def play() { println "${name} is playing" }

} // class Person

class InstanceInjector { 

  def doStuffPage204() {
    def jack = new Person('Jack')
    jack.play()
    def steve = new Person('Steve')
    steve.play()
    jack.name = "Joe"
    jack.play()
  } // doStuffPage204()

  static void main( String[] main ) { 
    def ii = new InstanceInjector()
    ii.doStuffPage204()
  } // end main

} // end class InstanceInjector