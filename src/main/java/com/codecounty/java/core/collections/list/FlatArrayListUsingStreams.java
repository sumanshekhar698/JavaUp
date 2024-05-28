package com.codecounty.java.core.collections.list;

import java.util.ArrayList;
import java.util.Arrays;

public class FlatArrayListUsingStreams {

    public static void main(String[] args) {
        String str = "alphabets";
        long count = str.chars().mapToObj(c -> (char) c).filter(x -> x == 'a').count();
        System.out.println(count);

        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(arr).forEach(x -> Arrays.stream(x).forEach(list::add));
        System.out.println(list);



    }


}
