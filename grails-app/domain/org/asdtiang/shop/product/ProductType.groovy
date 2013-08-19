package org.asdtiang.shop.product

import org.asdtiang.grails.annotation.Title
import org.asdtiang.shop.Seo;

@Title("产品类型")
class ProductType {
    @Title("关键字")
    String keywords
    @Title("描述")
    String metaDesc
    @Title("链接url")
    String linkUrl
	@Title("父类型")
	ProductType parentType
	@Title("类型名")
	String name
	@Title("类型描述")
	String description


	static constraints = {
		parentType nullable:true
        keywords size:1..50
        metaDesc size:1..200
        linkUrl size:1..20
	}
	static mapping = {
		description(type:"text")
	}

}
