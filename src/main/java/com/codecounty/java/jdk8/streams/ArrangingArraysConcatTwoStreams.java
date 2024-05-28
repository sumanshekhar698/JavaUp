package com.codecounty.java.jdk8.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrangingArraysConcatTwoStreams {

    public static void main(String[] args) {
        int arr[] = {23, 0, 45, 0, 67, 0, 9, 0};
        int numbers [] = arr.clone();


        int[] newArr = new int[arr.length];
        int j = newArr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i]!=0){
                newArr[j--]=arr[i];
            }


        }

        System.out.println(Arrays.toString(newArr));


//        via streams

        // Collect non-zero elements using filter and collect
        Integer[] nonZeros = Arrays.stream(numbers)
                .filter(i -> i != 0)
                .boxed()
                .collect(Collectors.toList())
                .toArray(Integer[]::new);

        // Create a stream of zeros by repeating the zero element
        Integer[] zeros = new Integer[numbers.length - nonZeros.length];
        Arrays.fill(zeros, 0);

        // Combine both streams using flatMap and collect
        // Correctly combine streams using two consecutive calls to concat
        Integer[] result =
                Stream.concat(Arrays.stream(zeros),Arrays.stream(nonZeros))
                .collect(Collectors.toList())
                .toArray(Integer[]::new);

        // Print the arranged array
        System.out.println(Arrays.toString(result));
    }
}
