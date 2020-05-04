<%@ page import="info.shelfunit.activejdbc.BookAuthor" %>



<div class="fieldcontain ${hasErrors(bean: bookAuthorInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="bookAuthor.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${bookAuthorInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookAuthorInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="bookAuthor.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${bookAuthorInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookAuthorInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="bookAuthor.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="country" required="" value="${bookAuthorInstance?.country}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bookAuthorInstance, field: 'yearOfBirth', 'error')} required">
	<label for="yearOfBirth">
		<g:message code="bookAuthor.yearOfBirth.label" default="Year Of Birth" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="yearOfBirth" type="number" max="1994" value="${bookAuthorInstance.yearOfBirth}" required=""/>
</div>

