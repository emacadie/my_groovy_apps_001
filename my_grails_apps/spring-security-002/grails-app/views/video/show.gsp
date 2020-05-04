
<%@ page import="info.shelfunit.Video" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'video.label', default: 'Video')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-video" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-video" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list video">
			
				<g:if test="${videoInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="video.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${videoInstance}" field="author"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="video.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${videoInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.minutes}">
				<li class="fieldcontain">
					<span id="minutes-label" class="property-label"><g:message code="video.minutes.label" default="Minutes" /></span>
					
						<span class="property-value" aria-labelledby="minutes-label"><g:fieldValue bean="${videoInstance}" field="minutes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${videoInstance?.seconds}">
				<li class="fieldcontain">
					<span id="seconds-label" class="property-label"><g:message code="video.seconds.label" default="Seconds" /></span>
					
						<span class="property-value" aria-labelledby="seconds-label"><g:fieldValue bean="${videoInstance}" field="seconds"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:videoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${videoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
