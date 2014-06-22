package info.shelfunit.properties.annotations

import org.codehaus.groovy.ast.ClassHelper 
import org.codehaus.groovy.ast.ClassNode 

import static org.codehaus.groovy.transform.ToStringASTTransformation.createToString

import java.lang.annotation.Annotation

/**
<p>This is a class that will process the annotations {@link info.shelfunit.properties.annotations.DoubleAnnotation}, {@link info.shelfunit.properties.annotations.FloatAnnotation}, {@link info.shelfunit.properties.annotations.IntAnnotation}, {@link info.shelfunit.properties.annotations.LongAnnotation} and {@link info.shelfunit.properties.annotations.StringAnnotation}</p>

<p>I never liked that fact that <a href="http://groovy.codehaus.org/Groovy+Beans">Groovy Beans</a> never had any validations for the properties (at least none that I could find). Grails has <a href="http://grails.org/doc/latest/ref/Constraints/Usage.html">constraints</a>. Why not Groovy?</p>

<p>This is pretty simple and a bit limited, but that is the intent. I want to add some easy validation to Groovy Beans. As far as I know, nobody has really done this for Groovy. There is project on Sourceforge called <a href="http://oval.sourceforge.net/">OVal</a>. That does a LOT of stuff, far beyond this project. It has <a href="http://oval.sourceforge.net/dependencies.html">22 dependencies</a>, 3 of them for logging alone. There is also <a href="http://hibernate.org/validator/">Hibernate Validator</a>. It implements some JSR, but when I read the documentation, it said I had to add two or three other JSRs. If that is what you need, go for it. Those are Java projects. This is for Groovy beans. The goal is to keep this as clean and simple as possible.</p>

*/
class ImmutableAnnotationProcessor {
    
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
        def imAnnotation = theClass.getAnnotation( ImmutableAnnotation )
        if ( imAnnotation ) {
            println "${theClass.name} has ImmutableAnnotation"
            def classNode = ClassHelper.make( theClass )
            println "classNode is a ${classNode.class.name} and its name is ${classNode.getUnresolvedName()}"
            // createToString( classNode, false, false, null, null, false, true )
        } else {
            println "${theClass.name} does not have ImmutableAnnotation"
        }
        def inConstructor = false
        
        // metaClass.constructor = { String arg -> }
        // Constructor: public info.shelfunit.properties.nonmutable.SecondImmutableSample(java.util.HashMap)
        // Constructor: public info.shelfunit.properties.nonmutable.SecondImmutableSample(java.lang.String,java.lang.String,int,int)
     
        theClass.metaClass.constructor = { Map theMap ->
            inConstructor = true
            println "\nIn the map constructor"
            println "theMap[ secondString ]: ${ theMap[ "secondString" ]}"
            def instance = theClass.newInstance()
            println "instance is a ${instance.class.name}  and delegate is a ${delegate.class.name}"
            delegate = instance
            println "instance is a ${instance.class.name}  and now delegate is a ${delegate.class.name}"
            // instance.setProperty( "secondString", "Voyager2" )
            // instance.setProperty( "firstString", "Voyager" )
            // instance.setProperty( "secondInt", 222 )
            // instance.setProperty( "firstInt", 333 )
            println "instance is a ${instance.class.name}"
            // def field = theClass.getDeclaredField( entry.key )
            //     def intAnnotation    = field?.getAnnotation( IntAnnotation.class )
            //     def stringAnnotation = field?.getAnnotation( StringAnnotation.class )
            
            ///////////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////
            
            
        // } // theMap
          
            // http://burtbeckwith.com/blog/?p=1003
            def methods = instance.metaClass.getMethods()
            methods.each {
                // println "Method: ${it.toString()}"
            }
            theMap.each { entry ->
                // if ( entry.key == "secondString" ) {
                //     println "We have second String"
                //     instance.setProperty( "secondString", "Voyager" )
                // }
                
                def field = theClass.getDeclaredField( entry.key )
                def intAnnotation    = field?.getAnnotation( IntAnnotation.class )
                def stringAnnotation = field?.getAnnotation( StringAnnotation.class )
                    
                if ( ( entry.value instanceof Integer ) && ( intAnnotation ) ) {
                    println "Here is arg for int in constructor: ${entry.value} and it is a ${entry.value.class.name}"
                    println "delegate is a ${delegate.class.name}, owner is a ${owner.class.name}"
                    
                    if ( ( entry.value instanceof Integer ) && 
                        ( entry.value >= intAnnotation.minValue() ) &&
                        ( entry.value <= intAnnotation.maxValue() ) &&
                        ( entry.value >= Integer.MIN_VALUE ) &&
                        ( entry.value <= Integer.MAX_VALUE ) ) {
                        theClass.metaClass.getMetaProperty( entry.key ).setProperty( instance, entry.value )
                        println "setting the int method"
                        // instance."${'set' + entry.key.capitalize()}"( entry.value )
                           
                    } else {
                        def currentVal = instance."${entry.key}"
                        instance."${'set' + entry.key.capitalize()}"( currentVal )
                        println "${entry.value} did not pass the tests"
                    }
                } else if ( ( stringAnnotation ) && ( entry.value instanceof String ) ) {
                    println "setting the String method"
                    def metaMethod = theClass.metaClass.getMetaMethod( "${'set' + entry.key.capitalize()}",  entry.value )
                    if ( ( entry.value.length() >= stringAnnotation.minLength() ) &&
                        ( entry.value.length() <= stringAnnotation.maxLength() ) ) {
                            // instance."${'set' + entry.key.capitalize()}"( entry.value )
                            def qq = entry.value + entry.value
                            // metaMethod.invoke( instance, entry.value )
                            // instance."${entry.key}" == qq
                            // metaMethod.invoke( instance, qq )
                            // theClass.metaClass.getMetaProperty( entry.key ).setProperty( delegate, qq ) // entry.value )
                            theClass.metaClass.getMetaProperty( entry.key ).setProperty( instance, qq ) // entry.value )
                            println "calling invoke for the String method"
                    } else {
                        def currentVal = instance."${entry.key}"
                        println "${entry.value} did not pass the tests, and currentVal is ${currentVal}"
                        
                        // instance."${'set' + entry.key.capitalize()}"( currentVal )
                        // metaMethod.invoke( instance, []  )
                        
                    }
                } else {} // end annotation   
                
            } // map.each
            println "Here is instance.getProperty( secondString ) : ${instance.getProperty( "secondString" )} "
            instance
        } // constructor
        
        
        /*
                            
                // this causes "object is not an instance of declaring class"
                // println "Is it already set?: ${theClass.metaClass.getMetaProperty( entry.key ).getProperty( entry.key )}"
                // this is okay: println "Is it already set?: ${theClass.metaClass.getProperty( entry.key ).getProperty( entry.key )}"
                // println "Is it already set?: ${theClass.metaClass.getMetaProperty( entry.key ).getProperty( delegate, entry.key )}"
                // println "Is it already set?: ${delegate.getProperty( entry.key )}"
                // theClass.metaClass.getMetaProperty( entry.key ).setProperty( delegate, entry.value )
               
                    def field = theClass.getDeclaredField( entry.key )
                    def intAnnotation    = field?.getAnnotation( IntAnnotation.class )
                    def stringAnnotation = field?.getAnnotation( StringAnnotation.class )
                    
                    if ( intAnnotation ) {
                        println "Here is arg for int in constructor: ${entry.value}"
                        println "delegate is a ${delegate.class.name}, owner is a ${owner.class.name}"
                    }
                
                
                    if ( ( entry.value instanceof Integer ) && 
                        ( entry.value >= intAnnotation.minValue() ) &&
                        ( entry.value <= intAnnotation.maxValue() ) &&
                        ( entry.value >= Integer.MIN_VALUE ) &&
                        ( entry.value <= Integer.MAX_VALUE ) ) {
                        theClass.metaClass.getMetaProperty( entry.key ).setProperty( delegate, entry.value )
                    }
                    
                } else if ( stringAnnotation ) {
                    println "Here is arg for string: ${entry.value}"
                    if ( ( entry.value.length() >= stringAnnotation.minLength() ) &&
                        ( entry.value.length() <= stringAnnotation.maxLength() ) ) {
                        theClass.metaClass.getMetaProperty( entry.key ).setProperty( delegate, entry.value )
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
                    handleFloat( theClass, name, delegate, arg, floatAnnotation )
                } else if ( longAnnotation ) {
                    handleLong( theClass, name, delegate, arg, longAnnotation )
                
                } else {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, entry.value ) // this works
                }
                
                println "Just set the prop in the map"
            }
        } //  end constructor
        */
        /*
        theClass.metaClass.constructor = { a, b, c, d ->
            println "In the other constructor: a is a ${a.class.name}, c is a ${c.class.name}"
        }
        */
       // *
        theClass.metaClass.setProperty = { String name, arg ->
            println " In set property for ${theClass.getName()} for property ${name} with arg ${arg},  and delegate is a ${delegate.class.name}"
            println "totally skipping it"
            println "Are we in constructor? Look: ${inConstructor}"
        }
        /*
             
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
                println "Here is arg for string ${name}: ${arg}"
                println "Value before change is ${theClass.metaClass.getMetaProperty( name ).getProperty( delegate )}"
                if ( ( arg.length() >= stringAnnotation.minLength() ) &&
                    ( arg.length() <= stringAnnotation.maxLength() ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg.toString() )
                }
                println "Value after change is ${theClass.metaClass.getMetaProperty( name ).getProperty( delegate )}"
            } else if ( doubleAnnotation ) {
                if ( ( arg instanceof Double ) && 
                    ( arg >= doubleAnnotation.minValue() ) &&
                    ( arg <= doubleAnnotation.maxValue() ) &&
                    ( arg >= Double.MIN_VALUE ) &&
                    ( arg <= Double.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
            } else if ( floatAnnotation ) {
                handleFloat( theClass, name, delegate, arg, floatAnnotation )
            } else if ( longAnnotation ) {
                handleLong( theClass, name, delegate, arg, longAnnotation )
            } else {
                theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg ) // this works
            }
        } // setProperty
        */
        
    } // end process - line 44
    
    static handleFloat( theClass, name, delegate, arg, floatAnnotation ) {
        if ( ( arg instanceof Float ) && 
                    ( arg >= floatAnnotation.minValue() ) &&
                    ( arg <= floatAnnotation.maxValue() ) &&
                    ( arg >= Float.MIN_VALUE ) &&
                    ( arg <= Float.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
    }

    static handleLong( theClass, name, delegate, arg, longAnnotation ) {
        if ( ( arg instanceof Long ) && ( arg >= longAnnotation.minValue() ) &&
                    ( arg <= longAnnotation.maxValue() ) &&
                    ( arg >= Long.MIN_VALUE ) &&
                    ( arg <= Long.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
    }
} // end class AnnotationProcessor - line 128

