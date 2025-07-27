package assessment;

import java.io.*;

public class Q42andQ43 {

    // Q42: Rethrowing Exceptions
    static void someMethod2() throws Exception {
        throw new Exception("Exception thrown in someMethod2");
    }

    static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Caught in someMethod, rethrowing...");
            throw e; // rethrowing
        }
    }

    // Q43: Read file using BufferedReader with try-with-resources
    static void readFile() {
        String fileName = "sample.txt";

        // Optional: Create a sample file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("This is line one.\n");
            writer.write("This is line two.\n");
            writer.write("This is line three.\n");
        } catch (IOException e) {
            System.out.println("Error writing to sample file: " + e.getMessage());
        }

        // Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nReading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception while reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Execute Q42
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Caught rethrown exception in main:");
            e.printStackTrace();
        }

        // Execute Q43
        readFile();
    }
}
