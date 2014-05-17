package info.shelfunit.properties.sample

import info.shelfunit.properties.annotations.SomeAnnotation
import info.shelfunit.properties.annotations.StringAnnotation

class Book {
  @SomeAnnotation(name='annotation name', value='the value')
  int pages

  @StringAnnotation(min=5, max=20)
  String title
  int year

  def doStuff() {
    println "In book.doStuff"
  }
 
}

