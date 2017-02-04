package info.shelfunit.funcjava.ch01;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ChapterOneRunner {
    private static final String className = "ChapterOneRunner.";
    private String methodName;
    
    public void discount() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        final List< BigDecimal > prices =
            Arrays.asList(
                        new BigDecimal( "10" ), new BigDecimal( "30" ), new BigDecimal( "17" ),
                        new BigDecimal( "20" ), new BigDecimal( "15" ), new BigDecimal( "18" ),
                        new BigDecimal( "45" ), new BigDecimal( "12" )
        );
        // total prices greater than 20, discounted by 10%
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for ( BigDecimal price : prices ) {
            if ( price.compareTo( BigDecimal.valueOf( 20 ) ) > 0 ) {
                totalOfDiscountedPrices = totalOfDiscountedPrices.add( price.multiply( BigDecimal.valueOf( 0.9 ) ) );
            }
        }
        System.out.println( "Total of dicounted prices: " + totalOfDiscountedPrices );

        System.out.println( "Now, let's try the new way" );
        final BigDecimal newTotalDiscountedPrices =
            prices.stream()
            .filter( price -> price.compareTo( BigDecimal.valueOf( 20 ) ) > 0 )
            .map( price -> price.multiply( BigDecimal.valueOf( 0.9 ) ) )
            .reduce( BigDecimal.ZERO, BigDecimal::add );

        System.out.println( "newTotalDiscountedPrices: " + newTotalDiscountedPrices );
    }
    
    public static void main( String [] args ) {
        ChapterOneRunner coR = new ChapterOneRunner();
        coR.discount();
    }       
}


        
