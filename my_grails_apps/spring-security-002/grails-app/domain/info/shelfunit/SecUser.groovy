package info.shelfunit

class SecUser {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	def returnID() { id }
	
	// static transients = ['springSecurityService']
	
	static hasMany = [books: Book, magazines: Magazine, albums: Album] // , categories: Category, buddyLists: BuddyList]

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}
	

	static mapping = {
		password column: '`password`'
	}

	Set<SecRole> getAuthorities() {
		SecUserSecRole.findAllBySecUser(this).collect { it.secRole } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}

