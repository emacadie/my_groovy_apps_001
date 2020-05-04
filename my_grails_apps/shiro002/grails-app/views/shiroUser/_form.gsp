<%@ page import="info.shelfunit.shiro.ShiroUser" %>



<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="shiroUser.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" maxlength="20" required="" value="${shiroUserInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="shiroUser.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${shiroUserInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="shiroUser.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${shiroUserInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="shiroUser.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${shiroUserInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'permissions', 'error')} ">
	<label for="permissions">
		<g:message code="shiroUser.permissions.label" default="Permissions" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'roles', 'error')} ">
	<label for="roles">
		<g:message code="shiroUser.roles.label" default="Roles" />
		
	</label>
	<g:select name="roles" from="${info.shelfunit.shiro.ShiroRole.list()}" multiple="multiple" optionKey="id" size="5" value="${shiroUserInstance?.roles*.id}" class="many-to-many"/>

</div>

