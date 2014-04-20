<%@ page import="info.shelfunit.activejdbc.Book" %>



<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'summary', 'error')} ">
	<label for="summary">
		<g:message code="book.summary.label" default="Summary" />
		
	</label>
	<g:textField name="summary" value="${bookInstance?.summary}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="book.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${info.shelfunit.activejdbc.BookAuthor.list()}" optionKey="id" required="" value="${bookInstance?.author?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="book.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${bookInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'yearPublished', 'error')} required">
	<label for="yearPublished">
		<g:message code="book.yearPublished.label" default="Year Published" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="yearPublished" type="number" value="${bookInstance.yearPublished}" required=""/>
</div>

