<%@ page import="info.shelfunit.Book" %>



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

<div class="fieldcontain ${hasErrors(bean: bookInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="book.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${info.shelfunit.SecUser.list()}" optionKey="id" required="" value="${bookInstance?.owner?.id}" class="many-to-one"/>
</div>

