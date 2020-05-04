<%@ page import="info.shelfunit.constraints.UniqueClass" %>



<div class="fieldcontain ${hasErrors(bean: uniqueClassInstance, field: 'firstString', 'error')} ">
	<label for="firstString">
		<g:message code="uniqueClass.firstString.label" default="First String" />
		
	</label>
	<g:textField name="firstString" value="${uniqueClassInstance?.firstString}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: uniqueClassInstance, field: 'firstInt', 'error')} required">
	<label for="firstInt">
		<g:message code="uniqueClass.firstInt.label" default="First Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="firstInt" type="number" value="${uniqueClassInstance.firstInt}" required=""/>
</div>

