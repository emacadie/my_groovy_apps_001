package collab.todo

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Todo)
class TodoTests {
    
    // def person1
    // def personID
    
    void setUp() {
        
        
    }

    void tearDown() {
        
    }

    void testSomething() {
       // fail "Implement me"
       assert 1 == 1
    }
    
    void testValidationsOnTodo() {
        def person1 = new Person(personName:'maxSize1', firstName:'John', lastName:'Adams', password:'passthispal', email:"email@email.com")
        def cat1 = new Category(name: 'Cat1', description: 'Describe this', person: person1)
        def todo = new Todo( owner: person1, name: "Validation Test", note:"Detailed web app description", dateCreated: new Date(), dueDate: new Date(), lastUpdated: new Date(), startDate: new Date() + 1, priority: "1", status: "1" , category: cat1)
        assert true == todo.validate()
         
        // shouldn't validate
        todo.completedDate = new Date() - 1
        todo.name = null
        assert false == todo.validate()
        todo.name = "Hello"
        // readjust the date to be in the future
        todo.completedDate = new Date() + 3
        
        assert true == todo.validate()
    }
}

