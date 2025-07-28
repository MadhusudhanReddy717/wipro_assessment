package assessment;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String name;
    String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class Q45 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(1, "Alice", "CSE"),
            new Student(2, "Bob", "ECE"),
            new Student(3, "Charlie", "CSE"),
            new Student(4, "David", "EEE"),
            new Student(5, "Eve", "ECE")
        );

        /* Grouping students by department */
        Map<String, List<Student>> grouped = students.stream()
            .collect(Collectors.groupingBy(s -> s.department));

        /* Print grouped students */
        System.out.println("Students Grouped by Department:");
        for (Map.Entry<String, List<Student>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + 
                entry.getValue().stream().map(s -> s.name).collect(Collectors.joining(", ")));
        }
    }
}
/*
Students Grouped by Department:
EEE: David
CSE: Alice, Charlie
ECE: Bob, Eve
*/
