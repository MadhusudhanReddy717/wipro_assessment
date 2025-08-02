package com.elform;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User u = new User();
        u.setName(req.getParameter("name"));
        u.setPass(req.getParameter("pass"));
        u.setAddr(req.getParameter("addr"));
        u.setNews(req.getParameter("news") != null);
        u.setFw(req.getParameterValues("fw"));
        u.setGender(req.getParameter("gender"));
        u.setNum(req.getParameter("num"));

        req.setAttribute("user", u);
        RequestDispatcher rd = req.getRequestDispatcher("user-view.jsp");
        rd.forward(req, res);
    }
}
