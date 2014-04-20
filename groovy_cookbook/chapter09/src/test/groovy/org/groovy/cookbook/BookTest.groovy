package org.groovy.cookbook

import org.junit.*
import org.groovy.cookbook.*

class BookTest { 

  @Test
  void testNames() {
    assert 'java.lang.String' == String.name
    assert 'org.groovy.cookbook.Author' == Author.name
  }

  @Test
  void testListProperties() { 
    Author a = new Author( name: 'Ernest', lastName: 'Hemingway' )
    Book book = new Book()
    book.with { 
      title = 'The Old Man and the Sea'
      year = 1952
      pages = 200
      author = a
    }
    book.properties.each { println it }
    println "${book.metaClass}"
    assert book.metaClass.hasProperty( book, 'pages' )

    println '#### METHODS ####'
    book.metaClass.methods.each { println it }
    println '#### PROPERTIES ####'
    book.metaClass.properties.each { println it.name }

    assert book.metaClass.respondsTo( book, 'getAmazonSalesPosition' )
    assert book.metaClass.respondsTo( book, 'attachReview', String )
    assert book.respondsTo( 'attachReview', String )

  }

}

