
<%@ page import="info.shelfunit.constraints.MaxClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'maxClass.label', default: 'MaxClass')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-maxClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-maxClass" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="firstIntField" title="${message(code: 'maxClass.firstIntField.label', default: 'First Int Field')}" />
					
						<g:sortableColumn property="firstFloatField" title="${message(code: 'maxClass.firstFloatField.label', default: 'First Float Field')}" />
					
						<g:sortableColumn property="firstDateField" title="${message(code: 'maxClass.firstDateField.label', default: 'First Date Field')}" />
					
						<g:sortableColumn property="secondDateField" title="${message(code: 'maxClass.secondDateField.label', default: 'Second Date Field')}" />
					
						<g:sortableColumn property="secondFloatField" title="${message(code: 'maxClass.secondFloatField.label', default: 'Second Float Field')}" />
					
						<g:sortableColumn property="secondIntField" title="${message(code: 'maxClass.secondIntField.label', default: 'Second Int Field')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${maxClassInstanceList}" status="i" var="maxClassInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${maxClassInstance.id}">${fieldValue(bean: maxClassInstance, field: "firstIntField")}</g:link></td>
					
						<td>${fieldValue(bean: maxClassInstance, field: "firstFloatField")}</td>
					
						<td><g:formatDate date="${maxClassInstance.firstDateField}" /></td>
					
						<td><g:formatDate date="${maxClassInstance.secondDateField}" /></td>
					
						<td>${fieldValue(bean: maxClassInstance, field: "secondFloatField")}</td>
					
						<td>${fieldValue(bean: maxClassInstance, field: "secondIntField")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${maxClassInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
