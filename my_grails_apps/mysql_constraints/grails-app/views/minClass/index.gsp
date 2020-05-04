
<%@ page import="info.shelfunit.constraints.MinClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'minClass.label', default: 'MinClass')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-minClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-minClass" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="firstIntField" title="${message(code: 'minClass.firstIntField.label', default: 'First Int Field')}" />
					
						<g:sortableColumn property="firstFloatField" title="${message(code: 'minClass.firstFloatField.label', default: 'First Float Field')}" />
					
						<g:sortableColumn property="firstDateField" title="${message(code: 'minClass.firstDateField.label', default: 'First Date Field')}" />
					
						<g:sortableColumn property="secondDateField" title="${message(code: 'minClass.secondDateField.label', default: 'Second Date Field')}" />
					
						<g:sortableColumn property="secondFloatField" title="${message(code: 'minClass.secondFloatField.label', default: 'Second Float Field')}" />
					
						<g:sortableColumn property="secondIntField" title="${message(code: 'minClass.secondIntField.label', default: 'Second Int Field')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${minClassInstanceList}" status="i" var="minClassInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${minClassInstance.id}">${fieldValue(bean: minClassInstance, field: "firstIntField")}</g:link></td>
					
						<td>${fieldValue(bean: minClassInstance, field: "firstFloatField")}</td>
					
						<td><g:formatDate date="${minClassInstance.firstDateField}" /></td>
					
						<td><g:formatDate date="${minClassInstance.secondDateField}" /></td>
					
						<td>${fieldValue(bean: minClassInstance, field: "secondFloatField")}</td>
					
						<td>${fieldValue(bean: minClassInstance, field: "secondIntField")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${minClassInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
