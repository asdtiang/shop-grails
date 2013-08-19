<%@ page import="org.asdtiang.shop.product.ProductType" %>



<div class="fieldcontain ${hasErrors(bean: productTypeInstance, field: 'parentType', 'error')} ">
	<label for="parentType">
		<g:message code="productType.parentType.label" default="Parent Type" />
		
	</label>
	<g:select id="parentType" name="parentType.id" from="${org.asdtiang.shop.product.ProductType.list()}" optionKey="id" value="${productTypeInstance?.parentType?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productTypeInstance, field: 'keywords', 'error')} ">
	<label for="keywords">
		<g:message code="productType.keywords.label" default="Keywords" />
		
	</label>
	<g:textField name="keywords" maxlength="50" value="${productTypeInstance?.keywords}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productTypeInstance, field: 'metaDesc', 'error')} ">
	<label for="metaDesc">
		<g:message code="productType.metaDesc.label" default="Meta Desc" />
		
	</label>
	<g:textField name="metaDesc" maxlength="200" value="${productTypeInstance?.metaDesc}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productTypeInstance, field: 'linkUrl', 'error')} ">
	<label for="linkUrl">
		<g:message code="productType.linkUrl.label" default="Link Url" />
		
	</label>
	<g:textField name="linkUrl" maxlength="20" value="${productTypeInstance?.linkUrl}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productTypeInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="productType.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${productTypeInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="productType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${productTypeInstance?.name}"/>
</div>

