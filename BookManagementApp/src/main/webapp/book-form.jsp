<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
    <h2>${book != null ? "Edit Book" : "Add New Book"}</h2>

    <c:if test="${not empty message}">
        <div style="color:green">${message}</div>
    </c:if>

    <form action="${book != null ? 'update' : 'insert'}" method="post">
        <c:if test="${book != null}">
            <input type="hidden" name="id" value="${book.id}" />
        </c:if>
        Title: <input type="text" name="title" value="${book.title}" required /><br><br>
        Author: <input type="text" name="author" value="${book.author}" required /><br><br>
        Price: <input type="number" step="0.01" name="price" value="${book.price}" required /><br><br>
        <input type="submit" value="${book != null ? 'Update' : 'Save'}" />
    </form>

    <p><a href="list">View All</a></p>
</body>
</html>
