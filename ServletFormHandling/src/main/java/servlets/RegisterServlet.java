package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * This servlet does NOT use @WebServlet annotation.
 * It is configured via web.xml.
 */

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html");


        PrintWriter out = response.getWriter();


        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String course = request.getParameter("course");


        out.println("<html><body>");
        out.println("<h2>Student Registration Details</h2>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Age:</b> " + age + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Course:</b> " + course + "</p>");
        out.println("</body></html>");
    }
}
