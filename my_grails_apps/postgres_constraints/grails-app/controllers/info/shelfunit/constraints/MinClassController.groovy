package info.shelfunit.constraints



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MinClassController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MinClass.list(params), model:[minClassInstanceCount: MinClass.count()]
    }

    def show(MinClass minClassInstance) {
        respond minClassInstance
    }

    def create() {
        respond new MinClass(params)
    }

    @Transactional
    def save(MinClass minClassInstance) {
        if (minClassInstance == null) {
            notFound()
            return
        }

        if (minClassInstance.hasErrors()) {
            respond minClassInstance.errors, view:'create'
            return
        }

        minClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'minClassInstance.label', default: 'MinClass'), minClassInstance.id])
                redirect minClassInstance
            }
            '*' { respond minClassInstance, [status: CREATED] }
        }
    }

    def edit(MinClass minClassInstance) {
        respond minClassInstance
    }

    @Transactional
    def update(MinClass minClassInstance) {
        if (minClassInstance == null) {
            notFound()
            return
        }

        if (minClassInstance.hasErrors()) {
            respond minClassInstance.errors, view:'edit'
            return
        }

        minClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MinClass.label', default: 'MinClass'), minClassInstance.id])
                redirect minClassInstance
            }
            '*'{ respond minClassInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MinClass minClassInstance) {

        if (minClassInstance == null) {
            notFound()
            return
        }

        minClassInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MinClass.label', default: 'MinClass'), minClassInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'minClassInstance.label', default: 'MinClass'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
