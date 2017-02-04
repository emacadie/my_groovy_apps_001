package info.shelfunit.funcjava.ch01

class GChapterOneRunner {
    final className = "GChapterOneRunner."
    def methodName
    
    def discount() {
        println "Starting method ${className}discount()"
        def prices = [ 10, 30, 17, 20, 15, 18, 45, 12 ]
        def discountedTotal = prices.findAll { p ->
            p > 20
        }.collect { p ->
            p * 0.9
        }.inject( 0 ) { total, next ->
            total + next
        }
        println "Discounted total is ${discountedTotal}"
    }
    
    static void main( String... args ) {
        GChapterOneRunner gcoR = new GChapterOneRunner()
        gcoR.discount()
    }
}
