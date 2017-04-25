This repo is for exercises in "Functional Programming in Java" by Venkat Subramaniam.

I don't really know a whole lot about the new stuff in JDK 8. I think some of it is similar to things we have had in Groovy for a while.

In chapter five, he points out that for the most part we don't need to worry about garbage collection. We do need to think about when we interface with resources outside our application: databases, files, sockets, native resources.    

up to page 23  

Some sample commands from another project:
gradle runJava -PmainClass=info.shelfunit.funcjava.ch01.ChapterOneRunner   
gradle runJava -PmainClass=info.shelfunit.funcjava.ch02.ChapterTwoRunner   
gradle runJava -PmainClass=info.shelfunit.funcjava.ch02.ChapterTwoRunner -PmainArgs=iterateThroughAList    
gradle runJava -PmainClass=info.shelfunit.funcjava.ch02.ChapterTwoRunner -PmainArgs=transformAList
gradle runJava -PmainClass=info.shelfunit.funcjava.ch02.ChapterTwoRunner -PmainArgs=findElements     
gradle runJava -PmainClass=info.shelfunit.funcjava.ch02.ChapterTwoRunner -PmainArgs=reuseLambda
gradle runJava -PmainClass=info.shelfunit.funcjava.ch02.ChapterTwoRunner -PmainArgs="pickName N"
gradle runJava -PmainClass=info.shelfunit.funcjava.ch02.ChapterTwoRunner -PmainArgs=reduceAndJoin
gradle runJava -PmainClass=info.shelfunit.funcjava.ch03.ChapterThreeRunner -PmainArgs=iterateAString
gradle runJava -PmainClass=info.shelfunit.funcjava.ch03.ChapterThreeRunner -PmainArgs=implementComparator
gradle runJava -PmainClass=info.shelfunit.funcjava.ch03.ChapterThreeRunner -PmainArgs=useCollectMethod
gradle runJava -PmainClass=info.shelfunit.funcjava.ch03.ChapterThreeRunner -PmainArgs=workWithFiles     
gradle runJava -PmainClass=info.shelfunit.funcjava.ch04.ChapterFourRunner -PmainArgs=separateConcerns
gradle runJava -PmainClass=info.shelfunit.funcjava.ch04.ChapterFourRunner -PmainArgs=delegateUsingLambdas
gradle runJava -PmainClass=info.shelfunit.funcjava.ch04.ChapterFourRunner -PmainArgs=decorateUsingLambdas
gradle runJava -PmainClass=info.shelfunit.funcjava.ch04.ChapterFourRunner -PmainArgs=useDefaultMethods      
gradle runJava -PmainClass=info.shelfunit.funcjava.ch04.ChapterFourRunner -PmainArgs=createFluentInterfaces
gradle runJava -PmainClass=info.shelfunit.funcjava.ch04.ChapterFourRunner -PmainArgs=dealWithExceptions
gradle runJava -PmainClass=info.shelfunit.funcjava.ch05.ChapterFiveRunner -PmainArgs=cleanUpResources
gradle runJava -PmainClass=info.shelfunit.funcjava.ch05.ChapterFiveRunner -PmainArgs=cleanUpWithLamdba
gradle runJava -PmainClass=info.shelfunit.funcjava.ch05.ChapterFiveRunner -PmainArgs=manageLocks
gradle runJava -PmainClass=info.shelfunit.funcjava.ch05.ChapterFiveRunner -PmainArgs=createConciseTests
gradle runJava -PmainClass=info.shelfunit.funcjava.ch06.ChapterSixRunner -PmainArgs=delayInitialization
gradle runJava -PmainClass=info.shelfunit.funcjava.ch06.ChapterSixRunner -PmainArgs=evaluateLazily      
gradle runJava -PmainClass=info.shelfunit.funcjava.ch06.ChapterSixRunner -PmainArgs=leverageTheLaziness      
gradle runJava -PmainClass=info.shelfunit.funcjava.ch06.ChapterSixRunner -PmainArgs=createInfiniteStreams
gradle runJava -PmainClass=info.shelfunit.funcjava.ch07.ChapterSevenRunner -PmainArgs=useTailCallRecursion     
gradle runJava -PmainClass=info.shelfunit.funcjava.ch07.ChapterSevenRunner -PmainArgs=speedUpWithMemos
gradle runJava -PmainClass=info.shelfunit.funcjava.ch08.ChapterEightRunner -PmainArgs=useFunctionComposition
gradle runJava -PmainClass=info.shelfunit.funcjava.ch08.ChapterEightRunner -PmainArgs=useMapReduce






gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch01.GChapterOneRunner    
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch02.GChapterTwoRunner    
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch02.GChapterTwoRunner -PmainArgs=iterateManyWays    
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch02.GChapterTwoRunner -PmainArgs=transformAList
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch02.GChapterTwoRunner -PmainArgs=findElements
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch02.GChapterTwoRunner -PmainArgs=reuseLambda
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch02.GChapterTwoRunner -PmainArgs="pickName N"
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch02.GChapterTwoRunner -PmainArgs=reduceAndJoin
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch03.GChapterThreeRunner -PmainArgs=iterateAString
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch03.GChapterThreeRunner -PmainArgs=implementComparator
gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch03.GChapterThreeRunner -PmainArgs=useInjectMethod      
                
gradle runJava -PmainClass=info.shelfunit.concurrency.venkatsbook.ch002.ConcurrentCallableNAV   
gradle runJava -PmainClass=info.shelfunit.concurrency.venkatsbook.ch002.SequentialPrimeFinder -PmainArgs=10000000   
gradle runJava -PmainClass=info.shelfunit.concurrency.venkatsbook.ch002.ConcurrentPrimeFinder -PmainArgs="10000000 2 2"




