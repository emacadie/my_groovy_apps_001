package info.shelfunit.properties.sample


import info.shelfunit.properties.annotations.SomeAnnotation
import info.shelfunit.properties.annotations.SecondAnnotation

class Book { 
  @SomeAnnotation(name='annotation name', value='the value')
  int pages

  @SecondAnnotation(name='second annotation name', value='second value')
  String title
  long year
}
