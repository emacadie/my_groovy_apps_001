package info.shelfunit.properties.annotations

class AnnotationProcessor {
    
    static process( Class theClass ) {
        print "In AnnotationProcessor.process"
        print ", the class is: ${theClass.name}"
        theClass.metaClass.setProperty = { String name, arg ->
            print ", name in setProperty is ${name}"
            def field = theClass.getDeclaredField( name )
            def intAnnotation = field?.getAnnotation( IntAnnotation.class )
            print ", -- Here is intAnnotation: ${intAnnotation}"
            if ( intAnnotation ) {
                print ", Looking at ${theClass.name}.set${name.capitalize()}"
                if ( !( arg < intAnnotation.minValue() ) &&
                    !( arg > intAnnotation.maxValue() ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                } else {
                    print ", Cannot call set${name.capitalize()}"
                }
            } else {
                def mName = "set${name.capitalize()}"
                def propClassName = theClass.class.metaClass.getMetaProperty( name ).getType().getName()
                print ", LET'S TRY CALLING ${mName}, it's a ${propClassName}"
                theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg ) // this works
            }
            println "\n"
        }
        theClass.metaClass.invokeMethod = { String name, args ->
            print ", ${theClass.name} Method name in standalone invokeMethod is ${name}"
            println "\n"
        }
        println "\n"
        
        ////////////////////////
        /*
        theClass.metaClass.constructor = { java.util.LinkedHashMap map ->
            
            println "Intercepting constructor call w/ map, and it is a ${map?.getClass().getName()}"
            def constructor = theClass.getConstructor(map.getClass())
            constructor.getParameterTypes().each {
                println "Next arg in constructor  is a ${it.name}"
            }
            println "Done with loop"
            def obj = constructor.newInstance()
            println "obj is a ${obj.class.name}"
          
            
        }
          */
        theClass.metaClass.constructor = { ->
            println "Intercepting no -arg constructor call"
            def fields = theClass.getDeclaredFields( )
            def constructor = theClass.getConstructor()
            constructor.getParameterTypes().each {
                println "Next arg in constructor  is a ${it.name}"
            }
            println "Done with loop"
            def obj = constructor.newInstance()
            println "obj is a ${obj.class.name}"
            obj.firstNum = null
            /*
            fields.each { field ->
               
                def intAnnotation = field?.getAnnotation( IntAnnotation.class )
                def name = field.getName()
                println "looking at ${name}, -- Here is intAnnotation: ${intAnnotation}"
                if ( intAnnotation ) {
                    println ", Looking at ${theClass.name}.set${name.capitalize()}"
                    def mp = theClass.metaClass.getMetaProperty( name )
                    println "mp is a ${mp.class.name}"
                    mp.setProperty( delegate, 0 )
                }
            }
            */
            // constructor = theClass.getConstructor()
            // constructor.newInstance()
        }
        
    } // end process
}

