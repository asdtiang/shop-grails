// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    appenders {
		console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
	}

	info  appenders:'org.codehaus.groovy.grails.web.servlet',        // controllers
			'org.codehaus.groovy.grails.web.pages',          // GSP
			'org.codehaus.groovy.grails.web.sitemesh',       // layouts
			'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
			'org.codehaus.groovy.grails.web.mapping',        // URL mapping
			'org.codehaus.groovy.grails.commons',            // core / classloading
			'org.codehaus.groovy.grails.plugins',            // plugins
			'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
			'org.springframework',
			'org.hibernate',
			'net.sf.ehcache.hibernate'
	root { info() }
}

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'org.asdtiang.shop.auth.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'org.asdtiang.shop.auth.UserRole'
grails.plugins.springsecurity.authority.className = 'org.asdtiang.shop.auth.Role'
grails.plugins.springsecurity.requestMap.className = 'org.asdtiang.shop.auth.Requestmap'
grails.plugins.springsecurity.securityConfigType = 'Requestmap'
grails.plugins.springsecurity.ui.password.validationRegex="\\S{6,64}"

/** error messages */
grails.plugins.springsecurity.errors.login.disabled = "对不起，用户已经被禁止！"
grails.plugins.springsecurity.errors.login.expired = "对不起，用户已经 过期！"
grails.plugins.springsecurity.errors.login.passwordExpired = "对不起，密码已经过期！"
grails.plugins.springsecurity.errors.login.locked = "对不起，用户被锁定！"
grails.plugins.springsecurity.errors.login.fail = "用户名或者密码不正确！"

// successHandler
grails.plugins.springsecurity.successHandler.defaultTargetUrl = '/login/loginAfter'
grails.plugins.springsecurity.successHandler.alwaysUseDefault = false
grails.plugins.springsecurity.successHandler.useReferer = false
grails.plugins.springsecurity.successHandler.ajaxSuccessUrl = '/login/ajaxSuccess'
grails {
	mail {
		host = "smtp.sina.com"
		port = 25
		username = "asdtiang@sina.com"
		password = "asdtiangmail2011"
		props = ["mail.smtp.auth":"true" ]
	}
}
grails.plugins.springsecurity.ui.register.emailBody='''\
Hi $user.username,<br/>
<br/>
You (or someone pretending to be you) created an account with this email address.<br/>
<br/>
If you made the request, please click&nbsp;<a href="$url">here</a> to finish the registration.
'''
grails.plugins.springsecurity.ui.register.emailFrom="sjzadmin@asdtiang.org"
grails.plugins.springsecurity.ui.register.emailSubject="register ok"
grails.plugins.springsecurity.ui.register.defaultRoleNames=['ROLE_USER']
grails.plugins.springsecurity.ui.register.postRegisterUrl=null
grails.plugins.springsecurity.ui.forgotPassword.emailBody='''\
Hi $user.username,<br/>
<br/>
You (or someone pretending to be you) requested that your password be reset.<br/>
<br/>
If you didn't make this request then ignore the email; no changes have been made.<br/>
<br/>
If you did make the request, then click <a href="$url">here</a> to reset your password.

重置密码请求
'''
grails.plugins.springsecurity.ui.forgotPassword.emailFrom="sjzadmin@asdtiang.org"
grails.plugins.springsecurity.ui.forgotPassword.emailSubject='重置密码'
grails.plugins.springsecurity.ui.forgotPassword.postResetUrl=null

ckeditor {
	config = "/js/ckeditorConfig.js"
	skipAllowedItemsCheck = false
	defaultFileBrowser = "ofm"
	upload {
		basedir = "/uploads/"
			overwrite = false
			link {
				browser = true
				upload = false
				allowed = []
				denied = ['html', 'htm', 'php', 'php2', 'php3', 'php4', 'php5',
						  'phtml', 'pwml', 'inc', 'asp', 'aspx', 'ascx', 'jsp',
						  'cfm', 'cfc', 'pl', 'bat', 'exe', 'com', 'dll', 'vbs', 'js', 'reg',
						  'cgi', 'htaccess', 'asis', 'sh', 'shtml', 'shtm', 'phtm']
			}
			image {
				browser = true
				upload = true
				allowed = ['jpg', 'gif', 'jpeg', 'png']
				denied = []
			}
			flash {
				browser = false
				upload = false
				allowed = ['swf']
				denied = []
			}
	}
}

