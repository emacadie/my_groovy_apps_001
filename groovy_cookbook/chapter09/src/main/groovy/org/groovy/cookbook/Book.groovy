package org.groovy.cookbook

class Book { 
  String title
  Author author
  Long year
  Long pages

  Long getAmazonSalesPosition() { 
    new Random().nextInt( 1 ) + 1
  }

  void attachReview( String review ) { }

}

class Author { 
  String name
  String lastName
}
