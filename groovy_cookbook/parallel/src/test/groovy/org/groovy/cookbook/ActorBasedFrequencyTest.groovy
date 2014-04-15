package org.groovy.cookbook

import org.junit.*
import edu.stanford.nlp.process.PTBTokenizer
import edu.stanford.nlp.process.CoreLabelTokenFactory
import edu.stanford.nlp.ling.CoreLabel

class ActorBasedFrequencyTest {
    
    @Test
    void testFrequency() {
        def bigText = 'http://norvig.com/big.txt'.toURL()
        def analyzer = new ActorBasedWordAnalyzer()
        Map res = analyzer.frequency( tokenize( bigText.text ) )
        res.each {
            println "[ ${it.key} ${it.value} ]"
        }
    }
    
    def tokenize( String txt ) {
        List< String > words = []
        PTBTokenizer ptbt = new PTBTokenizer( new StringReader( txt ), new CoreLabelTokenFactory(), '' )
        ptbt.each { entry ->
            words << entry.value()
        }
        words
    }

}


