package dev.codecounty.java.questions.interview.immutability;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Subject maths = new Subject(3, "Maths");
        Subject english = new Subject(1, "English");
        Subject science = new Subject(3, "Science");

        ArrayList<Subject> listOfSubjects = new ArrayList<>() {{
            add(maths);
            add(english);
            add(science);
        }};

        Student st1 = new Student(99, "John", listOfSubjects);
        System.out.println(st1);
        List<Subject> subjects = st1.getSubjects();
        String name = subjects.get(0).getName();


        //Test 2
        List<Subject> subList = new ArrayList<>();
        Subject sub1 = new Subject(1, "ECE");
        subList.add(sub1);


        Student s1 = new Student(1, "name", subList);
        System.out.println(s1);
        subList.add(new Subject(2, "CSE"));

        System.out.println(s1);


    }
}
