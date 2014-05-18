package info.shelfunit.properties.sample

// import info.shelfunit.properties.annotations.SomeAnnotation
import info.shelfunit.properties.annotations.IntAnnotation

class FirstSubject {
    @IntAnnotation(minValue=30, maxValue=400)
    int firstNum
    int secondNum
}


