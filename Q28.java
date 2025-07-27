package assessment;

@FunctionalInterface
interface PerformOperation {
    boolean check(int num);
}

public class Q28 {

    public static PerformOperation isOdd() {
        return num -> num % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return num -> {
            if (num <= 1) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return num -> {
            String str = String.valueOf(num);
            return str.equals(new StringBuilder(str).reverse().toString());
        };
    }

    public static void main(String[] args) {
        PerformOperation odd = isOdd();
        PerformOperation prime = isPrime();
        PerformOperation palindrome = isPalindrome();

        int[] numbers = {3, 10, 121, 7, 22};

        for (int num : numbers) {
            System.out.println("Number: " + num);
            System.out.println("Is Odd? " + odd.check(num));
            System.out.println("Is Prime? " + prime.check(num));
            System.out.println("Is Palindrome? " + palindrome.check(num));
            System.out.println();
        }
    }
}
