package info.shelfunit.funcjava.ch07;

import java.awt.Color;

import java.io.File;

import java.math.BigDecimal;

import java.util.Arrays;
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

    public void delayInitialization() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        try {
            final HolderNaive holderN = new HolderNaive();
            System.out.println( "deferring heavy creation in instance of HolderNaive, waiting for a few seconds" );
            Thread.sleep( 2 * 1000 );
            System.out.println( "calling holderN.getHeavy: " + holderN.getHeavy() );
            System.out.println( "calling holderN.getHeavy: " + holderN.getHeavy() );
            System.out.println( "Now, for the real stuff, the heavy hitters and the heavy holders. Hang on to your hats, it might get heady in here" );
            final Holder holder = new Holder();
            System.out.println( "About to wait again" );
            Thread.sleep( 2 * 1000 );
            System.out.println( "calling holder.getHeavy: " + holder.getHeavy() );
            System.out.println( "calling holder.getHeavy: " + holder.getHeavy() );
        } catch ( InterruptedException iEx ) {
            iEx.printStackTrace();
        }

    } // dealWithExceptions
    
    public void evaluateLazily() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "Calling Evaluation.evaluate with arg 20: " + Evaluation.evaluate( 20 ) );
        System.out.println( "Calling Evaluation.evaluate with arg 120: " + Evaluation.evaluate( 120 ) );
        System.out.println( "Trying eagerEvaluator with args 1 and 2" );
        Evaluation.eagerEvaluator( Evaluation.evaluate( 1 ), Evaluation.evaluate( 2 ) );
        System.out.println( "Trying lazy evaluator with args 1 and 2" );
        Evaluation.lazyEvaluator( () -> Evaluation.evaluate( 1 ), () -> Evaluation.evaluate( 2 ) );
    } // evaluateLazily

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
            case "delayInitialization" :
                cSevenR.delayInitialization();
                break;
            case "evaluateLazily":
                cSevenR.evaluateLazily();
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


        
