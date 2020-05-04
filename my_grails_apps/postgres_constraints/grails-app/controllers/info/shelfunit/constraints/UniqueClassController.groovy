package info.shelfunit.constraints



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UniqueClassController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UniqueClass.list(params), model:[uniqueClassInstanceCount: UniqueClass.count()]
    }

    def show(UniqueClass uniqueClassInstance) {
        respond uniqueClassInstance
    }

    def create() {
        respond new UniqueClass(params)
    }

    @Transactional
    def save(UniqueClass uniqueClassInstance) {
        if (uniqueClassInstance == null) {
            notFound()
            return
        }

        if (uniqueClassInstance.hasErrors()) {
            respond uniqueClassInstance.errors, view:'create'
            return
        }

        uniqueClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'uniqueClassInstance.label', default: 'UniqueClass'), uniqueClassInstance.id])
                redirect uniqueClassInstance
            }
            '*' { respond uniqueClassInstance, [status: CREATED] }
        }
    }

    def edit(UniqueClass uniqueClassInstance) {
        respond uniqueClassInstance
    }

    @Transactional
    def update(UniqueClass uniqueClassInstance) {
        if (uniqueClassInstance == null) {
            notFound()
            return
        }

        if (uniqueClassInstance.hasErrors()) {
            respond uniqueClassInstance.errors, view:'edit'
            return
        }

        uniqueClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UniqueClass.label', default: 'UniqueClass'), uniqueClassInstance.id])
                redirect uniqueClassInstance
            }
            '*'{ respond uniqueClassInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UniqueClass uniqueClassInstance) {

        if (uniqueClassInstance == null) {
            notFound()
            return
        }

        uniqueClassInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UniqueClass.label', default: 'UniqueClass'), uniqueClassInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'uniqueClassInstance.label', default: 'UniqueClass'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
