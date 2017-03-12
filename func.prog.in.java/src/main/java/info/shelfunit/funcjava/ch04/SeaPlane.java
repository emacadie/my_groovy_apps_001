package info.shelfunit.funcjava.ch04;

public class SeaPlane extends Vehicle implements FastFly, Sail {
    private int altitude;

    public void cruise() {
        System.out.print( "SeaPlane::cruise currently cruise like: " );
        if ( altitude > 0 ) {
            FastFly.super.cruise();
        } else {
            Sail.super.cruise();
        }
    }
}
