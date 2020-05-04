package info.shelfunit.properties.nonmutable.exception

import spock.lang.Specification
import org.junit.Rule
import org.junit.rules.TestName

class SecondMutableExSampleSpec extends Specification { 
    
    def setup() {}       // run before every feature method
    def cleanup() {}     // run after every feature method
    def setupSpec() {}   // run before the first feature method
    def cleanupSpec() {} // run after the last feature method
    
    @Rule 
    TestName name = new TestName()
    
    // for some reason the first time you call a class it does not actually process the annotations
    // comment out the lines for the "junk" object and compare
    def "test the no arg constructor"() {
        println "--- Starting test ${name.methodName}"
        
        // println "About to make junk"
        // def junk = new SecondMutableSample()
        println "About to make throwaway"
        
        def throwaway = new SecondMutableExSample( firstString: "Not Junk", secondString: "Goodbye Junk", firstInt: 21, secondInt: 30 )
        // throwaway.firstString = "Throwaway"
        println "Just made throwaway, about to make bTest1"
        def bTest1 = new SecondMutableExSample( firstString: "Hello1", secondString: "Goodbye", firstInt: 21, secondInt: 2000 )
        println "In test ${name.methodName}, bTest1: ${bTest1.toString()}"
        expect:
            bTest1.firstString == "Hello1"
            bTest1.secondInt == 0
         
    } // end "test the no arg constructor"
    
    def "test bTest2"() {
        println "--- Starting test ${name.methodName}"
        def bTest2 = new SecondMutableExSample( firstString: "Hello2", secondString: "Goodbye, this is more than 20 characters", firstInt: 22, secondInt: 20 )
        println "In test ${name.methodName}, bTest2: ${bTest2.toString()}"
        expect:
            bTest2.firstString == "Hello2"
    } // end "test bTest2"
    
    def "test the no arg constructor again"() {
        println "--- Starting test ${name.methodName}"
        
        /*
        def constructors = SecondMutableSample.class.getConstructors()
        constructors.each { 
            println "Constructor: ${it.toString()}"
        }
        
        def methods = SecondMutableSample.metaClass.getMethods() // getMetaMethods()
        methods.each {
            println "MetaMethod: ${it.toString()}"
        }
        println "SecondMutableSample.metaClass.getName(): ${SecondMutableSample.metaClass.getName()}"
        */

        def bTest1 = new SecondMutableExSample( firstString: "Hello3", secondString: "Goodbye", firstInt: 21, secondInt: 200 )
        println "In test ${name.methodName}, bTest1: ${bTest1.toString()}"
        expect:
            bTest1.firstString == "Hello3"
            bTest1.secondInt == 200
        
        // println "About to try a different way"
        // def bTest2 = new SecondMutableSample( 'Hello', 'Second', 21, 21 )
        // println "In test ${name.methodName}, bTest2: ${bTest2.toString()}"
        
    } // end "test the no arg constructor again"
    
}

