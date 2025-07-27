package assessment;

public class Q9andQ10 {

    public void calculateRetailValue() {
        int[] productNumbers = {1, 2, 3, 2, 1};
        int[] quantities = {2, 1, 4, 3, 1};

        double totalRetail = 0;

        for (int i = 0; i < productNumbers.length; i++) {
            int product = productNumbers[i];
            int quantity = quantities[i];

            switch (product) {
                case 1:
                    totalRetail += 22.50 * quantity;
                    break;
                case 2:
                    totalRetail += 44.50 * quantity;
                    break;
                case 3:
                    totalRetail += 9.98 * quantity;
                    break;
                default:
                    System.out.println("Invalid product number: " + product);
                    break;
            }
        }

        System.out.printf("Q9: Total retail value of products sold: %.2f\n", totalRetail);
    }

    
    
    public void calculateEggBreakdown(String[] args) {
        if (args.length < 1) {
            System.out.println("Q10: Please provide number of eggs as command-line argument.");
            return;
        }

        int eggs = Integer.parseInt(args[0]);

        int gross = eggs / 144;
        int remainder = eggs % 144;

        int dozen = remainder / 12;
        int leftover = remainder % 12;

        System.out.println("Q10: Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + leftover + " eggs.");
    }
    
    

    public static void main(String[] args) {
        Q9andQ10 q9 = new Q9andQ10();
        Q9andQ10 q10 = new Q9andQ10();

        q9.calculateRetailValue();
        q10.calculateEggBreakdown(args);
    }
}
