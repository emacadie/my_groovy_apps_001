package info.shelfunit

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional( readOnly = true )
class NewspaperController {
    
    def springSecurityService

    static allowedMethods = [ save: "POST", update: "PUT", delete: "DELETE" ]

    @Secured( [ 'permitAll' ] )
    def index( Integer max ) {
        params.max = Math.min( max ?: 10, 100 )
        respond Newspaper.list( params ), model:[newspaperInstanceCount: Newspaper.count()]
    }

    @Secured( [ 'permitAll' ] )
    def show(Newspaper newspaperInstance) {
        respond newspaperInstance
    }

    @Secured( [ 'permitAll' ] )
    def create() {
        respond new Newspaper( params )
    }

    @Secured( [ 'permitAll' ] )
    @Transactional
    def save( Newspaper newspaperInstance ) {
        println( "Here are the params for NewspaperController.save()" )
        println( "${params.dump()}" )
        if ( newspaperInstance == null ) {
            notFound()
            return
        }

        if ( newspaperInstance.hasErrors() ) {
            respond newspaperInstance.errors, view:'create'
            return
        }

        newspaperInstance.save flush:true
        
        println( "Here is newspaperInstance.city: ${newspaperInstance.city}" )
        println( "Here is newspaperInstance.name: ${newspaperInstance.name}" )
        println( "Here is newspaperInstance.id: ${newspaperInstance.id}" )

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'newspaperInstance.label', default: 'Newspaper'), newspaperInstance.id])
                redirect newspaperInstance
            }
            '*' { respond newspaperInstance, [status: CREATED] }
        }
    }

    @Secured( [ 'permitAll' ] )
    def edit( Newspaper newspaperInstance ) {
        respond newspaperInstance
    }

    @Secured( [ 'permitAll' ] )
    @Transactional
    def update( Newspaper newspaperInstance ) {
        if ( newspaperInstance == null ) {
            notFound()
            return
        }

        if ( newspaperInstance.hasErrors() ) {
            respond newspaperInstance.errors, view:'edit'
            return
        }

        newspaperInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Newspaper.label', default: 'Newspaper'), newspaperInstance.id])
                redirect newspaperInstance
            }
            '*'{ respond newspaperInstance, [status: OK] }
        }
    }

    @Transactional
    def delete( Newspaper newspaperInstance ) {

        if ( newspaperInstance == null ) {
            notFound()
            return
        }

        newspaperInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Newspaper.label', default: 'Newspaper'), newspaperInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'newspaperInstance.label', default: 'Newspaper'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

