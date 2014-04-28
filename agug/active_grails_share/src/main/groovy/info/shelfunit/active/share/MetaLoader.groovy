package info.shelfunit.active.share

import org.javalite.activejdbc.Model
import org.javalite.activejdbc.ColumnMetadata

class MetaLoader {
    
    static void createNewMethods() {
        def classList = [ Book.class, BookAuthor.class, SingleState.class ]
        def theTokens = []
        def capTokens = []
        
        classList.each { nextClass ->
            
            println "-- Working with ${nextClass.getCanonicalName()}"
            def columnMap = nextClass.getMetaModel().getColumnMetadata()
        
            nextClass.getMetaModel().getAttributeNamesSkipGenerated().each { theProp ->
                println "next prop is ${theProp}"
                theTokens.clear()
                capTokens.clear()
                theTokens = theProp.tokenize( '_' )
                theTokens.each { capTokens << it.capitalize() }
                
                println "Trying to make ${'get' + capTokens.join()}"
                
                nextClass.metaClass."${'get' + capTokens.join()}" { ->
                    delegate.get( theProp )
                }
                println "Making setter"
                nextClass.metaClass."${'set' + capTokens.join()}" { Object arg ->
                    delegate.set( theProp, arg )
                }
                println "column ${theProp} is a ${columnMap[theProp].getTypeName()}"
                switch ( columnMap[ theProp ].getTypeName() ) {
                    case "int4":
                        println "Making static method findWhere${capTokens.join()}GreaterThan"
                        nextClass.metaClass.static."${'findWhere' + capTokens.join() + 'GreaterThan'}" = { int arg ->
                            nextClass.where( "${theProp} > ?", arg )
                        }
                        println "Making static method findWhere${capTokens.join()}LessThan"
                        nextClass.metaClass.static."${'findWhere' + capTokens.join() + 'LessThan'}" = { int arg ->
                            nextClass.where( "${theProp} < ?", arg )
                        }
                        println "Making static method findWhere${capTokens.join()}Between"
                        nextClass.metaClass.static."${'findWhere' + capTokens.join() + 'Between'}" = { int smaller, int larger ->
                            nextClass.where( "${theProp} between ? and ?", smaller, larger )
                        }
                        break
                    case "varchar":
                        println "Making static method findBy${capTokens.join()}"
                        nextClass.metaClass.static."${'findBy' + capTokens.join()}" = { String arg ->
                            nextClass.where( "${theProp} = ?", arg )
                        }
                        break
                }
            } // end each prop
     
        } // classList.each
        
    } // createNewMethods
}

