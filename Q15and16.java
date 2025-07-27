package assessment;

import java.util.*;

public class Q15and16 {

    public void q15() {
        int[] arr = {2, 3, 54, 1, 6, 7, 7, 2, 3, 54};
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        System.out.println("Q15: Frequency of elements:");
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " occurred " + entry.getValue() + " times");
        }
    }

    public void q16() {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[3];
        int count = 0;
        while (count < 3) {
            System.out.print("Enter the mark (0-100) for student " + (count + 1) + ": ");
            int input = sc.nextInt();
            if (input >= 0 && input <= 100) {
                marks[count++] = input;
            } else {
                System.out.println("Invalid input, try again...");
            }
        }
        double avg = (marks[0] + marks[1] + marks[2]) / 3.0;
        System.out.printf("Q16: The average is: %.2f%n", avg);
        sc.close();
    }

    public static void main(String[] args) {
        Q15and16 q = new Q15and16();
        q.q15();
        System.out.println();
        q.q16();
    }
}
