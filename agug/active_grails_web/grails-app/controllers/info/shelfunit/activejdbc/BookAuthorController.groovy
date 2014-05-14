package info.shelfunit.activejdbc

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BookAuthorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BookAuthor.list(params), model:[bookAuthorInstanceCount: BookAuthor.count()]
    }

    def show(BookAuthor bookAuthorInstance) {
        respond bookAuthorInstance
    }

    def create() {
        respond new BookAuthor(params)
    }

    @Transactional
    def save(BookAuthor bookAuthorInstance) {
        if (bookAuthorInstance == null) {
            notFound()
            return
        }

        if (bookAuthorInstance.hasErrors()) {
            respond bookAuthorInstance.errors, view:'create'
            return
        }

        bookAuthorInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bookAuthorInstance.label', default: 'BookAuthor'), bookAuthorInstance.id])
                redirect bookAuthorInstance
            }
            '*' { respond bookAuthorInstance, [status: CREATED] }
        }
    }

    def edit(BookAuthor bookAuthorInstance) {
        respond bookAuthorInstance
    }

    @Transactional
    def update(BookAuthor bookAuthorInstance) {
        if (bookAuthorInstance == null) {
            notFound()
            return
        }

        if (bookAuthorInstance.hasErrors()) {
            respond bookAuthorInstance.errors, view:'edit'
            return
        }

        bookAuthorInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BookAuthor.label', default: 'BookAuthor'), bookAuthorInstance.id])
                redirect bookAuthorInstance
            }
            '*'{ respond bookAuthorInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BookAuthor bookAuthorInstance) {

        if (bookAuthorInstance == null) {
            notFound()
            return
        }

        bookAuthorInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BookAuthor.label', default: 'BookAuthor'), bookAuthorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bookAuthorInstance.label', default: 'BookAuthor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
