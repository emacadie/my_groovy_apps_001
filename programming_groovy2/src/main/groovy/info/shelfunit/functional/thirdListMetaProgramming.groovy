package info.shelfunit.functional


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

java.util.ArrayList.metaClass.constructor = {  ->
    println "Intercepting constructor call"
    constructor = ArrayList.class.getConstructor( null )
    constructor.newInstance(  ).asImmutable()
}

java.util.ArrayList.metaClass.constructor = { Object arg  -> // Object... arg ->
    println "Intercepting Second Collection call"
    constructor = ArrayList.class.getConstructor( java.util.Collection )
    println "just made constructor: ${constructor}"
    constructor.newInstance( arg ).asImmutable()
}




println "Using null arg"
def qq = new ArrayList()
println "qq.class.name: ${qq.class.name}"
println "using int arg"
def ww = new ArrayList( 5 )
println "ww.class.name: ${ww.class.name}"
println "Using collection arg"
def numArr = [ 1, 2, 3 ] as int[]
def ee = [ 2,3,4 ]
println "ee.class.name: ${ee.class.name}"
ee = ee + 2
println "ee.class.name: ${ee.class.name}"

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


