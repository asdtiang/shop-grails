package shop

class KeyAuthFilters {
    def springSecurityService
    def accessService
    def filters = {
        all(controller:'*', action:'*',controllerExclude:'login') {
            before = {
                if(springSecurityService.isLoggedIn()){
                     return true
                }
                boolean hasRight = false
                if(params.key){
                    hasRight =accessService.authKey(params.key)
                }
                return hasRight
            }
//            after = { Map model ->
//
//            }
//            afterView = { Exception e ->
//
//            }
        }
    }
}
