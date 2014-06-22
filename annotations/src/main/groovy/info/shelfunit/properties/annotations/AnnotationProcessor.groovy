package info.shelfunit.properties.annotations

/**
<p>This is a class that will process the annotations {@link info.shelfunit.properties.annotations.DoubleAnnotation}, {@link info.shelfunit.properties.annotations.FloatAnnotation}, {@link info.shelfunit.properties.annotations.IntAnnotation}, {@link info.shelfunit.properties.annotations.LongAnnotation} and {@link info.shelfunit.properties.annotations.StringAnnotation}</p>

<p>I never liked that fact that <a href="http://groovy.codehaus.org/Groovy+Beans">Groovy Beans</a> never had any validations for the properties (at least none that I could find). Grails has <a href="http://grails.org/doc/latest/ref/Constraints/Usage.html">constraints</a>. Why not Groovy?</p>

<p>This is pretty simple and a bit limited, but that is the intent. I want to add some easy validation to Groovy Beans. As far as I know, nobody has really done this for Groovy. There is project on Sourceforge called <a href="http://oval.sourceforge.net/">OVal</a>. That does a LOT of stuff, far beyond this project. It has <a href="http://oval.sourceforge.net/dependencies.html">22 dependencies</a>, 3 of them for logging alone. There is also <a href="http://hibernate.org/validator/">Hibernate Validator</a>. It implements some JSR, but when I read the documentation, it said I had to add two or three other JSRs. If that is what you need, go for it. Those are Java projects. This is for Groovy beans. The goal is to keep this as clean and simple as possible.</p>

*/
class AnnotationProcessor {
    
    /**
    <p>This is the method that actually processes the annotations.</p>
    <p>Suppose you made a class called "Book" that used some of the annotations this class processes. Somewhere in your code, you
    will need to do this:</p>
    <pre>
    AnnotationProcessor.process( Book.class ) 
    </pre>
    <p>I think you could also do:</p>
    <pre>
    AnnotationProcessor.process( Book ) 
    </pre>
    <p>You could make it a static method in the class itself, like this:</p>
    <pre>
    static { 
        AnnotationProcessor.process( Book.class ) 
    }
    </pre>
    <p>That is fine, but there is one corner case: If you use a map-based constructor the first time you instantiate the class, then the annotations will not be run on that object. however, they will be run for subsequent objects.</p>
    
    @param theClass The class to be transformed and validated
    */
    static process( Class theClass ) {
        println "Just got called for class ${theClass.getName()}"
        
        /*
        // metaClass.constructor = { String arg -> }
        // Constructor: public info.shelfunit.properties.nonmutable.SecondImmutableSample(java.util.HashMap)
        // Constructor: public info.shelfunit.properties.nonmutable.SecondImmutableSample(java.lang.String,java.lang.String,int,int)
        theClass.metaClass.constructor = { Map theMap ->
            println "In the map constructor"
            theMap.each { entry ->
                println "key $entry.key has value $entry.value"
                // this causes "object is not an instance of declaring class"
                // println "Is it already set?: ${theClass.metaClass.getMetaProperty( entry.key ).getProperty( entry.key )}"
                // this is okay: println "Is it already set?: ${theClass.metaClass.getProperty( entry.key ).getProperty( entry.key )}"
                // println "Is it already set?: ${theClass.metaClass.getMetaProperty( entry.key ).getProperty( delegate, entry.key )}"
                // println "Is it already set?: ${delegate.getProperty( entry.key )}"
                // theClass.metaClass.getMetaProperty( entry.key ).setProperty( delegate, entry.value )
                println "Just set the prop in the map"
            }
        }
        
        theClass.metaClass.constructor = { a, b, c, d ->
            println "In the other constructor: a is a ${a.class.name}, c is a ${c.class.name}"
        }
        */
        theClass.metaClass.setProperty = { String name, arg ->
            println " In set property for ${theClass.getName()} for property ${name} with arg ${arg}"
            def field = theClass.getDeclaredField( name )
            def intAnnotation    = field?.getAnnotation( IntAnnotation.class )
            def stringAnnotation = field?.getAnnotation( StringAnnotation.class )
            def doubleAnnotation = field?.getAnnotation( DoubleAnnotation.class )
            def floatAnnotation  = field?.getAnnotation( FloatAnnotation.class )
            def longAnnotation   = field?.getAnnotation( LongAnnotation.class )
            
            if ( intAnnotation ) {
                println "Here is arg for int: ${arg}"
                if ( ( arg instanceof Integer ) && 
                    ( arg >= intAnnotation.minValue() ) &&
                    ( arg <= intAnnotation.maxValue() ) &&
                    ( arg >= Integer.MIN_VALUE ) &&
                    ( arg <= Integer.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
            } else if ( stringAnnotation ) {
                println "Here is arg for string: ${arg}"
                if ( ( arg.length() >= stringAnnotation.minLength() ) &&
                    ( arg.length() <= stringAnnotation.maxLength() ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg.toString() )
                }
            } else if ( doubleAnnotation ) {
                if ( ( arg instanceof Double ) && 
                    ( arg >= doubleAnnotation.minValue() ) &&
                    ( arg <= doubleAnnotation.maxValue() ) &&
                    ( arg >= Double.MIN_VALUE ) &&
                    ( arg <= Double.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
            } else if ( floatAnnotation ) {
                if ( ( arg instanceof Float ) && 
                    ( arg >= floatAnnotation.minValue() ) &&
                    ( arg <= floatAnnotation.maxValue() ) &&
                    ( arg >= Float.MIN_VALUE ) &&
                    ( arg <= Float.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
            } else if ( longAnnotation ) {
                if ( ( arg instanceof Long ) && 
                    ( arg >= longAnnotation.minValue() ) &&
                    ( arg <= longAnnotation.maxValue() ) &&
                    ( arg >= Long.MIN_VALUE ) &&
                    ( arg <= Long.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
            } else {
                theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg ) // this works
            }
        }
        
    } // end process - line 44
} // end class AnnotationProcessor

