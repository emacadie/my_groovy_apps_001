package info.shelfunit.funcjava.ch05;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterARM implements AutoCloseable{
    private final FileWriter writer;

    public FileWriterARM( final String fileName ) throws IOException {
        writer = new FileWriter( fileName );
    }

    public void writeStuff( final String message ) throws IOException {
        writer.write( message );
    }

    // this was called "finalize", but since we never needed to run GC, empty files were created
    public void close() throws IOException {
        System.out.println( "Calling FileWriterARM::close" );
        writer.close();
    }
}
