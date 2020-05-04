package info.shelfunit.activejdbc



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SingleStateController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SingleState.list(params), model:[singleStateInstanceCount: SingleState.count()]
    }

    def show(SingleState singleStateInstance) {
        respond singleStateInstance
    }

    def create() {
        respond new SingleState(params)
    }

    @Transactional
    def save(SingleState singleStateInstance) {
        if (singleStateInstance == null) {
            notFound()
            return
        }

        if (singleStateInstance.hasErrors()) {
            respond singleStateInstance.errors, view:'create'
            return
        }

        singleStateInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'singleStateInstance.label', default: 'SingleState'), singleStateInstance.id])
                redirect singleStateInstance
            }
            '*' { respond singleStateInstance, [status: CREATED] }
        }
    }

    def edit(SingleState singleStateInstance) {
        respond singleStateInstance
    }

    @Transactional
    def update(SingleState singleStateInstance) {
        if (singleStateInstance == null) {
            notFound()
            return
        }

        if (singleStateInstance.hasErrors()) {
            respond singleStateInstance.errors, view:'edit'
            return
        }

        singleStateInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SingleState.label', default: 'SingleState'), singleStateInstance.id])
                redirect singleStateInstance
            }
            '*'{ respond singleStateInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SingleState singleStateInstance) {

        if (singleStateInstance == null) {
            notFound()
            return
        }

        singleStateInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SingleState.label', default: 'SingleState'), singleStateInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'singleStateInstance.label', default: 'SingleState'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
