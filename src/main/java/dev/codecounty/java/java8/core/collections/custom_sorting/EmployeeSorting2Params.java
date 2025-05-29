package dev.codecounty.java.java8.core.collections.custom_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeSorting2Params {
    //    https://blog.jooq.org/java-8-friday-goodies-lambdas-and-sorting/
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(1, "Alice", 25),
                new Employee(2, "Bob", 30),
                new Employee(3, "Charlie", 25),
                new Employee(4, "David", 28)
        };

        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee(66, "Barny", 30));
        empList.add(new Employee(23, "Toddy", 23));
        empList.add(new Employee(12, "Jane", 24));
        empList.add(new Employee(45, "John", 60));
        empList.add(new Employee(13, "Aby", 30));
        empList.add(new Employee(21, "Jay", 30));

        // Create a custom comparator to sort by age first, then alphabetically by name if ages are equal
        Comparator<Employee> comparator = Comparator.comparingInt(Employee::getAge)
                .thenComparing(Employee::getName);


        Comparator<Employee> cmp = Comparator.comparing(emp -> emp.getName());
        cmp = cmp.thenComparing(Employee::getName);


//        Comparator<Employee> cmp1 = Comparator.comparing(emp -> emp.getName()).thenComparing(Employee::getName);

        // Sort the array using the custom comparator
        Arrays.sort(employees, comparator);

        // Print the sorted employees
        System.out.println("Sorted employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sort the array using the custom comparator
        Collections.sort(empList, comparator);
        System.out.println("\nSorted employees list:");
        for (Employee employee : empList) {
            System.out.println(employee);
        }

    }
}
