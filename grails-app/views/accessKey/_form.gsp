<%@ page import="org.asdtiang.shop.auth.AccessKey" %>


<div class="fieldcontain ${hasErrors(bean: accessKeyInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="accessKey.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${accessKeyInstance?.name}"/>
</div>

