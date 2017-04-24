package info.shelfunit.funcjava.ch05;

import java.io.IOException;

import java.util.Date;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChapterFiveRunner {
    private static final String className = "ChapterFiveRunner.";
    private String methodName;

    public void cleanUpResources() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "Working with FileWriterExample" );
        try {
            FileWriterExample fWE = new FileWriterExample( "firstExample.txt" );
            fWE.writeStuff( new Date().toString() + ": peek-a-boo" );
        } catch ( IOException ioEx ) {
            System.out.println( "IOException: " + ioEx.getMessage() );
            ioEx.printStackTrace();
        }
        System.out.println( "\nNow we added a close method to FileWriterExample. Let's call the newly edited class" );
        try {
            FileWriterExample fWEB = new FileWriterExample( "secondExample.txt" );
            fWEB.writeStuff( new Date().toString() + ": Hello, this is the second example" );
            fWEB.close();
        } catch ( IOException ioEx ) {
            System.out.println( "IOException: " + ioEx.getMessage() );
            ioEx.printStackTrace();
        }
        System.out.println( "\nBut what if there is an exception before we call close? Then we use a finally block!" );
        FileWriterExample fWEC = null;
        try {
            fWEC = new FileWriterExample( "thirdExample.txt" );
            fWEC.writeStuff( new Date().toString() + ": Hello, this is the third example" );
        } catch ( IOException ioEx ) {
            System.out.println( "IOException: " + ioEx.getMessage() );
            ioEx.printStackTrace();
        } finally {
            try {
                System.out.println( "Yo dawg, I know you like control blocks, so I put a try block in your finally block" );
                fWEC.close();
            } catch ( IOException ioEx ) {
                System.out.println( "IOException in our finally block: " + ioEx.getMessage() );
                ioEx.printStackTrace();
            }
        }
        System.out.println( "\nYikes! Let's try ARM: Automatic Resource Management" );
        try ( final FileWriterARM writerARM = new FileWriterARM( "ARM.001.example.txt" ) ) {
                writerARM.writeStuff( new Date().toString() + ": This is the ARM file. First of many? Stay tuned"  );
                System.out.println( "Done with the resource" );
        } catch ( IOException ioEx ) {
            System.out.println( "Another IOException: " + ioEx.getMessage() );
            ioEx.printStackTrace();
        }
    } // cleanUpResources

    public void cleanUpWithLamdba() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "Working with FileWriterEAM, using the 'execute around method' pattern" );
        try {
            FileWriterEAM.use(
                "eam.example.txt",
                writerEAM -> writerEAM.writeStuff( "This is soooo elegant. But can it do more then one function call?" )
            );
            FileWriterEAM.use(
                "eam.multiline.txt",
                wrEAM -> {
                    wrEAM.writeStuff( "This is the first line in my file\n" );
                    wrEAM.writeStuff( "This is the second line\n" );
                    wrEAM.writeStuff( "Did Dr Venkat show us this? I can't remember" ); // a minute later I saw it on the next page
                }
            );
        } catch ( IOException ioEx ) {
            ioEx.printStackTrace();
        }
        System.out.println( "In summary, this also feels like Groovy" );
        System.out.println( "a lot of SQL stuff in Groovy is done by methods that take closures" );
        System.out.println( "The closures handle the boiler plate stuff for you"  );
        
    } // cleanUpWithLamdba

    public void manageLocks() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
        System.out.println( "I bet he will do the same thing I did with ClosureLock.groovy in my java-concurrency repo" );
        final Lock lock = new ReentrantLock();
        System.out.println( "About to try to write to a file with FileWriterEAM with the locking code" );

        Locker.runLocked( lock, () -> {
            try {
                FileWriterEAM.use(
                "eam.locked.txt",
                writerEAM -> writerEAM.writeStuff( "This is some locked code." )
                );
            } catch ( IOException ioEx ) {
                ioEx.printStackTrace();
            }
        }
        );
        System.out.println( "Okay, so that was not too elegant. Perhaps the locking class should throw the exception. But the point is we got it to work" );
        Locker.runLocked( lock, () -> { System.out.println( "This is locked" ); }
        );

    } // manageLocks

    public void createConciseTests() {
        methodName = className + Thread.currentThread().getStackTrace()[ 1 ].getMethodName();
        System.out.println( "-----\nstarting method " + methodName );
    } // createConciseTests
    
    public static void main( String [] args ) {
        ChapterFiveRunner cFiveR = new ChapterFiveRunner();
        String methodToRun = args[ 0 ];
        switch( methodToRun ) {
            case "cleanUpResources" :
                cFiveR.cleanUpResources();
                break;
            case "cleanUpWithLamdba":
                cFiveR.cleanUpWithLamdba();
                break;
            case "manageLocks":
                cFiveR.manageLocks();
                break;
            case "createConciseTests":
                cFiveR.createConciseTests();
                break;
            case "createFluentInterfaces":
                // cFiveR.createFluentInterfaces();
                break;
            case "dealWithExceptions":
                // cFiveR.dealWithExceptions();
                break;  
            default:
                System.out.println( "No method named " + methodToRun );
        }
        
    } // main       
}


        
