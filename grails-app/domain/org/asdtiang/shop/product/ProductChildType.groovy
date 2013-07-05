package org.asdtiang.shop.product

import org.asdtiang.grails.annotation.Title


@Title("产品子类型")
class ProductChildType {
	@Title("子类型名称")
	String name
	@Title("价格")
	Double price
	@Title("注释")
	String note
	static mapping = {
		note(type:"text")
	}
}
