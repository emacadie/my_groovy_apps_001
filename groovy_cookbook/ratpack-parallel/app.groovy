@GrabResolver(
    name = 'Sonatype OSS Snapshots',
    root = 'https://oss.sonatype.org/content/repositories/snapshots',
    m2Compatible = true
)
// @Grab('org.ratpack-framework:ratpack-groovy:0.7.0-SNAPSHOT')

@Grab("io.ratpack:ratpack-groovy:0.9.0-SNAPSHOT")

import static org.ratpackframework.groovy.Ratpack.ratpack

ratpack {
    /*
    handlers {
        get {
            response.send "This is the app root (also try: /date and /some.txt)"
        }

        get("date") {
            render groovyTemplate("date.html")
        }

        assets "public"
    }
    */
}
