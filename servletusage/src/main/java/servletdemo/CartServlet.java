package servletdemo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    // Handles GET requests (e.g., someone types /cart in browser)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to add item form if accessed directly via GET
        response.sendRedirect("addItem.jsp");
    }

    // Handles POST requests (form submissions)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        // Get or create the cart from session
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        if ("Add Item".equals(action)) {
            String itemName = request.getParameter("itemName");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Add or update item in cart
            cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
            session.setAttribute("cart", cart);

            // Back to add page
            response.sendRedirect("addItem.jsp");

        } else if ("View Cart".equals(action)) {
            session.setAttribute("cart", cart); // Store cart in session
            request.getRequestDispatcher("viewCart.jsp").forward(request, response);
        }
    }
}
