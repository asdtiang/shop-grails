dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false"
            pooled = true
            loggingSql = true
            driverClassName = "com.mysql.jdbc.Driver"
            username = "root"
            password = "123"
            dialect = org.hibernate.dialect.MySQL5Dialect
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                maxWait = 10000
                validationQuery = "select 1"
                testWhileIdle = true
                timeBetweenEvictionRunsMillis = 3600000
                poolPreparedStatements = true
            }
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
