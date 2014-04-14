I got ActiveJDBC to work with Groovy. 

Use this with Grails app /home/ericm/github/my_grails_apps/spring-security-002/

mysql --user=collab-dev-admin --password=dev-word-to-pass --database=collab_todo_dev

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


