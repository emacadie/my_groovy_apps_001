
<%@ page import="info.shelfunit.Album" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'album.label', default: 'Album')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-album" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-album" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list album">
			
				<g:if test="${albumInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="album.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${albumInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.artist}">
				<li class="fieldcontain">
					<span id="artist-label" class="property-label"><g:message code="album.artist.label" default="Artist" /></span>
					
						<span class="property-value" aria-labelledby="artist-label"><g:fieldValue bean="${albumInstance}" field="artist"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.year}">
				<li class="fieldcontain">
					<span id="year-label" class="property-label"><g:message code="album.year.label" default="Year" /></span>
					
						<span class="property-value" aria-labelledby="year-label"><g:fieldValue bean="${albumInstance}" field="year"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.numberOfTracks}">
				<li class="fieldcontain">
					<span id="numberOfTracks-label" class="property-label"><g:message code="album.numberOfTracks.label" default="Number Of Tracks" /></span>
					
						<span class="property-value" aria-labelledby="numberOfTracks-label"><g:fieldValue bean="${albumInstance}" field="numberOfTracks"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${albumInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="album.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="secUser" action="show" id="${albumInstance?.owner?.id}">${albumInstance?.owner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:albumInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${albumInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
