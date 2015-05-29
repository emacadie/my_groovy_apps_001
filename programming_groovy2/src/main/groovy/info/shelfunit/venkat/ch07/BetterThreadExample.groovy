package info.shelfunit.venkat.ch07

class BetterThreadExample {
    
    def printThreadInfo( msg ) {
        println "$msg" 
    }
    
    def doStuff() {
        sleep( 5000 )
        printThreadInfo 'Main'
        Thread.start {
            printThreadInfo "AA Started"
            sleep( 3000 ) 
            println "AA Interrupted 1" 
            sleep( 1000 )
            println "AA IN started"
            sleep( 3000 )
            println "AA still in started"
            println "AA Finished Started"
        }
        
        Thread.start {
            printThreadInfo "BB Started Daemon"
            sleep( 5000 ) 
            println "BB Interrupted 2" 
            sleep( 1000 )
            println "BB in second thread"
            sleep( 1000 )
            println "BB Finished Started Daemon"
        }
    }
      static void main( String[] args ) { 
          def bte = new BetterThreadExample()
          bte.doStuff()
      } // end method main

}

