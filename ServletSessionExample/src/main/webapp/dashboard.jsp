<%
    if (session == null || session.getAttribute("username") == null) {
%>
    <h3>Session expired or not logged in. <a href="login.html">Login</a></h3>
<%
    } else {
%>
    <h2>Welcome, <%= session.getAttribute("username") %></h2>
    <p>Login Time: <%= session.getAttribute("loginTime") %></p>
    <form action="logout" method="post">
        <input type="submit" value="Logout">
    </form>
<%
    }
%>
