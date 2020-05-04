package info.shelfunit

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AlbumController {
    
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    @Secured( [ 'permitAll' ] )
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Album.list(params), model:[albumInstanceCount: Album.count()]
    }
    
    @Secured( [ 'permitAll' ] )
    def show(Album albumInstance) {
        respond albumInstance
    }

    @Secured( [ 'permitAll' ] )
    def create() {
        respond new Album(params)
    }

    @Secured( [ 'permitAll' ] )
    @Transactional
    def save(Album albumInstance) {
        if (albumInstance == null) {
            notFound()
            return
        }

        if (albumInstance.hasErrors()) {
            respond albumInstance.errors, view:'create'
            return
        }

        albumInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'album.label', default: 'Album'), albumInstance.id])
                redirect albumInstance
            }
            '*' { respond albumInstance, [status: CREATED] }
        }
    }

    @Secured( [ 'permitAll' ] )
    def edit(Album albumInstance) {
        respond albumInstance
    }

    @Secured( [ 'permitAll' ] )
    @Transactional
    def update(Album albumInstance) {
        if (albumInstance == null) {
            notFound()
            return
        }

        if (albumInstance.hasErrors()) {
            respond albumInstance.errors, view:'edit'
            return
        }

        albumInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Album.label', default: 'Album'), albumInstance.id])
                redirect albumInstance
            }
            '*'{ respond albumInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Album albumInstance) {

        if (albumInstance == null) {
            notFound()
            return
        }

        albumInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Album.label', default: 'Album'), albumInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'album.label', default: 'Album'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
