package info.shelfunit

import grails.test.mixin.TestFor
import spock.lang.Specification

import info.shelfunit.SecUser 

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Magazine)
class MagazineSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    
    
    void "test valid Magazine"() {
        when: 'an Address is valid'
        def suser = Mock(SecUser)
        def validateable = new Magazine(title: 'Some Title', topic:'Groovy And Grails', owner:suser)

        then: 'validate() returns true and there are no errors'
        validateable.validate()
        !validateable.hasErrors()
        validateable.errors.errorCount == 0
    }
    
    
    void "test missing property violations on Magazine"() {
        when: 'an Magazine is missing a title property'
        
        def suser = Mock(SecUser)
        def validateable = new Magazine(topic:'Groovy And Grails', owner:suser)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "title"
        
        when: 'a Magazine is missing an topic property'
        validateable = new Magazine(title:'Return Of Magazine', owner:suser)
        
        then: 'validate() returns false and there is one error'
        !validateable.validate()
        validateable.hasErrors()
        validateable.errors.errorCount == 1
        validateable.errors.fieldError.field == "topic"

    }
}

