
<%@ page import="info.shelfunit.constraints.MinClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'minClass.label', default: 'MinClass')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-minClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-minClass" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list minClass">
			
				<g:if test="${minClassInstance?.firstIntField}">
				<li class="fieldcontain">
					<span id="firstIntField-label" class="property-label"><g:message code="minClass.firstIntField.label" default="First Int Field" /></span>
					
						<span class="property-value" aria-labelledby="firstIntField-label"><g:fieldValue bean="${minClassInstance}" field="firstIntField"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${minClassInstance?.firstFloatField}">
				<li class="fieldcontain">
					<span id="firstFloatField-label" class="property-label"><g:message code="minClass.firstFloatField.label" default="First Float Field" /></span>
					
						<span class="property-value" aria-labelledby="firstFloatField-label"><g:fieldValue bean="${minClassInstance}" field="firstFloatField"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${minClassInstance?.firstDateField}">
				<li class="fieldcontain">
					<span id="firstDateField-label" class="property-label"><g:message code="minClass.firstDateField.label" default="First Date Field" /></span>
					
						<span class="property-value" aria-labelledby="firstDateField-label"><g:formatDate date="${minClassInstance?.firstDateField}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${minClassInstance?.secondDateField}">
				<li class="fieldcontain">
					<span id="secondDateField-label" class="property-label"><g:message code="minClass.secondDateField.label" default="Second Date Field" /></span>
					
						<span class="property-value" aria-labelledby="secondDateField-label"><g:formatDate date="${minClassInstance?.secondDateField}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${minClassInstance?.secondFloatField}">
				<li class="fieldcontain">
					<span id="secondFloatField-label" class="property-label"><g:message code="minClass.secondFloatField.label" default="Second Float Field" /></span>
					
						<span class="property-value" aria-labelledby="secondFloatField-label"><g:fieldValue bean="${minClassInstance}" field="secondFloatField"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${minClassInstance?.secondIntField}">
				<li class="fieldcontain">
					<span id="secondIntField-label" class="property-label"><g:message code="minClass.secondIntField.label" default="Second Int Field" /></span>
					
						<span class="property-value" aria-labelledby="secondIntField-label"><g:fieldValue bean="${minClassInstance}" field="secondIntField"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:minClassInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${minClassInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
