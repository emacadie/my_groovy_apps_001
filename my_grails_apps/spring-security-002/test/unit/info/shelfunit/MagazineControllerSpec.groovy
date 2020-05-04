package info.shelfunit

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Shared

import grails.plugin.springsecurity.SpringSecurityService

import info.shelfunit.RequestMap
import info.shelfunit.SecRole
import info.shelfunit.SecUser
import info.shelfunit.SecUserSecRole

@TestFor( MagazineController )
@Mock( Magazine )
// @Mock([Magazine, SecUser])
class MagazineControllerSpec extends Specification {
    
    private SpringSecurityService service
    
    def setup() {
        defineBeans {
            springSecurityService( SpringSecurityService ) { bean ->
                bean.autowire = true
            }
        }
        
        SecRole adminRole = Mock( authority: 'ROLE_ADMIN' )
        SecRole userRole  = Mock( authority: 'ROLE_USER' )
        SecUser testUser  = Stub( id: 1, username: 'test', password: 'password' )
        testUser.returnID(_) >> "1".toInteger()
        println( "testUser.id: ${testUser.id}" )
        println( "testUser.returnID: ${testUser.returnID()}"  )
        println( "testUser.username: ${testUser.username}" )

        // SecUserSecRole userRole = Mock(.create testUser, adminRole, true
        
        def springSecurityServiceMock = mockFor( SpringSecurityService )
        springSecurityServiceMock.demand.getCurrentUser( 99 ) {-> testUser }
        springSecurityServiceMock.demand.currentUser( 99 ) {-> testUser }
        springSecurityServiceMock.demand.encodePassword( 9999 ) { "0123456789"  } 
        controller.springSecurityService = springSecurityServiceMock.createMock()
    } // setup
    
    @Shared
    def myuser 
    
    def setupSpec() {
        // Thread.sleep( 30 * 1000 )
        SecUser.metaClass.encodePassword = { null }
        myuser  =  new SecUser( username: 'auser3', password: 'password' )
        // myuser.save( failOnError:true ) // save(flush: true)
    }
    
    def populateValidParams( params ) {
        assert params != null
        // TODO: Populate valid properties like...
        // params["name"] = 'someValidName'
        params[ "topic" ]    = 'Star Trek'
        params[ "title" ]    = 'Deep Space Nine'
        params[ "create" ]   = 'Create'
        params[ "owner.id" ] = 1
        params[ "owner" ]    = [ id:1 ]
        params[ "action" ]   = 'save'
        params[ "format" ]   = null 
    }


    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.magazineInstanceList
            model.magazineInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.magazineInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        // get a SpringSecurityService in here
        // controller.springSecurityService = [principal: [id: 42]]
        // springSecurityService.id = 42
        // println("Here is testUser.returnID(): ${testUser.returnID()} and it is a ${testUser.returnID().getClass().getName()}" )
        
        when:"The save action is executed with an invalid instance"
            def book = new Magazine()
            book.validate()
            controller.save( book )

        then:"The create view is rendered again with the correct model"
            model.magazineInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
        // println( "testUser.id: ${testUser.id}" )
        // println( "testUser.username: ${testUser.username}" )
            response.reset()
            populateValidParams( params )
            book = new Magazine( params )

            controller.save( book )

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/magazine/show/1'
            controller.flash.message != null
            Magazine.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def magazine = new Magazine(params)
            controller.show(magazine)

        then:"A model is populated containing the domain instance"
            model.magazineInstance == magazine
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def magazine = new Magazine(params)
            controller.edit(magazine)

        then:"A model is populated containing the domain instance"
            model.magazineInstance == magazine
    }

    void "Test the update action performs an update on a valid domain instance"() {
        /*
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            status == 404
            */

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def magazine = new Magazine()
            magazine.validate()
            controller.update(magazine)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.magazineInstance == magazine

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            magazine = new Magazine(params).save(flush: true)
            controller.update(magazine)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/magazine/show/$magazine.id"
            flash.message != null
    }


    void "Test that the delete action deletes an instance if it exists"() {
        /*
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            status == 404
          */  

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def magazine = new Magazine(params).save(flush: true)

        then:"It exists"
            Magazine.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(magazine)

        then:"The instance is deleted"
            Magazine.count() == 0
            response.redirectedUrl == '/magazine/index'
            flash.message != null
    }

}

