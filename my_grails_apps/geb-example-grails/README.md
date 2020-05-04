This is a copy of https://github.com/geb/geb-example-grails   

When I tried to run it out of the box, I got a lot of errors. I am making my own copy so I have something that I know works.  

To run this:  

grails -Dgeb.env=chrome test-app   

or....    

grails -Dgeb.env=firefox test-app   

To make sure this works:  
Try a few different versions of Grails. Using Groovy 2.1.9 on JVM 1.7.0, it works with 2.3.4. It will not work on 2.3.3 or 2.4.0. Make sure you update the application.properties file.   

To get it to run with Chrome, you will need the chromedriver executable (at least on Ubuntu). Put it in a directory that is in your PATH environment variable.  

As of 2014-06-12, you can get that at http://chromedriver.storage.googleapis.com/index.html   

You can find more info about it at https://code.google.com/p/selenium/wiki/ChromeDriver    

The API for ChromeDriver is at  http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html?org/openqa/selenium/chrome/ChromeDriver.html   

A few stackoverflow pages:    
http://stackoverflow.com/questions/14654908/geb-test-driver-callback-issue     
http://stackoverflow.com/questions/13514338/failed-to-connect-to-binary-firefoxbinary-with-selenium-in-maven   
http://stackoverflow.com/questions/13724778/how-to-run-selenium-webdriver-test-cases-in-chrome   




