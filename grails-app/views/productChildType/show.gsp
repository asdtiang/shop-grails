
<%@ page import="org.asdtiang.shop.product.ProductChildType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productChildType.label', default: 'ProductChildType')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-productChildType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-productChildType" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list productChildType">
			
				<g:if test="${productChildTypeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="productChildType.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${productChildTypeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productChildTypeInstance?.note}">
				<li class="fieldcontain">
					<span id="note-label" class="property-label"><g:message code="productChildType.note.label" default="Note" /></span>
					
						<span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${productChildTypeInstance}" field="note"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productChildTypeInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="productChildType.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${productChildTypeInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productChildTypeInstance?.productStatus}">
				<li class="fieldcontain">
					<span id="productStatus-label" class="property-label"><g:message code="productChildType.productStatus.label" default="Product Status" /></span>
					
						<span class="property-value" aria-labelledby="productStatus-label"><g:fieldValue bean="${productChildTypeInstance}" field="productStatus"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${productChildTypeInstance?.id}" />
					<g:link class="edit" action="edit" id="${productChildTypeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
