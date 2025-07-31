<!DOCTYPE html>
<html>
<head><title>Fail Result</title></head>
<body>
    <h2>Sorry <%= request.getAttribute("name") %>, You Failed.</h2>
    <p>Your Marks: <%= request.getAttribute("marks") %></p>

    <jsp:include page="footer.jsp"/>
</body>
</html>
