package dev.codecounty.java.java8.specials.interfaces.functional_inteface.predefined.predicates;

import java.util.function.BiPredicate;

public class BiPredicates {

    public static void main(String[] args) {

        //When we need 2 inputs
        BiPredicate<Integer, Integer> divisblityBP = (x, y) -> x % y == 0;
        System.out.println(divisblityBP.test(81, 9));

    }
}
