package info.shelfunit.funcjava.ch02

class GChapterTwoRunner {
    final className = "GChapterTwoRunner."
    def methodName
    final friends    = [ "Brian", "Nate", "Neil", "Raju", "Sara", "Scott" ]
    final editors  = [ "Brian", "Jackie", "John", "Mike" ]
    final comrades = [ "Kate", "Ken", "Nick", "Paula", "Zack" ]
    
    def iterateManyWays() {
        println "In method ${className}iterateManyWays"
        
        println "Let's use a for loop"
        for ( int i = 0; i < friends.size(); i++ ) {
            println "Here is friends ${i}: ${friends[ i ]}"
        }
        println "let's use the each method"
        friends.each { nameA ->
            println "Next name is ${nameA}"
        }
        println "let's use eachWithIndex"
        friends.eachWithIndex { nameB, num ->
            println "Here is name ${num}: ${nameB}"
        }
        println "Using groovy's upto, which is exclusive (so using friends.size() - 1)"
        0.upto( friends.size() - 1 ) { nameUpto ->
            println "Here is name with upto: ${friends[ nameUpto ]}"
        }
        println "Using java.lang.Number.times (from GDK extensions)"
        friends.size().times { theTime ->
            println "Here is the next in times block: ${friends[ theTime ]}"
        }
        println "Here we use java.lang.Number.step (from GDK extensions)"
        0.step( friends.size(), 1 ) { nextStep ->
            println "Here is the next step: ${friends[ nextStep ]}"
        }
        println "Using a range, which is exclusive (so using friends.size() - 1)"
        ( 0..friends.size() - 1 ).each { nextRange ->
            println "Here is the next in the range: ${friends[ nextRange ]}"
        }
        println "Doing the groovy for-each loop (per Mr Haki)"
        for ( i in friends ) {
            println "Here is i: ${i}"
        }
        
    } // end iterateManyWays

    def transformAList() {
        println "In method ${className}transformAList"
        println "transforming to uppercase"
        def upperCaseFriends = friends.collect { name ->
            name.toUpperCase()
        }
        println "Here is upperCaseFriends: ${upperCaseFriends}"
        def nameLengths = friends.collect { name ->
            name.length()
        }
        println "here is nameLengths: ${nameLengths}"
        def upperFriendsReverse = friends.collect { name ->
            name.toUpperCase().reverse()
        }
        println "result of two methods in collect: ${upperFriendsReverse}"
        def upperFriendsReverseTwoCalls = friends.collect { name ->
            name.toUpperCase()
        }.collect { uName ->
            uName.reverse()
        }
        println "result of two calls to collect: ${upperFriendsReverseTwoCalls}"
    } // transformAList()

    def findElements() {
        println "In method ${className}findElements"
        println "Original list: ${friends}"
        def startsWithN = friends.findAll { name ->
            name.startsWith( 'N' )
        }
        println "List of friends starting with N: ${startsWithN}"
    } // findElements

    def reuseLambda() {
        println "In method ${className}reuseLambda"
        println "Here is friends: " + friends 
        println "Here is editors: " + editors 
        println "Here is comrades: " + comrades
        println "friends who start with N: " + friends.findAll{ name -> name.startsWith( "N" ) }.join( ", " )
        println "editors who start with N: " + editors.findAll{ name -> name.startsWith( "N" ) }.join( ", " )
        println "comrades who start with N: " + comrades.findAll{ name -> name.startsWith( "N" ) }.join( ", " )
        println "Frankly, doing it another way seems pointless in Groovy"
    } // reuseLambda

    def pickName( letter ) {
        println "In method ${className}pickName"
        println "Looking for a name in friends that starts with ${letter}: " +
            ( friends.find{ name -> name.startsWith( letter ) } ?: " nope" )
        def nullCheck = friends.find{ name -> name.startsWith( letter ) } ?: " nope"
        println "Names with null check: ${nullCheck}"
        println "Looking for a name in friends that starts with ${letter} and hopefully not returning null: " +
            friends.findResult{ name -> name.startsWith( letter ) } 
    } // pickName

    def reduceAndJoin() {
        println "Starting method ${className}reduceAndJoin"
        print "total number of characters in all names of friends: "
        println friends.inject( 0 ) { acc, val -> acc + val.length() }
        print "longest name: "
        println friends.inject ( "Joe" ) { acc, val -> acc >= val ? acc : val }
        println "join the strings: ${friends.join( ", " )}"
    } // reduceAndJoin
    
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
            case 'findElements':
                gcTwoR.findElements()
                break
            case 'reuseLambda':
                gcTwoR.reuseLambda()
                break
            case 'pickName':
                gcTwoR.pickName( args[ 1 ] )
                break
            case 'reduceAndJoin':
                gcTwoR.reduceAndJoin()
                break                                                                
            default:
                println "Unknown method"

        }
        
    } // end main
}
