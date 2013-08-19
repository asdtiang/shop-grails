
<%@ page import="org.asdtiang.shop.product.ProductType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productType.label', default: 'ProductType')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-productType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-productType" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list productType">
			
				<g:if test="${productTypeInstance?.parentType}">
				<li class="fieldcontain">
					<span id="parentType-label" class="property-label"><g:message code="productType.parentType.label" default="Parent Type" /></span>
					
						<span class="property-value" aria-labelledby="parentType-label"><g:link controller="productType" action="show" id="${productTypeInstance?.parentType?.id}">${productTypeInstance?.parentType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${productTypeInstance?.keywords}">
				<li class="fieldcontain">
					<span id="keywords-label" class="property-label"><g:message code="productType.keywords.label" default="Keywords" /></span>
					
						<span class="property-value" aria-labelledby="keywords-label"><g:fieldValue bean="${productTypeInstance}" field="keywords"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productTypeInstance?.metaDesc}">
				<li class="fieldcontain">
					<span id="metaDesc-label" class="property-label"><g:message code="productType.metaDesc.label" default="Meta Desc" /></span>
					
						<span class="property-value" aria-labelledby="metaDesc-label"><g:fieldValue bean="${productTypeInstance}" field="metaDesc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productTypeInstance?.linkUrl}">
				<li class="fieldcontain">
					<span id="linkUrl-label" class="property-label"><g:message code="productType.linkUrl.label" default="Link Url" /></span>
					
						<span class="property-value" aria-labelledby="linkUrl-label"><g:fieldValue bean="${productTypeInstance}" field="linkUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productTypeInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="productType.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${productTypeInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productTypeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="productType.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${productTypeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${productTypeInstance?.id}" />
					<g:link class="edit" action="edit" id="${productTypeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
