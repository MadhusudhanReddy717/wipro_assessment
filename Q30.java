package assessment;

import java.util.Scanner;

@FunctionalInterface
interface MinimumFinder {
    float minimum3(float a, float b, float c);
}

public class Q30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first float: ");
        float a = sc.nextFloat();
        System.out.print("Enter second float: ");
        float b = sc.nextFloat();
        System.out.print("Enter third float: ");
        float c = sc.nextFloat();

        MinimumFinder finder = (x, y, z) -> Math.min(x, Math.min(y, z));
        float result = finder.minimum3(a, b, c);

        System.out.println("Q30: Smallest value is: " + result);
        sc.close();
    }
}
/*
Enter first float: 20.00
Enter second float: 87.00
Enter third float: 88.00
Q30: Smallest value is: 20.0
*/
