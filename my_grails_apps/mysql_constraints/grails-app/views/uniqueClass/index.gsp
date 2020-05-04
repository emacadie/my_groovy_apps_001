
<%@ page import="info.shelfunit.constraints.UniqueClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'uniqueClass.label', default: 'UniqueClass')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-uniqueClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-uniqueClass" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="firstString" title="${message(code: 'uniqueClass.firstString.label', default: 'First String')}" />
					
						<g:sortableColumn property="firstInt" title="${message(code: 'uniqueClass.firstInt.label', default: 'First Int')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${uniqueClassInstanceList}" status="i" var="uniqueClassInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${uniqueClassInstance.id}">${fieldValue(bean: uniqueClassInstance, field: "firstString")}</g:link></td>
					
						<td>${fieldValue(bean: uniqueClassInstance, field: "firstInt")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${uniqueClassInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
