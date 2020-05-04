import grails.util.Environment

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
         def adminRole = new SecRole( authority: 'ROLE_ADMIN' ).save( flush: true ) 
         def userRole  = new SecRole( authority: 'ROLE_USER' ).save( flush: true )
         
         def testUser = new SecUser( username: 'me', password: 'password' ) 
         testUser.save( flush: true )
         
         SecUserSecRole.create testUser, adminRole, true
         
         def anotherUser = new SecUser( username: 'auser', password: 'password' )
         anotherUser.save( flush: true )
         SecUserSecRole.create anotherUser, userRole, true
         
         def bUser = new SecUser( username: 'buser', password: 'password' )
         bUser.save( flush: true )
         SecUserSecRole.create bUser, userRole, true
         
         // assert SecUser.count() == 3 
         // assert SecRole.count() == 2 
         // assert SecUserSecRole.count() == 3
    }

    def configureForTest() { 
        def adminRole = new SecRole( authority: 'ROLE_ADMIN' ).save( flush: true ) 
        def userRole  = new SecRole( authority: 'ROLE_USER' ).save( flush: true )
         
        def testUser = new SecUser( username: 'me', password: 'password' ) 
        testUser.save( flush: true )
         
        SecUserSecRole.create testUser, adminRole, true
         
        def anotherUser = new SecUser( username: 'auser', password: 'password' )
        anotherUser.save( flush: true )
        SecUserSecRole.create anotherUser, userRole, true
         
        def bUser = new SecUser( username: 'buser', password: 'password' )
        bUser.save( flush: true )
        SecUserSecRole.create bUser, userRole, true
        println( "Done bootstrapping for test 22222222222222222222222222222222222222222222222222222222222222222222" )
    }

    def configureForProduction() { }
}

