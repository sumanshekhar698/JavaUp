package com.codecounty.java.jdk8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeesByCountry {

    public static void main(String[] args) {
        List<Employee> listOfEmployees = List.of(
                new Employee("USA", "Alice", 80000),
                new Employee("India", "Bob", 65000),
                new Employee("USA", "Charlie", 90000),
                new Employee("China", "David", 72000)
        );

        // Group employees by country using streams
        Map<String, List<Employee>> employeesByCountry = listOfEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getCountry));

        System.out.println("Employees grouped by country:");
        for (Map.Entry<String, List<Employee>> entry : employeesByCountry.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Employee employee : entry.getValue()) {
                System.out.println("\t- " + employee.getEmpName() + " (" + employee.getSalary() + ")"); // Assuming salary is retrieved
            }
        }
    }

    static class Employee {
        private String country;
        private String empName;
        private Integer salary; // Assuming salary is also a property

        public Employee(String country, String empName, Integer salary) {
            this.country = country;
            this.empName = empName;
            this.salary = salary;
        }

        // Getters and setters (omitted for brevity)

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }
    }
}