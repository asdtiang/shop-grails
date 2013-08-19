
<%@ page import="org.asdtiang.shop.OrderInfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'orderInfo.label', default: 'OrderInfo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-orderInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-orderInfo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="email" title="${message(code: 'orderInfo.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'orderInfo.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="address" title="${message(code: 'orderInfo.address.label', default: 'Address')}" />
					
						<th><g:message code="orderInfo.logisticsInfo.label" default="Logistics Info" /></th>
					
						<g:sortableColumn property="orderJson" title="${message(code: 'orderInfo.orderJson.label', default: 'Order Json')}" />
					
						<g:sortableColumn property="orderStatus" title="${message(code: 'orderInfo.orderStatus.label', default: 'Order Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${orderInfoInstanceList}" status="i" var="orderInfoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${orderInfoInstance.id}">${fieldValue(bean: orderInfoInstance, field: "email")}</g:link></td>
					
						<td>${fieldValue(bean: orderInfoInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: orderInfoInstance, field: "address")}</td>
					
						<td>${fieldValue(bean: orderInfoInstance, field: "logisticsInfo")}</td>
					
						<td>${fieldValue(bean: orderInfoInstance, field: "orderJson")}</td>
					
						<td>${fieldValue(bean: orderInfoInstance, field: "orderStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${orderInfoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
