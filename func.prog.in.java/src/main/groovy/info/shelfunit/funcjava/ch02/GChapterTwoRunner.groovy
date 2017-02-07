package info.shelfunit.funcjava.ch02

class GChapterTwoRunner {
    final className = "GChapterTwoRunner."
    def methodName

    def iterateManyWays() {
        println "In method ${className}iterateManyWays"
    }
    
    
    
    static void main( String... args ) {
        GChapterTwoRunner gcTwoR = new GChapterTwoRunner()
        gcTwoR.iterateManyWays()
    }
}
