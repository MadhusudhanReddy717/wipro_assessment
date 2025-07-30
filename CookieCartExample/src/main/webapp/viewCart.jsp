<%@ page import="jakarta.servlet.http.Cookie" %>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
%>
    <h2>Your Cart</h2>
    <ul>
<%
        for (Cookie c : cookies) {
            if (c.getName().startsWith("cart_")) {
%>
                <li><%= c.getValue() %></li>
<%
            }
        }
%>
    </ul>
<%
    } else {
%>
    <p>Your cart is empty.</p>
<%
    }
%>
