import org.asdtiang.StaticMethod
import org.asdtiang.shop.auth.Role
import org.asdtiang.site.config.ConfigDomain
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes

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
		
	}
	private createDefaultConfig(){
	
		   }
	
    def destroy = {
    }
}
