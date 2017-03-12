package info.shelfunit.funcjava.ch04;

import java.util.function.Consumer;

public class FluentMailer {
    private FluentMailer() {}
    
    public FluentMailer from( final String address ) {
        System.out.println( "Calling FluentMailer.from with address: " + address );
        return this;
    }
    public FluentMailer to( final String address ) {
        System.out.println( "Calling FluentMailer.to with address: " + address );
        return this;
    }
    public FluentMailer subject( final String line ) {
        System.out.println( "Calling FluentMailer.subject with line: " + line );
        return this;
    }   
    public FluentMailer body( final String message ) {
        System.out.println( "Calling FluentMailer.body with message: " + message );
        return this;
    }
    
    public static void send( final Consumer< FluentMailer > block ) {
        final FluentMailer mailer = new FluentMailer();
        block.accept( mailer );
        System.out.println( "Sending...." );
    }
    
}
