<%@ page import="org.asdtiang.shop.product.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'keywords', 'error')} ">
	<label for="keywords">
		<g:message code="product.keywords.label" default="Keywords" />
		
	</label>
	<g:textField name="keywords" maxlength="50" value="${productInstance?.keywords}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'metaDesc', 'error')} ">
	<label for="metaDesc">
		<g:message code="product.metaDesc.label" default="Meta Desc" />
		
	</label>
	<g:textField name="metaDesc" maxlength="200" value="${productInstance?.metaDesc}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'linkUrl', 'error')} ">
	<label for="linkUrl">
		<g:message code="product.linkUrl.label" default="Link Url" />
		
	</label>
	<g:textField name="linkUrl" maxlength="20" value="${productInstance?.linkUrl}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'types', 'error')} ">
    <label for="types">
        <g:message code="product.types.label" default="Types" />

    </label>
    <g:select name="types" from="${org.asdtiang.shop.product.ProductType.list()}" multiple="multiple" optionKey="id" size="5" optionValue="name" value="${productInstance?.types*.id}" class="many-to-many"/>
</div>
<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'childTypes', 'error')} ">
	<label for="childTypes">
		<g:message code="product.childTypes.label" default="Child Types" />
		
	</label>
	<g:select name="childTypes" from="${org.asdtiang.shop.product.ProductChildType.list()}" multiple="multiple" optionKey="id" size="5" optionValue="name" value="${productInstance?.childTypes*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${productInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'productStatus', 'error')} required">
	<label for="productStatus">
		<g:message code="product.productStatus.label" default="Product Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="productStatus" from="${org.asdtiang.shop.ProductStatus?.values()}" keys="${org.asdtiang.shop.ProductStatus.values()*.name()}" required="" value="${productInstance?.productStatus?.name()}"/>
</div>



