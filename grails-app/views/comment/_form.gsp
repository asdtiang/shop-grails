<%@ page import="org.asdtiang.shop.Comment" %>



<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="comment.content.label" default="Content" />
		
	</label>
	<g:textArea name="content" cols="40" rows="5" maxlength="1000" value="${commentInstance?.content}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="comment.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${commentInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="comment.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${org.asdtiang.shop.product.Product.list()}" optionKey="id" required="" value="${commentInstance?.product?.id}" class="many-to-one"/>
</div>

