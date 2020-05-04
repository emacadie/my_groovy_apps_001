<%@ page import="info.shelfunit.SecRole" %>



<div class="fieldcontain ${hasErrors(bean: secRoleInstance, field: 'authority', 'error')} required">
	<label for="authority">
		<g:message code="secRole.authority.label" default="Authority" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="authority" required="" value="${secRoleInstance?.authority}"/>
</div>

