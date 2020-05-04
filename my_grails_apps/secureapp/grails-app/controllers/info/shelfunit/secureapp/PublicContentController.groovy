package info.shelfunit.secureapp

class PublicContentController {
    
    def springSecurityService
    
    def index() {
        log.info("${session?.user?.userName} Start action ${controllerName}Controller.${actionName}() : parameters $params")
        log.info("Start action ${controllerName} Controller.${actionName}")
        log.info("Here is springSecurityService: " + springSecurityService)
        log.info("springSecurityService.isLoggedIn(): ${springSecurityService.isLoggedIn()}")
        // log.info("springSecurityService.principal.username: ${springSecurityService?.principal?.username} ")
        log.info("This is info in PublicContentController")
        render "Some public content"
    }
   
}

