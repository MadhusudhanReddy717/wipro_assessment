package assessment;

import java.io.*;
import java.util.*;

public class Q37 {
    public static void main(String[] args) {
        File file = new File("batchmates.txt");
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.println("Enter batchmates' names (type 'end' to stop):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("end")) break;
            names.add(name);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("Batchmates' names written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("\nReading names from file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("-> " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
