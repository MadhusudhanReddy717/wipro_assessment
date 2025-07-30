package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = (String) request.getAttribute("studentName");
        int marks = (int) request.getAttribute("studentMarks");

        String grade;
        if (marks >= 90) grade = "A+";
        else if (marks >= 75) grade = "A";
        else if (marks >= 60) grade = "B";
        else if (marks >= 40) grade = "C";
        else grade = "Fail";

        out.println("<h2>Student Result</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Marks: " + marks + "</p>");
        out.println("<p>Grade: " + grade + "</p>");
    }
}
