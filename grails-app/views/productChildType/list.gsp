
<%@ page import="org.asdtiang.shop.product.ProductChildType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productChildType.label', default: 'ProductChildType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productChildType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productChildType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'productChildType.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="note" title="${message(code: 'productChildType.note.label', default: 'Note')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'productChildType.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="productStatus" title="${message(code: 'productChildType.productStatus.label', default: 'Product Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productChildTypeInstanceList}" status="i" var="productChildTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productChildTypeInstance.id}">${fieldValue(bean: productChildTypeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: productChildTypeInstance, field: "note")}</td>
					
						<td>${fieldValue(bean: productChildTypeInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: productChildTypeInstance, field: "productStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productChildTypeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
