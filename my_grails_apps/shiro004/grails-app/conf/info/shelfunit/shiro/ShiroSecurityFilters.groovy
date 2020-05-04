package info.shelfunit.shiro

import org.apache.shiro.SecurityUtils

/**
 * Generated by the Shiro plugin. This filters class protects all URLs
 * via access control by convention.
 */
class ShiroSecurityFilters {
    
    
    /**
     * Array of controller/action combinations which will be skipped from authentication
     * if the controller and action names match. The action value can also be '*' if it
     * encompasses all actions within the controller.
     */
    static nonAuthenticatedActions = [
            [ controller: 'home', action: 'index' ]
    ]

    /**
    * Array of controller/action combinations that will be authenticated against the user's
    * role. The map also includes the roles which the controller/action pair will match
    * against.
    */
    static authenticatedActions = [
        [ controller: 'shiroUser', action: '*', roles: [ 'ROLE_ADMIN' ] ],
        [ controller: 'shiroRole', action: '*', roles: [ 'ROLE_ADMIN' ] ],
        [ controller: 'home', action: 'secured', roles: [ 'ROLE_ADMIN', 'ROLE_USER' ] ],
        [ controller: 'home', action: 'admin', roles: [ 'ROLE_ADMIN' ] ],
        [ controller: 'box', action: '*', roles: [ 'ROLE_USER' ] ],
        [ controller: 'movie', action: 'create', roles: [ 'ROLE_ADMIN' ] ],
        [ controller: 'movie', action: 'edit', roles: [ 'ROLE_ADMIN' ] ]
        // http://localhost:8080/shiro004/movie/edit/5
    ]

    def filters = {

        all( controller: '*', action: '*' ) {
            before = {

                // Determine if the controller/action belongs is not to be authenticated
                def needsAuth = !nonAuthenticatedActions.find {
                    ( it.controller == controllerName ) && ( ( it.action == '*' ) || ( it.action == actionName ) )
                }

                if ( needsAuth ) {

                    // Get the map within the authenticated actions which pertain to the current controller and view.
                    def authRoles = authenticatedActions.find {
                        ( it.controller == controllerName ) && ( ( it.action == '*' ) || ( it.action == actionName ) )
                    }
                    if ( controllerName != "assets" ) {
                        println "In ${controllerName}/${actionName}, and is authRoles true: ${authRoles}"
                    }
                    if ( authRoles ) {
                        // Perform the access control for each of the roles provided in the authRoles
                        /* // ORIG
                        accessControl {
                            authRoles.roles.each { roleName ->
                                // print "roleName: ${roleName}; "
                                role( roleName )
                            }
                            // println "; done with Perform the access control for each of the roles provided in the authRoles"
                        }
                        */
                        authRoles.roles.each { roleName ->
                            print "roleName: ${roleName}; "
                            accessControl{ role( roleName ) }
                        }
                    } else { // Skip authentication if the authRoles was not found
                        if ( controllerName != "assets" ) {
                            println "Skip authentication if the authRoles was not found in controllerName ${controllerName} and action ${actionName}"
                        }
                        return true
                    }
                } else { // Skip authentication if no auth is needed
                    if ( controllerName != "assets" ) {
                        println "Skip authentication if no auth is needed in controllerName ${controllerName} and action ${actionName}"
                    }
                    return true
                }
            }
        } // line 73
        
        /*
        def requiresPermissions = [
            movie: [ "create", "edit", "save", "update" ] as Set,
            pluginTab: [ "editWikiPage" ],
            tutorial: [ "create", "edit", "save", "update" ] as Set,
            screencast: [ "create", "edit", "save", "update" ] as Set,
            webSite: [ "create", "edit", "save", "update" ] as Set,
            likeDislike: [ "like", "dislike" ] as Set
        ]
       
        withPermissions( controller: "*", action: "*" ) {
            before = {
                println "in withPermissions: actionName: ${actionName}, controllerName: ${controllerName}, requiresPermissions[ controllerName ]: ${requiresPermissions[ controllerName ]} "
                if ( actionName != null && ( actionName in requiresPermissions[ controllerName ] ) ) {
                    println "calling accessControl in withPermissions"
                    accessControl()
                } else {
                    println "returning true from withPermissions"
                    return true
                }
            }
        }
        
        // get the index page
        all( uri: "/**" ) {
            before = {
                // Ignore direct views (e.g. the default main index page).
                if ( !controllerName ) {
                    println "returning true from all filter"
                    return true
                }
                
            }
        }
        


        newsViewing(controller:'newsItem', action:"create") {
            before = {
                accessControl {
                    role("Editor") || role("Administrator")
                }
            }
        }
        newsViewing(controller:'newsItem', action:"edit") {
            before = {
                accessControl {
                    role("Administrator") || permission("news:edit:${params.id}")
                }
            }
        }
        // Ensure that all controllers and actions require an authenticated user,
        
        // Creating, modifying, or deleting a book requires the "Administrator" role.
        wikiEditing(controller: "(content|news)", action: "(editNews|createNews|markupWikiPage|editWikiPage|createWikiPage|saveWikiPage|editPlugin|updatePlugin|createPlugin|addTag|removeTag)") {
            before = {
                accessControl {
                    role("Editor") || role("Administrator")
                }
            }
        }

        wikiEditing(controller: "plugin", action: "(editPlugin|updatePlugin)") {
            before = {
                accessControl {
                    role("Administrator") || permission("plugin:edit:${params.id}")
                }
            }
        }


        // used by wiki pages and testimonials
        wikiImageShow(controller: "content", action: "showImage") {
            before = {
               return true
            }
        }
        wikiImageUpload(controller: "content", action: "(uploadImage|addImage)") {
            before = {
                accessControl { true }
            }
        }

        jobPosting(controller:"(job|paypal)", action:"(delete|edit|update|editJobs|save|create|buy|success|cancel)") {
            before = {
                accessControl {
                    role("Editor") || role("Administrator")
                }
            }
        }
        wikiManagement(controller:"content", action:"rollbackWikiVersion") {
            before = {
                accessControl {
                    role("Administrator")
                }
            }
        }
        userProfile(controller:"user", action:"profile") {
            before = {
                accessControl {
                    role("Editor") || role("Administrator")
                }
            }
        }
        comments(controller:"commentable", action:"add") {
            before = {
                accessControl { true }
            }
        }
        pluginSubmitting(controller:"plugin", action: "submitPlugin") {
            before = {
                accessControl { true }
            }
        }
        pluginPublishing(controller:"repository", action:"publish") {
            before = {
                accessControl { permission "plugin:publish:${params.plugin}" }
            }
        }
        screencasts(controller:"screencast", action:"(edit|create|save|update)") {
            before = {
                accessControl { true }
            }
        }
        blogPosting(controller:"blog", action:"(createEntry|editEntry)") {
            before = {
                accessControl { true }
            }
        }
        blogDeletion(controller:"blog", action:"delete") {
            before = {
                accessControl {
                    role("Administrator")
                }
            }
        }

        pluginDeletion(controller:"plugin", action:"deletePlugin") {
            before = {
                accessControl {
                    role("Administrator")
                }
            }
        }

        pluginActivities(controller:"(tag|plugin|rateable)", action:"(update|postComment|rate|addTag|removeTag)") {
            before = {
                accessControl {
                    role("Editor") || role("Administrator")
                }
            }
        }

        testimonialSubmitting(controller: "testimonial", action: "(create|save)") {
            before = {
                accessControl { true }
            }
        }

        testimonialEditing(controller: "testimonial", action: "edit") {
            before = {
                accessControl()
            }
        }

        adminArea(uri:"/admin/**") {
            before = {
                if (controllerName == "error") return true

                accessControl {
                    role("Administrator")
                }
            }
        }
        
        userInRequest(controller:"*", action:"*") {
            before = {
                if (controllerName == "error") return true

                def subject = SecurityUtils.getSubject()
                if (subject?.principal) {
                    request.user = userService.getUserFromPrincipal(subject.principal)
                }
            }
        }
        */

    } // end filters closure


}
