package com.sumanshekhar.java.jdk8.interfaces.functional_inteface.predefined.functions;

import java.util.function.BiFunction;

public class BiFunctions {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> avgOfTwoNumber = (x, y) -> (x + y) / 2;
        System.out.println(avgOfTwoNumber.apply(55,32));

    }
}
