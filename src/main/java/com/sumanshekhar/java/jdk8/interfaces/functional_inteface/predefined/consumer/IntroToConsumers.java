package com.sumanshekhar.java.jdk8.interfaces.functional_inteface.predefined.consumer;

import java.util.function.Consumer;

public class IntroToConsumers {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.print(s);//Use consumers when it has to return nothing but just do operations
        Consumer<String> c2 = s -> System.out.print(s.toLowerCase());
        Consumer<String> c3 = s -> System.out.print(s.trim().toUpperCase());
//        c1.accept("sumu");
        Consumer<String> c4 = c1.andThen(c2).andThen(c3);
        c4.accept(" SUmaN");
    }
}
