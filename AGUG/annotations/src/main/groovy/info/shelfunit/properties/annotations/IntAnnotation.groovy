package info.shelfunit.properties.annotations

import java.lang.annotation.Retention
import java.lang.annotation.Target

import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD)

public @interface IntAnnotation {
  public int minValue() default 0
  public int maxValue() default 2147483647 // Integer.MAX_VALUE as int
}


