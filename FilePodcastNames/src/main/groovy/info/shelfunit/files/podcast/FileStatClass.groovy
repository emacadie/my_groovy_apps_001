package info.shelfunit.files.podcast;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author ericm
 */
public class FileStatClass {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        String propFileName = System.getProperty( "propFile" );
        try {
            Properties props = new Properties();
            props.load( new FileInputStream( propFileName ) );
            FileTimestampRunner fsRunner = new FileTimestampRunner();
            fsRunner.getListing( props );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    } // end method main

} // end class info.shelfunit.files.podcast.FileStatClass
