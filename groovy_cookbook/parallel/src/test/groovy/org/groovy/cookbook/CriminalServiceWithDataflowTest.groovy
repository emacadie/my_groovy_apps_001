package org.groovy.cookbook

import org.junit.*
import org.groovy.cookbook.dataflow.CriminalServiceWithDataflow

class CriminalServiceWithDataflowTest {
    
    
    @Test
    void testDataflow() {
        def serviceUrl = 'http://localhost:5050'
        def criminalService = new CriminalServiceWithDataflow( serviceUrl )
        def data = criminalService.
        getData( [ 'germany', 'us', 'canada' ] )
        assert 3 == data.size()
        data.each {
            try {
                println it
            } catch ( e ) {
                e.printStackTrace()
            }
        }
    }

}


