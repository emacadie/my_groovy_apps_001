package info.shelfunit.funcjava.ch05;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM( final String fileName ) throws IOException {
        writer = new FileWriter( fileName );
    }

    public void writeStuff( final String message ) throws IOException {
        writer.write( message );
    }

    // this was called "finalize", but since we never needed to run GC, empty files were created
    public void close() throws IOException {
        System.out.println( "Calling FileWriterEAM::close" );
        writer.close();
    }

    public static void use( final String fileName, final UseInstance< FileWriterEAM, IOException > block ) throws IOException {
        final FileWriterEAM wEAM = new FileWriterEAM( fileName );
        try {
            block.accept( wEAM );
        } finally {
            wEAM.close();
        }
    }
} // FileWriterEAM
