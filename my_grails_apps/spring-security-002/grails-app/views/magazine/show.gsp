
<%@ page import="info.shelfunit.Magazine" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'magazine.label', default: 'Magazine')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-magazine" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-magazine" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list magazine">
			
				<g:if test="${magazineInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="magazine.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${magazineInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${magazineInstance?.topic}">
				<li class="fieldcontain">
					<span id="topic-label" class="property-label"><g:message code="magazine.topic.label" default="Topic" /></span>
					
						<span class="property-value" aria-labelledby="topic-label"><g:fieldValue bean="${magazineInstance}" field="topic"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${magazineInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="magazine.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="secUser" action="show" id="${magazineInstance?.owner?.id}">${magazineInstance?.owner?.username}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			
			<g:if test="${magazineInstance?.owner?.id == currentLoggedInUser?.id}">
                <g:form url="[resource:magazineInstance, action:'delete']" method="DELETE">
                    <fieldset class="buttons">
                        <g:link class="edit" action="edit" resource="${magazineInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                        <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </fieldset>
                </g:form>
			</g:if>
			
		</div>
	</body>
</html>

