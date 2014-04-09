<%@ page import="info.shelfunit.activejdbc.SingleState" %>



<div class="fieldcontain ${hasErrors(bean: singleStateInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="singleState.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${singleStateInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: singleStateInstance, field: 'largestCity', 'error')} required">
	<label for="largestCity">
		<g:message code="singleState.largestCity.label" default="Largest City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="largestCity" required="" value="${singleStateInstance?.largestCity}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: singleStateInstance, field: 'capitalCity', 'error')} required">
	<label for="capitalCity">
		<g:message code="singleState.capitalCity.label" default="Capital City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="capitalCity" required="" value="${singleStateInstance?.capitalCity}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: singleStateInstance, field: 'population', 'error')} required">
	<label for="population">
		<g:message code="singleState.population.label" default="Population" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="population" type="number" min="10000" value="${singleStateInstance.population}" required=""/>
</div>

