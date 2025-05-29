package dev.codecounty.java.java8.specials.streams;

import java.util.stream.IntStream;

public class FindSqrtUsingStreams {
    public static void main(String[] args) {
        double v = Math.sqrt(24) % 1;
        System.out.println(v);


        System.out.println(IntStream.rangeClosed(1, 1000)
                .filter(n -> Math.sqrt(n) % 1 == 0)
                .mapToObj(String::valueOf)
                .collect(java.util.stream.Collectors.joining(", ")));
    }
}
