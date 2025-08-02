package com.bookstore.dao;

import java.sql.*;
import java.util.*;
import com.bookstore.model.Book;

public class BookDAO {
    private String url = "jdbc:mysql://localhost:3306/bookdb?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String pass = "@Madhu717";

    private Connection getCon() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void insertBook(Book b) throws SQLException {
        String q = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        try (Connection c = getCon(); PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setFloat(3, b.getPrice());
            ps.executeUpdate();
        }
    }

    public Book selectBook(int id) {
        Book b = null;
        String q = "SELECT * FROM books WHERE id = ?";
        try (Connection c = getCon(); PreparedStatement ps = c.prepareStatement(q)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String t = rs.getString("title");
                String a = rs.getString("author");
                float p = rs.getFloat("price");
                b = new Book(id, t, a, p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    public List<Book> selectAllBooks() {
        List<Book> l = new ArrayList<>();
        String q = "SELECT * FROM books";
        try (Connection c = getCon(); PreparedStatement ps = c.prepareStatement(q)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String t = rs.getString("title");
                String a = rs.getString("author");
                float p = rs.getFloat("price");
                l.add(new Book(id, t, a, p));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public boolean deleteBook(int id) throws SQLException {
        boolean r;
        String q = "DELETE FROM books WHERE id = ?";
        try (Connection c = getCon(); PreparedStatement ps = c.prepareStatement(q)) {
            ps.setInt(1, id);
            r = ps.executeUpdate() > 0;
        }
        return r;
    }

    public boolean updateBook(Book b) throws SQLException {
        boolean r;
        String q = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";
        try (Connection c = getCon(); PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setFloat(3, b.getPrice());
            ps.setInt(4, b.getId());
            r = ps.executeUpdate() > 0;
        }
        return r;
    }
}
