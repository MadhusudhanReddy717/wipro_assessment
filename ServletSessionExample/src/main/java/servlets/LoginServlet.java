package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.time.LocalDateTime;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if ("admin".equals(user) && "admin123".equals(pass)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user);
            session.setAttribute("loginTime", LocalDateTime.now().toString());
            res.sendRedirect("dashboard.jsp");
        } else {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println("<h3>Invalid login. <a href='login.html'>Try again</a></h3>");
        }
    }
}
