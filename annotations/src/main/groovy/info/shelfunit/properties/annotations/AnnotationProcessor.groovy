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
        }
        theClass.metaClass.invokeMethod = { String name, args ->
            print ", ${theClass.name} Method name in standalone invokeMethod is ${name}"
        }
        print "\n"
    } // end process
}

