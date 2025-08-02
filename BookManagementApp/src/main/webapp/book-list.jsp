<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <h2>Books</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th>
        </tr>
        <c:forEach var="b" items="${listBook}">
            <tr>
                <td>${b.id}</td>
                <td>${b.title}</td>
                <td>${b.author}</td>
                <td>${b.price}</td>
                <td>
                    <a href="edit?id=${b.id}">Edit</a>
                    <a href="delete?id=${b.id}" onclick="return confirm('Delete this?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="new">Add Book</a>
</body>
</html>
