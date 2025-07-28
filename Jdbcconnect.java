package jdbc;

import java.sql.*;

public class Jdbcconnect {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "@Madhu717";

        String query = "SELECT id, name, age, course, marks FROM Student";

        try (
            Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)
        ) {
            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                double marks = rs.getDouble("marks");

                System.out.println("ID: " + id + ", Name: " + name +
                        ", Age: " + age + ", Course: " + course + ", Marks: " + marks);
            }

            if (!found) {
                System.out.println("No student records found.");
            }

        } catch (SQLException e) {
            System.out.println("Connection or Query Failed!");
            e.printStackTrace();
        }
    }
}
/*
Expected Output:

*/
