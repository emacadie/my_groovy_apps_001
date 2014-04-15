package org.groovy.cookbook

import org.junit.*
import edu.stanford.nlp.process.PTBTokenizer
import edu.stanford.nlp.process.CoreLabelTokenFactory
import edu.stanford.nlp.ling.CoreLabel
import org.groovy.cookbook.stm.*

class StmTest {

  @Test
  void testFrequency() {
      long start = System.currentTimeMillis()
      def stm = new StmValueIncreaser()
      def results = stm.start()
      def timeSpent = ( System.currentTimeMillis() - start )
      println "Execution time: ${timeSpent} ms"
        
      assert results.get( "withStm" ) == 100
      assert results.get( "noStm" ) != 100

      println "STM: " +  results[ 'withStm' ]
      println "NO STM: " + results.get( "noStm" ) 
  } 
}

