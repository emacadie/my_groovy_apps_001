package info.shelfunit

import grails.test.mixin.TestFor
import spock.lang.Specification

import info.shelfunit.SecUser 

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        println("This is the test in BookSpec")
    }
    
    void "test valid Book"() {
        when: 'an Address is valid'
        def suser = Mock(SecUser)
        def validateable = new Book(title: 'Some Title', author:'John Smith', owner:suser)

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }
    
    
    void "test missing property violations on Book"() {
        when: 'an Book is missing a title property'
        
        def suser = Mock(SecUser)
        def validateable = new Book(author:'John Smith', owner:suser)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
        
        when: 'a Book is missing an author property'
        validateable = new Book(title:'Return Of Book', owner:suser)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "author"
        
        when: 'a Book is missing an owner property'
        validateable = new Book(title:'Return Of Book', author:'John Doe')
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "owner"

    }
}

