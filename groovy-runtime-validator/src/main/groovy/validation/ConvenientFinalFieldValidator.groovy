package validation

import groovy.transform.AnnotationCollector
// import groovy.transform.Canonical 
import groovy.transform.ToString



import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor 

/**
<p>This annotation does the same basic thing as  {@link validation.AstImmutableConstructor}: It can be used to validate fields in immutable objects. It is a meta-annotation using <a href="http://docs.groovy-lang.org/latest/html/gapi/index.html?groovy/transform/AnnotationCollector.html">AnnotationCollector</a> to combine {@link validation.AstImmutableConstructor}, <a href="http://docs.groovy-lang.org/latest/html/gapi/index.html?groovy/transform/Immutable.html">Immutable</a> and <a href="http://docs.groovy-lang.org/latest/html/gapi/index.html?groovy/transform/ToString.html">ToString</a> into one annotation. For <a href="http://docs.groovy-lang.org/latest/html/gapi/index.html?groovy/transform/ToString.html">ToString</a>, includeNames is set to true. </p>

<p>The fields can be annotated with the following annotations: {@link validation.ValidDouble}, {@link validation.ValidFloat}, {@link validation.ValidInt}, {@link validation.ValidLong} and {@link validation.ValidString}.</p>

<p>Other than a few less lines of code, it should be the same as {@link validation.AstImmutableConstructor}:</p>

<p>
Here is an example class:
</p>

<pre>
package info.shelfunit.properties.sample.immutable

import validation.ImmutableValidator
import validation.ValidInt
import validation.ValidLong
import validation.ValidString

{@code @ImmutableValidator}
class ImmutableObject002 {

    @ValidString( minLength = 5, maxLength = 10, regex = /\d{4}?-\d\d-\d\d/ )
    String firstString
    @ValidInt( minValue = 10, maxValue = 100, divisorSet = [ 2, 3 ] )
    int firstInt
    @ValidLong( maxValue = 100L )
    long firstLong
}

</pre>

<p>
You could set this with a Map like any other immutable object in Groovy, or with the fields, but it will not trigger validation:
</p>

<pre>
def firstImObject = new ImmutableObject002( firstString: "Hello", firstInt: 55, firstLong: 44L )
</pre>

<p>
To get the annotation to actually process, you should send two parameters to the constructor: a Map for the fields, and a boolean for whether or not you want the fields to be validated. This boolean is called "validation" in the AST Transformer code. If validation is set to false, the effect is the same as if you simply sent the fields as a Map.
</p>

<pre>
def secondImObject = new ImmutableObject002( [ firstString: "Hi Again", firstInt: 11, firstLong: 22L ], true )
</pre>

<p>You could also send a second boolean (called "throwException" in the AST Transformer) after the Map to throw an Exception if one of the fields does not validate. It is false by default.
</p>

<pre>
def thirdImObject = new ImmutableObject002( [ firstString: "Hi Once Again", firstInt: 123456789, firstLong: 22L ], true, true )
</pre>

<p>If throwException is not set to true and a field does not validate, it will be set to "null" if it is a String and 0 for a number. If throwException is set to true and a field does not validate, an Exception is thrown and the object is not created.</p>

<p>There is a corner case I have not been able to solve. I made an object with two String fields and a few numbers. If I did not provide a value for the second String, it would be null if throwException was set to false, but it would be set to "null" if throwException was set to true.</p>

<p>If validation is set to false and throwException is set to true, then no exceptions are thrown.</p>

<p>The message of the exception is a pseudo-list of messages, one for each that did not pass the validation. They are separated by newline characters. Here is an example:</p>

<pre>
Groovy validation exception: 
"eeeeeeeeeee" is a String with a length outside the range of 5 to 10 characters or does not match the regular expression ".*"
"NNNNNNNNNNNNNNNN" is a String with a length outside the range of 0 to 15 characters or does not match the regular expression /^(?=.*[0-9].*[0-9])[0-9a-zA-Z]{8,12}\$/
101.0 is a double outside the range 10.0 to 100.0 
101.0 is a float outside the range 10.0 to 100.0
101 is an integer outside the range 10 to 100  or it is not divisible by anything in the set [1] 
101 is a long outside the range 0 to 100 or it is not divisible by anything in the set [5, 7] 
</pre>

*/

@ToString( includeNames = true )
@EqualsAndHashCode
@TupleConstructor 
@FinalFieldValidator
@AnnotationCollector
// @AnnotationCollector( [ Canonical, FinalFieldValidator, ToString ] )
public 
@interface ConvenientFinalFieldValidator {}

