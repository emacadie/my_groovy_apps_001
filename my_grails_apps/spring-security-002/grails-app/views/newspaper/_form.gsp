<%@ page import="info.shelfunit.Newspaper" %>



<div class="fieldcontain ${hasErrors(bean: newspaperInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="newspaper.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${newspaperInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: newspaperInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="newspaper.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${newspaperInstance?.name}"/>
</div>

