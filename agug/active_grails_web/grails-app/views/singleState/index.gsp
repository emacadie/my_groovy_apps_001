
<%@ page import="info.shelfunit.activejdbc.SingleState" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'singleState.label', default: 'SingleState')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-singleState" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-singleState" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'singleState.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="largestCity" title="${message(code: 'singleState.largestCity.label', default: 'Largest City')}" />
					
						<g:sortableColumn property="capitalCity" title="${message(code: 'singleState.capitalCity.label', default: 'Capital City')}" />
					
						<g:sortableColumn property="population" title="${message(code: 'singleState.population.label', default: 'Population')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${singleStateInstanceList}" status="i" var="singleStateInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${singleStateInstance.id}">${fieldValue(bean: singleStateInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: singleStateInstance, field: "largestCity")}</td>
					
						<td>${fieldValue(bean: singleStateInstance, field: "capitalCity")}</td>
					
						<td>${fieldValue(bean: singleStateInstance, field: "population")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${singleStateInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
