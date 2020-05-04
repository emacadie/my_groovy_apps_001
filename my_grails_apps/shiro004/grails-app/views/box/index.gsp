
<%@ page import="info.shelfunit.misc.Box" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'box.label', default: 'Box')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-box" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-box" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="color" title="${message(code: 'box.color.label', default: 'Color')}" />
					
						<g:sortableColumn property="height" title="${message(code: 'box.height.label', default: 'Height')}" />
					
						<g:sortableColumn property="length" title="${message(code: 'box.length.label', default: 'Length')}" />
					
						<g:sortableColumn property="label" title="${message(code: 'box.label.label', default: 'Label')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${boxInstanceList}" status="i" var="boxInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${boxInstance.id}">${fieldValue(bean: boxInstance, field: "color")}</g:link></td>
					
						<td>${fieldValue(bean: boxInstance, field: "height")}</td>
					
						<td>${fieldValue(bean: boxInstance, field: "length")}</td>
					
						<td>${fieldValue(bean: boxInstance, field: "label")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${boxInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
