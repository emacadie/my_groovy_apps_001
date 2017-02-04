Some classes are from Venkat Subraminian's book "Programming Groovy 2"   
As well as other classes I make that have no other place for the time being   

With a few extras using the Gradle groovysh plugin:
https://github.com/tkruse/gradle-groovysh-plugin

Up to page 200.    

gradle runGroovy -PmainClass=info.shelfunit.logandcli.CLIRunner    

gradle runGroovy -PmainClass=info.shelfunit.venkat.ch07.threadExample  
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch07.BetterThreadExample  


gradle runGroovy -PmainClass=info.shelfunit.venkat.ch012.CallIntercepter     
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch012.SecondCallIntercepter     
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch012.IntegerIntercepter         
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch012.MetaClassUser   

gradle runGroovy -PmainClass=info.shelfunit.venkat.ch013.UsingCategories     
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch013.UsingCategoriesAnnotations     
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch013.IntegerExpando     
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch013.MethodOnHierarchy     
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch013.IntegerEMCDSL     
gradle runGroovy -PmainClass=info.shelfunit.venkat.ch013.InstanceInjector     

gradle runGroovy -PmainClass=info.shelfunit.functional.listMetaProgramming
gradle runGroovy -PmainClass=info.shelfunit.functional.setMetaProgramming
gradle runGroovy -PmainClass=info.shelfunit.functional.moreListMetaProgramming
gradle runGroovy -PmainClass=info.shelfunit.functional.thirdListMetaProgramming

This is now also the catch-all app for this repo as of 2016-08-28.
