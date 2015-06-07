package info.shelfunit.functional

ExpandoMetaClass.enableGlobally()
List.metaClass.invokeMethod = { String name, args ->
    println "\t--------Call to $name intercepted... "
    // System.out.println("Here are args: ${args} and args is a ${args.class.name}")
    // println "Here is arg[0]: ${arg[0]}"    
    if ( name == 'add' ) {
        println "running filter on add... "
        if ( args.size() == 1 ) {
          println "one arg in add"
          print "Does List respond to add(Object)? " + List.metaClass.respondsTo(delegate, 'add', 'hello' )? 'yes to add(Object)' : 'no'
        } else if ( args.size() == 2 ) {
          println "two args in add, " 
          println "Does List respond to add(int, Object)? " + List.metaClass.respondsTo(delegate, 'add', [5, 'hello'] as Object[] )? 'yes to (int, Object)' : 'no'
          println "here is args[0]: ${args[ 0 ]}, here is args[ 1 ]: ${args[ 1 ]}"
        }
            // List.metaClass.getMetaMethod( 'add' ).doMethodInvoke( delegate, args ) // invoke( delegate, args )
        List.metaClass.add = { int arg, Object varArgs ->
            println "in the closure"
            delegate.invokeMethod( name, [ int, varArgs ] as Object[] )
        }
        return delegate
    } else {
      println "Did not get add"
      List.metaClass.getMetaMethod( name ).invoke( delegate, *args )
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

def aa = []
aa << 1
println "here is a: ${aa}"
aa.add( 2 )
println "here is a: ${aa}"
aa.add( 2, new Date() )
println "here is a: ${aa}"


