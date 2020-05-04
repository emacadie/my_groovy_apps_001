
<%@ page import="info.shelfunit.constraints.MaxClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'maxClass.label', default: 'MaxClass')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-maxClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-maxClass" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list maxClass">
			
				<g:if test="${maxClassInstance?.firstIntField}">
				<li class="fieldcontain">
					<span id="firstIntField-label" class="property-label"><g:message code="maxClass.firstIntField.label" default="First Int Field" /></span>
					
						<span class="property-value" aria-labelledby="firstIntField-label"><g:fieldValue bean="${maxClassInstance}" field="firstIntField"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${maxClassInstance?.firstFloatField}">
				<li class="fieldcontain">
					<span id="firstFloatField-label" class="property-label"><g:message code="maxClass.firstFloatField.label" default="First Float Field" /></span>
					
						<span class="property-value" aria-labelledby="firstFloatField-label"><g:fieldValue bean="${maxClassInstance}" field="firstFloatField"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${maxClassInstance?.firstDateField}">
				<li class="fieldcontain">
					<span id="firstDateField-label" class="property-label"><g:message code="maxClass.firstDateField.label" default="First Date Field" /></span>
					
						<span class="property-value" aria-labelledby="firstDateField-label"><g:formatDate date="${maxClassInstance?.firstDateField}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${maxClassInstance?.secondDateField}">
				<li class="fieldcontain">
					<span id="secondDateField-label" class="property-label"><g:message code="maxClass.secondDateField.label" default="Second Date Field" /></span>
					
						<span class="property-value" aria-labelledby="secondDateField-label"><g:formatDate date="${maxClassInstance?.secondDateField}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${maxClassInstance?.secondFloatField}">
				<li class="fieldcontain">
					<span id="secondFloatField-label" class="property-label"><g:message code="maxClass.secondFloatField.label" default="Second Float Field" /></span>
					
						<span class="property-value" aria-labelledby="secondFloatField-label"><g:fieldValue bean="${maxClassInstance}" field="secondFloatField"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${maxClassInstance?.secondIntField}">
				<li class="fieldcontain">
					<span id="secondIntField-label" class="property-label"><g:message code="maxClass.secondIntField.label" default="Second Int Field" /></span>
					
						<span class="property-value" aria-labelledby="secondIntField-label"><g:fieldValue bean="${maxClassInstance}" field="secondIntField"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:maxClassInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${maxClassInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
