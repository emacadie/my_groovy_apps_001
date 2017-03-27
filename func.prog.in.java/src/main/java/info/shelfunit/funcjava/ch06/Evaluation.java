package info.shelfunit.funcjava.ch06;

import java.util.function.Supplier;

public class Evaluation {
    public static boolean evaluate( final int value ) {
        System.out.println( "evaluating " + value );
        simulateTimeConsumingOp( 2000 );
        return value > 100;
    }

    public static void simulateTimeConsumingOp( final int milliseconds ) {
        try {
            Thread.sleep( 2000 + milliseconds );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    public static void eagerEvaluator( final boolean input1, final boolean input2 ) {
        System.out.println( "eager evaluator called..." );
        System.out.println( "accept?: " + ( input1 && input2 ) );
    }

    public static void lazyEvaluator( final Supplier< Boolean > input1, final Supplier< Boolean > input2 ) {
        System.out.println( "lazy evaluator called..." );
        System.out.println( "accept?: " + ( input1.get() && input2.get() ) );
    }
    
} // end class
