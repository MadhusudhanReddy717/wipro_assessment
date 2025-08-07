<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <h2>Student Registration</h2>
    <form:form modelAttribute="student" action="processForm" method="post">
        Name: <form:input path="name"/> <form:errors path="name"/><br/><br/>
        Age: <form:input path="age"/> <form:errors path="age"/><br/><br/>
        Email: <form:input path="email"/> <form:errors path="email"/><br/><br/>
        Phone: <form:input path="phone"/> <form:errors path="phone"/><br/><br/>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
