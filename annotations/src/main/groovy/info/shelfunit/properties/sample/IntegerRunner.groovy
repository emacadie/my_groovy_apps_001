package info.shelfunit.properties.sample

import info.shelfunit.properties.annotations.AnnotationProcessor
import info.shelfunit.properties.annotations.IntegerAnnotation

class IntegerRunner {
    
    static { 
        AnnotationProcessor.process( IntegerRunner.class ) 
    }
    
    @IntegerAnnotation( minValue = 0d, maxValue = 1000d )
    def numAsDef
    @IntegerAnnotation( minValue = 100, maxValue = 1000 )
    int numAsInt

}

