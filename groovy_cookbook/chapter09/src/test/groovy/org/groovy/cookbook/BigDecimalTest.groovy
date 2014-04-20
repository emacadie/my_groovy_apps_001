package org.groovy.cookbook

import java.math.BigDecimal
import java.text.NumberFormat

import org.junit.*

class BigDecimalTest { 

  @Test
  void testEuros() { 
    BigDecimal.metaClass.getInEuros = { ->
      def exchangeRate = 0.763461
      def nf = NumberFormat.getCurrencyInstance( Locale.US )
      nf.setCurrency( Currency.getInstance( 'EUR' ) )
      nf.format( delegate * exchangeRate )
    }
    assert 1500.00.inEuros == 'EUR1,145.19'
  }

}
