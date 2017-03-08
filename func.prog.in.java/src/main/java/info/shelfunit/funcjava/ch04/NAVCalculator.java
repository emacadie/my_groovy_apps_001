package info.shelfunit.funcjava.ch04;

import java.math.BigDecimal;
import java.util.function.Function;

public class NAVCalculator {

    private Function< String, BigDecimal > priceFinder;
    public NAVCalculator( final Function< String, BigDecimal > argPriceFinder ) {
        this.priceFinder = argPriceFinder;
    }
    
    public BigDecimal computeStockWorth( final String ticker, final int shares ) {
        return priceFinder.apply( ticker ).multiply( BigDecimal.valueOf( shares ) );
    }
} // NAVCalculator 
