package assessment;

import java.util.*;

public class Q23and24 {

    static class Hall {
        public void describe() {
            var out = System.out;
            out.println("Q23.1: This is the first room while entering the house");
        }
    }

    static class Kitchen {
        String[] appliances = {"Fridge", "Oven", "Microwave", "Toaster"};

        public void showAppliances() {
            System.out.println("Q23.2: Kitchen appliances:");
            for (String app : appliances) {
                System.out.println(app);
            }
            String[] copied = Arrays.copyOf(appliances, appliances.length);
            System.out.println("Q23.3: Copied appliances array:");
            for (String app : copied) {
                System.out.println(app);
            }
        }
    }

    
    
    public void q24() {
        Scanner sc = new Scanner(System.in);
        double[] speeds = new double[5];
        double total = 0;

        System.out.println("Q24: Enter speeds of 5 racers:");
        for (int i = 0; i < 5; i++) {
            speeds[i] = sc.nextDouble();
            total += speeds[i];
        }

        double average = total / 5;
        System.out.println("Average speed: " + average);
        System.out.println("Racers who qualified (speed > average):");
        for (double s : speeds) {
            if (s > average) {
                System.out.println(s);
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        Hall hall = new Hall();
        hall.describe();
        System.out.println();

        Kitchen kitchen = new Kitchen();
        kitchen.showAppliances();
        System.out.println();

        Q23and24 q = new Q23and24();
        q.q24();
    }
}
