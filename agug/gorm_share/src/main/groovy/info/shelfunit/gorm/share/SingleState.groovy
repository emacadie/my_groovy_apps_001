package info.shelfunit.gorm.share

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

}

