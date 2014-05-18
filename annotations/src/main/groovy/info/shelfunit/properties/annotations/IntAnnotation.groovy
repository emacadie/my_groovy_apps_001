package info.shelfunit.properties.annotations

import java.lang.annotation.Retention
import java.lang.annotation.Target

import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy

import org.codehaus.groovy.transform.GroovyASTTransformationClass

// If doing AST transformation, this may need to be @Retention (RetentionPolicy.SOURCE)
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD)
// @GroovyASTTransformationClass(['info.shelfunit.properties.annotations.Transform'])

public @interface IntAnnotation {
  public int minValue() default 0
  public int maxValue() default 2147483647 // Integer.MAX_VALUE as int
                           
}


