package info.shelfunit.funcjava.ch04;

public interface FastFly extends Fly {
    default void takeOff() {
        System.out.println( "FastFly::takeOff" );
    }
}
