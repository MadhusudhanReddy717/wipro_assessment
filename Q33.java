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
/*
Caught NegativeArraySizeException
java.lang.NegativeArraySizeException: -5
	at assessment1/assessment.Q32.main(Q32.java:6)

Caught ArrayIndexOutOfBoundsException
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
	at assessment1/assessment.Q32.main(Q32.java:14)

Caught StringIndexOutOfBoundsException
java.lang.StringIndexOutOfBoundsException: Index 5 out of bounds for length 3
	at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
	at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
	at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
	at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
	at java.base/java.lang.String.checkIndex(String.java:4832)
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:46)
	at java.base/java.lang.String.charAt(String.java:1555)
	at assessment1/assessment.Q32.main(Q32.java:22)

Caught IndexOutOfBoundsException
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 2
	at assessment1/assessment.Q32.main(Q32.java:30)

Caught NullPointerException
java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
	at assessment1/assessment.Q32.main(Q32.java:38)

Caught ArithmeticException
java.lang.ArithmeticException: / by zero
	at assessment1/assessment.Q32.main(Q32.java:45)
*/
