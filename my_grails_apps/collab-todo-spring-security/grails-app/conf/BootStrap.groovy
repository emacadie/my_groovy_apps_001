import grails.util.Environment

import info.shelfunit.RequestMap
import info.shelfunit.SecRole
import info.shelfunit.SecUser
import info.shelfunit.SecUserSecRole


class BootStrap {

    def init = { servletContext ->

      switch (Environment.current) { 
      case Environment.DEVELOPMENT:
        configureForDevelopment()
        break
      case Environment.TEST:
        configureForTest()
        break
      case Environment.PRODUCTION:
        configureForProduction()
        break
      }

    }
    

    def destroy = {
    }

    def configureForDevelopment() { 
        for (String url in [
      '/', '/index', '/index.gsp', '/**/favicon.ico',
      '/**/js/**', '/**/css/**', '/**/images/**',
      '/login', '/login.*', '/login/*',
      '/logout', '/logout.*', '/logout/*']) {
          // new info.shelfunit.RequestMap(url: url, configAttribute: 'permitAll').save()
          def rMap = RequestMap(url: url, configAttribute: 'permitAll')
          rMap.save(flush: true)
      }
      
      def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true) 
      def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)
      def testUser = new SecUser(username: 'me', password: 'password')
      testUser.save(flush: true)
      SecUserSecRole.create testUser, adminRole, true
      def anotherUser = new SecUser(username: 'auser', password: 'password')
      anotherUser.save(flush: true)
      SecUserSecRole.create anotherUser, userRole, true
      
      new RequestMap(url: '/profile/**', configAttribute: 'ROLE_USER').save() 
      new RequestMap(url: '/admin/**', configAttribute: 'ROLE_ADMIN').save() 
      new RequestMap(url: '/admin/role/**', configAttribute: 'ROLE_SUPERVISOR').save() 
      new RequestMap(url: '/admin/user/**', configAttribute: 'ROLE_ADMIN,ROLE_SUPERVISOR').save() 
      new RequestMap(url: '/j_spring_security_switch_user', configAttribute: 'ROLE_SWITCH_USER,isFullyAuthenticated()').save()

      new RequestMap(url: '/requestmap/**', configAttribute: 'ROLE_ADMIN').save()
      new RequestMap(url: '/role/**', configAttribute: 'ROLE_ADMIN').save()
      new RequestMap(url: '/securityInfo/**', configAttribute: 'ROLE_ADMIN').save()
      new RequestMap(url: '/user/**', configAttribute: 'ROLE_ADMIN').save()
      
      assert SecUser.count() == 1 
      assert SecRole.count() == 2 
      assert SecUserSecRole.count() == 1
    }

    def configureForTest() { }

    def configureForProduction() { }

}

