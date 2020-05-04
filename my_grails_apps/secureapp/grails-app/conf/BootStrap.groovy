import info.shelfunit.secureapp.SecAppRole
import info.shelfunit.secureapp.SecAppUser
import info.shelfunit.secureapp.SecAppUserSecAppRole

class BootStrap {

  def init = {  servletContext ->
    def adminRole = new SecAppRole(authority: 'ROLE_ADMIN').save(flush: true)
    def userRole = new SecAppRole(authority: 'ROLE_USER').save(flush: true)

    def testAdmin = new SecAppUser(username: 'admin', enabled: true, password: 'admin')
    testAdmin.save(flush: true)

    SecAppUserSecAppRole.create testAdmin, adminRole, true
    
    def testUser = new SecAppUser(username: 'user', enabled: true, password: 'user')
    testUser.save(flush: true)

    SecAppUserSecAppRole.create testUser, userRole, true

    assert SecAppUser.count() == 2
    assert SecAppRole.count() == 2
    assert SecAppUserSecAppRole.count() == 2
  }
  

    def destroy = {
    }
}

