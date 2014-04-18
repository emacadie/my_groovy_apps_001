I got ActiveJDBC to work with Groovy.   

gradle runGroovy -PmainClass="activejdbc.examples.simple.SimpleExample"    

To run the Groovy class that calls Java:   
gradle  runGroovy -PmainClass="info.shelfunit.SecondExample"   

bash run.example.sh to use the Groovy shell   
bash run.slimmer.sh to use the reduced classpath

To clean:   
gradle clean   
To build:   
gradle build   

The file active_shell can be used to run from the command line with groovysh. Run:  
gradle distZip   
Then unzip the archve, and put active_shell in the bin directory.   
To make one yourself, edit the bash file produced by distZip. Remove the groovy-all jar file from the classpath. Having it in there will cause issues, since groovysh will also have Groovy. There might be a way to get groovysh just there for the archiving.  

http://javalite.io/activejdbc   

Griffon with activeJDBC at https://github.com/griffon/griffon-activejdbc-plugin/blob/master/scripts/ActivejdbcInstrument.groovy    

addUrlIfNotPresent is at https://github.com/codehaus/griffon-git/blob/master/src/main/scripts/_GriffonClasspath.groovy  
----------------------------------
Dynamic properties:
Creating properties on demand (a.k.a. dynamic properties) has been deprecated and is scheduled to be removed in Gradle 2.0. Please read http://gradle.org/docs/current/dsl/org.gradle.api.plugins.ExtraPropertiesExtension.html for information on the replacement for dynamic properties.
Deprecated dynamic property: "projectMainClassesDir" on "task ':compileGroovy'", value: "/home/ericm/github/my_...".
Deprecated dynamic property: "rootLoader" on "task ':compileGroovy'", value: "null".
**************************** START INSTRUMENTATION ****************************
Directory: /home/ericm/github/my_groovy_apps_001/agug/active_grails_share/build/classes/main
Found model: info.shelfunit.active.share.SingleState
Instrumented class: info.shelfunit.active.share.SingleState in directory: /home/ericm/github/my_groovy_apps_001/agug/active_grails_share/build/classes/main/
**************************** END INSTRUMENTATION ****************************
Deprecated dynamic property: "activejdbcInstrumentSpyFile" on "task ':compileGroovy'", value: ".activejdbc_instrument".


