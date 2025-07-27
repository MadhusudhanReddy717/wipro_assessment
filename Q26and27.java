package assessment;

import java.util.*;

public class Q26and27 {

    public void q26() {
        int[] input = {2, 3, 54, 1, 6, 7, 7};
        Set<Integer> unique = new HashSet<>();
        int sumEven = 0;

        for (int n : input) {
            if (unique.add(n) && n % 2 == 0) {
                sumEven += n;
            }
        }

        System.out.println("Q26: Sum of even numbers after removing duplicates: " + sumEven);
    }

    enum Currency {
        ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
    }

    public void q27() {
        System.out.println("Q27: Paper Currency Info:");
        for (Currency c : Currency.values()) {
            System.out.print(c + ": ");
            switch (c) {
                case ONE -> System.out.println("Smallest denomination.");
                case FIVE -> System.out.println("Used frequently for small purchases.");
                case TEN -> System.out.println("Commonly used note.");
                case TWENTY -> System.out.println("Useful for medium transactions.");
                case FIFTY -> System.out.println("Large denomination note.");
                case HUNDRED -> System.out.println("Highest standard denomination.");
            }
        }
    }

    public static void main(String[] args) {
        Q26and27 q = new Q26and27();
        q.q26();
        System.out.println();
        q.q27();
    }
}
/*
Q26: Sum of even numbers after removing duplicates: 62

Q27: Paper Currency Info:
ONE: Smallest denomination.
FIVE: Used frequently for small purchases.
TEN: Commonly used note.
TWENTY: Useful for medium transactions.
FIFTY: Large denomination note.
HUNDRED: Highest standard denomination.
*/
