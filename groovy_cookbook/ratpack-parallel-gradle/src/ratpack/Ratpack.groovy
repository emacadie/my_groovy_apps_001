import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

import static info.shelfunit.ratpack.RatpackUtil.rnd

ratpack {
  handlers {
      get {
            response.send 'Welcome to the world criminal database'
        }
        get("us") {
            Thread.sleep( rnd( 10000L ) )
            render groovyTemplate( 'us.json' )
        }
        get('/canada') {
            Thread.sleep( rnd( 5000L ) )
            render groovyTemplate( 'can.json' )
        }
        get('/germany') {
            Thread.sleep( rnd( 7000L ) )
            render groovyTemplate( 'de.json' )
        }
        
      
      
      
      /*
    get {
      render groovyTemplate("index.html", title: "My Ratpack App")
    }
        */
    assets "public"
  }
  
  
}

