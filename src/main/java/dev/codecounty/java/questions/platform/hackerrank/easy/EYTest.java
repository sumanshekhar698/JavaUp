package dev.codecounty.java.questions.platform.hackerrank.easy;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class EYTest {

    public static void main(String[] args) {
        //s1 and s2
        String s1 = "apple";
        String s2 = "eappl";// e   appl

//        WAP remove duplicate in an ArrayList
        ArrayList<Integer> list = new ArrayList<>() {{

            add(2);
            add(12);
            add(3);
            add(7);
            add(8);
            add(8);
            add(3);
        }};

        Set<Integer> collect = list.stream().collect(Collectors.toSet());
        System.out.println(collect);

        //HashMap


    }
}
