package info.shelfunit.properties.nonmutable

import spock.lang.Specification
import org.junit.Rule
import org.junit.rules.TestName

class TrulyImmutable001Spec extends Specification {
    def setup() {}       // run before every feature method
    def cleanup() {}     // run after every feature method
    def setupSpec() {
    }   // run before the first feature method
    def cleanupSpec() {} // run after the last feature method
    
    @Rule 
    TestName name = new TestName()
    
    // for some reason the first time you call a class it does not actually process the annotations
    // comment out the lines for the "junk" object and compare
   
    def "two immutable objects with validation, trying to change the first"() {
        println "\n\n--- Starting test ${name.methodName}"

        println "About to make throwaway"
        when: "We make an immutable object with the numbers under their ranges and try to change the string"
            def throwaway = TrulyImmutable001.createValidatedObject( [ firstString: "Not Junk", secondString: "Goodbye Junk", firstInt: 21, secondInt: 20 ] )
            boolean exceptionThrown = false
            try {
                throwaway.firstString = "Throwaway"
            } catch ( Exception e ) {
                exceptionThrown = true
            }
        then: "The string has not changed, and the numbers are 0"
            throwaway.firstString == "Not Junk"
            throwaway.firstInt == 0
            throwaway.secondInt == 0
            exceptionThrown == true
        println "Just made throwaway, about to make bTest1"
        
        when: "we make an immutable object with one number outside the range"
            def bTest1 = TrulyImmutable001.createValidatedObject( [ firstString: "Hello1", secondString: "Goodbye", firstInt: 21, secondInt: 200 ] )
            println "In test ${name.methodName}, bTest1: ${bTest1.toString()}"
        then: "the firstInt should be 0"
            bTest1.firstString == "Hello1"
            bTest1.secondInt == 200
            bTest1.firstInt == 0
        
    } // end "test the no arg constructor"
    
    def "test bTest2"() {
        println "\n\n--- Starting test ${name.methodName}"
        def bTest2 = TrulyImmutable001.createValidatedObject( [ firstString: "Hello2", secondString: "Goodbye, this is more than 20 characters", firstInt: 22, secondInt: 20 ] )
        println "In test ${name.methodName}, bTest2: ${bTest2.toString()}"
        expect:
            bTest2.firstString == "Hello2"
            bTest2.secondString == null
            bTest2.firstInt == 0
            bTest2.secondInt == 0
    } // end "test bTest2"
    
    def "third test"() {
        println "\n\n--- Starting test ${name.methodName}"

        boolean exceptionThrown = false
        def bTest1 = TrulyImmutable001.createValidatedObject( [ firstString: "Hello3", secondString: "Goodbye", secondInt: 401, firstInt: 21 ] )
        println "In test ${name.methodName}, bTest1: ${bTest1.toString()}"
        // println "bTest1.firstString: ${bTest1.firstString}, bTest1.secondString: ${bTest1.secondString}"
        try {
            bTest1.secondString = "ChumbaWumba"
        } catch ( Exception e ) {
            exceptionThrown = true
        }
        println "Still in test ${name.methodName}, bTest1: ${bTest1.toString()}"
        expect:
        bTest1.firstString == "Hello3"
        bTest1.secondString == "Goodbye"
        bTest1.firstInt == 0
        bTest1.secondInt == 0
        exceptionThrown == true
    } // end "test the no arg constructor again"
   
} // TrulyImmutable001Test 


