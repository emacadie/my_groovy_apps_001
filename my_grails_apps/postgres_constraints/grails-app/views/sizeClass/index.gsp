
<%@ page import="info.shelfunit.constraints.SizeClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sizeClass.label', default: 'SizeClass')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-sizeClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-sizeClass" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="firstString" title="${message(code: 'sizeClass.firstString.label', default: 'First String')}" />
					
						<g:sortableColumn property="firstInt" title="${message(code: 'sizeClass.firstInt.label', default: 'First Int')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${sizeClassInstanceList}" status="i" var="sizeClassInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${sizeClassInstance.id}">${fieldValue(bean: sizeClassInstance, field: "firstString")}</g:link></td>
					
						<td>${fieldValue(bean: sizeClassInstance, field: "firstInt")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${sizeClassInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
