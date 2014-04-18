package org.groovy.cookbook.dataflow

import static groovyx.gpars.dataflow.Dataflow.task
import groovyx.gpars.dataflow.DataflowVariable

class CriminalServiceWithDataflow {
    def baseUrl
    
    CriminalServiceWithDataflow( String url ) {
        baseUrl = url
    }
    
    def fetchData( String country ) {
        println "fetching data for ${country}"
        def jsonResponse = new DataflowVariable()
        task {
            try {
                "${baseUrl}/${country}".toURL().openConnection().with {
                    if ( responseCode == 200 ) {
                        jsonResponse << inputStream.text
                    } else {
                        jsonResponse << new RuntimeException( 'Invalid Response Code from HTTP GET:' + responseCode )
                    }
                    disconnect()
                }
            } catch( e ) { jsonResponse << e }
        }
        jsonResponse
    }
    
    List getData( List countries ) {
        List aggregatedJson = []
        countries.each {
            aggregatedJson << fetchData( it )
        }
        aggregatedJson.val
    }
    
    
    
} // end class CriminalServiceWithDataflow


