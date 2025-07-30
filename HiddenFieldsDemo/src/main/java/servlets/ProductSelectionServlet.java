package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ProductSelectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] parts = request.getParameter("product").split(",");
        String productName = parts[0];
        double price = Double.parseDouble(parts[1]);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Enter Quantity</h2>");
        out.println("<form action='receipt' method='post'>");
        out.println("Quantity: <input type='number' name='quantity'><br><br>");
        out.println("<input type='hidden' name='productName' value='" + productName + "'>");
        out.println("<input type='hidden' name='price' value='" + price + "'>");
        out.println("<input type='submit' value='Generate Receipt'>");
        out.println("</form>");
    }
}
