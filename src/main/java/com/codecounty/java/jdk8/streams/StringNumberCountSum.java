package com.codecounty.java.jdk8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

//Assuming you have a stream of strings where each string contains digits, the goal is to print two things:
public class StringNumberCountSum {
    public static void main(String[] args) {
        Stream<String> streamOfStringWithDigits = Stream.of("Java4", "Python6", "GO2", "Javascript10");
        String digit = "0123456789";
        var count = streamOfStringWithDigits
                .flatMap(x -> Arrays.stream(x.split("")))
                .filter(x -> digit.contains(x))
                .count();

        System.out.println("Count of digits: " + count);

        //Alternate method
        var count2 = streamOfStringWithDigits
                .flatMapToInt(CharSequence::chars)
                .filter(Character::isDigit)
                .count();
        System.out.println("Count of digits: " + count2);


        var sum = streamOfStringWithDigits
                .flatMap(x -> Arrays.stream(x.split("")))
                .filter(x -> digit.contains(x))
                .mapToInt(x -> Integer.parseInt(x))
                .sum();
        System.out.println("Sum of digits: " + sum);

        //Alternate method
        sum = streamOfStringWithDigits
                .flatMapToInt(CharSequence::chars)
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();
        System.out.println("Sum of digits: " + sum);

//        Nxt Level 🚀
        IntSummaryStatistics stats = streamOfStringWithDigits
                .flatMapToInt(CharSequence::chars)
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .summaryStatistics();

        System.out.println("Count of digits: " + stats.getCount());
        System.out.println("Sum of digits: " + stats.getSum());


    }
}
