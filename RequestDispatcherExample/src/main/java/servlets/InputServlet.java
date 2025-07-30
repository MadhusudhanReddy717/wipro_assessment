package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int marks = Integer.parseInt(request.getParameter("marks"));


        request.setAttribute("studentName", name);
        request.setAttribute("studentMarks", marks);


        RequestDispatcher rd = request.getRequestDispatcher("grade");
        rd.forward(request, response);
    }
}
