package info.shelfunit.funcjava.ch06;

public class HolderNaive {
    private Heavy heavy;

    public HolderNaive() {
        System.out.println( "HolderNaive created" );
    }

    public Heavy getHeavy() {
        if ( heavy == null ) {
            heavy = new Heavy();
        }
        return heavy;
    }
}
