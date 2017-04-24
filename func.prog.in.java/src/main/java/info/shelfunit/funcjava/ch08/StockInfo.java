package info.shelfunit.funcjava.ch08;

import java.math.BigDecimal;

public class StockInfo {
    public final String ticker;
    public final BigDecimal price;

    public StockInfo (final String argTicker, final BigDecimal argPrice ) {
        ticker = argTicker;
        price = argPrice;
    }

    public String toString() {
        return String.format( "ticker: %s price: %g", ticker, price );
    }
}
