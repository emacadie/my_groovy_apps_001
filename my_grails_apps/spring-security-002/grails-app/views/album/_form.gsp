<%@ page import="info.shelfunit.Album" %>



<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="album.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${albumInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'artist', 'error')} required">
	<label for="artist">
		<g:message code="album.artist.label" default="Artist" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="artist" required="" value="${albumInstance?.artist}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="album.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" value="${albumInstance.year}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'numberOfTracks', 'error')} required">
	<label for="numberOfTracks">
		<g:message code="album.numberOfTracks.label" default="Number Of Tracks" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numberOfTracks" type="number" value="${albumInstance.numberOfTracks}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: albumInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="album.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${info.shelfunit.SecUser.list()}" optionKey="id" required="" value="${albumInstance?.owner?.id}" class="many-to-one"/>

</div>

