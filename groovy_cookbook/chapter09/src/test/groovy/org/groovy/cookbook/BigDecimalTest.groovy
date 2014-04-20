package org.groovy.cookbook

import java.math.BigDecimal
import java.text.NumberFormat

import org.junit.*

class BigDecimalTest { 

  static { 
    
    BigDecimal.metaClass.getInEuros = { ->
      def exchangeRate = 0.763461
      def nf = NumberFormat.getCurrencyInstance( Locale.US )
      nf.setCurrency( Currency.getInstance( 'EUR' ) )
      nf.format( delegate * exchangeRate )
    }
  }

  @Test
  void testEuros() { 
    /*
    // you could put this here or in a static block above
    BigDecimal.metaClass.getInEuros = { ->
      def exchangeRate = 0.763461
      def nf = NumberFormat.getCurrencyInstance( Locale.US )
      nf.setCurrency( Currency.getInstance( 'EUR' ) )
      nf.format( delegate * exchangeRate )
    }
*/
    assert 1500.00.inEuros == 'EUR1,145.19'
  }

}
