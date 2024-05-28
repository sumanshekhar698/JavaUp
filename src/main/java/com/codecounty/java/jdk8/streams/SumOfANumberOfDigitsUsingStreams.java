package com.codecounty.java.jdk8.streams;

public class SumOfANumberOfDigitsUsingStreams {
    public static void main(String[] args) {
        int x =98978;
        int sumOfDigits = Integer.toString(x).chars().map(ch -> ch - '0').sum();
        System.out.println(sumOfDigits);
         sumOfDigits = Integer.toString(x).chars().map(Character::getNumericValue).sum();
        System.out.println(sumOfDigits);

    }
}
