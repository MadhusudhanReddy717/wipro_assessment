package assessment;

import java.util.Scanner;

public class Q6 {

    Scanner sc;

    public Q6(Scanner sc) {
        this.sc = sc;
    }

    public void userInfo() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your roll number: ");
        String roll = sc.nextLine();

        System.out.print("Enter your field of interest: ");
        String interest = sc.nextLine();

        System.out.println("Hey, my name is " + name + " and my roll number is " + roll +
                           ". My field of interest are " + interest + ".");
    }

    public void bonusCalculation() {
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter your years of service: ");
        int service = sc.nextInt();

        if (service > 6) {
            double bonus = salary * 0.10;
            System.out.println("Q5: Bonus amount: " + bonus);
        } else {
            System.out.println("Q5: No bonus. Service must be more than 6 years.");
        }
    }

    public void gradeSystem() {
        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();
        String grade;

        if (marks < 25) {
            grade = "F";
        } else if (marks <= 45) {
            grade = "E";
        } else if (marks <= 50) {
            grade = "D";
        } else if (marks <= 60) {
            grade = "C";
        } else if (marks <= 80) {
            grade = "B";
        } else {
            grade = "A";
        }

        System.out.println("Q6: Your grade is " + grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q6 input = new Q6(scanner);

        input.userInfo();
        input.bonusCalculation();
        input.gradeSystem();

        scanner.close();
    }
}
