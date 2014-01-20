package info.shelfunit.app.math.util

public class MathUtil {
  
  def static void print2DArray( double [][]  twoD ) {
        println("twoD.length: " + twoD.length )
        for ( int x = 0; x < twoD.length; x++) {
	  // System.out.println("Hello")
        }
        for ( int r = 0; r < twoD.length; r++ ) {
	// twoD.length.times { } -> What about "r" in this case?
	  // for ( int c = 0; c < twoD[ r ].length; c++ ) {
	  for ( int c = 0; c < twoD[ r ].length; c++ ) {
                print( " " + twoD[ r ][ c ] )
            }
            println("")
        }
	println("twoD is a " + twoD.getClass().getName() + "\n--Try with more idiomatic Groovy\n")
	for ( r in twoD ) { 
	  print r
	  
	  print ", "
	  println " "
	  for ( c in r) {  print " c: ${c}"}
	  println ""
	}
    }    
} // end class info.shelfunit.app.math.util.MathUtil 

