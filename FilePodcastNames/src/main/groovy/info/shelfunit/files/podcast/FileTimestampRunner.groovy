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
        File[] theList = theDir.listFiles();

        GregorianCalendar theCal = new GregorianCalendar();
        long longTime = 0;
        String theTime = " ";
        DateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd_HH.mm.ss" ); // .SSS");
        String separator = System.getProperty( "file.separator" );

        for ( int i = 0; i < theList.length; i++ ) {
            File theFile = theList[ i ];
            longTime = theFile.lastModified();
            theCal.setTimeInMillis( longTime );

            System.out.println( "move \"" + theFile.getParent() +
                separator + theFile.getName() + "\" " +
                "\"" + theProp.getProperty( "destDirectory" ) +
                separator + formatter.format( theCal.getTime() ) + "." +
                theFile.getName() + "\""
            );
        } // for ( int i = 0; i < theList.length; i++ )

    } // end method getListing

} // end class info.shelfunit.files.podcast.FileTimestampRunner line 42


