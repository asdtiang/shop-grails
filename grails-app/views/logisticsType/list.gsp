
<%@ page import="org.asdtiang.shop.logistics.LogisticsType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logisticsType.label', default: 'LogisticsType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-logisticsType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-logisticsType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="searchUrl" title="${message(code: 'logisticsType.searchUrl.label', default: 'Search Url')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'logisticsType.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="tagCode" title="${message(code: 'logisticsType.tagCode.label', default: 'Tag Code')}" />
					
						<g:sortableColumn property="tel" title="${message(code: 'logisticsType.tel.label', default: 'Tel')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${logisticsTypeInstanceList}" status="i" var="logisticsTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${logisticsTypeInstance.id}">${fieldValue(bean: logisticsTypeInstance, field: "searchUrl")}</g:link></td>
					
						<td>${fieldValue(bean: logisticsTypeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: logisticsTypeInstance, field: "tagCode")}</td>
					
						<td>${fieldValue(bean: logisticsTypeInstance, field: "tel")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${logisticsTypeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
