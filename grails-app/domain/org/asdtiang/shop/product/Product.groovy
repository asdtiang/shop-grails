package org.asdtiang.shop.product

import org.asdtiang.grails.annotation.Title
import org.asdtiang.shop.Seo
import org.asdtiang.shop.ProductStatus
@Title("产品")
class Product {
    @Title("关键字")
    String keywords
    @Title("描述")
    String metaDesc
    @Title("链接url")
    String linkUrl
	@Title("名称")
	String name
    @Title("产品状态")
    ProductStatus productStatus
    static hasMany = [childTypes: ProductChildType,types: ProductType]
    static constraints = {
        keywords size:1..50
        metaDesc size:1..200
        linkUrl size:1..20
    }
    static mapping = {
        childTypes lazy: false
        types    lazy: false
    }

}
