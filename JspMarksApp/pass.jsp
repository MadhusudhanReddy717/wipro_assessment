<!DOCTYPE html>
<html>
<head><title>Pass Result</title></head>
<body>
    <h2>Congratulations <%= request.getAttribute("name") %>, You Passed!</h2>
    <p>Your Marks: <%= request.getAttribute("marks") %></p>

    <jsp:include page="footer.jsp"/>
</body>
</html>
