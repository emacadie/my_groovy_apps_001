package info.shelfunit.secureapp

import grails.plugins.springsecurity.Secured

class SensitiveContentController {

  @Secured(['ROLE_ADMIN'])
  def index() {
      log.info("Start action ${controllerName}Controller.${actionName}")
      log.info("${session?.user?.userName} Start action ${controllerName}Controller.${actionName}() : parameters $params")
      render "Some sensitive content"
  }

}

