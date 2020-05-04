package info.shelfunit

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import info.shelfunit.SecUser

@Transactional( readOnly = true )
class MagazineController {
    
    def springSecurityService

    static allowedMethods = [ save: "POST", update: "PUT", delete: "DELETE" ]

    @Secured( [ 'permitAll' ] )
    def index( Integer max ) {
        
        println("In MagazineController.index")
        // println( "currentUser id: ${currentLoggedInUser?.id}, currentUser username: ${currentLoggedInUser?.username}" )
        params.max = Math.min( max ?: 10, 100 )
        respond Magazine.list( params ), model:[ magazineInstanceCount: Magazine.count() ]
    }
    
    @Secured( [ 'permitAll' ] )
    def show( Magazine magazineInstance ) {
        respond magazineInstance
    }
    
    @Secured( [ 'ROLE_USER' ] )
    def create() {
        def  currentLoggedInUser = springSecurityService.currentUser
        respond new Magazine( params ), model:[ currentLoggedInUser_id:currentLoggedInUser.id ]
    }

    @Secured( [ 'ROLE_USER' ] )
    @Transactional
    def save( Magazine magazineInstance ) {
        println( "Here are the params for MagazineController.save()" )
        
        params.each { name, value ->
            println "${name} = ${value} ---" 
        }
        if ( magazineInstance == null ) {
            notFound()
            return
        }

        if ( magazineInstance.hasErrors() ) {
            respond magazineInstance.errors, view:'create'
            return
        }

        def user = springSecurityService.currentUser
        println( "currentUser id: ${user.returnID()}" )
        magazineInstance.owner = springSecurityService.currentUser 
        
        // magazineInstance.save flush:true
        magazineInstance.save( failOnError:true )
        println( "Here is magazineInstance.title: ${magazineInstance.title}" )
        println( "Here is magazineInstance.topic: ${magazineInstance.topic}" )
        println( "Here is magazineInstance.id: ${magazineInstance.id}" )
        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'magazineInstance.label', default: 'Magazine'), magazineInstance.id])
                redirect magazineInstance
            }
            '*' { respond magazineInstance, [status: CREATED] }
        }
        
    } // save

    @Secured( [ 'ROLE_USER' ] )
    def edit( Magazine magazineInstance ) {
        respond magazineInstance
    }

    @Secured( [ 'ROLE_USER' ] )
    @Transactional
    def update( Magazine magazineInstance ) {
        if ( magazineInstance == null ) {
            notFound()
            return
        }

        if ( magazineInstance.hasErrors() ) {
            respond magazineInstance.errors, view:'edit'
            return
        }

        magazineInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Magazine.label', default: 'Magazine'), magazineInstance.id])
                redirect magazineInstance
            }
            '*'{ respond magazineInstance, [status: OK] }
        }
    }

    @Secured( [ 'ROLE_USER' ] )
    @Transactional
    def delete( Magazine magazineInstance ) {

        if ( magazineInstance == null ) {
            notFound()
            return
        }

        magazineInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Magazine.label', default: 'Magazine'), magazineInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'magazineInstance.label', default: 'Magazine'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

