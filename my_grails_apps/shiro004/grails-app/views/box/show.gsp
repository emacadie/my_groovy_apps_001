
<%@ page import="info.shelfunit.misc.Box" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'box.label', default: 'Box')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-box" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-box" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list box">
			
				<g:if test="${boxInstance?.color}">
				<li class="fieldcontain">
					<span id="color-label" class="property-label"><g:message code="box.color.label" default="Color" /></span>
					
						<span class="property-value" aria-labelledby="color-label"><g:fieldValue bean="${boxInstance}" field="color"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${boxInstance?.height}">
				<li class="fieldcontain">
					<span id="height-label" class="property-label"><g:message code="box.height.label" default="Height" /></span>
					
						<span class="property-value" aria-labelledby="height-label"><g:fieldValue bean="${boxInstance}" field="height"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${boxInstance?.length}">
				<li class="fieldcontain">
					<span id="length-label" class="property-label"><g:message code="box.length.label" default="Length" /></span>
					
						<span class="property-value" aria-labelledby="length-label"><g:fieldValue bean="${boxInstance}" field="length"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${boxInstance?.label}">
				<li class="fieldcontain">
					<span id="label-label" class="property-label"><g:message code="box.label.label" default="Label" /></span>
					
						<span class="property-value" aria-labelledby="label-label"><g:fieldValue bean="${boxInstance}" field="label"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:boxInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${boxInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
