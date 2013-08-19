package shop

class AccessKeyFilters {
    def springSecurityService
    def filters = {
        all(controller: '*', action: '*') {
            before = {
                if(springSecurityService.isLoggedIn()){
                      return true
                }
                else if(params.key){
                    if(servletContext.accessKeyMap.get(params.key)){
                        return true
                    }
                    else{
                        return false
                    }
                }
                else{
                    return false
                }

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
