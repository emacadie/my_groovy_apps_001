package info.shelfunit

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import info.shelfunit.SecUser

@Transactional( readOnly = true )
class BookController {
    
    def springSecurityService

    static allowedMethods = [ save: "POST", update: "PUT", delete: "DELETE" ]
    
    @Secured( [ 'permitAll' ] )
    def index( Integer max ) {
        println("in the index ----------------------------------------------------------------------------------------------------")
        params.max = Math.min( max ?: 10, 100 )
        respond Book.list( params ), model:[ bookInstanceCount: Book.count() ]
    }
    
    @Secured( [ 'permitAll' ] )
    def show( Book bookInstance ) {
        def  currentLoggedInUser = springSecurityService.currentUser
        println( "In BookController.show" )
        println( "currentUser id: ${currentLoggedInUser?.id}, currentUser username: ${currentLoggedInUser?.username}" )
        
        respond bookInstance, model:[ currentLoggedInUser:currentLoggedInUser ]
    }

    @Secured( [ 'ROLE_USER' ] )
    def create() {
        println( "params is a ${params.getClass().getName()}" )
        // 
        respond new Book( params )
    }
    
    @Secured( [ 'ROLE_USER' ] )
    @Transactional
    def save( Book bookInstance ) {
        if ( bookInstance == null ) {
            notFound()
            return
        }

        println "In BookController.save"
        params.each { name, value ->
            // println "${name} = ${value} ---" 
        }
        
        if ( bookInstance.hasErrors() ) {
            respond bookInstance.errors, view:'create'
            return
        }

        def user = springSecurityService.currentUser
        println( "currentUser id: ${user.returnID()}" )
        /*
        println("is springSecurityService null: ${springSecurityService == null}")
        println("springSecurityService.encodePassword(\"String password\"): ${springSecurityService.encodePassword("String password")}")
        println("is user null?: ${user == null} +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
        println("About to print user id 0000000000000000000000000000000000000000000000000000000000000000000000000000")
        println( "currentUser id: ${user.id}")
        println( "currentUser id: ${user.id}, currentUser username: ${user.username}" )
        println("user is a ${user.getClass().getName()} 2222222222222222222222222222222222222222222222222")
        // check the params:
        println( "bookInstance.owner: ${bookInstance.owner}")
        // println( "owner.id: ${bookInstance.owner.id}")
        println( "owner.username: ${bookInstance.owner.username}" )
        println( "bookInstance.title: ${bookInstance.title}" )
        println( "bookInstance.author: ${bookInstance.author}" )
        */
        bookInstance.owner = springSecurityService.currentUser 
        
        // println( "After the change: bookInstance.owner: ${bookInstance.owner},  owner.id: ${bookInstance.owner.id}, owner.username: ${bookInstance.owner.username}" )

        bookInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bookInstance.label', default: 'Book'), bookInstance.id])
                redirect bookInstance
            }
            '*' { respond bookInstance, [ status: CREATED ] }
        }
    }

    // check if it's their book
    @Secured( [ 'ROLE_USER' ] )
    def edit( Book bookInstance ) {
        respond bookInstance
    }
    
        
    // check if it's their book
    @Secured( [ 'ROLE_USER' ] )
    @Transactional
    def update( Book bookInstance ) {
        if ( bookInstance == null ) {
            notFound()
            return
        }

        if ( bookInstance.hasErrors() ) {
            respond bookInstance.errors, view:'edit'
            return
        }

        bookInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Book.label', default: 'Book'), bookInstance.id])
                redirect bookInstance
            }
            '*'{ respond bookInstance, [status: OK] }
        }
    }

    // check if it's their book
    @Secured( [ 'ROLE_USER' ] )
    @Transactional
    def delete( Book bookInstance ) {

        if ( bookInstance == null ) {
            notFound()
            return
        }

        bookInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Book.label', default: 'Book'), bookInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bookInstance.label', default: 'Book'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

