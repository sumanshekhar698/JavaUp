package com.codecounty.java.jdk8.optional_classes;//package com.sumanshekhar.java.jdk8.optional_classes;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.sumanshekhar.java.core.oops.constructors.Employee.emp;
//
//public class Employee {
//
//
//    int id;
//
//    String name;
//    int age;
//
//
//    @Override
//    public int hashCode() {
//        return id;
//    }
//
//    public Employee(int id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return this.id == ((Employee) obj).id;
//    }
//
//
//    public static void main(String[] args) {
//        Employee john = new Employee(5, "John", 27);
//        Employee jane = new Employee(5, "Jane", 29);
//
//
//        // Current Employee List //up to date list
//        // Employee Who left the org // 1 oth before
//
//        List<Employee> currentEmployee = new ArrayList<>() {{
//            add(new Employee(5, "John", 27));
//            add(new Employee(8, "Jane", 27));
//            add(new Employee(2, "Jim", 27));
//            add(new Employee(1, "Jill", 27));
//        }};
//
//        Map<Integer, Employee> integerEmployeeHashMap = new HashMap<>();
//        for (Employee emp : currentEmployee) {
//            integerEmployeeHashMap.put(emp.id, emp);
//        }
//
//        List<Employee> resignedEmployees = new ArrayList<>() {{
//            add(new Employee(5, "John", 27));
//        }};
//
//        int count = 0;
//        long count1 = resignedEmployees.stream().filter(currentEmployee.contains(emp.id)).count();
//
//        System.out.println(count1);
//
//        System.out.println(john.equals(jane));
//    }
//}
