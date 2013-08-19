
<%@ page import="org.asdtiang.shop.logistics.LogisticsInfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logisticsInfo.label', default: 'LogisticsInfo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-logisticsInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-logisticsInfo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list logisticsInfo">
			
				<g:if test="${logisticsInfoInstance?.infoId}">
				<li class="fieldcontain">
					<span id="infoId-label" class="property-label"><g:message code="logisticsInfo.infoId.label" default="Info Id" /></span>
					
						<span class="property-value" aria-labelledby="infoId-label"><g:fieldValue bean="${logisticsInfoInstance}" field="infoId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${logisticsInfoInstance?.logisticsType}">
				<li class="fieldcontain">
					<span id="logisticsType-label" class="property-label"><g:message code="logisticsInfo.logisticsType.label" default="Logistics Type" /></span>
					
						<span class="property-value" aria-labelledby="logisticsType-label"><g:link controller="logisticsType" action="show" id="${logisticsInfoInstance?.logisticsType?.id}">${logisticsInfoInstance?.logisticsType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${logisticsInfoInstance?.id}" />
					<g:link class="edit" action="edit" id="${logisticsInfoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
