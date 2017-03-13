package info.shelfunit.funcjava.ch05;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    private final FileWriter writer;

    public FileWriterExample( final String fileName ) throws IOException {
        writer = new FileWriter( fileName );
    }

    public void writeStuff( final String message ) throws IOException {
        writer.write( message );
    }

    public void finalize() throws IOException {
        writer.close();
    }

    // this was called "finalize", but since we never needed to run GC, empty files were created
    public void close() throws IOException {
        System.out.println( "Calling FileWriterExample::close" );
        writer.close();
    }
}
