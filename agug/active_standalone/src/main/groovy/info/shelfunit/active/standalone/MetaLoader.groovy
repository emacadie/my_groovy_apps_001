package info.shelfunit.active.standalone

import org.javalite.activejdbc.Model
import org.javalite.activejdbc.ColumnMetadata

class MetaLoader {
// columns.txt  | grep -v varchar
// column year_of_birth is a int4

    
    static void createNewMethods() {
        def classList = [BookAuthor.class, SingleState.class]
        def performedMagic = false
        def theTokens = []
        def capTokens = []
        
        classList.each { nextClass ->
            // println "making static method findByLargestCity"
            println "-- Working with ${nextClass.getCanonicalName()}"
            def columnMap = nextClass.getMetaModel().getColumnMetadata()
        /*
            SingleState.metaClass.static.findByLargestCity = { String arg ->
                SingleState.where( "largest_city = ?", arg )
            }
            */
        
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
                
                    println "Making static method findWhere${capTokens.join()}LargerThan"
                    nextClass.metaClass.static."${'findWhere' + capTokens.join() + 'LargerThan'}" = { int arg ->
                        nextClass.where( "${theProp} > ?", arg )
                    }
                    println "Making static method findWhere${capTokens.join()}SmallerThan"
                    nextClass.metaClass.static."${'findWhere' + capTokens.join() + 'SmallerThan'}" = { int arg ->
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
        /*
        getMetaModel().getAttributeNamesSkipGenerated().each { theProp ->
                println "next prop is ${theProp}"
                theTokens.clear()
                capTokens.clear()
                theTokens = theProp.tokenize('_')
                
                theTokens.each { capTokens << it.capitalize() }
                println "making static method ${'findBy' + capTokens.join()}"
                methodName = 'get' + capTokens.join()
                SingleState.metaClass.'static'."${'findBy' + capTokens.join()}" { Object arg ->
                    println "In the body for the static method, here is arg: ${arg}"
                    // SingleState.where( "${theProp} = ?", arg )
                }
                println "done making static method ${'findBy' + capTokens.join()}"
                
                println "Making setter"
                this.metaClass."${'set' + capTokens.join()}" { Object arg ->
                    this.set( theProp, arg )
                }
                
         } // end each
         */
        } // classList.each
        
    } // createNewMethods
}


