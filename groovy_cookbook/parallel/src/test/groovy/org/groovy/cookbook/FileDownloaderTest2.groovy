package org.groovy.cookbook

import org.junit.*

class FileDownloaderTest2 {
    
    static final DOWNLOAD_BASE_DIR = '/tmp'
    static final TEST_SERVICE = 'https://androidnetworktester.googlecode.com'
    static final TEST_URL = "${TEST_SERVICE}/files/1mb.txt?cache="
    def downloader = new FileDownloader()
    Map files
    
    @Before
    void before() {
        files = [:]
        ( 1..10 ).each {
            files.put(
            "${TEST_URL}1.${it}", "${DOWNLOAD_BASE_DIR}/${it}MyFile.txt"
            )
        }
    }
    
    @Test
    void testSerialDownload() {
        println "Starting testSerialDownload"
        long start = System.currentTimeMillis()
        files.each{ k,v ->
            new File( v ) << k.toURL().text
        }
        long timeSpent = System.currentTimeMillis() - start
        println "TIME NOPAR: ${timeSpent}"
    }
    
    @Test
    void testParallelDownload() {
        println "Starting testParallelDownload"
        long start = System.currentTimeMillis()
        downloader.download( files, 0 )
        long timeSpent = System.currentTimeMillis() - start
        println "TIMEPAR: ${timeSpent}"
    }
    
    @Test
    void testParallelDownloadWithMaxConcurrent() {
        println "Starting testParallelDownloadWithMaxConcurrent"
        long start = System.currentTimeMillis()
        downloader.download( files, 3 )
        long timeSpent = System.currentTimeMillis() - start
        println "TIMEPAR MAX 3: ${timeSpent}"
    }
}


