package info.shelfunit

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SecUserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SecUser.list(params), model:[secUserInstanceCount: SecUser.count()]
    }

    def show(SecUser secUserInstance) {
        respond secUserInstance
    }

    def create() {
        respond new SecUser(params)
    }

    @Transactional
    def save(SecUser secUserInstance) {
        if (secUserInstance == null) {
            notFound()
            return
        }

        if (secUserInstance.hasErrors()) {
            respond secUserInstance.errors, view:'create'
            return
        }

        secUserInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'secUserInstance.label', default: 'SecUser'), secUserInstance.id])
                redirect secUserInstance
            }
            '*' { respond secUserInstance, [status: CREATED] }
        }
    }

    def edit(SecUser secUserInstance) {
        respond secUserInstance
    }

    @Transactional
    def update(SecUser secUserInstance) {
        if (secUserInstance == null) {
            notFound()
            return
        }

        if (secUserInstance.hasErrors()) {
            respond secUserInstance.errors, view:'edit'
            return
        }

        secUserInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SecUser.label', default: 'SecUser'), secUserInstance.id])
                redirect secUserInstance
            }
            '*'{ respond secUserInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SecUser secUserInstance) {

        if (secUserInstance == null) {
            notFound()
            return
        }

        secUserInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SecUser.label', default: 'SecUser'), secUserInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'secUserInstance.label', default: 'SecUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
