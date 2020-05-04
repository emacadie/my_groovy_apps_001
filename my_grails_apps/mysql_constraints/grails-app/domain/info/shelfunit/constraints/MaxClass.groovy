package info.shelfunit.constraints

class MaxClass {
    
    int firstIntField
    int secondIntField
    float firstFloatField
    float secondFloatField
    Date firstDateField
    Date secondDateField

    static constraints = {
        firstIntField max: 1000
        firstFloatField max: 1000.0f
        firstDateField max: new Date()
    }
}

