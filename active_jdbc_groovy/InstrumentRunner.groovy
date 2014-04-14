
import org.codehaus.groovy.tools.RootLoader;
import java.net.URL;
import org.javalite.instrumentation.Instrumentation


def addUrlIfNotPresent( to, what) { 
  if(!to || !what) return
  def urls = to.URLs.toList()
  switch(what.class) { 
  case URL: what = new File(what.toURI()); break
  case String: what = new File(what); break
  case GString: what = new File(what.toString()); break
  case File: break; // ok
  default:
             println "Don't know how to deal with $what as it is not an URL nor a File"
             System.exit(1)
  }

  if(what.directory && !what.exists()) what.mkdirs()
  def url = what.toURI().toURL()
  if(!urls.contains(url) && (what.directory || !urls.find{ it.path.endsWith(what.name)})) { 
    to.addURL(url)
  }
}



// activejdbcInstrumentSpyFile = new File("${ projectWorkDir}/.activejdbc_instrument")

// target(activejdbcInstrument: "Instrument source code with Activejdbc") {
def instrumentThisPal() { 
  // if (activejdbcInstrumentSpyFile.exists()) return
  Instrumentation instrumentation = new Instrumentation()
  projectMainClassesDir = "/home/ericm/github/my_groovy_apps_001/active_jdbc/build/classes/main" // /activejdbc/examples/simple/
  rootLoader = this.class.classLoader.rootLoader
    instrumentation.outputDirectory = projectMainClassesDir
    addUrlIfNotPresent rootLoader, projectMainClassesDir
    addUrlIfNotPresent Instrumentation.class.classLoader, projectMainClassesDir
    instrumentation.instrument()
    activejdbcInstrumentSpyFile = new File(".activejdbc_instrument")
    activejdbcInstrumentSpyFile.text = new Date().toString()
}

// setDefaultTarget(activejdbcInstrument)

def public static void main ( String [] args ) { 
  println("-------------------------------------------------------------------")
  this.class.classLoader.rootLoader.URLs.each { nextClass -> println nextClass }
  instrumentThisPal()
  println("-------------------------------------------------------------------") 
}