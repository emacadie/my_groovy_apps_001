
<%@ page import="info.shelfunit.activejdbc.BookAuthor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bookAuthor.label', default: 'BookAuthor')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bookAuthor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bookAuthor" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bookAuthor">
			
				<g:if test="${bookAuthorInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="bookAuthor.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${bookAuthorInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bookAuthorInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="bookAuthor.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${bookAuthorInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bookAuthorInstance?.country}">
				<li class="fieldcontain">
					<span id="country-label" class="property-label"><g:message code="bookAuthor.country.label" default="Country" /></span>
					
						<span class="property-value" aria-labelledby="country-label"><g:fieldValue bean="${bookAuthorInstance}" field="country"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bookAuthorInstance?.yearOfBirth}">
				<li class="fieldcontain">
					<span id="yearOfBirth-label" class="property-label"><g:message code="bookAuthor.yearOfBirth.label" default="Year Of Birth" /></span>
					
						<span class="property-value" aria-labelledby="yearOfBirth-label">${bookAuthorInstance.yearOfBirth}
						
						</span>
					
				</li>
				</g:if>
				<g:if test="${bookAuthorInstance?.yearOfBirth}">
				<li><g:link class="create" controller="book" action="create" params="[author: bookAuthorInstance.id]">Create a book by this author</g:link></li>
				</g:if>
			
			</ol>
			<g:form url="[resource:bookAuthorInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${bookAuthorInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
