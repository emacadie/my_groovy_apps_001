package org.groovy.cookbook

import static groovyx.gpars.GParsPool.*
import org.junit.*

class FileReadingTest {
    
    static final BASE_DIR = 'src/test/groovy/org/groovy/cookbook'
    static final TEST_SERVICE = 'https://androidnetworktester.googlecode.com'
    static final TEST_URL = "${TEST_SERVICE}/files/1mb.txt?cache="
    def downloader = new FileDownloader()
    List files
    static final int numberOfCores = Runtime.getRuntime().availableProcessors();
    static final double blockingCoefficient = 0.9;
    // static final int POOL_SIZE = ( int )( numberOfCores / ( 1 - blockingCoefficient ) ) // 4
    static final int POOL_SIZE = 2 // 2 is good
    static pool
    
    @Before
    void before() {
        files = []
        ( 1..10 ).each {
            files.add( "${BASE_DIR}/constitution.of.india.${it}.pdf" )
        }
        pool = createPool( POOL_SIZE )
    }
    
    @Test
    void testSerialReader() {
        println "Starting testSerialReader"
        long start = System.currentTimeMillis()
        files.each { file ->
            // println "looking at ${file}"
            long start2 = System.currentTimeMillis()
            def theFile = new File( file ) 
            def fr = new FileReader( theFile )
            def nextByte
            for ( i in 0..theFile.length() ) {
                nextByte = fr.read()
                // println "Here is byte ${i}: ${nextByte.toString()}"
            }
            println "Done with ${file}: ${System.currentTimeMillis() - start2}"
        }
        
        long timeSpent = System.currentTimeMillis() - start
        println "TIME NOPAR: ${timeSpent}"
    }
    
    @Test
    void testParallelRead() {
        println "Starting testParallelRead"
        long start = System.currentTimeMillis()
        
        // withPool( 10 ) {
        withExistingPool( pool ) {
            files.eachParallel { file ->
                long start2 = System.currentTimeMillis()
                // println "looking at ${file}"
                def theFile = new File( file ) 
                def fr = new FileReader( theFile )
                def nextByte
                for ( i in 0..theFile.length() ) {
                    nextByte = fr.read()
                    // println "Here is byte ${i}: ${nextByte.toString()}"
                }
                println "Done with ${file}: ${System.currentTimeMillis() - start2}"
            }
        }
                
        long timeSpent = System.currentTimeMillis() - start
        println "TIMEPAR: ${timeSpent}"
    }
    
    /*
    @Test
    void testParallelDownloadWithMaxConcurrent() {
        println "Starting testParallelDownloadWithMaxConcurrent"
        long start = System.currentTimeMillis()
        downloader.download( files, 3 )
        long timeSpent = System.currentTimeMillis() - start
        println "TIMEPAR MAX 3: ${timeSpent}"
    }
    */
}

