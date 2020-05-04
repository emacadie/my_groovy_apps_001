package info.shelfunit.secureapp

import grails.plugins.springsecurity.Secured

class UserContentController {
    
    def springSecurityService

    @Secured(['ROLE_USER'])
    def index() {
        log.info("${session?.user?.userName} Start action ${controllerName} Controller.${actionName}() : parameters $params")
        log.info("Start action ${controllerName} Controller.${actionName}")
        log.info("session['SPRING_SECURITY_LAST_USERNAME']" + session['SPRING_SECURITY_LAST_USERNAME'] )
        log.info("springSecurityService is a " + springSecurityService.class.name)
        log.info("springSecurityService.principal.username: " + springSecurityService.principal.username)
        log.info("springSecurityService.principal is a: " + springSecurityService.principal.class.name)
        log.info('--------------------------------------------------------------------------')
        render "Some User content"
    }
}

