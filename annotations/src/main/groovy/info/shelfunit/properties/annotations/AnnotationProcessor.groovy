package info.shelfunit.properties.annotations

class AnnotationProcessor {
    
    static process( Class theClass ) {
        
        theClass.metaClass.setProperty = { String name, arg ->
            
            def field = theClass.getDeclaredField( name )
            def intAnnotation = field?.getAnnotation( IntAnnotation.class )
            def stringAnnotation = field?.getAnnotation( StringAnnotation.class )
            
            if ( intAnnotation ) {
                if ( ( arg instanceof Integer ) && !( arg < intAnnotation.minValue() ) &&
                    !( arg > intAnnotation.maxValue() ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
            } else if ( stringAnnotation ) {
                if ( !( arg.length() < stringAnnotation.min() ) &&
                    !( arg.length() > stringAnnotation.max() ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg.toString() )
                }
            } else {
                theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg ) // this works
            }
        }
        
    } // end process - line 44
}

