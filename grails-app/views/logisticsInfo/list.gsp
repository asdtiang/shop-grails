
<%@ page import="org.asdtiang.shop.logistics.LogisticsInfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'logisticsInfo.label', default: 'LogisticsInfo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-logisticsInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-logisticsInfo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="infoId" title="${message(code: 'logisticsInfo.infoId.label', default: 'Info Id')}" />
					
						<th><g:message code="logisticsInfo.logisticsType.label" default="Logistics Type" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${logisticsInfoInstanceList}" status="i" var="logisticsInfoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${logisticsInfoInstance.id}">${fieldValue(bean: logisticsInfoInstance, field: "infoId")}</g:link></td>
					
						<td>${fieldValue(bean: logisticsInfoInstance, field: "logisticsType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${logisticsInfoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
