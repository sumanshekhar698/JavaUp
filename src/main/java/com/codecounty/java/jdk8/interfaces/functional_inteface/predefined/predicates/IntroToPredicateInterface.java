package com.codecounty.java.jdk8.interfaces.functional_inteface.predefined.predicates;

import java.util.Collection;
import java.util.function.Predicate;

public class IntroToPredicateInterface {

    public static void main(String[] args) {
        Predicate<Integer> p1 = i -> (i <= 50);//Predicates only return boolean value
        Predicate<Integer> p2 = i -> (i % 2 == 0);
        System.out.println(p1.test(55));

        Predicate<Integer> p3 = p1.and(p2);
        Predicate<Integer> p4 = p1.or(p2);
        Predicate<Integer> p5 = p1.negate();
        //or, negate & and can be chained even further
        System.out.println(p3.test(50));
        System.out.println(p4.test(52));
        System.out.println(p5.test(100));


        Predicate<Collection> c = i -> (i.isEmpty());


    }
}
