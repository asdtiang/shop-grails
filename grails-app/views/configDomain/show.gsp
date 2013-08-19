
<%@ page import="org.asdtiang.site.config.ConfigDomain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'configDomain.label', default: 'ConfigDomain')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-configDomain" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-configDomain" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list configDomain">
			
				<g:if test="${configDomainInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="configDomain.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${configDomainInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${configDomainInstance?.mapName}">
				<li class="fieldcontain">
					<span id="mapName-label" class="property-label"><g:message code="configDomain.mapName.label" default="Map Name" /></span>
					
						<span class="property-value" aria-labelledby="mapName-label"><g:fieldValue bean="${configDomainInstance}" field="mapName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${configDomainInstance?.mapValue}">
				<li class="fieldcontain">
					<span id="mapValue-label" class="property-label"><g:message code="configDomain.mapValue.label" default="Map Value" /></span>
					
						<span class="property-value" aria-labelledby="mapValue-label"><g:fieldValue bean="${configDomainInstance}" field="mapValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${configDomainInstance?.valueType}">
				<li class="fieldcontain">
					<span id="valueType-label" class="property-label"><g:message code="configDomain.valueType.label" default="Value Type" /></span>
					
						<span class="property-value" aria-labelledby="valueType-label"><g:link controller="valueType" action="show" id="${configDomainInstance?.valueType?.id}">${configDomainInstance?.valueType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${configDomainInstance?.id}" />
					<g:link class="edit" action="edit" id="${configDomainInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
