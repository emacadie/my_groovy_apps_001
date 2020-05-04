
<%@ page import="info.shelfunit.Magazine" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'magazine.label', default: 'Magazine')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-magazine" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<sec:ifAllGranted roles="ROLE_USER">
				    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</sec:ifAllGranted>
			</ul>
		</div>
		<div id="list-magazine" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'magazine.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="topic" title="${message(code: 'magazine.topic.label', default: 'Topic')}" />
					
						<th><g:message code="magazine.owner.label" default="Owner" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${magazineInstanceList}" status="i" var="magazineInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${magazineInstance.id}">${fieldValue(bean: magazineInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: magazineInstance, field: "topic")}</td>
					
						<td>${fieldValue(bean: magazineInstance, field: "owner.username")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${magazineInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

