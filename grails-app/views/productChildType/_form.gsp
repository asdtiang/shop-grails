<%@ page import="org.asdtiang.shop.product.ProductChildType" %>



<div class="fieldcontain ${hasErrors(bean: productChildTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="productChildType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${productChildTypeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productChildTypeInstance, field: 'note', 'error')} ">
	<label for="note">
		<g:message code="productChildType.note.label" default="Note" />
		
	</label>
	<g:textField name="note" value="${productChildTypeInstance?.note}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productChildTypeInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="productChildType.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: productChildTypeInstance, field: 'price')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: productChildTypeInstance, field: 'productStatus', 'error')} required">
	<label for="productStatus">
		<g:message code="productChildType.productStatus.label" default="Product Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="productStatus" from="${org.asdtiang.shop.ProductStatus?.values()}" keys="${org.asdtiang.shop.ProductStatus.values()*.name()}" required="" value="${productChildTypeInstance?.productStatus?.name()}"/>
</div>

