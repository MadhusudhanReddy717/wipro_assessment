package assessment;

import java.util.Scanner;

public class Q7andQ8 {

    Scanner sc;

    public Q7andQ8(Scanner sc) {
        this.sc = sc;
    }

    public void attendanceCheck() {
        System.out.print("Enter number of classes held: ");
        int totalClasses = sc.nextInt();

        System.out.print("Enter number of classes attended: ");
        int attendedClasses = sc.nextInt();

        double percentage = (attendedClasses * 100.0) / totalClasses;
        System.out.printf("Q7: Attendance Percentage: %.2f%%\n", percentage);

        if (percentage >= 70) {
            System.out.println("Student is allowed to sit in the exam.");
        } else {
            System.out.println("Student is NOT allowed to sit in the exam.");
        }
    }

    public void attendanceCheckWithMedical() {
        System.out.print("Enter number of classes held: ");
        int totalClasses = sc.nextInt();

        System.out.print("Enter number of classes attended: ");
        int attendedClasses = sc.nextInt();

        double percentage = (attendedClasses * 100.0) / totalClasses;
        System.out.printf("Q8: Attendance Percentage: %.2f%%\n", percentage);

        if (percentage >= 70) {
            System.out.println("Student is allowed to sit in the exam.");
        } else {
            System.out.print("Do you have a medical cause? (Y/N): ");
            char medical = sc.next().toUpperCase().charAt(0);

            if (medical == 'Y') {
                System.out.println("Student is allowed to sit in the exam due to medical cause.");
            } else {
                System.out.println("Student is NOT allowed to sit in the exam.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q7andQ8 q7 = new Q7andQ8(scanner);
        Q7andQ8 q8 = new Q7andQ8(scanner);
        q7.attendanceCheck();
        q8.attendanceCheckWithMedical();
        scanner.close();
    }
}
