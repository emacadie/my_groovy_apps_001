<%@ page import="collab.todo.Person" %>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'personName', 'error')} required">
	<label for="personName">
		<g:message code="person.personName.label" default="Person Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="personName" required="" value="${personInstance?.personName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${personInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${personInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'categories', 'error')} ">
	<label for="categories">
		<g:message code="person.categories.label" default="Categories" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.categories?}" var="c">
    <li><g:link controller="category" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="category" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'category.label', default: 'Category')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'todos', 'error')} ">
	<label for="todos">
		<g:message code="person.todos.label" default="Todos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.todos?}" var="t">
    <li><g:link controller="todo" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="todo" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'todo.label', default: 'Todo')])}</g:link>
</li>
</ul>

</div>

