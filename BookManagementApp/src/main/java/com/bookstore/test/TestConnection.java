package com.bookstore.test;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        String[] urls = {
            "jdbc:mysql://localhost:3306/bookdb?allowPublicKeyRetrieval=true&useSSL=false",
            "jdbc:mysql://localhost:3306/bookdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
            "jdbc:mysql://localhost:3306/bookdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Kolkata",
            "jdbc:mysql://localhost:3306/bookdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8"
        };

        String u = "root";
        String p = "@Madhu717";

        for (int i = 0; i < urls.length; i++) {
            System.out.println("\n=== Test " + (i + 1) + " ===");
            System.out.println("URL: " + urls[i]);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection(urls[i], u, p);
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery("SELECT * FROM books");
                while (r.next()) {
                    System.out.println(" ID: " + r.getInt("id") + ", Title: " + r.getString("title") + ", Author: " + r.getString("author") + ", Price: " + r.getFloat("price"));
                }
                c.close();
                System.out.println("✅ SUCCESS");
                System.out.println("Use this URL: " + urls[i]);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
