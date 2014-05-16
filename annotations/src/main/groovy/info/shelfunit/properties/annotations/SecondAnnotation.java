package info.shelfunit.properties.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)

    public @interface SecondAnnotation {
	public String name();
	public String value();
    }