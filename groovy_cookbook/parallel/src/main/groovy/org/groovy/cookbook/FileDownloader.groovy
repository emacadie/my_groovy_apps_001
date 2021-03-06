package org.groovy.cookbook

import static groovyx.gpars.GParsPool.*
import static com.google.common.collect.Lists.*

class FileDownloader {
    
    static final int POOL_SIZE = 2
    static pool
    FileDownloader() {
        pool = createPool( POOL_SIZE )
    }
    
    private void downloadFile( String remoteUrl, String localUrl ) {
        new File( "$localUrl" ).withOutputStream { out ->
            new URL( remoteUrl ).withInputStream { from ->
                out << from
            }
        }
    }
    
    private void parallelDownload( Map fromTo ) {
        withExistingPool( pool ) {
            fromTo.eachParallel { from, to ->
                downloadFile( from, to )
            }
        }
    }
    
    void download( Map fromTo, int maxConcurrent ) {
        if ( maxConcurrent > 0 ) {
            use( MapPartition ) {
                List maps = fromTo.partition( maxConcurrent )
                maps.each { downloadMap ->
                    parallelDownload( downloadMap )
                }
            }
        } else {
            parallelDownload( fromTo )
        }
    }
}

class MapPartition {
    static List partition( Map delegate, int size ) {
        def rslt = delegate.inject( [ [:] ] ) { ret, elem ->
            (ret.last() << elem).size() >= size ?
            ret << [:] : ret
        }
        rslt.last() ? rslt : rslt[0..-2]
    }
}


