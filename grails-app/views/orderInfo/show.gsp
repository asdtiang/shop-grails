
<%@ page import="org.asdtiang.shop.OrderInfo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'orderInfo.label', default: 'OrderInfo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-orderInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-orderInfo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list orderInfo">
			
				<g:if test="${orderInfoInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="orderInfo.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${orderInfoInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="orderInfo.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${orderInfoInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="orderInfo.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${orderInfoInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.logisticsInfo}">
				<li class="fieldcontain">
					<span id="logisticsInfo-label" class="property-label"><g:message code="orderInfo.logisticsInfo.label" default="Logistics Info" /></span>
					
						<span class="property-value" aria-labelledby="logisticsInfo-label"><g:link controller="logisticsInfo" action="show" id="${orderInfoInstance?.logisticsInfo?.id}">${orderInfoInstance?.logisticsInfo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.orderJson}">
				<li class="fieldcontain">
					<span id="orderJson-label" class="property-label"><g:message code="orderInfo.orderJson.label" default="Order Json" /></span>
					
						<span class="property-value" aria-labelledby="orderJson-label"><g:fieldValue bean="${orderInfoInstance}" field="orderJson"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.orderStatus}">
				<li class="fieldcontain">
					<span id="orderStatus-label" class="property-label"><g:message code="orderInfo.orderStatus.label" default="Order Status" /></span>
					
						<span class="property-value" aria-labelledby="orderStatus-label"><g:fieldValue bean="${orderInfoInstance}" field="orderStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.postcode}">
				<li class="fieldcontain">
					<span id="postcode-label" class="property-label"><g:message code="orderInfo.postcode.label" default="Postcode" /></span>
					
						<span class="property-value" aria-labelledby="postcode-label"><g:fieldValue bean="${orderInfoInstance}" field="postcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.remark}">
				<li class="fieldcontain">
					<span id="remark-label" class="property-label"><g:message code="orderInfo.remark.label" default="Remark" /></span>
					
						<span class="property-value" aria-labelledby="remark-label"><g:fieldValue bean="${orderInfoInstance}" field="remark"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${orderInfoInstance?.tel}">
				<li class="fieldcontain">
					<span id="tel-label" class="property-label"><g:message code="orderInfo.tel.label" default="Tel" /></span>
					
						<span class="property-value" aria-labelledby="tel-label"><g:fieldValue bean="${orderInfoInstance}" field="tel"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${orderInfoInstance?.id}" />
					<g:link class="edit" action="edit" id="${orderInfoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
