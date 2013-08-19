<%@ page import="org.asdtiang.site.config.ConfigDomain" %>



<div class="fieldcontain ${hasErrors(bean: configDomainInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="configDomain.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${configDomainInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: configDomainInstance, field: 'mapName', 'error')} ">
	<label for="mapName">
		<g:message code="configDomain.mapName.label" default="Map Name" />
		
	</label>
	<g:textField name="mapName" value="${configDomainInstance?.mapName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: configDomainInstance, field: 'mapValue', 'error')} ">
	<label for="mapValue">
		<g:message code="configDomain.mapValue.label" default="Map Value" />
		
	</label>
	<g:textField name="mapValue" value="${configDomainInstance?.mapValue}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: configDomainInstance, field: 'valueType', 'error')} required">
	<label for="valueType">
		<g:message code="configDomain.valueType.label" default="Value Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="valueType" name="valueType.id" from="${org.asdtiang.site.config.ValueType.list()}" optionKey="id" required="" value="${configDomainInstance?.valueType?.id}" class="many-to-one"/>
</div>

