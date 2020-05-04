import grails.util.Environment
import org.apache.shiro.crypto.hash.Sha256Hash
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
      def user = new ShiroUser(username: "user123", passwordHash: new Sha256Hash("password").toHex())
      user.addToPermissions("*:*")
      user.save()
    }

    def configureForTest() {

    }

    def configureForProduction() { }

}
