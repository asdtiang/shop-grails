<%@ page import="org.asdtiang.shop.OrderInfo" %>



<div class="fieldcontain ${hasErrors(bean: orderInfoInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="orderInfo.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${orderInfoInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInfoInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="orderInfo.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${orderInfoInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInfoInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="orderInfo.address.label" default="Address" />
		
	</label>
	<g:textField name="address" value="${orderInfoInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInfoInstance, field: 'logisticsInfo', 'error')} required">
	<label for="logisticsInfo">
		<g:message code="orderInfo.logisticsInfo.label" default="Logistics Info" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="logisticsInfo" name="logisticsInfo.id" from="${org.asdtiang.shop.logistics.LogisticsInfo.list()}" optionKey="id" required="" value="${orderInfoInstance?.logisticsInfo?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInfoInstance, field: 'orderJson', 'error')} ">
	<label for="orderJson">
		<g:message code="orderInfo.orderJson.label" default="Order Json" />
		
	</label>
	<g:textField name="orderJson" value="${orderInfoInstance?.orderJson}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInfoInstance, field: 'orderStatus', 'error')} required">
	<label for="orderStatus">
		<g:message code="orderInfo.orderStatus.label" default="Order Status" />
		<span class="required-indicator">*</span>