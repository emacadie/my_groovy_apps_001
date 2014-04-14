package info.shelfunit.activejdbc



import grails.test.mixin.*
import spock.lang.*

@TestFor(SingleStateController)
@Mock(SingleState)
class SingleStateControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.singleStateInstanceList
            model.singleStateInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.singleStateInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def singleState = new SingleState()
            singleState.validate()
            controller.save(singleState)

        then:"The create view is rendered again with the correct model"
            model.singleStateInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            singleState = new SingleState(params)

            controller.save(singleState)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/singleState/show/1'
            controller.flash.message != null
            SingleState.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def singleState = new SingleState(params)
            controller.show(singleState)

        then:"A model is populated containing the domain instance"
            model.singleStateInstance == singleState
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def singleState = new SingleState(params)
            controller.edit(singleState)

        then:"A model is populated containing the domain instance"
            model.singleStateInstance == singleState
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/singleState/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def singleState = new SingleState()
            singleState.validate()
            controller.update(singleState)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.singleStateInstance == singleState

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            singleState = new SingleState(params).save(flush: true)
            controller.update(singleState)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/singleState/show/$singleState.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/singleState/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def singleState = new SingleState(params).save(flush: true)

        then:"It exists"
            SingleState.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(singleState)

        then:"The instance is deleted"
            SingleState.count() == 0
            response.redirectedUrl == '/singleState/index'
            flash.message != null
    }
}
