package info.shelfunit.funcjava.ch06;

import java.util.function.Supplier;

public class Holder {
    // we could also do this: Supplier< Heavy > supplier = Heavy::new;
    // or the old-fashioned:  Supplier< Heavy > supplier = new Heavy();
    // this also provides some thread-safety, better than synchronized, since we only do this once
    private Supplier< Heavy > heavy = () -> createAndCacheHeavy();
    // so a Supplier is some sort of wrapper around what we really want
    // like agents in GPars
    // he calls this the virtual proxy pattern
    public Holder() {
        System.out.println( "new Holder" );
    }

    public Heavy getHeavy() {
        return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier< Heavy > {
            private final Heavy heavyInstance = new Heavy();
            public Heavy get() {
                return heavyInstance;
            }
        }
        if ( !HeavyFactory.class.isInstance( heavy ) ) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }
    // kinda neat, but still feels a bit.....heavy :P *rimshot*
}
