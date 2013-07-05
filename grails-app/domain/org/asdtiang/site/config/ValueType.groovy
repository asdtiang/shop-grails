package org.asdtiang.site.config

import org.asdtiang.grails.annotation.Title

@Title("配置属性类型")
class ValueType {
	@Title("名称")
    String name
	@Title("类型标识")
	String type
    static constraints = {
    }
}
