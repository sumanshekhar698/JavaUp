package dev.codecounty.java.java8.advance.multithreading.multithreading_by_defog.basics.synchronization_problem;

// Example illustrates multiple threads are executing
// on the same Object at the same time without synchronization.

class Line {
    // multiple threads(students) can access this unsynchronized method
    //So there is chance that Object's state will be corrupted.
    public void getLine() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Student extends Thread {
    // reference to Line's Object.
    Line line;

    Student(Line line) {
        this.line = line;
    }

    @Override
    public void run() {
        line.getLine();
    }
}

class Example {
    public static void main(String[] args) {
        // Object of Line class that is shared
        // among the threads.
        Line obj = new Line();

        // creating the threads that are
        // sharing the same Object.
        Student student1 = new Student(obj);
        Student student2 = new Student(obj);

        // threads start their execution.
        student1.start();
        student2.start();
    }
}