package org.asdtiang.grails.test

import grails.util.GrailsNameUtils

import org.asdtiang.PageUtil
import org.asdtiang.SafeProperties

class TestController {
    def asyncMailService
    def index() { }
	def testMail(){
		asyncMailService.sendSimpleEmail("asdtiang@sina.com","2227洗衣",
			"register ok",
			"""<br/>
You (or someone pretending to be you) created an account with this email address
.<br/>
<br/>
If you made the request, please click&nbsp;<a href="http://localhost:8080/higkin
g/register/verifyRegistration?t=907324e92ac74762af3f05125891efbc">here</a> to fi
nish the registration.""" ,"asdtiang@qq.com")
		render "OK!!!!"
	}
	def createMessage(){
		if (request.getMethod() == "POST" && params.className) {
			def object = PageUtil.getInstanceByName(params.className.trim())
			if(null==object){
				render "类不存在，要加包名的"
				return
			}
			def path=request.getRealPath("/")
			path=path.substring(0,path.length()-1)
			path=path.substring(0,path.lastIndexOf(File.separator))+"/grails-app/i18n/messages_zh_CN.properties"

			FileInputStream input = new FileInputStream(path);

			SafeProperties safeProp = new SafeProperties();

			safeProp.load(input);

			input.close();


			if (object) {
				def value
				def key=GrailsNameUtils.getShortName(params.className)
				key=key.charAt(0).toLowerCase().toString()+key.substring(1)+"..label"
				if(!safeProp.get(key.replace("..","."))&&object.class.getAnnotation(org.asdtiang.grails.annotation.Title)){
					safeProp.put(key.replace("..","."),object.class.getAnnotation(org.asdtiang.grails.annotation.Title).value())
				}
				def key1
				object.class.getDeclaredFields().each {
					if (it.getAnnotation(org.asdtiang.grails.annotation.Title)) {
						value = it.getAnnotation(org.asdtiang.grails.annotation.Title).value();
						key1=key.replace("..","."+it.getName()+".")
						if(!safeProp.get(key1)){
							safeProp.put(key1,value)
						}
					}
				}
			}
			FileOutputStream output = new FileOutputStream(path);
			safeProp.store( output,null)
			output.close();
		}
	}
}
