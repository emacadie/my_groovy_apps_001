package info.shelfunit.funcjava.ch05;

import java.util.concurrent.locks.Lock;

public class Locker {
    public static void runLocked( Lock lock, Runnable block ) {
        lock.lock();
        try {
            System.out.println( "In Locker.runLocked" );
            block.run();
        } finally {
            lock.unlock();
            System.out.println( "In finally block in Locker.runLocked" );
        }
    }
}
