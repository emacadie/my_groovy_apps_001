package info.shelfunit.funcjava.ch07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Memoizer {

    final List< Integer > prices;

    public Memoizer( final List< Integer > pricesForLength ) {
        prices = pricesForLength;
    }
    
    public int maxProfit( final int rodLength ) {
        BiFunction< Function< Integer, Integer >, Integer, Integer  > compute =
            ( func, length ) -> {
            int profit = ( length <= prices.size() ) ? prices.get( length - 1 ) : 0;
            for ( int i = 1; i < length; i++ ) {
                int priceWhenCut = func.apply( i ) + func.apply( length - i );
                if ( profit < priceWhenCut ) {
                    profit = priceWhenCut;
                }
            }
            return profit;
        };
        return callMemoized( compute, rodLength );
    } // end maxProfit

    public static < T, R > R callMemoized( final BiFunction< Function< T, R >, T, R > function, final T input ) {
        Function< T, R > memoized = new Function< T, R >() {
            private final Map< T, R > store = new HashMap<>();
            public R apply( final T input ) {
                return store.computeIfAbsent( input, key -> function.apply( this, key ) );
            }
        };
        return memoized.apply( input );
    } // end callMemoized
}
