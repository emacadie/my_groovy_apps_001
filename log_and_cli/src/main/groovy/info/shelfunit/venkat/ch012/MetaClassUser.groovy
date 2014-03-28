package info.shelfunit.venkat.ch012

import groovy.transform.Immutable

// from Programming Groovy 2 by Venkat Subramaniam, chapter 12

@Immutable
class MyClass { 
  String name
} // end class MyClass 

class MetaClassUser { 

  def printMetaClassInfo( instance ) { 
    print "Metaclass of ${instance} is ${instance.metaClass.class.simpleName}"
    println " with delegate ${instance.metaClass.delegate.class.simpleName}"
  }

  def doStuff() { 
    printMetaClassInfo( 2 )
    println "Metaclass of Integer is ${Integer.metaClass.class.simpleName}"
    println "Adding a method to Integer metaClass"
    Integer.metaClass.someNewMethod = { -> /* */ }
    printMetaClassInfo( 2 )

    def obj1 = new MyClass( "obj1" )
    printMetaClassInfo( obj1 )
    println "Adding a methodto MyClass metaClass"
    MyClass.metaClass.someNewMethod = { -> /* */ }
    printMetaClassInfo( obj1 )

    println "obj2 created later"
    def obj2 = new MyClass( "obj2" )
    printMetaClassInfo( obj2 )
  } // end doStuff

  static void main( String[] args ) { 
    def mcu = new MetaClassUser()
    mcu.doStuff()
  } // end method main

} // end class MetaClassUser
