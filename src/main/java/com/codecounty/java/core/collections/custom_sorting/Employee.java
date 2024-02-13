package com.codecounty.java.core.collections.custom_sorting;

public class Employee {

    private int empID;
    private String name;
    private int age;

    public Employee(int empID, String name, int age) {
        super();
        this.empID = empID;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [empID=" + empID + ", name=" + name + ", age=" + age + "]";
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}