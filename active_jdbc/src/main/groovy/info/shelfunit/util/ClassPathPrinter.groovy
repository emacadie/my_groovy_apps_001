package info.shelfunit.util

public class ClassPathPrinter { 
  def public static void main ( String [] args ) { 
    System.getProperty("java.class.path", ".").tokenize(File.pathSeparator).each {
      println it                             
    }

    println("\n---------------\n\n")
    println(System.getProperty("java.class.path"))
  }
}


