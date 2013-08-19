import org.asdtiang.StaticMethod
import org.asdtiang.shop.auth.Role
import org.asdtiang.shop.auth.User
import org.asdtiang.shop.auth.UserRole
import org.asdtiang.site.config.ConfigDomain
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.asdtiang.shop.auth.AccessKey
class BootStrap {

   def springSecurityService
    def init = { servletContext ->
		springSecurityService= servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT).getBean('springSecurityService')
		createDefaultRoles()
		createDefaultUsers()
		createDefaultConfig()
		
		def configList =ConfigDomain.findAll()
		def configMap=new HashMap<String,Object>()
		configList.each {
			StaticMethod.addToConfigMap(configMap,it)
		}
		servletContext.configMap=configMap
    }
	/**
	 * 创建角色
	 * @return
	 */
	def authority = Role.findByAuthority('ROLE_ADMIN')
	private createDefaultRoles() {
		if (!Role.findByAuthority('ROLE_USER')) {
			new Role(authority: 'ROLE_USER', description: "网站会员").save(flush: true)
		}
		if (!authority) {
			authority=new Role(authority: 'ROLE_ADMIN', description: "管理员")
			authority.save(flush: true)
		}
	}
	private createDefaultUsers(){
        if(!User.findByEmail("asdtiang@qq.com")){
            def password = springSecurityService.encodePassword("shop_2013")
            def user = new User(email: "asdtiang@qq.com", username: "asdtiang",
                    password: password, accountLocked: false, enabled: true)
            if (!user.validate() || !user.save()) {
                user.errors.each { log.info it }
            }
            def userAuthority =UserRole.create(user,authority)
            if (!userAuthority.save()) {
                userAuthority.errors.each { log.info it }
            }
        }
	}
	private createDefaultConfig(){
	
		   }
    private initAccessKey(servletContext){
        def map = new HashMap()
        AccessKey.list().each {
            map.put(it.keyValue,it.id)
        }
        servletContext.accessKeyMap = map
    }
	
    def destroy = {
    }
}
