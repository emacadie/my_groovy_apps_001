package info.shelfunit.venkat.ch013

import groovy.lang.Category

// from Programming Groovy 2 by Venkat Subramaniam, chapter 12

@Category( String )
class StringUtilAnnotated { 
  // write toSSN( String self ) to restrict to String
  def toSSN( ) { 
    if ( size() == 9 ) { 
      "${this[0..2]}-${this[3..4]}-${this[5..8]}"
    }
  }

} // end class StringUtilAnnotated 

class UsingCategoriesAnnotations { 
  static void main( String[] args ) { 
    use( StringUtilAnnotated ) { 
      println "123456789".toSSN()
      // println new StringBuilder( "987654321" ).toSSN()
    }

  } // end main
} // end class UsingCategoriesAnnotations

