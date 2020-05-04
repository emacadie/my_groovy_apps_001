
<%@ page import="info.shelfunit.activejdbc.SingleState" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'singleState.label', default: 'SingleState')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-singleState" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-singleState" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list singleState">
			
				<g:if test="${singleStateInstance?.stateName}">
				<li class="fieldcontain">
					<span id="stateName-label" class="property-label"><g:message code="singleState.stateName.label" default="State Name" /></span>
					
						<span class="property-value" aria-labelledby="stateName-label"><g:fieldValue bean="${singleStateInstance}" field="stateName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${singleStateInstance?.largestCity}">
				<li class="fieldcontain">
					<span id="largestCity-label" class="property-label"><g:message code="singleState.largestCity.label" default="Largest City" /></span>
					
						<span class="property-value" aria-labelledby="largestCity-label"><g:fieldValue bean="${singleStateInstance}" field="largestCity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${singleStateInstance?.capitalCity}">
				<li class="fieldcontain">
					<span id="capitalCity-label" class="property-label"><g:message code="singleState.capitalCity.label" default="Capital City" /></span>
					
						<span class="property-value" aria-labelledby="capitalCity-label"><g:fieldValue bean="${singleStateInstance}" field="capitalCity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${singleStateInstance?.population}">
				<li class="fieldcontain">
					<span id="population-label" class="property-label"><g:message code="singleState.population.label" default="Population" /></span>
					
						<span class="property-value" aria-labelledby="population-label"><g:fieldValue bean="${singleStateInstance}" field="population"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:singleStateInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${singleStateInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
