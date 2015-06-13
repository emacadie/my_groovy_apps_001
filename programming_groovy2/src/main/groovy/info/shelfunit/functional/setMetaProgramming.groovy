package info.shelfunit.functional

Closure testC =
{String x -> println x} 

ExpandoMetaClass.enableGlobally()
Set.metaClass.invokeMethod = { String name, args ->
    println "\t--------Call to $name intercepted... "
    // System.out.println("Here are args: ${args} and args is a ${args.class.name}")
    // println "Here is arg[0]: ${arg[0]}"    
    if ( name == 'findAll' ) {
        println "running filter on add... "
        if ( args.size() == 1 ) {
          println "one arg in findAll"
          print "Does Sett respond to add(Closure)? " + Set.metaClass.respondsTo(delegate, 'findAll', testC )? 'yes to add(Closure)' : 'no'
          println "here is args[0]: ${args[ 0 ].class.name}"
          def listMeth = Set.metaClass.respondsTo(delegate, 'findAll', testC )
          println "going through listMeth, 1 arg"
          listMeth.each {
              println "here is the class, 1 arg: ${it.getClass().getName()}"
          }
        } else if ( args.size() == 0 ) {
          println "0 args in findAll, " 
          println "Does Set respond to findAll()? " + Set.metaClass.respondsTo(delegate, 'findAll', null )? 'yes to no args' : 'no'
          def listMeth = Set.metaClass.respondsTo(delegate, 'findAll', null )
          println "going through listMeth, 0 arg"
          listMeth.each {
              println "here is the class, 0 arg: ${it.getClass().getName()}"
          }
          
        }
            // List.metaClass.getMetaMethod( 'add' ).doMethodInvoke( delegate, args ) // invoke( delegate, args )
        /*
        List.metaClass.add = { int arg, Object varArgs ->
            println "in the closure"
            delegate.invokeMethod( name, [ int, varArgs ] as Object[] )
        }
        */
        return delegate
    } else {
      println "Did not get add"
      Set.metaClass.getMetaMethod( name ).invoke( delegate, *args )
    }
    /*
    def validMethod = Car.metaClass.getMetaMethod(name, args)
    if (validMethod != null) {
        validMethod.invoke(delegate, args)
    } else {
        Car.metaClass.invokeMissingMethod(delegate, name, args)
    }
    */
}

def aa = [] as Set
aa << 1
println "here is a: ${aa}"
aa << 2 
println "here is a: ${aa}"
aa << 3 
println "here is a: ${aa}"
aa << 4 
println "here is a: ${aa}"
println "calling findAll()"
aa.findAll()
println "calling findAll(closure)"
aa.findAll{ it > 2 }
///////////////////////////////////////////
println "+++++++++++++++++++++++++++++++"
/*
def theList = [ 1, 2, 3 ]
def listMethods = theList.metaClass.getMethods()
println "going through the list"
listMethods.each { meth ->
    println "here is the method: ${meth.getClass().getName()}"
    println "---"
}
*/
///////////////////
class Test {
   public void foo(int x) { System.out.println("Inside foo(int)"); }
   public void foo(String x) { System.out.println("Inside foo(String)"); }
}
def intMethodT = Test.metaClass.getMetaMethod("foo", [Integer] as Class[] )
def strMethodT = Test.metaClass.getMetaMethod("foo", [String] as Class[] )

Test.metaClass.foo = { int arg ->
    println "foo(int) intercepted"
    intMethodT.invoke(delegate, arg)
}
Test.metaClass.foo = { String arg ->
    println "foo(String) intercepted"
    strMethodT.invoke(delegate, arg)
}
def o = new Test()
o.foo(1)
o.foo("")
println "------------------------------------"

