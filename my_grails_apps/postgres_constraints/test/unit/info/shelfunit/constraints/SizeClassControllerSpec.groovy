package info.shelfunit.constraints



import grails.test.mixin.*
import spock.lang.*

@TestFor(SizeClassController)
@Mock(SizeClass)
class SizeClassControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.sizeClassInstanceList
            model.sizeClassInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.sizeClassInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def sizeClass = new SizeClass()
            sizeClass.validate()
            controller.save(sizeClass)

        then:"The create view is rendered again with the correct model"
            model.sizeClassInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            sizeClass = new SizeClass(params)

            controller.save(sizeClass)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/sizeClass/show/1'
            controller.flash.message != null
            SizeClass.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def sizeClass = new SizeClass(params)
            controller.show(sizeClass)

        then:"A model is populated containing the domain instance"
            model.sizeClassInstance == sizeClass
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def sizeClass = new SizeClass(params)
            controller.edit(sizeClass)

        then:"A model is populated containing the domain instance"
            model.sizeClassInstance == sizeClass
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/sizeClass/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def sizeClass = new SizeClass()
            sizeClass.validate()
            controller.update(sizeClass)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.sizeClassInstance == sizeClass

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            sizeClass = new SizeClass(params).save(flush: true)
            controller.update(sizeClass)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/sizeClass/show/$sizeClass.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/sizeClass/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def sizeClass = new SizeClass(params).save(flush: true)

        then:"It exists"
            SizeClass.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(sizeClass)

        then:"The instance is deleted"
            SizeClass.count() == 0
            response.redirectedUrl == '/sizeClass/index'
            flash.message != null
    }
}
