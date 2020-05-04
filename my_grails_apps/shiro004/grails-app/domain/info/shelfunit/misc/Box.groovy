package info.shelfunit.misc

class Box {
    
    String color
    int height
    int length
    String label

    static constraints = {
        color blank: false
        height blank: false
        length blank: false
        label blank: false
    }
}

