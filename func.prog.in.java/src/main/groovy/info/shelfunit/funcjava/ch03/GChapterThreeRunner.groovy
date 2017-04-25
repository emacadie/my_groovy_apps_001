package info.shelfunit.funcjava.ch03

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.concurrent.TimeUnit;

import java.util.function.BinaryOperator;

import java.util.function.Function;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GChapterThreeRunner {
    final className = "ChapterThreeRunner."
    def methodName
    final String str = "w00t";

    final people = [ new Person( "John", 20 ), new Person( "Sara", 21 ),
                     new Person( "Jane", 21 ), new Person( "Greg", 35 ) ]

                     /*
    public static void printPeople( final String message, final List people ) {
        System.out.println( message );
        people.forEach( println );
    }
                     */
    // Comparator< Person > compareAgeAscending  = ( person1, person2 ) -> person1.ageDifference( person2 );
                     // Comparator< Person > compareAgeDescending = compareAgeAscending.reversed();
    // final Function< Person, String > byTheirName = person -> person.getName();
    // final Function< Person, Integer > byAge = person -> person.getAge(); 
    
    public void iterateAString() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        println( "-----\nstarting method ${className}iterateAString" )
        
        println( "\nIterating with chars method: " )
        str.chars().forEach{ ch -> print( ch + " " ) }
        println();
        println( "Iterating with our closure" )
        str.each{ inChar ->
            print( inChar + " " )
        }
        println()
        println( "Filter out digits from string" )
        println( str.findAll{ it.isNumber() }.join(", ") )
    } // iterateAString

    public void implementComparator() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        println( "-----\nstarting method " + methodName );
        /*
        println( "Sorting by age" );
        List< Person > ascendingAge =
            people.stream()
            .sorted( ( person1, person2 ) -> person1.ageDifference( person2 ) )
            .collect( Collectors.toList() );
        println( ascendingAge );
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
        println( "Here is the youngest: " );
        people.stream()
            .min( Person::ageDifference )
            .ifPresent( youngest -> println( "Youngest: " + youngest ) );

        println( "And the oldest: " );
        people.stream()
            .max( Person::ageDifference )
            .ifPresent( oldest -> println( "Oldest: " + oldest ) );
        println( "Comparing with Function byTheirName: " );
        println(
            people.stream()
            .sorted( Comparator.comparing( byTheirName ) )
            .collect( Collectors.toList() ) );
        printPeople( "Sorted in ascending order by age and name with our functions together: ",
            people.stream()
                     .sorted( Comparator.comparing( byAge ).thenComparing( byTheirName ) )
                     .collect( Collectors.toList() ) );
        */
    } // implementComparator

    public void useCollectMethod() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        println( "-----\nstarting method " + methodName );
        println( "Remember, in Java, java.util.stream.Stream.collect is a method analogous to 'reduce' in functional languages" );
        println( "In Groovy, 'reduce' is more like functional 'map'" );
        /*
        List< Person > olderThan20 = new ArrayList< Person >();
        people.stream()
            .filter( person -> person.getAge() > 20 )
            .forEach( person -> olderThan20.add( person ) );
        println( "People older than 20 using stream, filter and forEach: " + olderThan20 );
        List< Person > olderThan20B =
            people.stream()
            .filter( person -> person.getAge() > 20 )
            .collect( ArrayList::new, ArrayList::add, ArrayList::addAll );
        println( "People older than 20 using stream, filter and collect: " + olderThan20B );
        println( "You must use ArrayList for those method references. So much for interfaces, I suppose" );
        List< Person > olderThan20C =
            people.stream()
            .filter( person -> person.getAge() > 20 )
            .collect( Collectors.toList() );
        println( "People older than 20 using less verbose stream, filter and collect w/Collectors.toList(): " + olderThan20C );
        Map< Integer, List< Person > > peopleByAge =
            people.stream()
            .collect( Collectors.groupingBy( Person::getAge ) );
        println( "Grouped by age w/Collectors.groupingBy: " + peopleByAge );
        Map< Integer, List< String > > nameOfPeopleByAge =
            people.stream()
            .collect( Collectors.groupingBy( Person::getAge, Collectors.mapping( Person::getName, Collectors.toList() ) ) );
        println( "People grouped by age: " + nameOfPeopleByAge );
        println( "Yo dawg, I heard you like functional programming, so I added lambdas to your lambda so you can collect while you collect" );
        Comparator< Person > byAge = Comparator.comparing( Person::getAge );
        Map< Character, Optional< Person > > olderPersonOfEachLetter =
            people.stream()
            .collect( Collectors.groupingBy( person -> person.getName().charAt( 0 ),
                                             Collectors.reducing( BinaryOperator.maxBy( byAge ) ) ) );
        println( "Oldest person of each letter: " + olderPersonOfEachLetter );
        println( "I had to define the Comparator in the method" );
        */
    } // useCollectMethod

    public void workWithFiles() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        println( "-----\nstarting method " + methodName );
        println( "Let's list the files in the current directory as a stream" );
        /*
        try {
            Files.list( Paths.get( "." ) )
            .forEach( f -> System.out.print( f + " " ) );
            println();
            println( "Let's list immediate subdirectories with streams" );
            Files.list( Paths.get( "." ) )
                .filter( Files::isDirectory )
                .forEach( dir -> System.out.print( dir + " " ) );
            println();
            println( "Listing files with FilenameFilter" );
            final String[] files = new File( "." ).list( new java.io.FilenameFilter() {
                    public boolean accept( final File dir, final String name ) {
                        return name.endsWith( ".gradle" );
                    }
                });
            println( files );
            println( "Send that primitive array to Arrays.asList and use forEach" );
            Arrays.asList( files ).forEach( f -> System.out.print( f + ", " ) );
            println();
            println( "A better way with streams" );
            Files.newDirectoryStream( Paths.get( "." ), path -> path.toString().endsWith( ".gradle" ) )
                .forEach( f -> System.out.print( f + " " ) );
            println();
            println( "Hidden files: " );
            final File[] hiddenFiles = new File( "." ).listFiles( file -> file.isHidden() );
            Arrays.asList( hiddenFiles ).forEach( f -> System.out.print( f + ", " ) );
            println();
            println( "Listing directories the hard way" );
            List< File > qFiles = new ArrayList< File >();
            File[] filesInCurrentDir = new File( "." ).listFiles();
            for ( File nextFile : filesInCurrentDir ) {
                File[] filesInSubDir = nextFile.listFiles();
                if ( filesInSubDir != null ) {
                    qFiles.addAll( Arrays.asList( filesInSubDir ) );
                } else {
                    qFiles.add( nextFile );
                }
            }
            println( "count: " + qFiles.size() );
            println( "Now, using flatMap" );
            List< File > wFiles =
                Stream.of( new File( "." ).listFiles() )
                .flatMap( file -> file.listFiles() == null ? Stream.of( file ) : Stream.of( file.listFiles() ) )
                .collect( Collectors.toList() );
            println( "Count: " + wFiles.size() );
            println( "Here they are as a list with forEach: " );
            Arrays.asList( wFiles ).forEach( f -> System.out.print( f + ", " ) );
            println();

            println( "Let's watch, baby" );
            final Path thePath = Paths.get( "." );
            final WatchService watchService =
                thePath.getFileSystem().newWatchService();
            thePath.register( watchService, StandardWatchEventKinds.ENTRY_MODIFY );
            final WatchKey watchKey = watchService.poll( 1, TimeUnit.MINUTES );
            if ( watchKey != null ) {
                watchKey.pollEvents()
                    .stream()
                    .forEach( event -> println( event.context() ) );
            }
            
        } catch ( IOException ioEx ) {
            println( "IOException: " + ioEx.getMessage() );
            ioEx.printStackTrace();
        } catch ( InterruptedException intEx ) {
            println( "InterruptedException : " + intEx.getMessage() );
            intEx.printStackTrace();
        }
        */
    } // workWithFiles

    static void main( String... args ) {
        GChapterThreeRunner cThreeR = new GChapterThreeRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "iterateAString" :
                cThreeR.iterateAString();
                break;
            case "implementComparator":
                cThreeR.implementComparator();
                break;
            case "useCollectMethod":
                cThreeR.useCollectMethod();
                break;
            case "workWithFiles":
                cThreeR.workWithFiles();
                break;
            default:
                println( "No method named " + methodToRun );
        }
        
    } // main       
} // line 261


        
