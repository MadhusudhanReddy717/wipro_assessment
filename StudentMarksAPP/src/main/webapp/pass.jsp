<!DOCTYPE html>
<html>
<head>
    <title>Result -You are Passed</title>
</head>
<body>
    <h2>Congratulations <%= request.getAttribute("studentName") %>!</h2>
    <p>You have passed with <%= request.getAttribute("studentMarks") %> marks.</p>

    <jsp:include page="footer.jsp" />
</body>
</html>
