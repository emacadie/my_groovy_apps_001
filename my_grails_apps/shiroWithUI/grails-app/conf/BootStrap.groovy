import grails.util.Environment

import org.apache.shiro.crypto.hash.Sha256Hash
import info.shelfunit.shiro.ShiroRole
import info.shelfunit.shiro.ShiroUser

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
        def adminUser = new ShiroUser( username: "user123", passwordHash: new Sha256Hash( "password" ).toHex(),
        email: 'gwash@hello.com', firstName: 'George', lastName: 'Washington', dateCreated: new Date(), lastUpdated: new Date() ) 
        adminUser.addToPermissions( "*:*" ) 
        adminUser.save()
        
        def user2 = new ShiroUser( username: "user456", passwordHash: new Sha256Hash( "password" ).toHex(),
        email: 'jadams@hello.com', firstName: 'John', lastName: 'Adams', dateCreated: new Date(), lastUpdated: new Date() ) 
        // user.addToPermissions("*:*")
        user2.save()
        
        // Create the admin role
        def adminRole = ShiroRole.findByName('ROLE_ADMIN') ?:
            new ShiroRole(name: 'ROLE_ADMIN', dateCreated: new Date(), lastUpdated: new Date() ).save( flush: true, failOnError: true )
        // adminRole.addToPermissions( "movie:*" )
        adminRole.addToPermissions( "shiroUser:*" )
        adminRole.addToPermissions( "shiroRole:*" )
        adminRole.save()

        // Create the user role
        def userRole = ShiroRole.findByName('ROLE_USER') ?:
            new ShiroRole(name: 'ROLE_USER', dateCreated: new Date(), lastUpdated: new Date() ).save(flush: true, failOnError: true)
        
         // Add roles to the admin user
         adminUser.addToRoles( adminRole ).addToRoles( userRole ).save( flush: true, failOnError: true )    
         
    }
    
    /*
    hbm2ddl.SchemaUpdate Unsuccessful: alter table shiro_user add column date_created timestamp not null
hbm2ddl.SchemaUpdate ERROR: column "date_created" contains null values
hbm2ddl.SchemaUpdate Unsuccessful: alter table shiro_user add column email varchar(255) not null unique
hbm2ddl.SchemaUpdate ERROR: column "email" contains null values
hbm2ddl.SchemaUpdate Unsuccessful: alter table shiro_user add column first_name varchar(255) not null
hbm2ddl.SchemaUpdate ERROR: column "first_name" contains null values
hbm2ddl.SchemaUpdate Unsuccessful: alter table shiro_user add column last_name varchar(255) not null
hbm2ddl.SchemaUpdate ERROR: column "last_name" contains null values
hbm2ddl.SchemaUpdate Unsuccessful: alter table shiro_user add column last_updated timestamp not null

    */

    def configureForTest() { 

    }

    def configureForProduction() { }

}

