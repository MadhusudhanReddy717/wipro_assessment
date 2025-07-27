package assessment;
import java.util.Scanner;


class LowSalException extends Exception {
    public LowSalException(String message) {
        super(message);
    }
}

class Emp {
    private int empId;
    private String empName;
    private String designation;
    private double basic;
    private final double hra;

    public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
        if (basic < 50000) {
            throw new LowSalException("Basic salary is too low. Must be at least 50000.");
        }
        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.basic = basic;
        // Initialize final field directly in constructor
        this.hra = calculateHRA(designation, basic);
    }

    private static double calculateHRA(String designation, double basic) {
        double hraValue = 0;
        if (designation.equals("Manager")) {
            hraValue = basic * 0.10;
        } else if (designation.equals("TeamLeader")) {
            hraValue = basic * 0.12;
        } else if (designation.equals("HR")) {
            hraValue = basic * 0.05;
        }
        return hraValue;
    }

    public void printDET() {
        System.out.println("Emp ID: " + empId);
        System.out.println("Emp Name: " + empName);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
    }
}

public class Q33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            String name = sc.nextLine();
            String designation = sc.nextLine();
            double basic = sc.nextDouble();
            
            Emp emp = new Emp(id, name, designation, basic);
            emp.printDET();
        } catch (LowSalException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}