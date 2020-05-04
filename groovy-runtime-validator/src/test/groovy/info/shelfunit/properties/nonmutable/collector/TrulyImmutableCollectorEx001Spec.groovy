package info.shelfunit.properties.nonmutable.collector

import spock.lang.Specification
import org.junit.Rule
import org.junit.rules.TestName

class TrulyImmutableCollectorEx001Spec extends Specification {
    def setup() {}       // run before every feature method
    def cleanup() {}     // run after every feature method
    def setupSpec() {
    }   // run before the first feature method
    def cleanupSpec() {} // run after the last feature method
    
    @Rule 
    TestName name = new TestName()
   
    def "two immutable objects with validation, trying to change the first"() {
        println "\n\n--- Starting test ${name.methodName}"
        println "About to make throwaway"
        when:
            def throwaway = TrulyImmutableCollector001.createValidatedObject( [ firstString: "Not Junk", secondString: "Goodbye Junk", firstInt: 21, secondInt: 20 ], true )
            boolean exceptionThrown = false
            try {
                throwaway.firstString = "Throwaway"
            } catch ( Exception e ) {
                exceptionThrown = true
            }
        then:
            def ex1 = thrown( Exception )
            ex1.message == "Groovy validation exception:\n" +
            "21 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]\n" +
            "20 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]"
            exceptionThrown == false
            println "Just made throwaway, about to make bTest1"
        
        when:
            def bTest1 = TrulyImmutableCollector001.createValidatedObject( [ firstString: "Hello1", secondString: "Goodbye", firstInt: 21, secondInt: 200 ], true )
            println "In test ${name.methodName}, bTest1: ${bTest1.toString()}"
        then:
            def ex2 = thrown ( Exception )
            ex2.message == "Groovy validation exception:\n" +
            "21 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]"
        
    } // end "two immutable objects with validation, trying to change the first"
    
    def "test bTest2"() {
        println "\n\n--- Starting test ${name.methodName}"
        when:
            def bTest2 = TrulyImmutableCollector001.createValidatedObject( [ firstString: "Hello2", secondString: "Goodbye, this is more than 20 characters", firstInt: 22, secondInt: 20 ], true )
            println "In test ${name.methodName}, bTest2: ${bTest2.toString()}"
        then:
            def exTest2 = thrown( Exception )
            StringWriter sw = new StringWriter();
            exTest2.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            // println "Here is the stack trace: ${exceptionAsString}"
            println "here is the message: ${exTest2.message}"
            exTest2.message == "Groovy validation exception:\n" +
            "\"Goodbye, this is more than 20 characters\" is a String with a length outside the range of 5 to 20 characters or does not match the regular expression \".*\"\n" +
            "22 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]\n" +
            "20 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]"
    } // end "test bTest2"
    
    def "third test"() {
        println "\n\n--- Starting test ${name.methodName}"
        when:
            boolean exceptionThrown = false
            def bTest1 = TrulyImmutableCollector001.createValidatedObject( [ firstString: "Hello3", secondString: "Goodbye", secondInt: 401, firstInt: 21 ], true )
            println "In test ${name.methodName}, bTest1: ${bTest1.toString()}"
            
            try {
                bTest1.secondString = "ChumbaWumba"
            } catch ( Exception e ) {
                exceptionThrown = true
            }
            println "Still in test ${name.methodName}, bTest1: ${bTest1.toString()}"
        then:
            def exThirdTest = thrown( Exception )
            exThirdTest.message == "Groovy validation exception:\n" +
            "21 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]\n" +
            "401 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]"
            exceptionThrown == false
    } // end "third test
    
    def "test bTest3"() {
        println "\n\n--- Starting test ${name.methodName}"
        when:
            def bTest2 = TrulyImmutableCollector001.createValidatedObject( [ firstString: "Hel", secondString: "Goodbye, this is more than 20 characters", firstInt: 22, secondInt: 20 ], true )
            println "In test ${name.methodName}, bTest2: ${bTest2.toString()}"
        then:
            def exTest2 = thrown( Exception )
            StringWriter sw = new StringWriter();
            exTest2.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            println "Here is the stack trace: ${exceptionAsString}"
            println "here is the message: ${exTest2.message}"
            exTest2.message == "Groovy validation exception:\n" +
            "\"Hel\" is a String with a length outside the range of 5 to 200 characters or does not match the regular expression \".*\"\n" +
            "\"Goodbye, this is more than 20 characters\" is a String with a length outside the range of 5 to 20 characters or does not match the regular expression \".*\"\n" +
            "22 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]\n" +
            "20 is a java.lang.Integer outside the range 30 to 400 or it is not divisible by anything in the set [1]"
    } // end "test bTest3"
   
} // TrulyImmutableCollectorEx001Test 


