package info.shelfunit.ratpack

class RatpackUtil {
    
    static rnd(long maxMilliseconds) {
            def rnd = new Random().nextInt()
            Math.abs(rnd % maxMilliseconds + 1000)
        }
}

