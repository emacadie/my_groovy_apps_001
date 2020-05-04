<%@ page import="info.shelfunit.misc.Movie" %>



<div class="fieldcontain ${hasErrors(bean: movieInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="movie.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="30" required="" value="${movieInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: movieInstance, field: 'summary', 'error')} required">
	<label for="summary">
		<g:message code="movie.summary.label" default="Summary" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="summary" cols="40" rows="5" maxlength="500" required="" value="${movieInstance?.summary}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: movieInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="movie.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" min="1900" value="${movieInstance.year}" required=""/>

</div>

