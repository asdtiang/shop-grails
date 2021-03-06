
<%@ page import="org.asdtiang.shop.logistics.LogisticsType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logisticsType.label', default: 'LogisticsType')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-logisticsType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-logisticsType" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list logisticsType">
			
				<g:if test="${logisticsTypeInstance?.searchUrl}">
				<li class="fieldcontain">
					<span id="searchUrl-label" class="property-label"><g:message code="logisticsType.searchUrl.label" default="Search Url" /></span>
					
						<span class="property-value" aria-labelledby="searchUrl-label"><g:fieldValue bean="${logisticsTypeInstance}" field="searchUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${logisticsTypeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="logisticsType.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${logisticsTypeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${logisticsTypeInstance?.tagCode}">
				<li class="fieldcontain">
					<span id="tagCode-label" class="property-label"><g:message code="logisticsType.tagCode.label" default="Tag Code" /></span>
					
						<span class="property-value" aria-labelledby="tagCode-label"><g:fieldValue bean="${logisticsTypeInstance}" field="tagCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${logisticsTypeInstance?.tel}">
				<li class="fieldcontain">
					<span id="tel-label" class="property-label"><g:message code="logisticsType.tel.label" default="Tel" /></span>
					
						<span class="property-value" aria-labelledby="tel-label"><g:fieldValue bean="${logisticsTypeInstance}" field="tel"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${logisticsTypeInstance?.id}" />
					<g:link class="edit" action="edit" id="${logisticsTypeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
