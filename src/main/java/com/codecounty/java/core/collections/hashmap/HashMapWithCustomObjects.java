package com.codecounty.java.core.collections.hashmap;

import java.util.ArrayList;
import java.util.HashSet;

public class HashMapWithCustomObjects {

    public static void main(String[] args) {


        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", 14));
        students.add(new Student("John", 15));
        students.add(new Student("Jane", 10));
        students.add(new Student("John", 11));
        students.add(new Student("Jill", 18));


        HashSet<Student> set = new HashSet<>();
        students.stream().filter(s -> !set.contains(s)).forEach(s -> set.add(s));
        System.out.println(set);
    }

    static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            com.codecounty.java.core.collections.hashmap.Student student = (com.codecounty.java.core.collections.hashmap.Student) o;

            return name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

}

