package info.shelfunit.logandcli

import groovy.util.CliBuilder
import groovy.util.ConfigSlurper

// import org.apache.log4j.DailyRollingFileAppender
import org.apache.logging.log4j.core.appender.RollingFileAppender
// import org.apache.log4j.EnhancedPatternLayout
import org.apache.logging.log4j.core.layout.PatternLayout
import org.apache.log4j.Level
// import org.apache.log4j.Logger
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager
import org.apache.log4j.PropertyConfigurator

import java.io.File

class CLIRunner {
    
    def static getLogger( options ) {
        Logger log = LogManager.getLogger( getClass() )
        
        if ( options.log4jConfigFile ) {
            def config = new ConfigSlurper().parse( new File( options.log4jConfigFile ).toURL() )
            PropertyConfigurator.configure( config.toProperties() )
        } else {
            // provide a default logger
            log.level = Level.INFO
            log.addAppender( new RollingFileAppender( new PatternLayout( PatternLayout.TTCC_CONVERSION_PATTERN ), "xml.transform.log", "'.'yyyy-MM-dd" ) )
        }
        return log
    } // end method getLogger
    
    def static void main( String[] args ) {
        def cli = new CliBuilder( usage: 'CLIRunner' )
        cli.inputFile( args: 1, argName: 'file path', 'The input file, required argument' )
        cli.outputFile( args: 1, argName: 'file path', 'The output file, required argument' )
        cli.log4jConfigFile( args: 1, argName: 'log config file', 'Path to Log4J config file, optional argument' )
        cli.usage()
        def options = cli.parse( args )
        
        if ( !options.inputFile || !options.outputFile ) {
            println( "\n\n\n\nYou are missing a required argument: either inputFile or outputFile" )
            println( "Here is what you sent:" )
            println( "inputFile: ${options.inputFile}" )
            println( "outputFile: ${options.outputFile}" )
        } else {
            def log = getLogger( options )
            println( "Do your regular stuff here" )
	    log.info( "We got some logging" )
        }
        
    } // end method main
    
} // end class CLIRunner


