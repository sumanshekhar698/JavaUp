package com.sumanshekhar.java.core.collections.list;

import java.util.Objects;

public class Student {
    public String regNo;


/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return regNo == student.regNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }*/

    public Student(String reg) {
        this.regNo=reg;
    }

}
