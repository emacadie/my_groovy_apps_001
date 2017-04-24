package info.shelfunit.funcjava.ch04;

import java.math.BigDecimal;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// this is pretty much taken as-is from the book
public class YahooFinance {
    public static BigDecimal getPrice( final String ticker ) {

        try {
            // old: "http://ichart.finance.yahoo.com/table.csv?s=
            // new?: http://chart.finance.yahoo.com/table.csv?s=
            final URL url = new URL( "https://chart.finance.yahoo.com/table.csv?s=" + ticker );
            final BufferedReader reader = new BufferedReader( new InputStreamReader( url.openStream() ) );
            final String data = reader.lines().skip( 1 ).findFirst().get();
            // System.out.println( "Here is data: " + data );
            final String[] dataItems = data.split( "," );
            // System.out.println( "returning " + ticker + ": " + new BigDecimal( dataItems[ dataItems.length - 1 ] ) );
            return new BigDecimal( dataItems[ dataItems.length - 1 ] );
            
        } catch ( Exception ex ) {
            System.out.println( "----------------- Here is the exception" );
            throw new RuntimeException( ex );
        }
    }
}
