package info.shelfunit.funcjava.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;

public class ChapterTwoRunner {
    private static final String className = "ChapterTwoRunner.";
    private String methodName;
    final List< String > friends =
        Arrays.asList(
            "Brian", "Nate", "Neil", "Raju", "Sara", "Scott"
    );
    final List< String > editors =
        Arrays.asList(
            "Brian", "Jackie", "John", "Mike"
    );
    final List< String > comrades =
        Arrays.asList(
            "Kate", "Ken", "Nick", "Paula", "Zack"
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
        System.out.println( "-----\nstarting method " + methodName );
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

    public void findElements() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "original list: " + friends );
        final List< String > startsWithN = new ArrayList< String >();
        for ( String name : friends ) {
            if ( name.startsWith( "N" ) ) {
                startsWithN.add( name );
            }
        }
        System.out.println( "New list with Java 5 for-each loop: " + startsWithN );

        final List< String > startsWithNFilter =
        friends.stream()
            .filter( name -> name.startsWith( "N" ) )
            .collect( Collectors.toList() );
        System.out.println( "New list using filter and collect: " + startsWithNFilter );
            
    } // findElements

    public static Predicate < String > startsWithLetter( final String letter ) {
        return name -> name.startsWith( letter );
    }

    public final Function < String, Predicate< String > > funcStartsWithLetter =
        ( String letter ) -> ( String name ) -> name.startsWith( letter );

    public void reuseLambda() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        
        System.out.println( "Here is friends: " + friends );
        System.out.println( "Here is editors: " + editors );
        System.out.println( "Here is comrades: " + comrades );
        final Predicate< String > startsWithN = name -> name.startsWith( "N" );
        System.out.println( "Defining a predicate like this: final Predicate< String > startsWithN = name -> name.startsWith( \"N\" );"  );
        System.out.println( "Here is the Predicate.toString(): " + startsWithN.toString() );
        System.out.print( "friends who start with N: " );
        friends.stream().filter( startsWithN ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
        System.out.print( "editors who start with N: " );
        editors.stream().filter( startsWithN ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
        System.out.print( "comrades who start with N: " );
        comrades.stream().filter( startsWithN ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
        
        System.out.println( "About to try an even better way with closures" );
        System.out.print( "friends who start with N: " );
        friends.stream().filter( startsWithLetter( "N" ) ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
        System.out.print( "editors who start with B: " );
        editors.stream().filter( startsWithLetter( "B" ) ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
        System.out.print( "comrades who start with K: " );
        comrades.stream().filter( startsWithLetter( "K" ) ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
        System.out.println( "Now with a java.util.function.Function" );
        System.out.println( "It's called funcStartsWithLetter, and you call it like this: funcStartsWithLetter.apply( \"N\" )" );
        System.out.print( "friends who start with N: " );
        friends.stream().filter( funcStartsWithLetter.apply( "N" ) ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
        System.out.print( "editors who start with B: " );
        editors.stream().filter( funcStartsWithLetter.apply( "B" ) ).forEach( n -> System.out.print( n + " " ) );
        System.out.println();
                            
    } // reuseLambda

    public void pickName( final String startingLetter ) {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        final Optional< String > foundName =
            friends.stream()
            .filter( startsWithLetter( startingLetter ) )
            .findFirst();
        System.out.println( String.format( "A name starting with %s: %s",
            startingLetter, foundName.orElse( "No name found" )) );
        foundName.ifPresent( name -> System.out.println( "Hello, " + name ) );
    } // pickName

    public void reduceAndJoin() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "Total number of characters in all names of friends: " +
           friends.stream()
           .mapToInt( name -> name.length() )
           .sum() );
        System.out.println( "Let's try reduce" );
        final Optional< String > aLongName =
            friends.stream()
            .reduce( ( name1, name2 ) -> name1.length() >= name2.length() ? name1 : name2 );
        aLongName.ifPresent( name ->
            System.out.println( String.format( "The longest name: %s", name ) ) );
        System.out.println( "Calling reduce with a default value of Joe. Twenty years, and all I could think of is 'Joe'" );
        final String joeOrMore =
            friends.stream()
            .reduce( "Joe", ( name1, name2 ) -> name1.length() >= name2.length() ? name1 : name2 );
        System.out.println( "longest name: " + joeOrMore );
        System.out.println( "Joining friends into a string w/join: " + String.join( ", ", friends ) );
        System.out.println( "Let's uses 'collect' to join the strings" );
        System.out.println(
            friends.stream()
            .map( String::toUpperCase )
            .collect( Collectors.joining( ", " )));
        System.out.println( "so in Java, 'collect' is like functional 'reduce', while in Groovy, 'collect' is like functional 'map'" );
    } // reduceAndJoin
    
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
            case "findElements":
                cTwoR.findElements();
                break;
            case "reuseLambda":
                cTwoR.reuseLambda();
                break;
            case "pickName":
                cTwoR.pickName( args[ 1 ] );
                break;
            case "reduceAndJoin":
                cTwoR.reduceAndJoin();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
