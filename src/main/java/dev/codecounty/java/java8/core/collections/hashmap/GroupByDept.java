package dev.codecounty.java.java8.core.collections.hashmap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Employee(int id, String dept) {
        this.id = id;
        this.dept = dept;
    }

    // Getters and setters omitted for brevity
}

public class GroupByDept {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "IT"),
                new Employee(2, "Sales"),
                new Employee(3, "IT"),
                new Employee(4, "Marketing"),
                new Employee(5, "IT")
        );

        // Group employees by department using Collectors.groupingBy
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        // Print the grouped employees
        for (Map.Entry<String, List<Employee>> entry : groupedByDept.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (Employee emp : entry.getValue()) {
                System.out.println("\tID: " + emp.getId());
            }
        }
    }
}