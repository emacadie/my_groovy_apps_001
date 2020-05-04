package info.shelfunit

class Album {
    
    SecUser owner
    String title
    String artist
    int year
    int numberOfTracks
    
    static belongsTo = [SecUser]

    static constraints = {
        title blank: false
        artist blank: false
        year blank: false
        numberOfTracks blank: false
    }


}

