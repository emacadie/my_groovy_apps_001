package info.shelfunit.properties.sample

import info.shelfunit.properties.annotations.AnnotationProcessor
import info.shelfunit.properties.annotations.StringAnnotation

class Book {
    
    static { 
        AnnotationProcessor.process( Book.class ) 
    }
    
    int pages
    
    @StringAnnotation( min = 5, max = 20 )
    String title
      
    int year
    
    def doStuff() {
        println "In book.doStuff"
    }
 
}

