Griffon with activeJDBC at 
https://github.com/griffon/griffon-activejdbc-plugin/blob/master/scripts/ActivejdbcInstrument.groovy    

addUrlIfNotPresent is at
https://github.com/codehaus/griffon-git/blob/master/src/main/scripts/_GriffonClasspath.groovy  

From a Griffon project at /home/ericm/tmp/groovy/grif001
-------------------------------------------------------------------
here is projectMainClassesDir: /home/ericm/.griffon/1.4.0/projects/grif001/classes/main
here is rootLoader: org.codehaus.griffon.cli.support.GriffonRootLoader@7377711
-------------------------------------------------------------------
https://github.com/griffon/griffon/blob/master/subprojects/griffon-cli/src/main/groovy/org/codehaus/griffon/cli/support/GriffonRootLoader.java

t depends on how you to start groovy script.

If you run (without 'groovy' command):

java -cp lib/groovy-all-1.7.5.jar groovy.ui.GroovyMain YourGroovyScript.groovy

Script is run, but rootLoader is null.

If you want to use rootLoader, run script with this command line:

java -cp lib/groovy-all-1.7.5.jar org.codehaus.groovy.tools.GroovyStarter --classpath lib/groovy-all-1.7.5.jar --main groovy.ui.GroovyMain YourGroovyScript.groovy


