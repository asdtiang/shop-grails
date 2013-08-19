
<%@ page import="org.asdtiang.site.config.ConfigDomain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'configDomain.label', default: 'ConfigDomain')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-configDomain" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-configDomain" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'configDomain.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="mapName" title="${message(code: 'configDomain.mapName.label', default: 'Map Name')}" />
					
						<g:sortableColumn property="mapValue" title="${message(code: 'configDomain.mapValue.label', default: 'Map Value')}" />
					
						<th><g:message code="configDomain.valueType.label" default="Value Type" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${configDomainInstanceList}" status="i" var="configDomainInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${configDomainInstance.id}">${fieldValue(bean: configDomainInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: configDomainInstance, field: "mapName")}</td>
					
						<td>${fieldValue(bean: configDomainInstance, field: "mapValue")}</td>
					
						<td>${fieldValue(bean: configDomainInstance, field: "valueType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${configDomainInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
