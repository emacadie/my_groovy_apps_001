<%@ page import="info.shelfunit.misc.Box" %>



<div class="fieldcontain ${hasErrors(bean: boxInstance, field: 'color', 'error')} required">
	<label for="color">
		<g:message code="box.color.label" default="Color" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="color" required="" value="${boxInstance?.color}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: boxInstance, field: 'height', 'error')} required">
	<label for="height">
		<g:message code="box.height.label" default="Height" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="height" type="number" value="${boxInstance.height}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: boxInstance, field: 'length', 'error')} required">
	<label for="length">
		<g:message code="box.length.label" default="Length" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="length" type="number" value="${boxInstance.length}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: boxInstance, field: 'label', 'error')} required">
	<label for="label">
		<g:message code="box.label.label" default="Label" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="label" required="" value="${boxInstance?.label}"/>

</div>

