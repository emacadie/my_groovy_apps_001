dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    // dialect = "org.hibernate.dialect.PostgreSQLDialect"
    dialect = "com.burtbeckwith.TableNameSequencePostgresDialect"
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
          dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
          url = "jdbc:postgresql://localhost:5432/active_gw_dev_001" // ?useUnicode=yes&characterEncoding=UTF-8"
          username = "active_gwudev"
          password = "active-grails-12"
          
        }
    }
    test {
        dataSource {
            dbCreate = "create-drop" // "update"
            url = "jdbc:mysql://localhost:3306/collab_todo_test"
            username = "collab-tst-admin"
            password = "test-word-to-pass"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=false
               validationQuery="SELECT 1"
               jdbcInterceptors="ConnectionState"
            }
        }
    }
}


