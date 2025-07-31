<%
    String name = request.getParameter("name");
    int marks = Integer.parseInt(request.getParameter("marks"));
    request.setAttribute("name", name);
    request.setAttribute("marks", marks);

    if (marks >= 40) {
        RequestDispatcher rd = request.getRequestDispatcher("pass.jsp");
        rd.forward(request, response);
    } else {
        RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
        rd.forward(request, response);
    }
%>
