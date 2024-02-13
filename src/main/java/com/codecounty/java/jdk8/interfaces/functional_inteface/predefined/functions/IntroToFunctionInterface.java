package com.codecounty.java.jdk8.interfaces.functional_inteface.predefined.functions;

import java.util.function.Function;

public class IntroToFunctionInterface {
    public static void main(String[] args) {
        Function<String, Integer> f1 = s -> s.length();//it can return anything and has two Types specified<input,output>
        Function<String, String> f2 = s -> s.toUpperCase();
        Function<String, String> f3 = s -> s.substring(0, 3);
        System.out.println(f1.apply("sumu"));

//        Function Chaining
        System.out.println(f2.andThen(f3).apply("suUmu"));//1st f2 and then f3
        System.out.println(f1.compose(f3).apply("suUmu"));//1st f3 and then f1


    }
}
