package org.groovy.cookbook.stm

import static org.multiverse.api.StmUtils.newIntRef
import groovyx.gpars.actor.*
import groovyx.gpars.stm.GParsStm
// import org.multiverse.api.references.IntRef
import org.multiverse.api.references.TxnInteger
import org.multiverse.api.StmUtils

class StmValueIncreaser {
    int value = 0
    private final TxnInteger stmValue =  StmUtils.newTxnInteger( 0 )
    
    // Message
    final class Increase { }
    
    final class ValueAccessActor extends DynamicDispatchActor {
        void onMessage( Increase message ) {
            value++ // unsafe increment
           
            GParsStm.atomic {
                stmValue.increment() // safe increment
            }
        }
    }
    
    def actors = [:]
    Random random = new Random()
    int max = 20
    Map start() {
        
        // init actors
        ( 1..20 ).each {
            actors.put( it, new ValueAccessActor().start() )
        }
        // spawn actors and increase counter
        ( 1..100 ).each {
            actors.get( rnd( 1, 20 ) ) << new Increase()
        }
        ( actors.values()*.stop() )*.join()
        int stmProtected = 0
        
        GParsStm.atomic {
            stmProtected = stmValue.get()
        }
        
        [ 'withStm': stmProtected, 'noStm': value ]
    }
    
    def rnd = { from, to ->
        random.nextInt( to-from + 1 ) + from
    }
}

