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


    Customer.metaClass.constructor << { 
      Long id, String fullName ->
      new Customer(
        id: id,
	name: fullName.split( ',' )[ 0 ],
	lastName: fullName.split( ',' )[ 1 ]
      )
    }

    def c0 = new Customer( 'Mike' )
    c0.name = 'Mike'
    def c1 = new Customer( 1000, 'Mike,Whitall' )
    assert c1.name == 'Mike'
    assert c1.lastName == 'Whitall'
  }

}



