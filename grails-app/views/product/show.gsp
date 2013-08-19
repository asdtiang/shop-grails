
<%@ page import="org.asdtiang.shop.product.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-product" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list product">
			
				<g:if test="${productInstance?.keywords}">
				<li class="fieldcontain">
					<span id="keywords-label" class="property-label"><g:message code="product.keywords.label" default="Keywords" /></span>
					
						<span class="property-value" aria-labelledby="keywords-label"><g:fieldValue bean="${productInstance}" field="keywords"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.metaDesc}">
				<li class="fieldcontain">
					<span id="metaDesc-label" class="property-label"><g:message code="product.metaDesc.label" default="Meta Desc" /></span>
					
						<span class="property-value" aria-labelledby="metaDesc-label"><g:fieldValue bean="${productInstance}" field="metaDesc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.linkUrl}">
				<li class="fieldcontain">
					<span id="linkUrl-label" class="property-label"><g:message code="product.linkUrl.label" default="Link Url" /></span>
					
						<span class="property-value" aria-labelledby="linkUrl-label"><g:fieldValue bean="${productInstance}" field="linkUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.childTypes}">
				<li class="fieldcontain">
					<span id="childTypes-label" class="property-label"><g:message code="product.childTypes.label" default="Child Types" /></span>
					
						<g:each in="${productInstance.childTypes}" var="c">
						<span class="property-value" aria-labelledby="childTypes-label"><g:link controller="productChildType" action="show" id="${c.id}">${c?.name.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="product.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${productInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.productStatus}">
				<li class="fieldcontain">
					<span id="productStatus-label" class="property-label"><g:message code="product.productStatus.label" default="Product Status" /></span>
					
						<span class="property-value" aria-labelledby="productStatus-label"><g:fieldValue bean="${productInstance}" field="productStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productInstance?.types}">
				<li class="fieldcontain">
					<span id="types-label" class="property-label"><g:message code="product.types.label" default="Types" /></span>
					
						<g:each in="${productInstance.types}" var="t">
						<span class="property-value" aria-labelledby="types-label"><g:link controller="productType" action="show" id="${t.id}">${t?.name.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${productInstance?.id}" />
					<g:link class="edit" action="edit" id="${productInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
