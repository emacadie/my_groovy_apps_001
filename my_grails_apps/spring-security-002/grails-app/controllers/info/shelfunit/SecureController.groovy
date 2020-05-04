package info.shelfunit

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class SecureController {

    def index() {
        log.info "This is the SecureController"

	    log.error "In SecureController, logging error"
	    log.info "In SecureController, logging info"
		println("In SecureController, request.post : ${request.post}")
		println("In SecureController, request.get: ${request.get}")
      render 'Secure access only'
   }
   
   def secondAction() {
       log.info "This is the SecureController.secondAction"

	    log.error "In SecureController.secondAction, logging error"
	    log.info "In SecureController.secondAction, logging info"
		println("In SecureController.secondAction, request.post : ${request.post}")
		println("In SecureController.secondAction, request.get: ${request.get}")
      render 'Secure access only in second action'
   }
}

