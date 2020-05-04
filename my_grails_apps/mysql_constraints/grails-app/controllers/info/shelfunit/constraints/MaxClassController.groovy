package info.shelfunit.constraints



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MaxClassController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MaxClass.list(params), model:[maxClassInstanceCount: MaxClass.count()]
    }

    def show(MaxClass maxClassInstance) {
        respond maxClassInstance
    }

    def create() {
        respond new MaxClass(params)
    }

    @Transactional
    def save(MaxClass maxClassInstance) {
        if (maxClassInstance == null) {
            notFound()
            return
        }

        if (maxClassInstance.hasErrors()) {
            respond maxClassInstance.errors, view:'create'
            return
        }

        maxClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'maxClassInstance.label', default: 'MaxClass'), maxClassInstance.id])
                redirect maxClassInstance
            }
            '*' { respond maxClassInstance, [status: CREATED] }
        }
    }

    def edit(MaxClass maxClassInstance) {
        respond maxClassInstance
    }

    @Transactional
    def update(MaxClass maxClassInstance) {
        if (maxClassInstance == null) {
            notFound()
            return
        }

        if (maxClassInstance.hasErrors()) {
            respond maxClassInstance.errors, view:'edit'
            return
        }

        maxClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MaxClass.label', default: 'MaxClass'), maxClassInstance.id])
                redirect maxClassInstance
            }
            '*'{ respond maxClassInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MaxClass maxClassInstance) {

        if (maxClassInstance == null) {
            notFound()
            return
        }

        maxClassInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MaxClass.label', default: 'MaxClass'), maxClassInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'maxClassInstance.label', default: 'MaxClass'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
