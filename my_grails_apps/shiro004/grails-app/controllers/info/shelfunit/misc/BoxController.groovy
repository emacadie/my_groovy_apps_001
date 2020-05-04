package info.shelfunit.misc

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional


@Transactional(readOnly = true)
class BoxController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        println "In BoxController.index"
        params.max = Math.min(max ?: 10, 100)
        respond Box.list(params), model:[boxInstanceCount: Box.count()]
    }

    def show(Box boxInstance) {
        println "In BoxController.show"
        respond boxInstance
    }

    def create() {
        println "In BoxController.create"
        respond new Box(params)
    }

    // @Transactional
    def save(Box boxInstance) {
        println "In BoxController.save"
        if (boxInstance == null) {
            println "Box in null"
            notFound()
            return
        }

        if (boxInstance.hasErrors()) {
            respond boxInstance.errors, view:'create'
            return
        }

        boxInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'box.label', default: 'Box'), boxInstance.id])
                redirect boxInstance
            }
            '*' { respond boxInstance, [status: CREATED] }
        }
    }

    def edit(Box boxInstance) {
        respond boxInstance
    }

    @Transactional
    def update(Box boxInstance) {
        if (boxInstance == null) {
            notFound()
            return
        }

        if (boxInstance.hasErrors()) {
            respond boxInstance.errors, view:'edit'
            return
        }

        boxInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Box.label', default: 'Box'), boxInstance.id])
                redirect boxInstance
            }
            '*'{ respond boxInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Box boxInstance) {

        if (boxInstance == null) {
            notFound()
            return
        }

        boxInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Box.label', default: 'Box'), boxInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'box.label', default: 'Box'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

