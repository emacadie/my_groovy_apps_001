package info.shelfunit.exercise.numberformatter

import spock.lang.Specification

public class NumberFormatterTest extends Specification { 
  
  def "print out the pretty strings"() { 
    // println "In the print pretty strings test"
    NumberFormatter nf = new NumberFormatter()
    expect:
    nf.formatNumber(number) == output
    
    where:
    number   | output
    5        | '5'
    '5'      | '5'
    4        | '4'
    6        | '6'
    2000000000000 | '2T' // TWO TRILLION DOLLAHS!!!  
  }

  def "print millions"() { 
    // println "In the print millions test"
    NumberFormatter nf = new NumberFormatter()
    expect:
    nf.formatNumber(number) == output
    
    where:
    number   | output
    10000000 | '10M'  // ten million
    2500000.34 | '2.5M'
  }
  
  def "print out billions"() { 
    // println "In print out billions test"
    NumberFormatter nf = new NumberFormatter()
    expect:
    nf.formatNumber(number) == output
    
    where:
    number     | output
    1123456789 | '1.1B'    
  }

  def "print out trillions"() { 
    // println "In the print out trillions test"
    NumberFormatter nf = new NumberFormatter()
    expect:
    nf.formatNumber(number) == output
    
    where:
    number   | output
    2000000000000 | '2T' // TWO TRILLION DOLLAHS!!! 
  }

} // end class NumberFormatterTest

