/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.chrome.ChromeDriver

driver = { new ChromeDriver() }

environments {
	
	// run as “grails -Dgeb.env=chrome test-app”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run as “grails -Dgeb.env=firefox test-app”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
	    /*
	    FirefoxBinary firefoxBinary = new FirefoxBinary()
	    // firefoxBinary.setEnvironmentProperty("DISPLAY",":77")
	    firefoxBinary.setTimeout(20000l)
	    FirefoxProfile profile = new FirefoxProfile()
		
		driver = {  
		    new FirefoxDriver(firefoxBinary, profile)
        }
        */
        
        driver = { new FirefoxDriver() }
	}

}
