package info.shelfunit.app.math

import org.apache.commons.math3.linear.Array2DRowRealMatrix
// import org.apache.commons.math3.linear.DecompositionSolver
import org.apache.commons.math3.linear.LUDecomposition
import org.apache.commons.math3.linear.RealMatrix
import info.shelfunit.app.math.util.MathUtil

public class SecondRunner {
  def public static void main ( String [] args ) {
        
    // Create a real matrix with two rows and three columns
    double[][] matrixData = [ [1d,2d,3d], [2d,5d,3d]]
    println("matrixData is a " + matrixData.class)
    RealMatrix m = new Array2DRowRealMatrix(matrixData)

    // One more with three rows, two columns
    double[][] matrixData2 = [[1d,2d], [2d,5d], [1d, 7d]]
    RealMatrix n = new Array2DRowRealMatrix(matrixData2)

    // Note: The constructor copies  the input double[][] array.

    // Now multiply m by n
    RealMatrix p = m.multiply(n)
    println("p.getRowDimension: " + p.getRowDimension())    // 2
    println("p.getColumnDimension: " + p.getColumnDimension()) // 2

    // Invert p, using LU decomposition
    RealMatrix pInverse = new LUDecomposition(p).getSolver().getInverse()
    println( "matrixData.length: " + matrixData.length )
    println( "matrixData2.length: " + matrixData2.length )
    MathUtil.print2DArray( matrixData )
    MathUtil.print2DArray( matrixData2 )
    println("-----------------------------------------------------------")
    println("This is the SecondRunner ")
    println("-----------------------------------------------------------")
  } // end method main

} // end class FirstRunner
