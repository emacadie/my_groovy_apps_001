package info.shelfunit.funcjava.ch06;

import java.awt.Color;

import java.io.File;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Stream;

public class ChapterSixRunner {
    private static final String className = "ChapterSixRunner.";
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

    public static void main( String [] args ) {
        ChapterSixRunner cSixR = new ChapterSixRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "delayInitialization" :
                cSixR.delayInitialization();
                break;
            case "evaluateLazily":
                cSixR.evaluateLazily();
                break;
            case "decorateUsingLambdas":
                // cSixR.decorateUsingLambdas();
                break;
            case "useDefaultMethods":
                // cSixR.useDefaultMethods();
                break;
            case "createFluentInterfaces":
                // cSixR.createFluentInterfaces();
                break;
            case "dealWithExceptions":
                // cSixR.dealWithExceptions();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
