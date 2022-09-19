package com.sumanshekhar.java.core.collections.queue;

import java.util.PriorityQueue;

public class SimplePriotityQueue {

    public static void main(String[] args) {
        PriorityQueue<Character> characters = new PriorityQueue<>();
        characters.add('C');
        characters.add('O');
        characters.add('D');
        System.out.println(characters);
        characters.add('C');
        characters.add('C');
        System.out.println(characters);

    }
}
