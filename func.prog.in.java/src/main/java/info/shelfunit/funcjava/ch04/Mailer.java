package info.shelfunit.funcjava.ch04;

public class Mailer {
    public void from( final String address ) {}
    public void to( final String address ) {}
    public void subject( final String line ) {}
    public void body( final String message ) {}
    public void send() { System.out.println( "Sending...." ); }
}
