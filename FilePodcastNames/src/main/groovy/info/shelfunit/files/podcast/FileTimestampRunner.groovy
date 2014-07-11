package info.shelfunit.files.podcast;

import java.io.File;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

/**
 *
 * @author ericm
 */
public class FileTimestampRunner {

    public void getListing( Properties theProp ) {
        File theDir = new File( theProp.getProperty( "sourceDirectory" ) );
        File[] fileList = theDir.listFiles();

        GregorianCalendar theCal = new GregorianCalendar();
        DateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd_HH.mm.ss" ); 
        String separator = System.getProperty( "file.separator" );

        fileList.each { nextFile ->
            theCal.setTimeInMillis( nextFile.lastModified() );

            println( "move \"" + nextFile.parent +
                separator + nextFile.name + "\" " +
                "\"" + theProp.getProperty( "destDirectory" ) +
                separator + formatter.format( theCal.getTime() ) + "." +
                nextFile.name + "\""
            );
        } // for ( int i = 0; i < fileList.length; i++ )

    } // end method getListing

} // end class info.shelfunit.files.podcast.FileTimestampRunner line 42


