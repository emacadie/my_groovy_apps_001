/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package info.shelfunit.files.podcast;

import java.io.File;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ericm
 */
public class FileTimestampRunner {
    String sourceDirectory = "C:\\EKM\\aTunes\\1967438726\\";
            // Bloomberg - All Podcasts\\";
    // c/Documents and Settings/ericm/My Documents/My Music/iTunes/iTunes Music/Podcasts/Bloomberg - All Podcasts
    String destDirectory = "c:\\mp3\\TheTakeAway\\";

    public void getListing() {
        File theDir = new File( sourceDirectory );
        File[] theList = theDir.listFiles();

        GregorianCalendar theCal = new GregorianCalendar();
        long longTime = 0;
        String theTime = " ";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_hh.mm.ss" ); // .SSS");
        String separator = System.getProperty( "file.separator" );

        for ( int i = 0; i < theList.length; i++ ) {
            File theFile = theList[ i ];
            longTime = theFile.lastModified();
            theCal.setTimeInMillis( longTime );

            // System.out.println( "File: " + theFile.getName() + " Time: " + theFile.lastModified() );
            // System.out.println( longTime + " = " + formatter.format( theCal.getTime() ) );
            // System.out.println( "Path: " + theFile.getAbsolutePath() );
            // System.out.println( "Parent: " + theFile.getParent() );
            System.out.println( "move \"" + theFile.getParent() +
                separator + theFile.getName() + "\" " +
                // theFile.getParent() +
                "\"" + destDirectory  +
                separator + formatter.format( theCal.getTime() ) + "." +
                theFile.getName() + "\""
            );
        } // for ( int i = 0; i < theList.length; i++ )

    } // end method getListing

} // end class info.shelfunit.files.podcast.FileTimestampRunner {


