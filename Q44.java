package assessment;
import java.util.*;

/*
 * Custom class representing an Employee with id, name, and salary.
 */
class Q44Employee {
    int id;
    String name;
    double salary;

    public Q44Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class Q44 {
    public static void main(String[] args) {
        /* Create a list of employees */
        List<Q44Employee> employees = new ArrayList<>();
        employees.add(new Q44Employee(101, "Ravi", 50000));
        employees.add(new Q44Employee(102, "Priya", 60000));
        employees.add(new Q44Employee(103, "Arun", 55000));
        employees.add(new Q44Employee(104, "Kavya", 70000));
        employees.add(new Q44Employee(105, "Divya", 45000));

        /* Sort by salary in descending order using Comparator */
        employees.sort(Comparator.comparingDouble((Q44Employee e) -> e.salary).reversed());
        System.out.println("Sorted by Salary (Descending):");
        for (Q44Employee e : employees) {
            System.out.println(e);
        }

        System.out.println();

        /* Sort by name alphabetically using lambda */
        employees.sort((e1, e2) -> e1.name.compareToIgnoreCase(e2.name));
        System.out.println("Sorted by Name (Alphabetically):");
        for (Q44Employee e : employees) {
            System.out.println(e);
        }
    }
}
