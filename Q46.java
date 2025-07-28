package assessment;

import java.util.*;

class Q46Employee {
    private int id;
    private String name;
    private double salary;

    public Q46Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

class Repository<T, ID> {
    private Map<ID, T> storage = new HashMap<>();

    public void save(ID id, T entity) {
        storage.put(id, entity);
    }

    public T findById(ID id) {
        return storage.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(ID id) {
        storage.remove(id);
    }
}

public class Q46 {
    public static void main(String[] args) {
        Repository<Q46Employee, Integer> repo = new Repository<>();

        repo.save(101, new Q46Employee(101, "Alice", 50000));
        repo.save(102, new Q46Employee(102, "Bob", 60000));
        repo.save(103, new Q46Employee(103, "Charlie", 55000));

        System.out.println("All Employees:");
        repo.findAll().forEach(System.out::println);

        System.out.println("\nEmployee with ID 102:");
        System.out.println(repo.findById(102));

        repo.deleteById(101);
        System.out.println("\nEmployees after deleting ID 101:");
        repo.findAll().forEach(System.out::println);
    }
}
/*
All Employees:
Employee{id=101, name='Alice', salary=50000.0}
Employee{id=102, name='Bob', salary=60000.0}
Employee{id=103, name='Charlie', salary=55000.0}

Employee with ID 102:
Employee{id=102, name='Bob', salary=60000.0}

Employees after deleting ID 101:
Employee{id=102, name='Bob', salary=60000.0}
Employee{id=103, name='Charlie', salary=55000.0}
*/
