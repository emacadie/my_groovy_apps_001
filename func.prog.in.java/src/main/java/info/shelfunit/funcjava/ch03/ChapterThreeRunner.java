package info.shelfunit.funcjava.ch03;

// import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChapterThreeRunner {
    private static final String className = "ChapterThreeRunner.";
    private String methodName;
    final String str = "w00t";

    final List< Person > people = Arrays.asList(
        new Person( "John", 20 ),
        new Person( "Sara", 21 ),
        new Person( "Jane", 21 ),
        new Person( "Greg", 35 )
    );

    private static void printChar( int inChar ) {
        System.out.print( ( ( char ) ( inChar ) ) + " " );
    }

    public static void printPeople( final String message, final List < Person > people ) {
        System.out.println( message );
        people.forEach( System.out::println );
    }

    Comparator< Person > compareAgeAscending  = ( person1, person2 ) -> person1.ageDifference( person2 );
    Comparator< Person > compareAgeDescending = compareAgeAscending.reversed();
    
    public void iterateAString() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        
        System.out.println( "\nIterating with chars method: " );
        str.chars().forEach( ch -> System.out.print( ch + " " ) );
        System.out.println();
        System.out.println( "Iterating with our static method" );
        str.chars().forEach( ChapterThreeRunner::printChar );
        System.out.println();
        System.out.println( "Iterating with streams to get chars from the start, using mapToObj" );
        str.chars()
            .mapToObj( ch -> Character.valueOf( ( char ) ch ) )
            .forEach( ch2 -> System.out.print( ch2 + " " ) ); // I have not figured out how to send to args to System.out.print w/method reference
        System.out.println();
        System.out.println( "Filter out digits from string" );
        str.chars()
            .filter( c -> Character.isDigit( c ) )
            .forEach( c2 -> printChar( c2 ) );
        System.out.println();
        System.out.println( "Filter out digits from string w/method references" );
        str.chars()
            .filter( Character::isDigit )
            .forEach( ChapterThreeRunner::printChar );
        System.out.println();
        
    } // iterateAString

    public void implementComparator() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );

        System.out.println( "Sorting by age" );
        List< Person > ascendingAge =
            people.stream()
            .sorted( ( person1, person2 ) -> person1.ageDifference( person2 ) )
            .collect( Collectors.toList() );
        System.out.println( ascendingAge );
        printPeople( "Using method reference and our static method:",
            people.stream().sorted( Person::ageDifference ).collect( Collectors.toList() ) );
        printPeople( "Sorted in descending order by age:",
                     people.stream().sorted( ( p1, p2 ) -> p2.ageDifference( p1 ) ).collect( Collectors.toList() ) );
        printPeople( "Using Comparator compareAgeAscending: ",
                     people.stream().sorted( compareAgeAscending ).collect( Collectors.toList() ) );
        printPeople( "Using Comparator compareAgeDescending: ",
                     people.stream().sorted( compareAgeDescending ).collect( Collectors.toList() ) );
        printPeople( "Sort by name ascending: ",
                     people.stream()
                     .sorted( ( p1, p2 ) -> p1.getName().compareTo( p2.getName() ) )
                     .collect( Collectors.toList() ) );
        System.out.println( "Here is the youngest: " );
        people.stream()
            .min( Person::ageDifference )
            .ifPresent( youngest -> System.out.println( "Youngest: " + youngest ) );

        System.out.println( "And the oldest: " );
        people.stream()
            .max( Person::ageDifference )
            .ifPresent( oldest -> System.out.println( "Oldest: " + oldest ) );
    } // implementComparator


    
    public static void main( String [] args ) {
        ChapterThreeRunner cThreeR = new ChapterThreeRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "iterateAString" :
                cThreeR.iterateAString();
                break;
            case "implementComparator":
                cThreeR.implementComparator();
                break;
            case "findElements":
                // cThreeR.findElements();
                break;
            case "reuseLambda":
                // cThreeR.reuseLambda();
                break;
            case "pickName":
                // cThreeR.pickName( args[ 1 ] );
                break;
            case "reduceAndJoin":
                // cThreeR.reduceAndJoin();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
