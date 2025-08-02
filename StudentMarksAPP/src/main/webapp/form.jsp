<!DOCTYPE html>
<html>
<head>
    <title>Student Marks Form</title>
</head>
<body>
    <h2>Enter Student Details</h2>
    <form action="form.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Marks: <input type="number" name="marks" required><br><br>
        <input type="submit" value="Submit">
    </form>

<%
    String name = request.getParameter("name");
    String marksStr = request.getParameter("marks");

    if (name != null && marksStr != null) {
        int marks = Integer.parseInt(marksStr);
        request.setAttribute("studentName", name);
        request.setAttribute("studentMarks", marks);

        if (marks >= 40) {
            RequestDispatcher rd = request.getRequestDispatcher("pass.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
            rd.forward(request, response);
        }
    }
%>

</body>
</html>
