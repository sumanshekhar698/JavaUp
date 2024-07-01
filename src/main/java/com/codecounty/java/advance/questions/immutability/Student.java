package com.codecounty.java.advance.questions.immutability;

import java.util.List;
import java.util.stream.Collectors;

final class Student {

    private final int id;
    private final String name;
    private final List<Subject> subjects;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects.stream().collect(Collectors.toList());
//        return subjects;
    }

    public Student(int id, String name, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects.stream().collect(Collectors.toList());
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}


final class Subject {
    private final int id;
    private final String name;


    Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}