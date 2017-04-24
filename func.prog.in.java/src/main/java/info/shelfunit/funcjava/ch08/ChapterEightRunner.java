package info.shelfunit.funcjava.ch08;

import info.shelfunit.funcjava.ch04.YahooFinance;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.function.Predicate;

import java.util.stream.Collectors;

public class ChapterEightRunner {
    private static final String className = "ChapterEightRunner.";
    private String methodName;

    List< String > symbols = Arrays.asList(
        "AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
        "AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT",
        "ORCL", "TSLA", "VRSN", "YHOO"
    );

    public void useFunctionComposition() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        


        final BigDecimal HUNDRED = new BigDecimal( 100 );
        System.out.println( "Here are stocks with prices over $100: " );
        String bigStocks = symbols.stream()
            .filter( symbol -> YahooFinance.getPrice( symbol ).compareTo( HUNDRED ) > 0 ) 
            .sorted()
            .collect( Collectors.joining( ", " ) );
        System.out.println( "here are some big Scottish stocks: " + bigStocks );
        
        final List< String > theList = symbols.stream()
            .filter( symbol -> YahooFinance.getPrice( symbol ).compareTo( HUNDRED ) > 0 ) 
            .sorted()
            .collect( Collectors.toList() );
        System.out.println( "Here it is again: " + theList );
        
    } // useFunctionComposition

    public StockInfo getPrice( final String ticker ) {
        return new StockInfo( ticker, YahooFinance.getPrice( ticker ) );
    }

    public Predicate< StockInfo > isPricedLessThan( final int price ) {
        return stockInfo -> stockInfo.price.compareTo( BigDecimal.valueOf( price ) ) < 0;
    }

    public StockInfo pickHigh( final StockInfo stock1, final StockInfo stock2 ) {
        return stock1.price.compareTo( stock2.price ) > 0 ? stock1 : stock2;
    }
    
    public void useMapReduce() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "Here is the imperative version with three loops" );
        long start = System.nanoTime();
        final List< StockInfo > stocks = new ArrayList< StockInfo >();
        for ( String symbol : symbols ) {
            stocks.add( this.getPrice( symbol ) );
        }
        final List< StockInfo > stocksUnder500 = new ArrayList< StockInfo > ();
        final Predicate< StockInfo > isPriceLessThan500 = this.isPricedLessThan( 500 );
        for( StockInfo stock : stocks ) {
            if ( isPriceLessThan500.test( stock ) ) {
                stocksUnder500.add( stock );
            }
        }

        StockInfo highPriced = new StockInfo( "", BigDecimal.ZERO );
        for ( StockInfo stock : stocksUnder500 ) {
            highPriced = this.pickHigh( highPriced, stock );
        }
        long end = System.nanoTime();
        System.out.println( "Highest priced stock under $500 from imperative: " + highPriced );
        System.out.println( "Time taken: " + (end - start)/1.0e9 );
        System.out.println( "Trying again with a more concise imperative" );
        start = System.nanoTime();
        StockInfo highPricedB = new StockInfo( "", BigDecimal.ZERO );
        // we will re-use final Predicate< StockInfo > isPriceLessThan500 = this.isPricedLessThan( 500 );
        for( String symbol : symbols ) {
            StockInfo stockInfo = this.getPrice( symbol );
            if ( isPriceLessThan500.test( stockInfo ) ) {
                highPricedB = this.pickHigh( highPricedB, stockInfo );
            }
        }
        end = System.nanoTime();
        System.out.println( "Highest priced stock under $500 from concise imperative: " + highPricedB );
        System.out.println( "Time taken: " + (end - start)/1.0e9 );
        System.out.println( "Let's do it again with functional programming" );
        start = System.nanoTime();
        final StockInfo highPricedC =
            symbols.stream()
            .map( nextSymbol -> this.getPrice( nextSymbol ) )
            .filter( this.isPricedLessThan( 500 ) )
            .reduce( this::pickHigh )
            .get();
        end = System.nanoTime();
        System.out.println( "Highest priced stock under $500 from functional: " + highPricedC );
        System.out.println( "Time taken: " + (end - start)/1.0e9 );

        System.out.println( "Let's do it again with parallel streams" );
        start = System.nanoTime();
        final StockInfo highPricedP =
            symbols.parallelStream()
            .map( nextSymbol -> this.getPrice( nextSymbol ) )
            .filter( this.isPricedLessThan( 500 ) )
            .reduce( this::pickHigh )
            .get();
        end = System.nanoTime();
        System.out.println( "Highest priced stock under $500 with parallel streams: " + highPricedP );
        System.out.println( "Time taken: " + (end - start)/1.0e9 );
    } // useMapReduce    
    

    public static void main( String [] args ) {
        ChapterEightRunner cEightR = new ChapterEightRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "useFunctionComposition" :
                cEightR.useFunctionComposition();
                break;
            case "useMapReduce" :
                cEightR.useMapReduce();
                break;
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
