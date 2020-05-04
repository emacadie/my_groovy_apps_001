package info.shelfunit.misc

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MovieController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Movie.list(params), model:[movieInstanceCount: Movie.count()]
    }

    def show(Movie movieInstance) {
        respond movieInstance
    }

    def create() {
        println "In MovieController.create"
        print "Here are params: "
        params.each { k, v ->
            print "${k}: ${v},  "
        }
        print "\n"
        println "Here are the session vars: ${session.getAttributeNames()}"
        session.getAttributeNames().each { nextName ->
            print "next name is: ${nextName}; value: ${session.getAttribute(nextName)} and it is a ${session.getAttribute(nextName)?.class?.name}"
        }
        println "\nDone creating"
        respond new Movie(params)
    }

    @Transactional
    def save(Movie movieInstance) {
        if (movieInstance == null) {
            notFound()
            return
        }

        if (movieInstance.hasErrors()) {
            respond movieInstance.errors, view:'create'
            return
        }

        movieInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'movieInstance.label', default: 'Movie'), movieInstance.id])
                redirect movieInstance
            }
            '*' { respond movieInstance, [status: CREATED] }
        }
    }

    def edit(Movie movieInstance) {
        respond movieInstance
    }

    @Transactional
    def update(Movie movieInstance) {
        if (movieInstance == null) {
            notFound()
            return
        }

        if (movieInstance.hasErrors()) {
            respond movieInstance.errors, view:'edit'
            return
        }

        movieInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Movie.label', default: 'Movie'), movieInstance.id])
                redirect movieInstance
            }
            '*'{ respond movieInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Movie movieInstance) {

        if ( movieInstance == null ) {
            notFound()
            return
        }

        movieInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Movie.label', default: 'Movie'), movieInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'movieInstance.label', default: 'Movie'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

