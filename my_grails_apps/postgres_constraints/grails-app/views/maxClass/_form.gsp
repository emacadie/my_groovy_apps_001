<%@ page import="info.shelfunit.constraints.MaxClass" %>



<div class="fieldcontain ${hasErrors(bean: maxClassInstance, field: 'firstIntField', 'error')} required">
	<label for="firstIntField">
		<g:message code="maxClass.firstIntField.label" default="First Int Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="firstIntField" type="number" max="1000" value="${maxClassInstance.firstIntField}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: maxClassInstance, field: 'firstFloatField', 'error')} required">
	<label for="firstFloatField">
		<g:message code="maxClass.firstFloatField.label" default="First Float Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="firstFloatField" value="${fieldValue(bean: maxClassInstance, field: 'firstFloatField')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: maxClassInstance, field: 'firstDateField', 'error')} required">
	<label for="firstDateField">
		<g:message code="maxClass.firstDateField.label" default="First Date Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="firstDateField" precision="day"  value="${maxClassInstance?.firstDateField}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: maxClassInstance, field: 'secondDateField', 'error')} required">
	<label for="secondDateField">
		<g:message code="maxClass.secondDateField.label" default="Second Date Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="secondDateField" precision="day"  value="${maxClassInstance?.secondDateField}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: maxClassInstance, field: 'secondFloatField', 'error')} required">
	<label for="secondFloatField">
		<g:message code="maxClass.secondFloatField.label" default="Second Float Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="secondFloatField" value="${fieldValue(bean: maxClassInstance, field: 'secondFloatField')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: maxClassInstance, field: 'secondIntField', 'error')} required">
	<label for="secondIntField">
		<g:message code="maxClass.secondIntField.label" default="Second Int Field" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="secondIntField" type="number" value="${maxClassInstance.secondIntField}" required=""/>
</div>

