
<div id="menu">
    <nobr>
    <sec:ifLoggedIn>
Welcome Back, <sec:loggedInUserInfo field="username" /> - To logout, <g:link controller="logout" method="post">click here</g:link>
</sec:ifLoggedIn>
 <%--  (<g:link controller='logout'>Logout</g:link>) 
 <g:link controller="logout" method="post">
        <g:if test="${session.person}">
            <b>${session.person?.firstName} ${session.person?.lastName}</b> |
            <%--  <g:link controller="logout"><g:message code="topbar.logout" /></g:link> --%>
            <%--  
            <g:link controller="person" action="logout"><g:message code="topbar.logout" /></g:link>
        </g:if>
        <g:else>
            
            <g:link controller="person" action="login">
            <g:message code="topbar.login" /></g:link>
        </g:else>
         --%>
        
    </nobr>
</div>

