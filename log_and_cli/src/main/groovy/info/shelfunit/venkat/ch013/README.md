A category can be used to inject methods into a metaclass inside a block of code. We can use it to add new methods, or intercept methods. I guess it is like MetaClass.       

In UsingCategories we create a class called StringUtil to convert a string to SSN format. It can be used within the "use(StringUtil)" block.  

UsingCategoriesAnnotations creates a class and uses an annotation to signify that the class has a method that is used as a category. I do not know if doing so would make every method a category method. But the idea is that by doing this you do not need to make the methods static. You still use this within a use block.   

I changed UseCategory to have another class called FindUtil. (Dr S usually likes to write scripts; I like classes with main methods).
