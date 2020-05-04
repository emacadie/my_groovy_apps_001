package collab.todo

class Todo {

    String name
    String note
    // Date createdDate
    Date startDate
    Date dueDate
    Date completedDate
    
    // Date lastModifiedDate
    Date dateCreated // for db versioning
    Date lastUpdated // for db versioning
    
    String priority
    String status = "Started"
    Person owner
    Category category
    
    
    static belongsTo = [Person, Category]
    static hasMany = [keywords: Keyword]
    
    static constraints = {
        owner(nullable:false)
        name(blank:false)
        // createdDate()
        priority()
        status()
        note(maxSize:1000, nullable:true)
        startDate(nullable:true,
            validator: {
                if (it?.compareTo(new Date()) < 0 ) {
                    return false
                }
                return true
            })
        completedDate(nullable:true,
            validator: {
                val, obj ->
                if (val != null) {
                    return val.after(obj.dateCreated)
                }
                return true
            })
        dueDate(nullable:true)
    }
    
    String toString() {
        name
    }
    
    static mapping = {
        table 'todo_tbl'
        columns {
            name column:'name_str'
            note column:'note_str'
            name index:'Name_Idx, Name_Create_Date_Idx'
            createDate index:'Name_Create_Date_Idx'
        }
        cache true
        autoTimestamp true
    }
}

