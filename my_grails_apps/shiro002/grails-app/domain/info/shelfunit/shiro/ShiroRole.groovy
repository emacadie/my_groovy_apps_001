package info.shelfunit.shiro

class ShiroRole {
    String name
    Date dateCreated // added for Shiro-UI
    Date lastUpdated // added for Shiro-UI

    static hasMany = [ users: ShiroUser, permissions: String ]
    static belongsTo = ShiroUser

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
}

