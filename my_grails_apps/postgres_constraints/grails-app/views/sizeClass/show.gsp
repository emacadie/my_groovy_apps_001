
<%@ page import="info.shelfunit.constraints.SizeClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sizeClass.label', default: 'SizeClass')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-sizeClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sizeClass" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list sizeClass">
			
				<g:if test="${sizeClassInstance?.firstString}">
				<li class="fieldcontain">
					<span id="firstString-label" class="property-label"><g:message code="sizeClass.firstString.label" default="First String" /></span>
					
						<span class="property-value" aria-labelledby="firstString-label"><g:fieldValue bean="${sizeClassInstance}" field="firstString"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sizeClassInstance?.firstInt}">
				<li class="fieldcontain">
					<span id="firstInt-label" class="property-label"><g:message code="sizeClass.firstInt.label" default="First Int" /></span>
					
						<span class="property-value" aria-labelledby="firstInt-label"><g:fieldValue bean="${sizeClassInstance}" field="firstInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sizeClassInstance?.uniqueClasses}">
				<li class="fieldcontain">
					<span id="uniqueClasses-label" class="property-label"><g:message code="sizeClass.uniqueClasses.label" default="Unique Classes" /></span>
					
						<g:each in="${sizeClassInstance.uniqueClasses}" var="u">
						<span class="property-value" aria-labelledby="uniqueClasses-label"><g:link controller="uniqueClass" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:sizeClassInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${sizeClassInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
