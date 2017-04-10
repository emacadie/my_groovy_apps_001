package info.shelfunit.funcjava.ch07;

import java.math.BigInteger;
    
public class BigFactorial {
    public static BigInteger decrement( final BigInteger number ) {
        return number.subtract( BigInteger.ONE );
    }

    public static BigInteger multiply( final BigInteger first, final BigInteger second ) {
        return first.multiply( second );
    }

    private static TailCall< BigInteger > factorialTailRec( final BigInteger factorial, final BigInteger number ) {
        if ( number.equals( BigInteger.ONE ) ) {
            return TailCalls.done( factorial );
        } else {
            return TailCalls.call( () -> factorialTailRec( multiply( factorial, number ), decrement( number ) ) );
        }
    }

    public static BigInteger factorial( final BigInteger number ) {
        return factorialTailRec( BigInteger.ONE, number ).invoke();
    }
}
