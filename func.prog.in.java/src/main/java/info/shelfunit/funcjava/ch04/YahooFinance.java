package info.shelfunit.funcjava.ch04;

import java.math.BigDecimal;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.Random;

// this is pretty much taken as-is from the book
public class YahooFinance {
    public static BigDecimal getPrice( final String ticker ) {
        System.out.println( "Calling getPrice with ticker " + ticker  );
        try {
            // old: "http://ichart.finance.yahoo.com/table.csv?s=
            // new?: http://chart.finance.yahoo.com/table.csv?s=
            
            final URL url = new URL( "http://ichart.finance.yahoo.com/table.csv?s=" + ticker );
            final BufferedReader reader = new BufferedReader( new InputStreamReader( url.openStream() ) );
            reader.lines().forEach( System.out::println );
            /*
            // final String test = reader.lines().skip( 1 );
            // orig:
            final String data = reader.lines().skip( 1 ).findFirst().get();
            // String firstLine = reader.readLine();
            // final String data = reader.readLine();
            System.out.println( "Here is data: " + data );
            final String[] dataItems = data.split( "," );
            return new BigDecimal( dataItems[ dataItems.length - 1 ] );
            */
            return new BigDecimal( "10" );
        } catch ( Exception ex ) {
            System.out.println( "----------------- Here is the exception" );
            throw new RuntimeException( ex );
        }
    }
}
