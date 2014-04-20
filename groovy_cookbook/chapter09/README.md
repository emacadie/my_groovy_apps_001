This is chapter 9, the chapter on metaprogramming and DSLs    

gradle test   
gradle -Dtest.single=BookTest test -info    
gradle -Dtest.single=BigDecimalTest test -info    

gradle runGroovy -PmainClass=org.groovy.cookbook.CriminalDataService

From the part in the book about BigDecimalTest: "The only aspect worth mentioning is the delegate variable, which refers to the object on which we call the method."    



