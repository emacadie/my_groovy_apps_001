<%@ page import="info.shelfunit.constraints.MinClass" %>



<div class="fieldcontain ${hasErrors(bean: minClassInstance, field: 'firstIntField', 'error')} required">
	<label for="firstIntField">
		<g:message code="minClass.firstIntField.label" default="First Int Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="firstIntField" type="number" min="10" value="${minClassInstance.firstIntField}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: minClassInstance, field: 'firstFloatField', 'error')} required">
	<label for="firstFloatField">
		<g:message code="minClass.firstFloatField.label" default="First Float Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="firstFloatField" value="${fieldValue(bean: minClassInstance, field: 'firstFloatField')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: minClassInstance, field: 'firstDateField', 'error')} required">
	<label for="firstDateField">
		<g:message code="minClass.firstDateField.label" default="First Date Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="firstDateField" precision="day"  value="${minClassInstance?.firstDateField}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: minClassInstance, field: 'secondDateField', 'error')} required">
	<label for="secondDateField">
		<g:message code="minClass.secondDateField.label" default="Second Date Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="secondDateField" precision="day"  value="${minClassInstance?.secondDateField}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: minClassInstance, field: 'secondFloatField', 'error')} required">
	<label for="secondFloatField">
		<g:message code="minClass.secondFloatField.label" default="Second Float Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="secondFloatField" value="${fieldValue(bean: minClassInstance, field: 'secondFloatField')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: minClassInstance, field: 'secondIntField', 'error')} required">
	<label for="secondIntField">
		<g:message code="minClass.secondIntField.label" default="Second Int Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="secondIntField" type="number" value="${minClassInstance.secondIntField}" required=""/>
</div>

