<%@ page import="info.shelfunit.constraints.SizeClass" %>



<div class="fieldcontain ${hasErrors(bean: sizeClassInstance, field: 'firstString', 'error')} ">
	<label for="firstString">
		<g:message code="sizeClass.firstString.label" default="First String" />
		
	</label>
	<g:textField name="firstString" maxlength="15" value="${sizeClassInstance?.firstString}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sizeClassInstance, field: 'firstInt', 'error')} required">
	<label for="firstInt">
		<g:message code="sizeClass.firstInt.label" default="First Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="firstInt" type="number" value="${sizeClassInstance.firstInt}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sizeClassInstance, field: 'uniqueClasses', 'error')} ">
	<label for="uniqueClasses">
		<g:message code="sizeClass.uniqueClasses.label" default="Unique Classes" />
		
	</label>
	<g:select name="uniqueClasses" from="${info.shelfunit.constraints.UniqueClass.list()}" multiple="multiple" optionKey="id" size="5" value="${sizeClassInstance?.uniqueClasses*.id}" class="many-to-many"/>
</div>

