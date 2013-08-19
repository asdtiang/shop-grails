<%@ page import="org.asdtiang.shop.logistics.LogisticsType" %>



<div class="fieldcontain ${hasErrors(bean: logisticsTypeInstance, field: 'searchUrl', 'error')} ">
	<label for="searchUrl">
		<g:message code="logisticsType.searchUrl.label" default="Search Url" />
		
	</label>
	<g:field type="url" name="searchUrl" value="${logisticsTypeInstance?.searchUrl}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: logisticsTypeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="logisticsType.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${logisticsTypeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: logisticsTypeInstance, field: 'tagCode', 'error')} ">
	<label for="tagCode">
		<g:message code="logisticsType.tagCode.label" default="Tag Code" />
		
	</label>
	<g:textField name="tagCode" value="${logisticsTypeInstance?.tagCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: logisticsTypeInstance, field: 'tel', 'error')} ">
	<label for="tel">
		<g:message code="logisticsType.tel.label" default="Tel" />
		
	</label>
	<g:textField name="tel" value="${logisticsTypeInstance?.tel}"/>
</div>

