
<%@ page import="info.shelfunit.activejdbc.Book" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-book" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<%--  <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li> --%>
			</ul>
		</div>
		<div id="list-book" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'book.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="summary" title="${message(code: 'book.summary.label', default: 'Summary')}" />
					
						<g:sortableColumn property="yearPublished" title="${message(code: 'book.yearPublished.label', default: 'Year Published')}" />
					
						<g:sortableColumn property="numberOfPages" title="${message(code: 'book.numberOfPages.label', default: 'Number Of Pages')}" />
					
						<th><g:message code="book.author.label" default="Author" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bookInstanceList}" status="i" var="bookInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bookInstance.id}">${fieldValue(bean: bookInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: bookInstance, field: "summary")}</td>
					
						<td>${bookInstance.yearPublished}</td>
					
						<td>${fieldValue(bean: bookInstance, field: "numberOfPages")}</td>
					
						<td>${bookInstance.author.firstName} ${bookInstance.author.lastName}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bookInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
