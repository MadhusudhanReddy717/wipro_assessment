package assessment;

import java.io.*;
import java.util.Scanner;

class Emp38 implements Serializable {
    private int emp_id;
    private String emp_name;
    private transient double emp_sal;

    public Emp38(int emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    public void display() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Salary (transient): " + emp_sal);
    }
}

public class Q38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double sal = sc.nextDouble();

            Emp38 emp = new Emp38(id, name, sal);

            FileOutputStream fos = new FileOutputStream("employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.close();

            FileInputStream fis = new FileInputStream("employee.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Emp38 empDeserialized = (Emp38) ois.readObject();
            ois.close();

            System.out.println("\nDeserialized Employee object:");
            empDeserialized.display();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        sc.close();
    }
}
