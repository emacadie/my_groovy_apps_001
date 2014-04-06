A category can be used to inject methods into a metaclass inside a block of code. We can use it to add new methods, or intercept methods. I guess it is like MetaClass.       

In UsingCategories we create a class called StringUtil to convert a string to SSN format. It can be used within the "use(StringUtil)" block.  

UsingCategoriesAnnotations creates a class and uses an annotation to signify that the class has a method that is used as a category. I do not know if doing so would make every method a category method. But the idea is that by doing this you do not need to make the methods static. You still use this within a use block.   

I changed UseCategory to have another class called FindUtil. (Dr S usually likes to write scripts; I like classes with main methods). There is a method that uses multiple categories in a use block.  

Dr S points out that categories can do as much WRT intercepting as MetaClass. But if you just want to intercept certain methods in certain situations, then it is a good choice.    

In IntegerExpando we use MetaClass to add methods to the pre-existing java.lang.Integer class. In doStuffPage199(), we use delegate instead of this since we are doing this outside of the class (since we don't have the code).    

In MethodOnHierarchy, Dr S defines a method as a closure, and then adds it to two metaclasses, Integer and Long. Then he adds a method for java.lang.Number, and it shows up in two instances of Number's subclasses: Integer and Long.   

Then we go back to IntegerExpando to add a static method and a constructor. Then we override a constructor. We use "<<" to add, "=" to override.      

IntegerEMCDSL uses MetaClass to inject methods and constructors. EMCDSL is ExpandoMetaClass Domain Specific Language. It uses the ExpandoMetaClass DSL to defind them all in one block.    



