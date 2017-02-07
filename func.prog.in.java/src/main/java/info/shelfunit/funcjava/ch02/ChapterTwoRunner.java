package info.shelfunit.funcjava.ch02;

// import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
    
public class ChapterTwoRunner {
    private static final String className = "ChapterTwoRunner.";
    private String methodName;
    
    public void iterateThroughAList() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        final List< String > friends =
            Arrays.asList(
                "Brian", "Nate", "Neil", "Raju", "Sara", "Scott"
        );
        System.out.println( "About to do old-fashioned iteration through list" );
        for ( int i = 0; i < friends.size(); i ++ ) {
            System.out.println( friends.get( i ) );
        }
        System.out.println( "In Russia, use enhanced for loop" );
        for ( String name : friends ) {
            System.out.println( name );
        }
        System.out.println( "\nUsing Consumer with anonymous inner class syntax, with the expected 'accept' method" );
        friends.forEach( new Consumer< String >() {
            public void accept( final String name ) {
                System.out.println( name );
            }
        });
        System.out.println( "using a lambda expression" );
        friends.forEach( ( final String name ) -> System.out.println( name ) );
        System.out.println( "So forEach can accept an anonymous class, or a lambda expression" );
        System.out.println( "You can also leave out the type information, but you can't make the field final" );
        friends.forEach( ( name ) -> System.out.println( name ) );
        System.out.println( "Now with method reference" );
        friends.forEach( System.out::println );
        
    } // iterateThroughAList() 
    
    public static void main( String [] args ) {
        ChapterTwoRunner cTwoR = new ChapterTwoRunner();
        cTwoR.iterateThroughAList();
    }       
}


        
