<%@ page import="info.shelfunit.Magazine" %>



<div class="fieldcontain ${hasErrors(bean: magazineInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="magazine.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${magazineInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: magazineInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="magazine.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="topic" required="" value="${magazineInstance?.topic}"/>
</div>
<p>currentLoggedInUser_id: ${currentLoggedInUser_id}</p>
<g:hiddenField name="owner.id2" value="${currentLoggedInUser_id}" />
<div class="fieldcontain ${hasErrors(bean: magazineInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="magazine.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${info.shelfunit.SecUser.list()}" optionKey="username" required="" value="${magazineInstance?.owner?.id}" class="many-to-one"/> <!-- I changed optionKey -->
</div>

