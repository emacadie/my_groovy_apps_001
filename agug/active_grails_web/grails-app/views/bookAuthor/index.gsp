
<%@ page import="info.shelfunit.activejdbc.BookAuthor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bookAuthor.label', default: 'BookAuthor')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bookAuthor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bookAuthor" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					    <th class="sortable">Hello</th>
					
						<g:sortableColumn property="firstName" title="${message(code: 'bookAuthor.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'bookAuthor.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="country" title="${message(code: 'bookAuthor.country.label', default: 'Country')}" />
					
						<g:sortableColumn property="yearOfBirth" title="${message(code: 'bookAuthor.yearOfBirth.label', default: 'Year Of Birth')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bookAuthorInstanceList}" status="i" var="bookAuthorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					    <td><g:link action="show" id="${bookAuthorInstance.id}">See author info</g:link></td>
						<td>${fieldValue(bean: bookAuthorInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: bookAuthorInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: bookAuthorInstance, field: "country")}</td>
					
						<td>${bookAuthorInstance.yearOfBirth}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bookAuthorInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
