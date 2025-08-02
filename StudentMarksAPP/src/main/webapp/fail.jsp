<!DOCTYPE html>
<html>
<head>
    <title>Result - Fail</title>
</head>
<body>
    <h2>Sorry <%= request.getAttribute("studentName") %>,</h2>
    <p>You have failed with <%= request.getAttribute("studentMarks") %> marks. Please try again.</p>

    <jsp:include page="footer.jsp" />
</body>
</html>
