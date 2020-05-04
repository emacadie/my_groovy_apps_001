package info.shelfunit.shiro

class ShiroUser {
    String username
    String passwordHash
    String email     // added for Shiro-UI
    String firstName // added for Shiro-UI
    String lastName  // added for Shiro-UI
    Date dateCreated // added for Shiro-UI
    Date lastUpdated // added for Shiro-UI
    
    static hasMany = [ roles: ShiroRole, permissions: String ]

    static constraints = {
        username( nullable: false, blank: false, unique: true, size: 5..20 )
        passwordHash( display:false )
    }
}

