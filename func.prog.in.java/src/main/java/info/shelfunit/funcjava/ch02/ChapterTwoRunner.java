package info.shelfunit.funcjava.ch02;

// import java.math.BigDecimal;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
    
public class ChapterTwoRunner {
    private static final String className = "ChapterTwoRunner.";
    private String methodName;
    final List< String > friends =
        Arrays.asList(
            "Brian", "Nate", "Neil", "Raju", "Sara", "Scott"
    );
    
    public void iterateThroughAList() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        
        System.out.println( "\nAbout to do old-fashioned iteration through list: " );
        for ( int i = 0; i < friends.size(); i ++ ) {
            System.out.print( friends.get( i ) + ", " );
        }
        System.out.print( "\nIn Russia, use enhanced for loop: " );
        for ( String name : friends ) {
            System.out.print( name + ", " );
        }
        System.out.print( "\nUsing Consumer with anonymous inner class syntax, with the expected 'accept' method: " );
        friends.forEach( new Consumer< String >() {
            public void accept( final String name ) {
                System.out.print( name + ", " );
            }
        });
        System.out.print( "\nusing a lambda expression: " );
        friends.forEach( ( final String name ) -> System.out.print( name + ", " ) );
        System.out.println( "\nSo forEach can accept an anonymous class, or a lambda expression" );
        System.out.print( "You can also leave out the type information, but you can't make the field final: " );
        friends.forEach( ( name ) -> System.out.print( name + ", " ) );
        System.out.println( "\nNow with method reference (using System.out.println for this instead of System.out.print)" );
        friends.forEach( System.out::println );
        
    } // iterateThroughAList()

    public void transformAList() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "manipulate a collection to produce another as a result" );
        System.out.println( "Original collection: " + friends );
        final List< String > uppercaseNamesForEachLoop = new ArrayList< String >();
        for( String name : friends ) {
            uppercaseNamesForEachLoop.add( name.toUpperCase() );
        }
        System.out.println( "New list with Java 5 for-each loop: " + uppercaseNamesForEachLoop );
        final List< String > uppercaseNamesJDK8ForEach = new ArrayList< String >();
        friends.forEach( name -> uppercaseNamesJDK8ForEach.add( name.toUpperCase() ) );
        System.out.println( "New list using forEach method from Iterable in JDK8 : " + uppercaseNamesJDK8ForEach );
        System.out.println( "Now, we show you with Stream's map method going to Stream's forEach: " );
        friends.stream()
            .map( theName -> theName.toUpperCase() )
            .forEach( moreName -> System.out.print( moreName + " " ) );
        System.out.println();
        System.out.println( "We can change the type while working with Stream elements, like when counting length of strings" );
        friends.stream()
            .map( firstPass -> firstPass.length() )
            .forEach( count -> System.out.print( count + " " ) );
        System.out.println();
        System.out.println( "Again, with a method reference in the map call of String::toUpperCase" );
        friends.stream()
            .map( String::toUpperCase )
            .forEach( name -> System.out.print( name + " " ) );
        System.out.println();
        
    } // transformAList()
    
    public static void main( String [] args ) {
        ChapterTwoRunner cTwoR = new ChapterTwoRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "iterateThroughAList" :
                cTwoR.iterateThroughAList();
                break;
            case "transformAList":
                cTwoR.transformAList();
                break;
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
