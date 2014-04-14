I got this message when I tried to build:    
POM relocation to an other version number is not fully supported in Gradle : xml-apis#xml-apis;2.0.2 relocated to xml-apis#xml-apis;1.0.b2.
Please update your dependency to directly use the correct version 'xml-apis#xml-apis;1.0.b2'.   

gradle test   
gradle  -Dtest.single=FileReadingTest test -info    

gradle runGroovy -PmainClass=org.groovy.cookbook.CriminalDataService

For the parallel collections, I can only get the multithreaded file readers to be 10% faster with 2 threads. I guess I don't understand this stuff yet. I thought IO stuff worked well with more threads. Plus it seems to matter if I run all the tests or some.  

They use Guava a lot: https://google-collections.googlecode.com/svn/trunk/javadoc/com/google/common/collect/Lists.html  
Especially Lists.partition, which "Returns consecutive sublists of a list, each of the same size (the final list may be smaller)"    


