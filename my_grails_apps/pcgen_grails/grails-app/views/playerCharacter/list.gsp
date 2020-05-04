<html>
    <body>
        <h1>PC's</h1>
        <table>
            <thead>
                <tr>
                    <td>Strength</td>
                    <td>Dexterity</td>
                    <td>Charisma</td>
                </tr>
            </thead>
            <tbody>
                <% playerCharacters.each({ pc -> %>
                <tr>
                    <td><%="${pc?.strength}"%></td>
                    <td><%="${pc?.dexterity}"%></td>
                    <td><%="${pc?.charisma}"%></td>
                </tr>
                <%})%>
            </tbody>
        </table>
    </body>
</html>
