package com.codecounty.java.jdk8.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private List<String> departments;

    public Employee(String name, List<String> departments) {
        this.name = name;
        this.departments = departments;
    }





    public String getName() {
        return name;
    }

    public List<String> getDepartments() {
        return departments;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", new ArrayList<>(List.of("Engineering", "Sales"))));
        employees.add(new Employee("Jane", new ArrayList<>(List.of("Marketing", "Finance","Sales"))));
        employees.add(new Employee("Peter", new ArrayList<>(List.of("Engineering"))));

        // Create a map with department names as keys and a list of employee names in each department as values
        Map<String, Long> departmentEmployeesMapCount = employees.stream()
                .flatMap(employee -> employee.getDepartments().stream()) // Flatten the departments of each employee
//                .distinct() // Remove duplicate department names
                .collect(Collectors.groupingBy(department -> department, Collectors.counting()));// Collect as a list of employee names



        // Print the map contents
        for (Map.Entry<String,Long> entry : departmentEmployeesMapCount.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("Employees: " + entry.getValue());
        }
    }
}