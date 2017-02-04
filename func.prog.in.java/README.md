This repo is for exercises in "Functional Programming in Java" by Venkat Subramaniam.

I don't really know a whole lot about the new stuff in JDK 8. I think some of it is similar to things we have had in Groovy for a while.

Some sample commands from another project:
gradle runJava -PmainClass=info.shelfunit.funcjava.ch01.ChapterOneRunner   

gradle runGroovy -PmainClass=info.shelfunit.funcjava.ch01.GChapterOneRunner

gradle runJava -PmainClass=info.shelfunit.concurrency.venkatsbook.ch002.ConcurrentCallableNAV   
gradle runJava -PmainClass=info.shelfunit.concurrency.venkatsbook.ch002.SequentialPrimeFinder -PmainArgs=10000000   
gradle runJava -PmainClass=info.shelfunit.concurrency.venkatsbook.ch002.ConcurrentPrimeFinder -PmainArgs="10000000 2 2"



