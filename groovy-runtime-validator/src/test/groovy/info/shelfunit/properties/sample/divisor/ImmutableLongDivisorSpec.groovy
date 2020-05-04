package info.shelfunit.properties.sample.divisor

import spock.lang.Ignore
import spock.lang.Specification
import org.junit.Rule
import org.junit.rules.TestName

class ImmutableLongDivisorSpec extends Specification { 
    def setup() {}          // run before every feature method
    def cleanup() {}        // run after every feature method
    def setupSpec() {
        
    }     // run before the first feature method
    def cleanupSpec() {}   // run after the last feature method
    
    @Rule 
    TestName name = new TestName()
    
    @Ignore
    def "test both long fields"() {
        println "--- Starting test ${name.methodName}"
        
        when:
            def rid = ImmutableLongDivisor.createValidatedObject( [ longWithDiv: 2147483655L, longWithDiv002: 14L ], true )
        then:
            rid.longWithDiv == 2147483655L
            rid.longWithDiv002 == 14L
            println "rid.toString(): ${rid.toString()}"
        
        when:
            def rid2 = ImmutableLongDivisor.createValidatedObject( [ longWithDiv: 2147483640L, longWithDiv002: 13L ], true )
            println "rid2.toString(): ${rid2.toString()}"
        then:
            def ex = thrown( Exception )
            ex.message == "Groovy validation exception:\n" +
            "2147483640 is a java.lang.Long outside the range 2147483647 to 9223372036854775807 or it is not divisible by anything in the set [5]\n" +
            "13 is a java.lang.Long outside the range 0 to 9223372036854775807 or it is not divisible by anything in the set [7]"
        
    } // end "test both long fields"

    @Ignore
    def "test with divisor array"() {
        println "--- Starting test ${name.methodName}"
        when:
            def rid = ImmutableLongDivisor.createValidatedObject( [ longWithDivArray: 12L ], true )
        then:
            rid.longWithDivArray == 12L
        
        when:
            rid.longWithDiv = 2147483947L
        then:
            def ex = thrown( Exception )
            ex.message == "Cannot set readonly property: longWithDiv for class: info.shelfunit.properties.sample.divisor.ImmutableLongDivisor"
        
        when:
            def rid2 = ImmutableLongDivisor.createValidatedObject( [ longWithDivArray: 13L ], true )
        then:
            def ex2 = thrown( Exception )
            ex2.message == "Groovy validation exception:\n" +
            "13 is a java.lang.Long outside the range 0 to 40 or it is not divisible by anything in the set [3, 4]"
        
        when:
            def rid3 = ImmutableLongDivisor.createValidatedObject( [ longWithDivArray: 9L ], true )
        then:
            rid3.longWithDivArray == 9L
       
        when:
            def rid4 = ImmutableLongDivisor.createValidatedObject( [ longWithDivArray: 16L ], true )
        then:
            rid4.longWithDivArray == 16L
        
        when:
            def rid5 = ImmutableLongDivisor.createValidatedObject( [ longWithDivArray: 55L ], true )
        then:
            def ex5 = thrown( Exception )
            ex5.message == "Groovy validation exception:\n" +
            "55 is a java.lang.Long outside the range 0 to 40 or it is not divisible by anything in the set [3, 4]"
        
    } // end test with divisor array
    
    @Ignore
    def "test with zero divisor"() {
        println "--- Starting test ${name.methodName}"
        when:
            def rid = ImmutableLongDivisor.createValidatedObject( [ longWithDivArray: 12L, longWithZeroDiv: 35L ], true )
            // println "rid: ${rid.toString()}"
        then:
            rid.longWithDivArray == 12L
            rid.longWithZeroDiv == 35L
        
        when:
            def rid2 = ImmutableLongDivisor.createValidatedObject( [ longWithDivArray: 9L, longWithZeroDiv: 55L ], true )
        then:
            def ex = thrown( Exception )
            ex.message == "Groovy validation exception:\n" +
            "55 is a java.lang.Long outside the range 0 to 40 or it is not divisible by anything in the set [1]"

    } // end test with zero divisor
    
} // ImmutableLongDivisorSpec

