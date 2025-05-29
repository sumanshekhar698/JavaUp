package dev.codecounty.java.java8.core.collections.list;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeExample {

    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>() {{
            add(4);
            add(14);
            add(43);
            add(124);
            add(423);
            add(44);
            add(23234);
            add(423);
        }};


        Iterator<Integer> it = queue.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


//        for (int i : queue.reversed()) {} //JDK 21 feature

    }
}
