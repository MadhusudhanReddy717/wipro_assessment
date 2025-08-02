package com.bookstore.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;

@WebServlet("/")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO dao;

    public void init() {
        dao = new BookDAO();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String a = req.getServletPath();
        try {
            switch (a) {
                case "/new":
                    showNew(req, res);
                    break;
                case "/insert":
                    insert(req, res);
                    break;
                case "/delete":
                    delete(req, res);
                    break;
                case "/edit":
                    showEdit(req, res);
                    break;
                case "/update":
                    update(req, res);
                    break;
                case "/list":
                    list(req, res);
                    break;
                default:
                    home(req, res);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void home(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher d = req.getRequestDispatcher("book-form.jsp");
        d.forward(req, res);
    }

    private void list(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException {
        List<Book> l = dao.selectAllBooks();
        req.setAttribute("listBook", l);
        RequestDispatcher d = req.getRequestDispatcher("book-list.jsp");
        d.forward(req, res);
    }

    private void showNew(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher d = req.getRequestDispatcher("book-form.jsp");
        d.forward(req, res);
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book b = dao.selectBook(id);
        RequestDispatcher d = req.getRequestDispatcher("book-form.jsp");
        req.setAttribute("book", b);
        d.forward(req, res);
    }

    private void insert(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException {
        String t = req.getParameter("title");
        String a = req.getParameter("author");
        float p = Float.parseFloat(req.getParameter("price"));
        Book b = new Book(t, a, p);
        dao.insertBook(b);
        req.setAttribute("message", "Book saved successfully!");
        req.setAttribute("messageType", "success");
        RequestDispatcher d = req.getRequestDispatcher("book-form.jsp");
        d.forward(req, res);
    }

    private void update(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String t = req.getParameter("title");
        String a = req.getParameter("author");
        float p = Float.parseFloat(req.getParameter("price"));
        Book b = new Book(id, t, a, p);
        dao.updateBook(b);
        res.sendRedirect("list");
    }

    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.deleteBook(id);
        res.sendRedirect("list");
    }
}
