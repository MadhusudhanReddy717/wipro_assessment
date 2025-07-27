package assessment;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Q29 {

    public static void validateInput(String regNo, String mobileNo) {
        if (regNo.length() != 9) {
            throw new IllegalArgumentException("Register number must be exactly 9 characters.");
        }

        if (!regNo.matches("[a-zA-Z0-9]+")) {
            throw new NoSuchElementException("Register number must contain only digits and alphabets.");
        }

        if (mobileNo.length() != 10) {
            throw new IllegalArgumentException("Mobile number must be exactly 10 digits.");
        }

        if (!mobileNo.matches("\\d+")) {
            throw new NumberFormatException("Mobile number must contain only digits.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Register Number: ");
            String regNo = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobileNo = sc.nextLine();

            validateInput(regNo, mobileNo);
            System.out.println("Valid");

        } catch (NumberFormatException e) {
            System.out.println("Invalid: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Invalid: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
