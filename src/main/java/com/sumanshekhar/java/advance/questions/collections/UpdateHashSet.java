package com.sumanshekhar.java.advance.questions.collections;

import java.util.HashSet;
/**/
class Student {
    public int id;
    public String name;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int hashCode() {
        return this.id;
    }

    public String toString() {
        return "Student: " + this.name + "@" + Integer.toHexString(hashCode());
    }

    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student s = (Student) o;
            return s.id == this.id ? true : false;
        }
        return false;
    }


}

public class UpdateHashSet {

    public static void main(String[] args) {
        HashSet<Student> studentList = new HashSet<>();

        Student st1 = new Student("Nimit", 1);
        Student st2 = new Student("Rahul", 3);
        Student st3 = new Student("Nimit", 2);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);

        System.out.println(studentList.size());//3
        System.out.println(studentList);//3 students

        st1.id = 2;
        System.out.println(studentList.size());//3
        System.out.println(studentList);//3 students

        /*3
        [Student: Nimit@1, Student: Nimit@2, Student: Rahul@3]
        3
        [Student: Nimit@2, Student: Nimit@2, Student: Rahul@3]*/


    }
}