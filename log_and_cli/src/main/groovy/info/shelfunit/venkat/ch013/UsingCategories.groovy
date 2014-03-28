package info.shelfunit.venkat.ch013

// from Programming Groovy 2 by Venkat Subramaniam, chapter 12

class StringUtil { 
  // write toSSN( String self ) to restrict to String
  def static toSSN( self ) { 
    if ( self.size() == 9 ) { 
      "${self[0..2]}-${self[3..4]}-${self[5..8]}"
    }
  }

} // end class StringUtil 

class FindUtil { 
  def static extractOnly( String self, closure ) { 
    def result = ''
    self.each { 
      if ( closure( it ) ) { result += it }
    }
    result
  }
} // end class FindUtil 

class UsingCategories { 

  def doStuffPage194() { 
    use( StringUtil ) { 
      println "123456789".toSSN()
      println new StringBuilder( "987654321" ).toSSN()
    }

    try { 
      println "123456789".toSSN()
    } catch ( MissingMethodException ex ) { 
      println ex.message
    }
  }

  def doStuffPage196() { 
    use( FindUtil ) { 
      println "121254123".extractOnly{ it == '4' || it == '5' }
    }
  }

  static void main( String[] args ) { 
    def uc = new UsingCategories()
    uc.doStuffPage194()
    uc.doStuffPage196()

  } // end main
} // end class UsingCategories
