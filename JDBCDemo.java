package jdbc;

import java.sql.*;


public class JDBCDemo {

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
Output:

ID: 1, Name: Madhu, Age: 21, Course: Java, Marks: 88.5
ID: 2, Name: Babu, Age: 22, Course: Python, Marks: 75.0
ID: 3, Name: Shiv, Age: 20, Course: C++, Marks: 92.3
*/
