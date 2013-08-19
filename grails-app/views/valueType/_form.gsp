<%@ page import="org.asdtiang.site.config.ValueType" %>



<div class="fieldcontain ${hasErrors(bean: valueTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="valueType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${valueTypeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: valueTypeInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="valueType.type.label" default="Type" />
		
	</label>
	<g:textField name="type" value="${valueTypeInstance?.type}"/>
</div>

