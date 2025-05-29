package dev.codecounty.java.java8.specials.streams;

public final class Student {
    private final int roll;
    private  int marks;
    private final String name;

    @Override
    public String toString() {
        return "Student [roll=" + roll + ", marks=" + marks + ", name=" + name + "]";
    }

    public int getRoll() {
        return roll;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public Student(int roll, int marks, String name) {
        super();
        this.roll = roll;
        this.marks = marks;
        this.name = name;
    }

    public Student(int roll, String name) {
        super();
        this.roll = roll;
        this.name = name;
    }


}
