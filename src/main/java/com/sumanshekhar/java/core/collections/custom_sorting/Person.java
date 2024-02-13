package com.sumanshekhar.java.core.collections.custom_sorting;

public class Person {

    int age;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person( String name,int age) {
        this.age = age;
        this.name = name;
    }
}
