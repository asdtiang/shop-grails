
<%@ page import="org.asdtiang.shop.product.ProductType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productType.label', default: 'ProductType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="productType.parentType.label" default="Parent Type" /></th>
					
						<g:sortableColumn property="keywords" title="${message(code: 'productType.keywords.label', default: 'Keywords')}" />
					
						<g:sortableColumn property="metaDesc" title="${message(code: 'productType.metaDesc.label', default: 'Meta Desc')}" />
					
						<g:sortableColumn property="linkUrl" title="${message(code: 'productType.linkUrl.label', default: 'Link Url')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'productType.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'productType.name.label', default: 'Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productTypeInstanceList}" status="i" var="productTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productTypeInstance.id}">${fieldValue(bean: productTypeInstance, field: "parentType")}</g:link></td>
					
						<td>${fieldValue(bean: productTypeInstance, field: "keywords")}</td>
					
						<td>${fieldValue(bean: productTypeInstance, field: "metaDesc")}</td>
					
						<td>${fieldValue(bean: productTypeInstance, field: "linkUrl")}</td>
					
						<td>${fieldValue(bean: productTypeInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: productTypeInstance, field: "name")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productTypeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
