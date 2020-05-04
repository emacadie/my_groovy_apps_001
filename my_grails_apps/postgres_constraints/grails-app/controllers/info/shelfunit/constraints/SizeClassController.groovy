package info.shelfunit.constraints



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SizeClassController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SizeClass.list(params), model:[sizeClassInstanceCount: SizeClass.count()]
    }

    def show(SizeClass sizeClassInstance) {
        respond sizeClassInstance
    }

    def create() {
        respond new SizeClass(params)
    }

    @Transactional
    def save(SizeClass sizeClassInstance) {
        if (sizeClassInstance == null) {
            notFound()
            return
        }

        if (sizeClassInstance.hasErrors()) {
            respond sizeClassInstance.errors, view:'create'
            return
        }

        sizeClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sizeClassInstance.label', default: 'SizeClass'), sizeClassInstance.id])
                redirect sizeClassInstance
            }
            '*' { respond sizeClassInstance, [status: CREATED] }
        }
    }

    def edit(SizeClass sizeClassInstance) {
        respond sizeClassInstance
    }

    @Transactional
    def update(SizeClass sizeClassInstance) {
        if (sizeClassInstance == null) {
            notFound()
            return
        }

        if (sizeClassInstance.hasErrors()) {
            respond sizeClassInstance.errors, view:'edit'
            return
        }

        sizeClassInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SizeClass.label', default: 'SizeClass'), sizeClassInstance.id])
                redirect sizeClassInstance
            }
            '*'{ respond sizeClassInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SizeClass sizeClassInstance) {

        if (sizeClassInstance == null) {
            notFound()
            return
        }

        sizeClassInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SizeClass.label', default: 'SizeClass'), sizeClassInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sizeClassInstance.label', default: 'SizeClass'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
