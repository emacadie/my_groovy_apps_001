package info.shelfunit.shiro



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ShiroRoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ShiroRole.list(params), model:[shiroRoleInstanceCount: ShiroRole.count()]
    }

    def show(ShiroRole shiroRoleInstance) {
        respond shiroRoleInstance
    }

    def create() {
        respond new ShiroRole(params)
    }

    @Transactional
    def save(ShiroRole shiroRoleInstance) {
        if (shiroRoleInstance == null) {
            notFound()
            return
        }

        if (shiroRoleInstance.hasErrors()) {
            respond shiroRoleInstance.errors, view:'create'
            return
        }

        shiroRoleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'shiroRole.label', default: 'ShiroRole'), shiroRoleInstance.id])
                redirect shiroRoleInstance
            }
            '*' { respond shiroRoleInstance, [status: CREATED] }
        }
    }

    def edit(ShiroRole shiroRoleInstance) {
        respond shiroRoleInstance
    }

    @Transactional
    def update(ShiroRole shiroRoleInstance) {
        if (shiroRoleInstance == null) {
            notFound()
            return
        }

        if (shiroRoleInstance.hasErrors()) {
            respond shiroRoleInstance.errors, view:'edit'
            return
        }

        shiroRoleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ShiroRole.label', default: 'ShiroRole'), shiroRoleInstance.id])
                redirect shiroRoleInstance
            }
            '*'{ respond shiroRoleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ShiroRole shiroRoleInstance) {

        if (shiroRoleInstance == null) {
            notFound()
            return
        }

        shiroRoleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ShiroRole.label', default: 'ShiroRole'), shiroRoleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'shiroRole.label', default: 'ShiroRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
