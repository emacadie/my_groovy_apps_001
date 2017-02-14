package info.shelfunit.funcjava.ch02

class GChapterTwoRunner {
    final className = "GChapterTwoRunner."
    def methodName
    final names = [ "Brian", "Nate", "Neil", "Raju", "Sara", "Scott" ]

    def iterateManyWays() {
        println "In method ${className}iterateManyWays"
        
        println "Let's use a for loop"
        for ( int i = 0; i < names.size(); i++ ) {
            println "Here is names ${i}: ${names[ i ]}"
        }
        println "let's use the each method"
        names.each { nameA ->
            println "Next name is ${nameA}"
        }
        println "let's use eachWithIndex"
        names.eachWithIndex { nameB, num ->
            println "Here is name ${num}: ${nameB}"
        }
        println "Using groovy's upto, which is exclusive (so using names.size() - 1)"
        0.upto( names.size() - 1 ) { nameUpto ->
            println "Here is name with upto: ${names[ nameUpto ]}"
        }
        println "Using java.lang.Number.times (from GDK extensions)"
        names.size().times { theTime ->
            println "Here is the next in times block: ${names[ theTime ]}"
        }
        println "Here we use java.lang.Number.step (from GDK extensions)"
        0.step( names.size(), 1 ) { nextStep ->
            println "Here is the next step: ${names[ nextStep ]}"
        }
        println "Using a range, which is exclusive (so using names.size() - 1)"
        ( 0..names.size() - 1 ).each { nextRange ->
            println "Here is the next in the range: ${names[ nextRange ]}"
        }
        println "Doing the groovy for-each loop (per Mr Haki)"
        for ( i in names ) {
            println "Here is i: ${i}"
        }
        
    } // end iterateManyWays

    def transformAList() {
        println "In method ${className}transformAList"
        println "transforming to uppercase"
        def upperCaseNames = names.collect { name ->
            name.toUpperCase()
        }
        println "Here is upperCaseNames: ${upperCaseNames}"
        def nameLengths = names.collect { name ->
            name.length()
        }
        println "here is nameLengths: ${nameLengths}"
        def upperNamesReverse = names.collect { name ->
            name.toUpperCase().reverse()
        }
        println "result of two methods in collect: ${upperNamesReverse}"
        def upperNamesReverseTwoCalls = names.collect { name ->
            name.toUpperCase()
        }.collect { uName ->
            uName.reverse()
        }
        println "result of two calls to collect: ${upperNamesReverseTwoCalls}"
    } // transformAList()
    
    static void main( String... args ) {
        GChapterTwoRunner gcTwoR = new GChapterTwoRunner()
        println "Here is args: ${args}"
        println "Args is a ${args.getClass().name}"
        def methodToRun = args[ 0 ]
        switch ( methodToRun ) {
            case 'iterateManyWays':
                gcTwoR.iterateManyWays()
                break
            case 'transformAList':
                gcTwoR.transformAList()
                break
            default:
                println "Unknown method"

        }
        
    } // end main
}
