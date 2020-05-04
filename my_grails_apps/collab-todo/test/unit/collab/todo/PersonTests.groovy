package collab.todo

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonTests {

    void testSomething() {
       // fail "Implement me"
       assert 1 == 1
    }
    
    void testCRUDOperations() {
        // Let's create the person
        def personTemp = new Person(personName: 'testPerson', firstName:'John', lastName:'Smith', password:'pass', email:"smith@gmail.com")
        println("1 person count: " + Person.count())
        // Create - let's save it
        personTemp.save()
        
        // grab the person id
        def personId = personTemp.id
         
        // Update - since we are still within the session we caught it
        // we shouldn't need to do anything explicit
        personTemp.password = 'A new password'
        // let's see if it got updated
        personTemp = Person.get(personId)
        assert "A new password" == personTemp.password
        assert "John" == personTemp.firstName
         println("2 person count: " + Person.count())
        // let's show the delete
        personTemp.delete(flush: true)
        // def person2 = Person.get(personId)
        // person2.delete(flush: true)
        // let's make sure it got deleted
        assert null == Person.get(personId)
    }
}

