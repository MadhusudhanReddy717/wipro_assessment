package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("-------------------- Hibernate Student CRUD --------------------");

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Get Student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    getStudentById(scanner);
                    break;
                case 0:
                    HibernateUtil.shutdown();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 0);
    }

    private static void addStudent(Scanner scanner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        scanner.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        scanner.nextLine(); // consume newline

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, age, course, marks);
        session.save(student);
        tx.commit();
        session.close();

        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent(Scanner scanner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();

        Student student = session.get(Student.class, id);
        if (student == null) {
            System.out.println("Student not found!");
        } else {
            scanner.nextLine(); // consume newline

            System.out.print("Enter New Name: ");
            student.setName(scanner.nextLine());

            System.out.print("Enter New Age: ");
            student.setAge(scanner.nextInt());

            scanner.nextLine();

            System.out.print("Enter New Course: ");
            student.setCourse(scanner.nextLine());

            System.out.print("Enter New Marks: ");
            student.setMarks(scanner.nextDouble());

            session.update(student);
            tx.commit();
            System.out.println("Student updated successfully!");
        }
        session.close();
    }

    private static void deleteStudent(Scanner scanner) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        Student student = session.get(Student.class, id);
        if (student == null) {
            System.out.println("Student not found!");
        } else {
            session.delete(student);
            tx.commit();
            System.out.println("Student deleted successfully!");
        }
        session.close();
    }

    private static void getStudentById(Scanner scanner) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Student student = session.get(Student.class, id);
        if (student == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println(student);
        }
        session.close();
    }
}
