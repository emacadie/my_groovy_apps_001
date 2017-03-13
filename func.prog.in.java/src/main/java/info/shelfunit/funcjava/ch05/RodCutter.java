package info.shelfunit.funcjava.ch05;

import java.util.List;

public class RodCutter {

    private boolean mustFail;

    public RodCutter( final boolean fail ) {
        mustFail = fail;
    }
    
    
    public void setPrices( final List< Integer > prices ) {
        System.out.println( "In RodCutter::setPrices with arg " + prices.toString() );
        throw new RodCutterException(); // this will cause the non-lambda tests to fail
    }

    public int maxProfit( final int length ) {
        if ( length == 0 ) {
            throw new RodCutterException();
        }
        return 0;
    }
}
