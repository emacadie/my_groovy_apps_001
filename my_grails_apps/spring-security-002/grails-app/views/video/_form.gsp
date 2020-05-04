<%@ page import="info.shelfunit.Video" %>



<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="video.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="author" required="" value="${videoInstance?.author}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="video.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${videoInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'minutes', 'error')} required">
	<label for="minutes">
		<g:message code="video.minutes.label" default="Minutes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minutes" type="number" min="0" value="${videoInstance.minutes}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: videoInstance, field: 'seconds', 'error')} required">
	<label for="seconds">
		<g:message code="video.seconds.label" default="Seconds" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="seconds" type="number" min="0" value="${videoInstance.seconds}" required=""/>

</div>

