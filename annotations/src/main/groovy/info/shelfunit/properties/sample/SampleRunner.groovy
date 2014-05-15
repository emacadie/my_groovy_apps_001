package info.shelfunit.properties.sample

class SampleRunner { 

  def doStuff001() { 
    def b = new Book()
    def bmc = Book.metaClass()
    
    def bFields = Book.class.getDeclaredFields()
    println "Fields of book:"
    bFields.each { print "${it.getName()} "  }
    println " "
  } // def doStuff001() 

  static void main( String[] args ) { 
    def sr = new SampleRunner()
    sr.doStuff001()
  }

}
