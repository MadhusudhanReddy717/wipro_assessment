package assessment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Q31: Enter an integer: ");
            int num = sc.nextInt();
            System.out.println("Entered number: " + num);

            System.out.print("Enter a string: ");
            sc.nextLine();
            String str = sc.nextLine();

            System.out.print("Enter an index to access: ");
            int index = sc.nextInt();
            char ch = str.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter an integer.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Index is out of range for the string.");
        }

        sc.close();
    }
}
/*
Q31: Enter an integer: 22
Entered number: 22
Enter a string: Madhu
Enter an index to access: 3
Character at index 3: h
*/
