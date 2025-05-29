package dev.codecounty.java.java8.advance.multithreading.multithreading_by_defog.parallelism;

public class User {

    int id;
    int salary;

    public User(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }
}
