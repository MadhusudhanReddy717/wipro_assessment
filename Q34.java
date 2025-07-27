package assessment;
import java.util.Scanner;


class Employee {
    private String employeeID;
    private String name;
    private int yearOfBirth;

    public Employee(String employeeID, String name, int yearOfBirth) {
        this.employeeID = employeeID;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public void printDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yearOfBirth);
    }
}

public class Q34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID (format: YY-D-XXX): ");
        String empId = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Year of Birth: ");
        int yob = sc.nextInt();

        if (isValidEmployeeID(empId)) {
            Employee emp = new Employee(empId, name, yob);
            emp.printDetails();
        } else {
            System.out.println("Invalid Employee ID format.");
        }

        sc.close();
    }

    public static boolean isValidEmployeeID(String id) {
        // Expected format: 2 digits - 1 letter - 3 digits (e.g., 81-F-112)
        return id.matches("\\d{2}-[FS]-\\d{3}");
    }
}
