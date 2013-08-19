<%@ page import="org.asdtiang.shop.logistics.LogisticsInfo" %>



<div class="fieldcontain ${hasErrors(bean: logisticsInfoInstance, field: 'infoId', 'error')} ">
	<label for="infoId">
		<g:message code="logisticsInfo.infoId.label" default="Info Id" />
		
	</label>
	<g:textField name="infoId" value="${logisticsInfoInstance?.infoId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: logisticsInfoInstance, field: 'logisticsType', 'error')} required">
	<label for="logisticsType">
		<g:message code="logisticsInfo.logisticsType.label" default="Logistics Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="logisticsType" name="logisticsType.id" from="${org.asdtiang.shop.logistics.LogisticsType.list()}" optionKey="id" required="" value="${logisticsInfoInstance?.logisticsType?.id}" class="many-to-one"/>
</div>

