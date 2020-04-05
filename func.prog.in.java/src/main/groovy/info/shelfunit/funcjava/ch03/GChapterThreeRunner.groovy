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

class GChapterThreeRunner {
    final className = "GChapterThreeRunner."
    def methodName
    final String str = "w00t";

    final people = [ new Person( "John", 20 ), new Person( "Sara", 21 ),
                     new Person( "Jane", 21 ), new Person( "Greg", 35 ) ]
    
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
        println( str.findAll{ it.isNumber() }.join( ", " ) )
        
    } // iterateAString

    public void implementComparator() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        println( "-----\nstarting method ${className}${methodName}" );
        
        println( "Sorting by age" );
        def ascendingAge = people.groupBy{ it.age }
        println "here it is: " + ascendingAge
        println "Using the OrderBy class"
        // OrderBy( [ { it.age } ] )
        def orderByAge = new OrderBy( { it.age } ) 
        def orderedByAge = people.sort( orderByAge )
        println "here it is: ${people.sort( orderByAge )}"
        println "No idea why that won't work"
        println "Regular sort with closure: " + people.sort{ it.age }
        println "Sorting with both: " + people.sort{ [ it.age, it.name ] } + "; no idea why this won't work either"
        def spaceshipSort = people.sort{ x, y -> x.age <=> y.age ?: x.name <=> y.name }
        println "Here is sort with spaceship operator: ${spaceshipSort}"
        def spaceshipSortD = people.sort{ x, y -> y.age <=> x.age ?: x.name <=> y.name }
        println "Spaceship sort for age descending: " + spaceshipSortD
        def nameAscending = people.sort{ x, y -> x.name <=> y.name ?: x.age <=> y.age }
        println "Sort by name ascending: " + nameAscending

        println "Get the youngest: " + people.min{ it.age }
        println "Get the oldest: " + people.max{ it.age }
        println "Sort by name: " + people.sort{ it.name }

    } // implementComparator

    public void useInjectMethod() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        println( "-----\nstarting method " + methodName );
        println( "Remember, in Java, java.util.stream.Stream.collect is a method analogous to 'reduce' in functional languages" );
        println( "In Groovy, 'collect' is more like functional 'map'" );

        def olderThan20 = people.findAll{ x -> x.age > 20 }
        println "People older than 20 found with findAll: " + olderThan20

        println "To group by age, we will make a map"
        def groupByAge = [:]
        java.util.Map.metaClass.addToListInMap = { Object key, Object value ->
            if ( !delegate.containsKey( key ) ) { delegate[ key ] = [] }
            delegate[ key ] << value
        }
        people.each { it ->
            groupByAge.addToListInMap( it.age, it.name )
        }
        println "Here is groupByAge: " + groupByAge
        def oldestByLetter = [:]
        people.each { pers ->
            if ( ( !oldestByLetter.containsKey( pers.name[ 0 ] ) ) ||
                 ( oldestByLetter[ pers.name[ 0 ] ].age < pers.age ) ) {
                oldestByLetter[ pers.name[ 0 ] ] = pers
            } // is this really idiomatic groovy?
            /* slightly longer way:
            if ( !oldestByLetter.containsKey( pers.name[ 0 ] ) ) {
                oldestByLetter[ pers.name[ 0 ] ] = pers
            } else {
                if ( oldestByLetter[ pers.name[ 0 ] ].age < pers.age ) {
                    oldestByLetter[ pers.name[ 0 ] ] = pers
                }
            }
            */
        }
        println "Here is oldest person for each letter: " + oldestByLetter 

    } // useCollectMethod

    public void workWithFiles() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        println( "-----\nstarting method " + methodName );
        println( "Let's list the files in the current directory as a stream" );
        /* I will get to this later
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
            case "useInjectMethod":
                cThreeR.useInjectMethod();
                break;
            case "workWithFiles":
                cThreeR.workWithFiles();
                break;
            default:
                println( "No method named " + methodToRun );
        }
        
    } // main       
} // line 261


        
