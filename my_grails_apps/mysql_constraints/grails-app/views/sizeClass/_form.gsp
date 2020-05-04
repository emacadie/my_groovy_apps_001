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

<div class="fieldcontain ${hasErrors(bean: sizeClassInstance, field: 'maxClasses', 'error')} ">
	<label for="maxClasses">
		<g:message code="sizeClass.maxClasses.label" default="Max Classes" />
		
	</label>
	<g:select name="maxClasses" from="${info.shelfunit.constraints.MaxClass.list()}" multiple="multiple" optionKey="id" size="5" value="${sizeClassInstance?.maxClasses*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sizeClassInstance, field: 'minClasses', 'error')} ">
	<label for="minClasses">
		<g:message code="sizeClass.minClasses.label" default="Min Classes" />
		
	</label>
	<g:select name="minClasses" from="${info.shelfunit.constraints.MinClass.list()}" multiple="multiple" optionKey="id" size="5" value="${sizeClassInstance?.minClasses*.id}" class="many-to-many"/>
</div>

