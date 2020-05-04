package info.shelfunit.activejdbc

class SingleState {
    
    String stateName
    int population
    String largestCity
    String capitalCity
    
    static constraints = {
        stateName blank: false, unique: true
        largestCity blank: false
        capitalCity blank: false
        population min: 10000
    }
    
    static mapping = {
        id column: 'single_state_id'
        id generator:'sequence', params:[ sequence:'single_state_id_seq' ]
    }
  
}

