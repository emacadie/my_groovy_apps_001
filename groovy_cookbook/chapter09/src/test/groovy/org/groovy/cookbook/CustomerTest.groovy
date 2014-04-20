package org.groovy.cookbook

import org.junit.*

class Customer { 
  Long id
  String name
  String lastName
}

class CustomerTest { 

  @Test
  void testInstanceMetaclass() { 
    def c = new Customer()
    c.metaClass.fullName { "$name $lastName" }
    c.name = 'John'
    c.lastName = 'Ross'
    assert c.fullName() == 'John Ross'
  }

  @Test
  void testAddingConstructor() { 
    Customer.metaClass.constructor << { 
      String name -> new Customer(name: name)
    }
    
    def c = new Customer('John')
    assert 'John' == c.name

  }

}



