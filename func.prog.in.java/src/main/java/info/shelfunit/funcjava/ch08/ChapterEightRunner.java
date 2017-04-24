package info.shelfunit.funcjava.ch08;

import info.shelfunit.funcjava.ch04.YahooFinance;
import java.awt.Color;

import java.io.File;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        System.out.println( "Highest priced stock under $500 from imperative: " + highPriced );
        System.out.println( "Trying again with a more concise imperative" );
        StockInfo highPricedB = new StockInfo( "", BigDecimal.ZERO );
        // we will re-use final Predicate< StockInfo > isPriceLessThan500 = this.isPricedLessThan( 500 );
        for( String symbol : symbols ) {
            StockInfo stockInfo = this.getPrice( symbol );
            if ( isPriceLessThan500.test( stockInfo ) ) {
                highPricedB = this.pickHigh( highPricedB, stockInfo );
            }
        }
        System.out.println( "Highest priced stock under $500 from concise imperative: " + highPricedB );
        System.out.println( "Let's do it again with functional programming" );
        final StockInfo highPricedC =
            symbols.stream()
            .map( nextSymbol -> this.getPrice( nextSymbol ) )
            .filter( this.isPricedLessThan( 500 ) )
            .reduce( this::pickHigh )
            .get();
        System.out.println( "Highest priced stock under $500 from functional: " + highPricedC );
    } // useMapReduce

    public static int length( final String name ) {
        System.out.println( "getting length for " + name );
        return name.length();
    }

    public static String toUpper( final String name ) {
        System.out.println( "Converting following name to uppercase: " + name );
        return name.toUpperCase();
    }
    
    public void leverageTheLaziness() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        List< String > names = Arrays.asList(
            "Brad", "Kate", "Kim", "Jack", "Joe", "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson"
        );
        final String firstNameWith3Letters =
            names.stream()
            .filter( name -> ChapterEightRunner.length( name ) == 3 )
            .map( name -> ChapterEightRunner.toUpper( name ) )
            .findFirst()
            .get();
        System.out.println( "Printing out firstNameWith3Letters:\n" + firstNameWith3Letters );
        System.out.println( "Let's break it down again" );
        Stream< String > namesWith3Letters =
            names.stream()
            .filter( name -> ChapterEightRunner.length( name ) == 3 )
            .map( name -> ChapterEightRunner.toUpper( name ) );
        System.out.println( "Stream created, filtered, mapped" );
        System.out.println( "Ready to call findFirst" );
        final String firstWith3Letters = namesWith3Letters.findFirst().get();
        System.out.println( "Here we are: " + firstWith3Letters );
    } // leverageTheLaziness

    public static boolean isPrime( final int number ) {
        return number > 1 &&
            IntStream.rangeClosed( 2, ( int ) Math.sqrt( number ) )
            .noneMatch( divisor -> number % divisor == 0 );
    }

    // he has this in a separate class
    private static int primeAfter( final int number ) {
        if ( isPrime( number + 1 ) ) {
            return number + 1;
        } else {
            return primeAfter( number + 1 );
        }
    }

    public static List< Integer > primes( final int fromNumber, final int count ) {
        return Stream.iterate( primeAfter( fromNumber - 1 ), ChapterEightRunner::primeAfter )
            .limit( count )
            .collect( Collectors.< Integer >toList() );
    }

    public void createInfiniteStreams() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "10 primes from 1: " + ChapterEightRunner.primes( 1, 10 ) );
        System.out.println( "5 primes from 100: " + ChapterEightRunner.primes( 100, 5 ) );
    } // createInfiniteStreams

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
            case "leverageTheLaziness":
                cEightR.leverageTheLaziness();
                break;
            case "createInfiniteStreams":
                cEightR.createInfiniteStreams();
                break;
            case "createFluentInterfaces":
                // cEightR.createFluentInterfaces();
                break;
            case "dealWithExceptions":
                // cEightR.dealWithExceptions();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
