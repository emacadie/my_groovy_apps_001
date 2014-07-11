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
    def static void main( final String[] args ) {
        String propFileName = args[ 0 ]
        println "Here is propFileName: ${propFileName}"
        try {
            Properties props = new Properties()
            props.load( new FileInputStream( propFileName ) )
            FileTimestampRunner fsRunner = new FileTimestampRunner()
            fsRunner.getListing( props )
        } catch ( Exception e ) {
            e.printStackTrace()
        }
    } // end method main

} // end class info.shelfunit.files.podcast.FileStatClass - line 27

