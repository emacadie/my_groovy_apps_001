
<%@ page import="info.shelfunit.constraints.UniqueClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'uniqueClass.label', default: 'UniqueClass')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-uniqueClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-uniqueClass" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list uniqueClass">
			
				<g:if test="${uniqueClassInstance?.firstString}">
				<li class="fieldcontain">
					<span id="firstString-label" class="property-label"><g:message code="uniqueClass.firstString.label" default="First String" /></span>
					
						<span class="property-value" aria-labelledby="firstString-label"><g:fieldValue bean="${uniqueClassInstance}" field="firstString"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${uniqueClassInstance?.firstInt}">
				<li class="fieldcontain">
					<span id="firstInt-label" class="property-label"><g:message code="uniqueClass.firstInt.label" default="First Int" /></span>
					
						<span class="property-value" aria-labelledby="firstInt-label"><g:fieldValue bean="${uniqueClassInstance}" field="firstInt"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:uniqueClassInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${uniqueClassInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
