package info.shelfunit.exercise.numberformatter

public class NumberFormatter { 

  public NumberFormatter() { 
  }

  def million  = 1000000
  def billion  = 1000000000
  def trillion = 1000000000000
  def whateverIsBiggerThanTrillion = 1000000000000000

  def formatNumber(number) {
    if ( number < million ) {
      return number.toString()
    } 

    def numString = number.toString()
    numString = numString.split('\\.')[0] // get anything in front of decimal point

    if (million <= number && number < billion) {
      return formatBigNumbers(numString, 6, "M")
    } else if (billion <= number && number < trillion) {
      return formatBigNumbers(numString, 9, "B")
    } else if (trillion <= number && number < whateverIsBiggerThanTrillion) {
      return formatBigNumbers(numString, 12, "T")
    }
  } // end formatNumber

  // trailingString = "M", "B", or "T"
  def formatBigNumbers( numString, lengthOfZeroes, trailingString ) { 
      def remainder = numString.length() - lengthOfZeroes
      def theXillions = numString.substring(0, remainder )
      def afterXillions = numString.substring(remainder, remainder + 1 )
      def finalString
      if ( !afterXillions.startsWith("0") ) {
	finalString = theXillions + "." + afterXillions + trailingString
      } else { finalString = theXillions + trailingString }
      return finalString
  } // formatBigNumbers

  def public static void main ( String [] args ) { 
  }

} // end class info/shelfunit/exercise/numberformatter/NumberFormatter - line 88