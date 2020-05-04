
<%@ page import="info.shelfunit.Video" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'video.label', default: 'Video')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-video" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-video" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="author" title="${message(code: 'video.author.label', default: 'Author')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'video.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="minutes" title="${message(code: 'video.minutes.label', default: 'Minutes')}" />
					
						<g:sortableColumn property="seconds" title="${message(code: 'video.seconds.label', default: 'Seconds')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${videoInstanceList}" status="i" var="videoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${videoInstance.id}">${fieldValue(bean: videoInstance, field: "author")}</g:link></td>
					
						<td>${fieldValue(bean: videoInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: videoInstance, field: "minutes")}</td>
					
						<td>${fieldValue(bean: videoInstance, field: "seconds")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${videoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
