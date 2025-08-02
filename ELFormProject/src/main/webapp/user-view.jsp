<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>User Info</title></head>
<body>
    <h2>Submitted Details</h2>
    <p><b>Name:</b> ${user.name}</p>
    <p><b>Password:</b> ${user.pass}</p>
    <p><b>Address:</b> ${user.addr}</p>
    <p><b>Subscribed:</b> ${user.news}</p>
    <p><b>Web Frameworks:</b>
        <c:forEach var="f" items="${user.fw}">
            ${f}&nbsp;
        </c:forEach>
    </p>
    <p><b>Gender:</b> ${user.gender}</p>
    <p><b>Favorite Number:</b> ${user.num}</p>
</body>
</html>
