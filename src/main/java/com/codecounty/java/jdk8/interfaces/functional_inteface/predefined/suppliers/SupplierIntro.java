package com.codecounty.java.jdk8.interfaces.functional_inteface.predefined.suppliers;

import java.util.function.Supplier;

public class SupplierIntro {


    public static void main(String[] args) {
        //Sometime we just have to operate without input, like generate random 4 digit integers

        Supplier<Integer> random4DigitInteger = () -> (int) (Math.random() * 10000);
        System.out.println(random4DigitInteger.get());
        System.out.println(random4DigitInteger.get());
        System.out.println(random4DigitInteger.get());
        System.out.println(random4DigitInteger.get());


    }
}
