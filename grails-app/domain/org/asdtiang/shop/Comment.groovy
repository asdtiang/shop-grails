package org.asdtiang.shop

import org.asdtiang.grails.annotation.Title
import org.asdtiang.shop.product.Product

@Title("评论")
class Comment {
	@Title("名称")
	String name
	@Title("评论")
	String content
	@Title("产品")
	Product product
	static mapping = {
		content(type:"text")
	}
    static constraints = {
        content maxSize: 1000
    }
}
