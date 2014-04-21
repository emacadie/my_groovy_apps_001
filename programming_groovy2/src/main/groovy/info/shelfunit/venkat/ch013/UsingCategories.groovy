package info.shelfunit.venkat.ch013

// from Programming Groovy 2 by Venkat Subramaniam, chapter 13

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

class Helper { 
  def static toString( String self ) { 
    def method = self.metaClass.methods.find{ it.name == 'toString' }
    '!!' + method.invoke( self, null ) + '!!'
  }
}

class UsingCategories { 

  def doStuffPage194() {
    println "In doStuffPage194"
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
    println "\nIn doStuffPage196"
    use( FindUtil ) { 
      println "121254123".extractOnly{ it == '4' || it == '5' }
    }
  }

  def doStuffPage197() { 
    println "\nIn doStuffPage197"
    use( StringUtil, FindUtil ) {
      def str = "123487651"
      println str.toSSN()
      println str.extractOnly { it == '8' || it == '1' }
    }

    use( Helper ) { 
      println 'hello'.toString()
    }

  }


  static void main( String[] args ) { 
    def uc = new UsingCategories()
    uc.doStuffPage194()
    uc.doStuffPage196()
    uc.doStuffPage197()

  } // end main
} // end class UsingCategories
