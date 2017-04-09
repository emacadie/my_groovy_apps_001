package info.shelfunit.funcjava.ch07;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall< T > {
    TailCall< T > apply();

    default boolean isComplete() {
        return false;
    }

    default T result() {
        throw new Error( "Not yet implemented" );
    }

    default T invoke() {
        return Stream.iterate( this, TailCall::apply)
            .filter( TailCall::isComplete )
            .findFirst()
            .get()
            .result();
    }
    
}
