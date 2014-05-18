package info.shelfunit.properties.sample

// import info.shelfunit.properties.annotations.SomeAnnotation
import info.shelfunit.properties.annotations.AnnotationProcessor
import info.shelfunit.properties.annotations.IntAnnotation

class FirstSubject {
    
    static { 
        println "In FirstSubject static block"
        println "FirstSubject.class is ${FirstSubject.class.name}"
        AnnotationProcessor.process( FirstSubject.class ) 
    }
    
    @IntAnnotation(minValue=30, maxValue=400)
    int firstNum
    int secondNum
}


