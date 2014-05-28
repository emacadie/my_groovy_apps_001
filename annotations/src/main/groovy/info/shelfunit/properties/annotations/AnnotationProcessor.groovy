package info.shelfunit.properties.annotations

class AnnotationProcessor {
    
    static process( Class theClass ) {
        
        theClass.metaClass.setProperty = { String name, arg ->
            
            def field = theClass.getDeclaredField( name )
            def intAnnotation = field?.getAnnotation( IntAnnotation.class )
            def stringAnnotation = field?.getAnnotation( StringAnnotation.class )
            def doubleAnnotation = field?.getAnnotation( DoubleAnnotation.class )
            def floatAnnotation  = field?.getAnnotation( FloatAnnotation.class )
            def longAnnotation   = field?.getAnnotation( LongAnnotation.class )
            
            if ( intAnnotation ) {
                if ( ( arg instanceof Integer ) && 
                    ( arg >= intAnnotation.minValue() ) &&
                    ( arg <= intAnnotation.maxValue() ) &&
                    ( arg >= Integer.MIN_VALUE ) &&
                    ( arg <= Integer.MAX_VALUE ) ) {
                    theClass.metaClass.getMetaProperty( name ).setProperty( delegate, arg )
                }
            } else if ( stringAnnotation ) {
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
}

