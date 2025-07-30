package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ReceiptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String product = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double total = price * quantity;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Receipt</h2>");
        out.println("<p>Product: " + product + "</p>");
        out.println("<p>Price: ₹" + price + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");
        out.println("<p><strong>Total: ₹" + total + "</strong></p>");
    }
}
