package info.shelfunit.funcjava.ch07;

import java.awt.Color;

import java.io.File;

import java.math.BigInteger;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;
 import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChapterSevenRunner {
    private static final String className = "ChapterSevenRunner.";
    private String methodName;

    public int factorialRec( final int number ) {
        if ( number == 1 ) {
            return number;
        } else {
            return ( number * ( factorialRec( number - 1 ) ) );
        }
    } // factorialRec

    // first arg is the initial value, sort of like for reduce in clojure
    public TailCall< Integer > factorialTailRec( final int factorial, final int number ) {
        if ( number == 1 ) {
            return TailCalls.done( factorial );
        } else {
            return TailCalls.call( () -> factorialTailRec( ( factorial * number ) , ( number - 1 ) ) );
        }
    } // factorialTailRec

    public int factorial( final int number ) {
        return this.factorialTailRec( 1, number ).invoke();
    }

    public void useTailCallRecursion() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        boolean gotStackOverflow = false;
        int stackOverflowCounter = 0;
        try {
            System.out.println( "About to call factorialRec( 5 ): " + this.factorialRec( 5 ) );
            System.out.println( "Have we gotten a StackOverFlowError: " + gotStackOverflow + ", this many times: " + stackOverflowCounter );
            System.out.println( "Let's try again with 20,000" );
            this.factorialRec( 20000 );
        } catch ( StackOverflowError iEx ) {
            gotStackOverflow = true;
            stackOverflowCounter++;
        }
        System.out.println( "Have we gotten a StackOverFlowError: " + gotStackOverflow + ", this many times: " + stackOverflowCounter );
        System.out.println( "Now to use our TailCall classes: " +  this.factorialTailRec( 1, 2 ).invoke() );
        System.out.println( "Now to use our TailCall classes with 19: " +  this.factorialTailRec( 1, 19 ).invoke() );
        System.out.println( "Now to use our TailCall classes with 5: " +  this.factorialTailRec( 1, 5 ).invoke() );
        System.out.println( "Now a cleaner call to just factorial with arg of 5: " + this.factorial( 5 ) );
        System.out.println( "Now getting factorial of 5 with BigFactorial: " + BigFactorial.factorial( new BigInteger( "5" ) ) );
        System.out.println( "Now getting factorial of 20000 with BigFactorial: " + String.format( "%.10s...", BigFactorial.factorial( new BigInteger( "20000" ) ) ) );

    } // useTailCallRecursion
        
    public void speedUpWithMemos() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        final List< Integer > priceValues = Arrays.asList( 2, 1, 1, 2, 2, 2, 1, 8, 9, 15 );
        final RodCutterBasic rodCutter = new RodCutterBasic( priceValues );
        System.out.println( "Max profit of 5: " + rodCutter.maxProfit( 5 ) );
        System.out.println( "Date before 22: " + new Date().toString() );
        System.out.println( "Max profit of 22: " + rodCutter.maxProfit( 22 ) );
        System.out.println( "Date after 22: " + new Date().toString() );
        final Memoizer memoizer = new Memoizer( priceValues );
        System.out.println( "Using memoizer" );
        System.out.println( "Max profit of 5: " + memoizer.maxProfit( 5 ) );
        System.out.println( "Date before 22: " + new Date().toString() );
        System.out.println( "Max profit of 22: " + memoizer.maxProfit( 22 ) );
        System.out.println( "Date after 22: " + new Date().toString() );
        
    } // speedUpWithMemos

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
            .filter( name -> ChapterSevenRunner.length( name ) == 3 )
            .map( name -> ChapterSevenRunner.toUpper( name ) )
            .findFirst()
            .get();
        System.out.println( "Printing out firstNameWith3Letters:\n" + firstNameWith3Letters );
        System.out.println( "Let's break it down again" );
        Stream< String > namesWith3Letters =
            names.stream()
            .filter( name -> ChapterSevenRunner.length( name ) == 3 )
            .map( name -> ChapterSevenRunner.toUpper( name ) );
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
        return Stream.iterate( primeAfter( fromNumber - 1 ), ChapterSevenRunner::primeAfter )
            .limit( count )
            .collect( Collectors.< Integer >toList() );
    }

    public void createInfiniteStreams() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "10 primes from 1: " + ChapterSevenRunner.primes( 1, 10 ) );
        System.out.println( "5 primes from 100: " + ChapterSevenRunner.primes( 100, 5 ) );
    } // createInfiniteStreams

    public static void main( String [] args ) {
        ChapterSevenRunner cSevenR = new ChapterSevenRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "useTailCallRecursion" :
                cSevenR.useTailCallRecursion();
                break;
            case "speedUpWithMemos":
                cSevenR.speedUpWithMemos();
                break;
            case "leverageTheLaziness":
                cSevenR.leverageTheLaziness();
                break;
            case "createInfiniteStreams":
                cSevenR.createInfiniteStreams();
                break;
            case "createFluentInterfaces":
                // cSevenR.createFluentInterfaces();
                break;
            case "dealWithExceptions":
                // cSevenR.dealWithExceptions();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
