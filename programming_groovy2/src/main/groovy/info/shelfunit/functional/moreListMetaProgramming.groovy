package info.shelfunit.functional
/*
java.util.ArrayList.metaClass.constructor = { int arg ->
    println "Intercepting int constructor call"
    constructor = ArrayList.class.getConstructor( int )
    constructor.newInstance( arg ).asImmutable()
}

java.util.ArrayList.metaClass.constructor = { java.util.Collection arg ->
    println "Intercepting Collection call, here is arg: ${arg.class.name}"
    constructor = ArrayList.class.getConstructor( java.util.Collection )
    println "just made constructor: ${constructor}"
    constructor.newInstance( arg ).asImmutable()
}

java.util.ArrayList.metaClass.constructor = {  Object[] arg ->
    println "Intercepting Second Collection call"
    constructor = ArrayList.class.getConstructor( java.util.Collection )
    println "just made constructor: ${constructor}"
    constructor.newInstance( arg ).asImmutable()
}



java.util.ArrayList.metaClass.constructor = {  ->
    println "Intercepting constructor call"
    constructor = ArrayList.class.getConstructor( null )
    constructor.newInstance(  ).asImmutable()
}



ArrayList.metaClass.constructor = { Collection arg ->
    println "Intercepting call from mailing list"
      def ctor = ArrayList.getConstructor(Collection)
      println "got constructor"
      println "arg is: ${arg.class.name}"
      println "ctor is ${ctor.class.name}"
      ctor.newInstance(arg).asImmutable()
}

java.util.Collections$UnmodifiableRandomAccessList.metaClass.invokeMethod = { String name, args ->
    println "invoking ${name} on UnmodifiableRandomAccessList"
}

println "Using null arg"
def qq = new ArrayList()
println "qq.class.name: ${qq.class.name}"
println "using int arg"
def ww = new ArrayList( 5 )
println "ww.class.name: ${ww.class.name}"
println "Using collection arg"
def numArr = [ 1, 2, 3 ] as int[]
def ee = [ 2,3,4, "hello" ]
println "ee.class.name: ${ee.class.name}"
ee = ee + 2
println "ee.class.name: ${ee.class.name}"

def emptyList = []
println "emptyList.class.name: ${emptyList.class.name}"

def xs = new ArrayList( [ 1, 2, 3, "hello" ] )
println "xs.class.name: ${xs.class.name}"
*/
// closet I have gotten:
println "\nTrying with a closure"
def collConst = ArrayList.class.getConstructor( java.util.Collection )
def pp = { Object[] arg -> collConst.newInstance( arg ).asImmutable() }
def rr = pp( [ 1, 2, 3 ] )
println "rr: ${rr}"
println "rr.class.name: ${rr.class.name}" 
rr.class.name
def constQ = { Object... args -> collConst.newInstance( args ).asImmutable() }
def firstQ = constQ( [ 1, 2, 3, "kkkkk" ] )
println "firstQ: ${firstQ}"
println "firstQ.class.name: ${firstQ.class.name}"

def constW = { Object... args ->
    println "args is a ${args.class.name}"
    collConst.newInstance( args as Object [] ).asImmutable() 
}
def firstW = constW( [ 1, 2, 3, "dkdjeb" ] )
println "firstW: ${firstW}"
println "firstW.class.name: ${firstW.class.name}"
firstW = firstW + "UU"
// System.identityHashCode(xx) to see if two objects are the same
///

/*
groovy:000> pp = aa[0].metaClass.respondsTo(aa[0], 'clone')
===> [protected native java.lang.Object java.lang.Object.clone() throws java.lang.CloneNotSupportedException]
groovy:000> pp.class.name
===> java.util.Collections$SingletonList
groovy:000> pp[0].class.name
===> org.codehaus.groovy.reflection.CachedMethod
groovy:000> pp[0].toString()
===> protected native java.lang.Object java.lang.Object.clone() throws java.lang.CloneNotSupportedException
groovy:000> oo = aa[4].metaClass.respondsTo(aa[4], 'clone')
===> [public java.lang.Object java.util.Date.clone()]
groovy:000> oo[0].toString()
===> public java.lang.Object java.util.Date.clone()
*/
/*
===> [1, 2, 3, Fri Jun 12 00:16:09 CDT 2015]
groovy:000> uu = new Date()
===> Fri Jun 12 00:16:17 CDT 2015
groovy:000> aI = aa.asImmutable()
===> [1, 2, 3, Fri Jun 12 00:16:09 CDT 2015]
groovy:000> System.identityHashCode(aa[4])
===> 0
groovy:000> aa[3]
===> Fri Jun 12 00:16:09 CDT 2015
groovy:000> System.identityHashCode(aa[3])
===> 1687155254
groovy:000> System.identityHashCode(aI[3])
===> 1687155254
groovy:000> aa[3] = new Date()
===> Fri Jun 12 00:17:09 CDT 2015
groovy:000> aa
===> [1, 2, 3, Fri Jun 12 00:17:09 CDT 2015]
groovy:000> aI
===> [1, 2, 3, Fri Jun 12 00:17:09 CDT 2015]
groovy:000> aa.add(9)
===> true
groovy:000> aa
===> [1, 2, 3, Fri Jun 12 00:17:09 CDT 2015, 9]
groovy:000> aI.add(9)
null
        at java_util_List$add$4.call (Unknown Source)
groovy:000> aI
===> [1, 2, 3, Fri Jun 12 00:17:09 CDT 2015, 9]
groovy:000> aa[3] = "HellO"
===> HellO
groovy:000> aI
===> [1, 2, 3, HellO, 9]
groovy:000> aa[0]
===> 1
groovy:000> aa[0] = "Hello"
===> Hello
groovy:000> aa
===> [Hello, 2, 3, HellO, 9]
groovy:000> aI
===> [Hello, 2, 3, HellO, 9]
groovy:000> aa[0].metaClass
===> org.codehaus.groovy.runtime.HandleMetaClass@638cc502[groovy.lang.MetaClassImpl@638cc502[class java.lang.String]]
groovy:000> aII = aa.clone().asImmutable()
===> [Hello, 2, 3, HellO, 9]
groovy:000> aa[0] = "boom"
===> boom
groovy:000> aa
===> [boom, 2, 3, HellO, 9]
groovy:000> aI
===> [boom, 2, 3, HellO, 9]
groovy:000> aII
===> [Hello, 2, 3, HellO, 9]
groovy:000> aa[5]
===> null
groovy:000> aa[4]
===> 9
groovy:000> aa[4] = 'p'
===> p
groovy:000> aa
===> [boom, 2, 3, HellO, p]
groovy:000> aI
===> [boom, 2, 3, HellO, p]
groovy:000> aII
===> [Hello, 2, 3, HellO, 9]
groovy:000> 
*/
// look at https://github.com/mperry/functionalgroovy/blob/master/core/src/main/groovy/com/github/mperry/fg/ListOps.groovy
// uuid1 = new UUID((2 * new Random().nextInt()), (3 * new Random().nextInt()))
// to get a range: 
def startTime = System.nanoTime()
def rng = 0..20000
def listA = []
rng.each { 
    listA <<  new UUID( ( it * new Random().nextInt() ), ( 3 * new Random().nextInt() ) )
}
def listAIm = listA.clone().asImmutable()
// def listAIm = listA.asImmutable()
def endTime = System.nanoTime()
println "Time (seconds) taken " + ( ( endTime - startTime ) / 1.0e9 )
println "listA size: ${listA.size()}, listAIm size: ${listAIm.size()}"
println "listA: ${listA.class.name} listAIm: ${listAIm.class.name}"
// listA[99]
// listAIm[99]
println "System.identityHashCode(listA[99]): ${System.identityHashCode(listA[99])}"
println "System.identityHashCode(listAIm[99]): ${System.identityHashCode(listAIm[99])}"
listA[99] =  new UUID((2 * new Random().nextInt()), (3 * new Random().nextInt()))

println "System.identityHashCode(listA[99]): ${System.identityHashCode(listA[99])}"
println "System.identityHashCode(listAIm[99]): ${System.identityHashCode(listAIm[99])}"
// listAIm[99] =  new UUID((2 * new Random().nextInt()), (3 * new Random().nextInt()))
// System.identityHashCode(listAIm[99])
// listAIm[99]


//
