package org.groovy.cookbook

import static groovyx.gpars.GParsPool.*
import org.junit.*
import edu.stanford.nlp.process.PTBTokenizer
import edu.stanford.nlp.process.CoreLabelTokenFactory
import edu.stanford.nlp.ling.CoreLabel

class ParallelizerTest {
    static words = []
    
    @BeforeClass
    static void loadDict() {
        def libraryUrl = 'http://www.gutenberg.org/cache/epub/'
        def bookFile = '17405/pg17405.txt'
        def bigText = "${libraryUrl}${bookFile}".toURL()
        words = tokenize( bigText.text )
    }
    
    static tokenize( String txt ) {
        List<String> words = []
        PTBTokenizer ptbt = new PTBTokenizer(
            new StringReader( txt ), new CoreLabelTokenFactory(), ''
        )
        ptbt.each { entry ->
            words << entry.value()
        }
        words
    }
    
    @Test
    void testParallelEach() {
        println "Starting testParallelEach"
        withPool {
            words.eachParallel { token ->
                if ( token.length() > 10 && !token.startsWith( 'http' ) ) {
                    println token
                }
            }
        }
        println "Ending testParallelEach"
    }
    
    @Test
    void testEveryParallel() {
        println "Starting testEveryParallel"
        withPool {
            assert !( words.everyParallel { token ->
                token.length() > 20
            })
        }
        println "Ending testEveryParallel"
    }
    
    @Test
    void combinedParallel() {
        println "Starting combinedParallel"
        withPool {
            println words
            .findAllParallel { it.length() > 10 && !it.startsWith( 'http' ) } // filter list into another list
            .groupByParallel { it.length() } // sort them by length into a Map, w/length as keys and array of words as values
            .collectParallel { "\nWORD LENGTH ${it.key}: " + it.value*.toLowerCase().unique() } // put the map into an array
        }
        println "Ending combinedParallel"
    }
    
}

