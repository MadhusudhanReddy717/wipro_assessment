package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class AddToCartServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String[] selectedItems = req.getParameterValues("item");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if (selectedItems != null) {
            for (String item : selectedItems) {
                Cookie cookie = new Cookie("cart_" + item, item);
                cookie.setMaxAge(60 * 60); // 1 hour
                res.addCookie(cookie);
            }
        }

        out.println("<h3>Items added to cart!</h3>");
        out.println("<a href='selectItems.html'>Go Back</a><br>");
        out.println("<a href='viewCart.jsp'>View Cart</a>");
    }
}
