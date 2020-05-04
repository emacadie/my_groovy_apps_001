package info.shelfunit.shiro



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ShiroUserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ShiroUser.list(params), model:[shiroUserInstanceCount: ShiroUser.count()]
    }

    def show(ShiroUser shiroUserInstance) {
        respond shiroUserInstance
    }

    def create() {
        respond new ShiroUser(params)
    }

    @Transactional
    def save(ShiroUser shiroUserInstance) {
        if (shiroUserInstance == null) {
            notFound()
            return
        }

        if (shiroUserInstance.hasErrors()) {
            respond shiroUserInstance.errors, view:'create'
            return
        }

        shiroUserInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'shiroUser.label', default: 'ShiroUser'), shiroUserInstance.id])
                redirect shiroUserInstance
            }
            '*' { respond shiroUserInstance, [status: CREATED] }
        }
    }

    def edit(ShiroUser shiroUserInstance) {
        respond shiroUserInstance
    }

    @Transactional
    def update(ShiroUser shiroUserInstance) {
        if (shiroUserInstance == null) {
            notFound()
            return
        }

        if (shiroUserInstance.hasErrors()) {
            respond shiroUserInstance.errors, view:'edit'
            return
        }

        shiroUserInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ShiroUser.label', default: 'ShiroUser'), shiroUserInstance.id])
                redirect shiroUserInstance
            }
            '*'{ respond shiroUserInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ShiroUser shiroUserInstance) {

        if (shiroUserInstance == null) {
            notFound()
            return
        }

        shiroUserInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ShiroUser.label', default: 'ShiroUser'), shiroUserInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'shiroUser.label', default: 'ShiroUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
