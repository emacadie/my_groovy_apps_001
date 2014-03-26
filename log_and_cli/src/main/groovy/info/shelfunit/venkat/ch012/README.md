CallIntercepter.groovy contains a class that implements GroovyInterceptable. To implement that interface, you include a method called invokeMethod.  

Every time you call a method it is intercepted and handled by invokeMethod. So you can catch/handle particular methods. We are doing something before the method is called. This is known as "before advice".   

To call the method, get the meta-method from the meta-class, and invoke it.    

And, yes, you can call invokeMethod. You can try it with the first arg being a String and other args, but it will keep calling itself with one less argument every time. I suppose if you had an infinite array of String objects you could keep going. Otherwise you will soon get a groovy.lang.MissingMethodException.    



