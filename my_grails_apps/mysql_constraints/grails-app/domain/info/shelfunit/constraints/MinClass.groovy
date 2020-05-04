package info.shelfunit.constraints

class MinClass {
    
    int firstIntField
    int secondIntField
    float firstFloatField
    float secondFloatField
    Date firstDateField
    Date secondDateField

    static constraints = {
        firstIntField min: 10
        firstFloatField min: 10.0f
        firstDateField min: new Date()
        id column: 'id'
        id generator:'sequence', params:[ sequence:'min_class_id_seq' ]
    }
}

