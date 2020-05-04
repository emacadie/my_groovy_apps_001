
<div id="menu">
    <nobr>
        <g:if test="${session.person}">
            <b>${session.person?.firstName} ${session.person?.lastName}</b> |
            <%--  <g:link controller="logout"><g:message code="topbar.logout" /></g:link> --%>
            <g:link controller="person" action="logout"><g:message code="topbar.logout" /></g:link>
        </g:if>
        <g:else>
            
            <g:link controller="person" action="login">
            <g:message code="topbar.login" /></g:link>
        </g:else>
    </nobr>
</div>

