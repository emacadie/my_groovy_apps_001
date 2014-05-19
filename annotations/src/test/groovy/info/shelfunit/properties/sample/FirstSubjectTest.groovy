package info.shelfunit.properties.sample

import spock.lang.Specification

class FirstSubjectTest extends Specification { 
    def setup() {}          // run before every feature method
    def cleanup() {}        // run after every feature method
    def setupSpec() {}     // run before the first feature method
    def cleanupSpec() {}   // run after the last feature method
    
    def "test the no arg constructor"() {
    }
    
    
    /*
    ef fs001 = new FirstSubject()
        println "1. Just called constructor for fs001"
        def fs002 = new FirstSubject()
        // @IntAnnotation(minValue=30, maxValue=400)
        // int firstNum
        println "1. fs001.secondNum is ${fs001.secondNum}, fs001.firstNum is ${fs001.firstNum}"
        fs001.firstNum = 100
        println "2. fs001.secondNum is ${fs001.secondNum}, fs001.firstNum is ${fs001.firstNum}"
        fs001.firstNum = 10
        println "3. fs001.secondNum is ${fs001.secondNum}, fs001.firstNum is ${fs001.firstNum}"
        fs001.firstNum = 10000
        println "4. fs001.secondNum is ${fs001.secondNum}, fs001.firstNum is ${fs001.firstNum}"
        fs001.firstNum = "qwertyuiopasdfg"
        println "5. fs001.secondNum is ${fs001.secondNum}, fs001.firstNum is ${fs001.firstNum}"
        println "About to call fs001.hello()"
        fs001.hello()
        println "Instantiating with map, setting firstNum to 40"
        def fsWithMap = new FirstSubject(firstNum: 40)
        println "fsWithMap.firstNum is ${fsWithMap.firstNum}"
        println "Instantiating with map, setting firstNum to 20"
        def fsWithMap2 = new FirstSubject(firstNum: 20)
        println "fsWithMap2.firstNum is ${fsWithMap2.firstNum}"
    */
    def "testing with map constructor"() {
        when:
        def fsWithMap = new FirstSubject(firstNum: 40)
        then:
        fsWithMap.firstNum == 40
        
        when:
        def fsWithMap2 = new FirstSubject(firstNum: 20)
        then:
        fsWithMap2.firstNum == null
    }
}