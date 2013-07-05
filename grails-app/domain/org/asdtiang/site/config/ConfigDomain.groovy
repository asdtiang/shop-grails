package org.asdtiang.shop.site

import org.asdtiang.grails.annotation.Title

@Title("网站配置")
class ConfigDomain {
    @Title("配置属性名")
    String mapName
    @Title("属性值")
    String mapValue
    @Title("描述")
    String description
    @Title("值类型")
    ValueType valueType
    static constraints = {
    }
     static mapping = {
		description(type:"text")
    }
}