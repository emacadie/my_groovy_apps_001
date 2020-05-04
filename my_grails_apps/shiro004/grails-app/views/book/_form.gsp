<%@ page import="info.shelfunit.misc.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="book.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${bookInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="book.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="author" required="" value="${bookInstance?.author}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'pages', 'error')} required">
	<label for="pages">
		<g:message code="book.pages.label" default="Pages" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="pages" type="number" value="${bookInstance.pages}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'summary', 'error')} required">
	<label for="summary">
		<g:message code="book.summary.label" default="Summary" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="summary" required="" value="${bookInstance?.summary}"/>

</div>

